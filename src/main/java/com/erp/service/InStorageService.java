package com.erp.service;

import com.erp.bean.entity.InStorage;
import com.erp.bean.entity.SalesDts;
import com.erp.util.result.Response;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface InStorageService {
    /**
     * 查询库存列表
     * @return
     */
    Response getInStorageList(int pageNum,int pageSize);

    /**
     * 新增入库
     * @param inStorage
     * @return
     */
    Response addInStorage(InStorage inStorage);
}
