package com.akioss.leanote.model.rest;

import com.akioss.leanote.common.Constants;
import com.akioss.leanote.model.entities.AccountInfo;
import com.akioss.leanote.model.entities.BaseInfo;
import com.akioss.leanote.model.entities.NoteItem;
import com.akioss.leanote.model.entities.UserInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import java.io.File;
import java.util.List;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 15/11/25.
 * Package: com.akioss.leanote.model.rest
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
public class DataSourceService implements DataSourceRestAPI {

    private final DataSourceRestAPI dataSourceAPI;

    private static DataSourceService _INSTANCE = new DataSourceService();

    private OkHttpClient client;

    public static DataSourceService getInstance() {
        return _INSTANCE;
    }

    private DataSourceService() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-ddHH:mm:ss")
                .create();

        client = new OkHttpClient();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        dataSourceAPI = retrofit.create(DataSourceRestAPI.class);
    }

    public OkHttpClient getClient() {
        return client;
    }

    @Override
    public Call<AccountInfo> authLogin(String email, String pwd) {
        return dataSourceAPI.authLogin(email, pwd);
    }

    @Override
    public Call<BaseInfo> logout(String token) {
        return dataSourceAPI.logout(token);
    }

    @Override
    public Call<BaseInfo> register(String email, String pwd) {
        return dataSourceAPI.register(email, pwd);
    }

    @Override
    public Call<UserInfo> getUserInfo(String userId, String token) {
        return dataSourceAPI.getUserInfo(userId, token);
    }

    @Override
    public Call<BaseInfo> updateUsername(String userName, String token) {
        return dataSourceAPI.updateUsername(userName, token);
    }

    @Override
    public Call<BaseInfo> updatePwd(String oldPwd, String newPwd, String token) {
        return dataSourceAPI.updatePwd(oldPwd, newPwd, token);
    }

    @Override
    public Call<BaseInfo> updateLogo(File file) {
        return null;
    }

    @Override
    public Call<List<NoteItem>> getNotes(int afterUsn, int maxEntry, String token) {
        return dataSourceAPI.getNotes(afterUsn, maxEntry, token);
    }
}
