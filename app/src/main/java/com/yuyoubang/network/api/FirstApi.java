package com.yuyoubang.network.api;

import com.yuyoubang.bean.First;

import okhttp3.FormBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by lenovo on 2017/10/25.
 */

public interface FirstApi {
    @POST("find.json")
    Call<First> first(@Body FormBody body);

}
