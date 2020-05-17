package com.erp.mapper;

import com.erp.bean.entity.InStorage;
import com.erp.bean.entity.Sales;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SalesMapper {
    /**
     * 查询销售列表
     * @return
     */
    @Select("select FID salesId,FXSBM salesCode,FKHXM customerName,FKHDH customerPhone,FXSRQ salesDate, " +
            "FXSJG salesPrice,FCBJG basePrice,FQTFY otherCost,FLR profit,FBZ remark from mlrfx")
    List<Sales> getSalesList();

    /**
     * 新增销售
     * @param sales
     * @return
     */
    @Insert("INSERT INTO mlrfx(FXSBM,FKHXM,FKHDH,FXSRQ,FXSJG,FCBJG,FQTFY,FLR,FBZ) " +
            "VALUES(#{salesCode},#{customerName},#{customerPhone},#{salesDate},#{salesPrice},#{basePrice},#{otherCost},#{profit},#{remark})")
    int addSales(Sales sales);
}
