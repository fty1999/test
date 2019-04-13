package com.bawei.com.test.model.http;

import com.bawei.com.test.application.Contract;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/13 09:09:12
 * @Description:
 */
public class LoginModel implements Contract.ILoginModel {
    public static final String BaseUrl = "http://172.17.8.100/movieApi/cinema/v1/findRecommendCinemas?page=1&count=10";
    @Override
    public void login(final Contract.ILoginModel.CallBack callBack) {
        AsyncHttpClient.getInstance().GetAsync(BaseUrl, new AsyncHttpClient.AsyncCallBack() {
            @Override
            public void Error(int errorcode, String message) {

            }

            @Override
            public void Succorce(String result) {
                callBack.onSuccess(result);
            }
        });
    }
}
