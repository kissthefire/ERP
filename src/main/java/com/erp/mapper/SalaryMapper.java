package com.erp.mapper;

import com.erp.bean.entity.Salary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SalaryMapper {
    /**
     * 查询员工薪资列表
     * @return
     */
    @Select("SELECT  FID fid,FXM deployeeName,FJBGZ salary,FZJTC cookeerRoyalty,FRSQTC heaterRoyalty,FQTTC otherRoyalty, " +
            "FZJAZF cookeerInstallCost,FRSQAZF heaterInstallCost,FQTAZF otherInstallCost,FFJXZ totalSalary,FFXRQ payDate,FBZ remark FROM ygxz")
    List<Salary> getSalaryList();
}
