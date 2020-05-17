package com.erp.service.impl;

import com.erp.bean.entity.InStorage;
import com.erp.bean.entity.Sales;
import com.erp.mapper.SalesMapper;
import com.erp.service.SalesService;
import com.erp.util.result.Response;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SalesServiceImpl implements SalesService {

    @Autowired
    @SuppressWarnings("all")
    private SalesMapper salesMapper;

    /**
     * 获取销售列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public Response getSalesList(int pageNum, int pageSize){
        PageHelper.startPage(pageNum==0?1:pageNum,pageSize==0?10:pageSize);
        PageInfo<Sales> pageInfo=new PageInfo<Sales>(this.salesMapper.getSalesList());
        return Response.success(pageInfo);
    }

    /**
     * 添加销售记录
     * @param sales
     * @return
     */
    @Override
    public Response addSales(Sales sales){
        int flag=this.salesMapper.addSales(sales);
        log.info("保存销售单结果为：{}",flag);
        return Response.successWithEmpty();
    }
}
