package com.erp.controller;

import com.erp.bean.entity.InStorage;
import com.erp.service.InStorageService;
import com.erp.util.converter.JsonConverter;
import com.erp.util.result.Response;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("instorage")
public class InstorageController {
    @Autowired
    private InStorageService inStorageService;

    /**
     * 查询库存列表
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET,produces = "application/json")
    @ApiOperation(value = "查询库存列表",notes = "查询库存列表",httpMethod = "GET")
    public Response getInStorageList(@RequestParam(required = true) int pageNum,@RequestParam(required = true) int pageSize,
                                     @RequestParam(required = false) String queryTime,@RequestParam(required=false)String keywords){
        return this.inStorageService.getInStorageList(pageNum,pageSize,queryTime,keywords);
    }

    /**
     * 新增入库
     * @param inStorage
     * @return
     */
    @RequestMapping(value="add",method = RequestMethod.POST,produces = "application/json")
    @ApiOperation(value = "添加入库",notes = "添加库存",httpMethod = "POST")
    public Response addInStorage(@RequestBody InStorage inStorage){
        return this.inStorageService.addInStorage(inStorage);
    }
}
