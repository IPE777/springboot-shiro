package com.wangyuhang.service;


import com.wangyuhang.pojo.User;

public interface UserService {

    User queryUserByName(String name);
}