package com.erp.service.impl;

import com.erp.bean.entity.InStorage;
import com.erp.bean.entity.SalesDts;
import com.erp.mapper.InStorageMapper;
import com.erp.service.InStorageService;
import com.erp.util.result.Response;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.netty.util.internal.SuppressJava6Requirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InStorageServiceImpl implements InStorageService {
    @Autowired
    @SuppressWarnings("all")
    private InStorageMapper inStorageMapper;

    /**
     * 查询库存列表
     * @return
     */
    @Override
    public Response getInStorageList(int pageNum, int pageSize,String intoDate,String keywords){
        PageHelper.startPage(pageNum==0?1:pageNum,pageSize==0?10:pageSize);
        PageInfo<InStorage> pageInfo=new PageInfo<InStorage>(this.inStorageMapper.getInStorageList(intoDate,keywords));
        return Response.success(pageInfo);
    }

    /**
     * 新增入库
     * @param inStorage
     * @return
     */
    @Override
    public Response addInStorage(InStorage inStorage){
        int flag=this.inStorageMapper.addInStorage(inStorage);
        if(flag>0){
            return Response.successWithEmpty();
        }
        return Response.error("新增库存失败");
    }
}
