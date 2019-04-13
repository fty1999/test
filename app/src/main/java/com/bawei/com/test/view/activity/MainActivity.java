package com.bawei.com.test.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.bawei.com.test.R;
import com.bawei.com.test.application.Contract;
import com.bawei.com.test.model.bean.ShopBean;
import com.bawei.com.test.presenter.LoginPresenter;
import com.bawei.com.test.view.adapter.MyAdapter;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Contract.ILoginView {

    private ListView listView;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        loginPresenter = new LoginPresenter();
        loginPresenter.attch(this);
    }

    private void init() {
        listView = findViewById(R.id.listview);
    }

    @Override
    public void getPresenter(String name) {
        Gson gson = new Gson();
        ShopBean shopBean = gson.fromJson(name, ShopBean.class);
        List<ShopBean.ResultBean> result = shopBean.getResult();
        listView.setAdapter(new MyAdapter(this,result));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.detch();
    }
}
