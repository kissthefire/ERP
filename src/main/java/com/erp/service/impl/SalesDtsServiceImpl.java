package com.erp.service.impl;

import com.erp.bean.entity.SalesDts;
import com.erp.mapper.SalesDtsMapper;
import com.erp.service.SalesDtsService;
import com.erp.util.result.Response;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SalesDtsServiceImpl implements SalesDtsService {

    @Autowired
    @SuppressWarnings("all")
    private SalesDtsMapper salesDtsMapper;

    /**
     * 查询销售明细列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public Response getSalesDtsList(int pageNum, int pageSize){
        PageHelper.startPage(pageNum==0?1:pageNum,pageSize==0?10:pageSize);
        PageInfo<SalesDts> pageInfo=new PageInfo<>(this.salesDtsMapper.getSalesDts());
        return Response.success(pageInfo);
    }

    /**
     * 保存销售明细
     * @param salesDts
     * @return
     */
    @Override
    public Response addSalesDts(SalesDts salesDts){
        int flag=this.salesDtsMapper.addSalesDts(salesDts);
        log.info("销售明细状态：{}",flag);
        return Response.successWithEmpty();
    }


}
