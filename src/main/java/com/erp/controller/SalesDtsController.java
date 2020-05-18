package com.erp.controller;

import com.erp.bean.entity.SalesDts;
import com.erp.service.SalesDtsService;
import com.erp.util.result.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/salesdts")
public class SalesDtsController {

    @Autowired
    private SalesDtsService salesDtsService;

    /**
     * 获取销售明细列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response getSalesDtsList(@RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "10")int pageSize){
        return this.salesDtsService.getSalesDtsList(pageNum,pageSize);
    }

    /**
     * 保存销售明细
     * @param salesDts
     * @return
     */
    @RequestMapping(value="/add",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response addSalesDts(@RequestBody SalesDts salesDts){
        return this.salesDtsService.addSalesDts(salesDts);
    }

}
