package com.erp.service;

import com.erp.bean.entity.Sales;
import com.erp.util.result.Response;

public interface SalesService {
    /**
     * 获取销售列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    Response getSalesList(int pageNum,int pageSize);

    /**
     * 添加销售记录
     * @param sales
     * @return
     */
    Response addSales(Sales sales);
}
