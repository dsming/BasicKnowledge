package com.example.basicknowledge.mvp_login.view;

/**
 * view层,顾名思义,视图层,针对的是activity和fragment;
 * 负责从视图中获取相应的数据和更新UI
 */

public interface UserLoginView {

    /**
     * 获取用户输入的信息
     * @return
     */
    String getUserName();

    /**
     * 获取用户输入的信息
     * @return
     */
    String getUserPassword();
    /**
     *显示进度条
     */
    void showLoadding();

    /**
     * 隐藏进度条
     */
    void hideLoadding();

    /**
     * 登陆成功
     */
    void toActivity();

    /**
     * 登陆失败了
     */
    void loadFailed();

    /**
     * 重置信息
     */
    void clearUserMessage();
}