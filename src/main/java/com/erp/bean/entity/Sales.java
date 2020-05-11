package com.erp.bean.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 销售
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sales {
    //id
    private Integer salesId;
    //销售编号
    private String salesCode;
    //客户姓名
    private String customerName;
    //客户电话
    private String customerPhone;
    //销售日期
    private Date salesDate;
    //销售价格
    private BigDecimal salesPrice;
    //成本价格
    private BigDecimal basePrice;
    //其他费用
    private BigDecimal otherCost;
    //利润
    private BigDecimal profit;
    //备注
    private String remark;
}
