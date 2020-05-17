package com.erp.mapper;

import com.erp.bean.entity.InStorage;
import com.erp.bean.entity.OutStorage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 商品出库
 */
@Mapper
public interface OutStorageMapper {
    /**
     * 查询出库列表
     * @return
     */
    @Select("select FID outId,FCPXH model,FTXM barCode,FCKRQ outDate,FCPDJ price,FCKSL outCount, " +
            "FCZRY operator, FBZ remark from cpck")
    List<InStorage> getOutStorageList();

    /**
     * 新增出库
     * @param outStorage
     * @return
     */
    @Insert("insert into cpck(FCPXH,FTXM,FCKRQ,FCPDJ,FCKSL,FCZRY,FBZ) " +
            "values(#{model},#{barCode},#{outDate},#{price},#{outCount},#{operator},#{remark})")
    int addOutStorage(OutStorage outStorage);
}
