package com.bawei.com.test.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.com.test.R;
import com.bawei.com.test.model.bean.ShopBean;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/13 08:32:14
 * @Description:
 */
public class MyAdapter extends BaseAdapter {

    Context context;
    private List<ShopBean.ResultBean> list;

    public MyAdapter(Context context, List<ShopBean.ResultBean> shopBeanResult) {
        this.context = context;
        this.list = shopBeanResult;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null){
            view = View.inflate(context, R.layout.item,null);
            holder = new ViewHolder();
            holder.textView = view.findViewById(R.id.textView);
            holder.imageView = view.findViewById(R.id.imageView);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        ShopBean.ResultBean resultBean = list.get(i);
        holder.textView.setText(resultBean.getName());
        Glide.with(context).load(resultBean.getLogo()).into(holder.imageView);
        return view;
    }

    class ViewHolder{
        TextView textView;
        ImageView imageView;
    }
}
