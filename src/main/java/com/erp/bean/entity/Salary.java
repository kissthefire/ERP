package com.erp.bean.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 员工薪资
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salary {
    //员工id
    private Integer fid;
    //员工姓名
    private String deployeeName;
    //工资
    private BigDecimal salary;
    //灶具提成
    private BigDecimal cookeerRoyalty;
    //热水器提成
    private BigDecimal heaterRoyalty;
    //其他提成费用
    private BigDecimal otherRoyalty;
    //灶具安装费用
    private BigDecimal cookeerInstallCost;
    //热水器安装费用
    private BigDecimal heaterInstallCost;
    //其他安装费用
    private BigDecimal otherInstallCost;
    //合计薪资
    private BigDecimal totalSalary;
    //发薪日期
    private Date payDate;
    //备注
    private String remark;





}
