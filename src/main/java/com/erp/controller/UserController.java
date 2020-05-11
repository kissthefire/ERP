package com.erp.controller;

import com.erp.bean.entity.User;
import com.erp.util.result.Response;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public Response login(@RequestBody User user){
        if(StringUtils.isEmpty(user.getUsername())||!"admin".equals(user.getUsername())){
            return Response.error("用户名或密码不正确");
        }
        if(StringUtils.isEmpty(user.getPassword())||!"123456".equals(user.getPassword())){
            return Response.error("用户名或密码不正确");
        }
        Map map=new LinkedHashMap();
        String token= UUID.randomUUID().toString();
        map.put("token",token);
        return Response.success(map);
    }
}
