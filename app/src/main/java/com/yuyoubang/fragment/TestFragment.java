package com.yuyoubang.fragment;

import android.os.Bundle;
import android.view.View;

import com.yuyoubang.R;
import com.yuyoubang.fragment.base.BaseNetFragment;
import com.yuyoubang.network.RetrofitManager;
import com.yuyoubang.network.api.TestApi;

import retrofit2.Call;

/**
 * Created by xiaoyuan on 16/11/6.
 */

public class TestFragment extends BaseNetFragment<Object> {

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        goneLoading();
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void loadData() {
        TestApi testApi = RetrofitManager.getTestRetrofit().create(TestApi.class);
        Call<Object> testCall = testApi.test();
        testCall.enqueue(this);
    }

    @Override
    protected void processData(Object o) {

    }

    @Override
    protected int getContentResId() {
        return R.layout.activity_test;
    }
}
