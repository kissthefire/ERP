package com.erp.service.impl;

import com.erp.bean.entity.Salary;
import com.erp.mapper.SalaryMapper;
import com.erp.service.SalaryService;
import com.erp.util.result.Response;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    @SuppressWarnings("all")
    private SalaryMapper salaryMapper;

    /**
     * 查询员工薪资列表
     * @return
     */
    @Override
    public Response getSalaryList(int pageNum,int pageSize){
        PageHelper.startPage(pageNum==0?1:pageNum,pageSize==0?10:pageSize);
        PageInfo<Salary> pageInfo=new PageInfo<>(this.salaryMapper.getSalaryList());
        return Response.success(pageInfo);
    }
}
