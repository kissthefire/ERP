package com.erp.controller;

import com.erp.service.SalaryService;
import com.erp.util.result.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    /**
     * 查询员工薪资列表
     * @return
     */
    @RequestMapping(value="list",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response getSalaryList(@RequestParam(required = true) int pageNum,@RequestParam(required = false) int pageSize){
        return this.salaryService.getSalaryList(pageNum,pageSize);
    }

}
