package com.erp.service.impl;

import com.erp.bean.entity.InStorage;
import com.erp.bean.entity.OutStorage;
import com.erp.mapper.OutStorageMapper;
import com.erp.service.OutStorageService;
import com.erp.util.result.Response;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OutStorageServiceImpl implements OutStorageService {

    @Autowired
    @SuppressWarnings("all")
    private OutStorageMapper outStorageMapper;

    /**
     * 查询出库列表
     * @return
     */
    @Override
    public Response getOutStorageList(int pageNum,int pageSize){
        PageHelper.startPage(pageNum==0?1:pageNum,pageSize==0?10:pageSize);
        PageInfo<InStorage> pageInfo=new PageInfo<InStorage>(this.outStorageMapper.getOutStorageList());
        return Response.success(pageInfo);
    }

    /**
     * 新增出库
     * @param outStorage
     * @return
     */
    @Override
    public Response addOutStorage(OutStorage outStorage){
        int flag=this.outStorageMapper.addOutStorage(outStorage);
        log.info("保存出库结果为：{}",flag);
        return Response.successWithEmpty();
    }
}
