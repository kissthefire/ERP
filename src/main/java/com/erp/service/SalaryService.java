package com.erp.service;

import com.erp.bean.entity.Salary;
import com.erp.util.result.Response;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SalaryService {
    /**
     * 查询员工薪资列表
     * @return
     */
    Response getSalaryList(int pageNum,int pageSize);
}
