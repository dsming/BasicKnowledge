package com.example.basicknowledge.mvp_login.model;


/**
 * 用户登录的具体实现类,实现定义的接口,毕竟,接口里方法是没有办法直接使用的
 * 在这里实现具体的登录操作
 */

public class UserLogin implements IUserLogin {
    @Override
    public void login(final User user, final OnLoginListener onLoginListener) {
        //模拟联网校验过程耗时操作
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //模拟登录成功
                if (user.getUsername().equals("devil") && user.getUserpassword().equals("123456")) {
                    //登录成功
                    onLoginListener.loginSuccess();
                } else {
                    //登录失败
                    onLoginListener.loginFailed();
                }
            }
        }.start();
    }
}