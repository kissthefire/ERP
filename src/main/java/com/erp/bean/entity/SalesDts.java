package com.erp.bean.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 销售明细
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesDts {
    //流水号
    private Integer salesDtsId;
    //销售编号
    private String salesCode;
    //客户姓名
    private String customerName;
    //客户地址
    private String customerAddress;
    //客户电话
    private String customerPhone;
    //产品型号
    private String model;
    //条形码
    private String barCode;
    //销售金额
    private BigDecimal salesAmount;
    //收款方式
    private BigDecimal payWay;
    //销售日期
    private String salesDate;
    //销售人员
    private String salesman;
    //安装人员
    private String installman;
    //是否送管
    private Integer includePiple;
    //备注
    private String remark;
}
