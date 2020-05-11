package com.erp.bean.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 入库
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InStorage {
    //入库id
    private Integer intoId;
    //型号
    private String model;
    //条形码
    private String barCode;
    //入库日期
    private String intoDate;
    //产品单价
    private BigDecimal price;
    //入库数量
    private Integer inCount;
    //操作员
    private String operator;
    //备注
    private String remark;
}
