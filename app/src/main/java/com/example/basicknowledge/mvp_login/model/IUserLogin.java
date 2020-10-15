package com.example.basicknowledge.mvp_login.model;

/**
 * 用户登录接口:定义一个业务逻辑的实现方法
 */

public interface IUserLogin {
    /**
     * @param user            登录需要的用户信息
     * @param onLoginListener 登录需要的监听事件
     */
    void login(User user, OnLoginListener onLoginListener);
}