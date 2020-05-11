package com.erp.bean.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutStorage {
    //出库id
    private int outId;
    //产品型号
    private String model;
    //出库日期
    private String barCode;
    //产品价格
    private Date outDate;
    //产品价格
    private BigDecimal price;
    //出库数量
    private Integer outCount;
    //操作员
    private String operator;
    //备注
    private String remark;
}
