package com.erp.mapper;

import com.erp.bean.entity.InStorage;
import com.erp.bean.entity.SalesDts;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SalesDtsMapper {
    /**
     * 查询销售明细列表
     * @return
     */
    @Select(" SELECT FID salesDtsId,FXSBM salesCode,FNAME customerName,FADDR customerAddress,FPHONE customerPhone,FCPXH model,FTXM barCode," +
            "FXSJE salesAmount,FSKFS payWay,FXSRQ salesDate,FXSRY salesman,FAZRY installman,FSFSG includePiple,FBZ remark FROM xsmx ")
    List<SalesDts> getSalesDts();

    /**
     * 新增入库
     * @param salesDts
     * @return
     */
    @Insert("INSERT INTO xsmx(FXSBM,FNAME,FADDR,FPHONE,FCPXH,FTXM,FXSJE,FSKFS,FXSRQ,FXSRY,FAZRY,FSFSG,FBZ)  " +
            "VALUES(#{salesCode},#{customerName},#{customerAddress},#{customerPhone},#{model},#{barCode},#{salesAmount},#{payWay}, " +
            "#{salesDate},#{salesman},#{installman},#{includePiple},#{remark})")
    int addSalesDts(SalesDts salesDts);
}
