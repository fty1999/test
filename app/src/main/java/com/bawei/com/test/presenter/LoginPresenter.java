package com.bawei.com.test.presenter;

import com.bawei.com.test.application.Contract;
import com.bawei.com.test.model.http.LoginModel;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/13 08:46:28
 * @Description:
 */
public class LoginPresenter implements Contract.ILoginPresenter {

    private LoginModel loginModel;
    private Contract.ILoginView view;
    @Override
    public void getModel() {

    }

    @Override
    public void attch(final Contract.ILoginView view) {
        loginModel = new LoginModel();
        this.view = view;
        loginModel.login(new Contract.ILoginModel.CallBack() {
            @Override
            public void onSuccess(String names) {
                view.getPresenter(names);
            }

            @Override
            public void onFail() {

            }
        });
    }

    @Override
    public void detch() {
        if (view!=null){
            view = null;
        }
        if (loginModel!=null){
            loginModel = null;
        }
        System.gc();
    }
}
