package com.erp.mapper;

import com.erp.bean.entity.InStorage;
import com.erp.bean.entity.SalesDts;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

@Mapper
public interface InStorageMapper {
    /**
     * 查询库存列表
     * @return
     */
    @Select("select FID intoId,FCPXH model,FTXM barCode,FRKRQ intoDate,FCPDJ price,FRKSL inCount,FCZRY operator," +
            "FBZ remark from cprk")
    List<InStorage> getInStorageList();

    /**
     * 新增入库
     * @param inStorage
     * @return
     */
    @Insert("insert into cprk(FCPXH,FTXM,FRKRQ,FCPDJ,FRKSL,FCZRY,FBZ) " +
            "values(#{model},#{barCode},#{intoDate},#{price},#{inCount},#{operator},#{remark})")
    int addInStorage(InStorage inStorage);
}
