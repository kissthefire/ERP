package com.erp.service;

import com.erp.bean.entity.SalesDts;
import com.erp.util.result.Response;

public interface SalesDtsService {
    /**
     * 查询销售明细列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    Response getSalesDtsList(int pageNum,int pageSize);

    /**
     * 保存销售明细
     * @param salesDts
     * @return
     */
    Response addSalesDts(SalesDts salesDts);
}
