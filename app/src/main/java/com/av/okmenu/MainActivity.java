package com.av.okmenu;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.av.okmenu.adabters.CatsAdapter;
import com.av.okmenu.callData.ApiClient;
import com.av.okmenu.callData.ApiInterface;
import com.av.okmenu.classes.LoginResponse;
import com.av.okmenu.classes.SyncDataResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);
    String email="imran@beinmedia.com";
    String password="123456";
    String deviceToken="asdjakcxzx6zcsd";
    TextView tv;
    FloatingActionButton syncData_btn;
    RecyclerView recyclerView;
    CatsAdapter adapter;
    ProgressBar progress_bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.text_view);
        syncData_btn=findViewById(R.id.syncData_btn);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        progress_bar=findViewById(R.id.progress_bar);
        syncData_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("");
                progress_bar.setVisibility(View.VISIBLE);
                syncData(1);

            }
        });

     }


    public void requestLogin(String email, String password, String deviceToken) {

         Call<LoginResponse> call = apiInterface.loginApi(email,password,deviceToken);
         call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse=response.body();
                tv.setText(loginResponse.phone);
            }
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                tv.setText(t.getMessage());
            }
        });
    }

    public void syncData(int adminId) {

        Call<SyncDataResponse> call = apiInterface.syncData(adminId);
        call.enqueue(new Callback<SyncDataResponse>() {
            @Override
            public void onResponse(Call<SyncDataResponse> call, Response<SyncDataResponse> response) {
              //  LoginResponse loginResponse=response.body();
                SyncDataResponse syncDataResponse =response.body();
                if(syncDataResponse!=null) {
                    adapter = new CatsAdapter(getApplicationContext(),syncDataResponse.getCategories());
                    recyclerView.setAdapter(adapter);
                    progress_bar.setVisibility(View.GONE);
                }
            }
            @Override
            public void onFailure(Call<SyncDataResponse> call, Throwable t) {
                tv.setText(t.getMessage());
            }
        });
    }
}
