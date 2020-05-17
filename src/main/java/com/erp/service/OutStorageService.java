package com.erp.service;

import com.erp.bean.entity.InStorage;
import com.erp.bean.entity.OutStorage;
import com.erp.util.result.Response;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OutStorageService {
    /**
     * 查询出库列表
     * @return
     */
    Response getOutStorageList(int pageNum,int pageSize);

    /**
     * 新增出库
     * @param outStorage
     * @return
     */
    Response addOutStorage(OutStorage outStorage);
}
