package com.example.basicknowledge.mvp_login.model;

/**
 * 用户登录是否成功的监听
 * 里面的方法不需要参数,也不需要回传数据,只需随时调用
 */

public interface OnLoginListener {
    /**
     * 登录成功
     */
    void loginSuccess();

    /**
     * 登录失败
     */
    void loginFailed();
}