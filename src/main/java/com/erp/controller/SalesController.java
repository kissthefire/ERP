package com.erp.controller;

import com.erp.bean.entity.Sales;
import com.erp.service.SalesService;
import com.erp.util.result.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @RequestMapping(value = "/list",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response getSalesList(@RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "10")int pageSize){
        return this.salesService.getSalesList(pageNum,pageSize);
    }

    /**
     * 添加销售记录
     * @param sales
     * @return
     */
    @RequestMapping(value="/add",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public  Response addSales(@RequestBody Sales sales){
        return this.salesService.addSales(sales);
    }

}
