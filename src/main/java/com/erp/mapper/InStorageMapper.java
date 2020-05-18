package com.erp.mapper;

import com.erp.bean.entity.InStorage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface InStorageMapper {
    /**
     * 查询库存列表
     * @return
     */
    @Select("<script>select FID intoId,FCPXH model,FTXM barCode,FRKRQ intoDate,FCPDJ price,FRKSL inCount,FCZRY operator," +
            "FBZ remark from cprk where 1=1" +
            "<if test=\"intoDate!=null and intoDate!=''\"> and  FRKRQ=#{intoDate} </if>" +
            "<if test=\"keywords!=null and keywords!=''\"> and  FCPXH=#{keywords} </if>" +
            "</script>")
    List<InStorage> getInStorageList(String intoDate,String keywords);

    /**
     * 新增入库
     * @param inStorage
     * @return
     */
    @Insert("insert into cprk(FCPXH,FTXM,FRKRQ,FCPDJ,FRKSL,FCZRY,FBZ) " +
            "values(#{model},#{barCode},#{intoDate},#{price},#{inCount},#{operator},#{remark})")
    int addInStorage(InStorage inStorage);
}
