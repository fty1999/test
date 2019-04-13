package com.bawei.com.test.application;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/13 08:37:16
 * @Description:
 */

/**
 * 契约接口
 */
public interface Contract {

    //IView
    public interface ILoginView{
        //获取数据的方法
        void getPresenter(String name);
    }
    //Imodel
    public interface ILoginModel{
        //业务数据处理 数据库 网络数据
        void login(ILoginModel.CallBack callBack);
        interface CallBack{
            //成功返回
            void onSuccess(String names);
            //失败返回
            void onFail();
        }
    }
    //IPresenter
    public interface ILoginPresenter{
        //view与model交互的纽带
        void getModel();
        //绑定
        void attch(ILoginView view);
        //解绑
        void detch();
    }
}
