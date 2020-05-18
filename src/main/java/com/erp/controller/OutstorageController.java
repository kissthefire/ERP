package com.erp.controller;

import com.erp.bean.entity.InStorage;
import com.erp.bean.entity.OutStorage;
import com.erp.service.InStorageService;
import com.erp.service.OutStorageService;
import com.erp.util.result.Response;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("outstorage")
public class OutstorageController {
    @Autowired
    private OutStorageService outStorageService;

    /**
     * 查询库存列表
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET,produces = "application/json")
    @ApiOperation(value = "查询库存列表",notes = "查询库存列表",httpMethod = "GET")
    public Response getOutStorageList(@RequestParam(required = true) int pageNum,@RequestParam(required = true) int pageSize,
                                     @RequestParam(required = false) String queryTime,@RequestParam(required=false)String keywords){
        return this.outStorageService.getOutStorageList(pageNum,pageSize,queryTime,keywords);
    }

    /**
     * 新增入库
     * @param outStorage
     * @return
     */
    @RequestMapping(value="add",method = RequestMethod.POST,produces = "application/json")
    @ApiOperation(value = "添加入库",notes = "添加库存",httpMethod = "POST")
    public Response addInStorage(@RequestBody OutStorage outStorage){
        return this.outStorageService.addOutStorage(outStorage);
    }
}
