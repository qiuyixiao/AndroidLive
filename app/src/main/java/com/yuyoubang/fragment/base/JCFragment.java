package com.yuyoubang.fragment.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.yuyoubang.R;
import com.yuyoubang.bean.First;
import com.yuyoubang.network.api.FirstApi;

import okhttp3.FormBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lenovo on 2017/10/24.
 */

public class JCFragment extends Fragment {
    @Nullable
    RecyclerView recyclerView;
    ListView listView;
    View v;
    MyLvAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fra_jc,null);
        init();
        return v;
    }
    void init(){
//        recyclerView = (RecyclerView) v.findViewById(R.id.rcv_jc);
//        //设置布局方式瀑布流的形式
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        listView = (ListView) v.findViewById(R.id.lv_jc);
        listView.setAdapter(adapter);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://121.42.26.175:14444/")
                //添加工厂解析器
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        FirstApi firstApi = retrofit.create(FirstApi.class);
        //构建body
        FormBody body = new FormBody.Builder()
                .add("type","1")
                .add("page","1")
                .build();
        firstApi.first(body).enqueue(new Callback<First>() {
            @Override
            public void onResponse(Call<First> call, Response<First> response) {
                //发送请求成功
                Gson gson = new Gson();
                
            }

            @Override
            public void onFailure(Call<First> call, Throwable t) {

            }
        });

    }
    public class MyLvAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            return null;
        }
    }
}
