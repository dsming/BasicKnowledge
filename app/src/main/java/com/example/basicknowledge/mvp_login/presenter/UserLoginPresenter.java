package com.example.basicknowledge.mvp_login.presenter;

import com.example.basicknowledge.mvp_login.model.IUserLogin;
import com.example.basicknowledge.mvp_login.model.OnLoginListener;
import com.example.basicknowledge.mvp_login.model.User;
import com.example.basicknowledge.mvp_login.model.UserLogin;
import com.example.basicknowledge.mvp_login.view.UserLoginView;

/**
 * 连接view层和model的桥梁,--->中介的性质
 * Presenter是用作Model和View之间交互的桥梁，那么应该有什么方法呢？
 * 其实也是主要看该功能有什么操作，比如本例，两个操作:login和clear。
 */
public class UserLoginPresenter {
    private IUserLogin userLogin;//model层
    private UserLoginView userLoginView;//view层

    //v层的有参构造--->因为viewactivity调用时只需要传递上下文
    public UserLoginPresenter(UserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        this.userLogin = new UserLogin();
    }

    /**
     * 供调用的登录方法 login
     */
    public void login() {
        userLoginView.showLoadding();
        User user = new User(userLoginView.getUserName(), userLoginView.getUserPassword());
        //m层登录业务操作类
        userLogin.login(user, new OnLoginListener() {
            @Override
            public void loginSuccess() {
                //登录成功
                userLoginView.toActivity();
                //隐藏进度条
                userLoginView.hideLoadding();
            }

            @Override
            public void loginFailed() {
                //登录失败
                userLoginView.loadFailed();
                //隐藏进度条
                userLoginView.hideLoadding();
            }
        });
    }

    /**
     * 供调用的重置方法 clear
     */
    public void clear() {
        userLoginView.clearUserMessage();
    }
}
