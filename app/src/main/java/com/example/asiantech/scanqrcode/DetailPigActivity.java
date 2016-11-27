package com.example.asiantech.scanqrcode;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asiantech.scanqrcode.adapter.HealthAdapter;
import com.example.asiantech.scanqrcode.model.HealthJournalList;
import com.example.asiantech.scanqrcode.model.Race;
import com.example.asiantech.scanqrcode.model.ResultPig;
import com.example.asiantech.scanqrcode.network.ApiClient;
import com.example.asiantech.scanqrcode.network.LoginService;
import com.example.asiantech.scanqrcode.network.PigDetailServer;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Copyright © 2016 AsianTech inc.
 * Created by ync on 26/11/2016.
 */
@EActivity(R.layout.detail_pig)
public class DetailPigActivity extends AppCompatActivity {

    @ViewById(R.id.tvMaSo)
    TextView mTvMaSo;
    @ViewById(R.id.tvGiong)
    TextView mTvGiong;
    @ViewById(R.id.tvKhoiLuong)
    TextView mTvKHoiLuong;
    @ViewById(R.id.tvDangNuoi)
    TextView mTvDangNuoi;
    @ViewById(R.id.tvMaChuong)
    TextView mTvMaChuong;
    @ViewById(R.id.tvTienDoSinhTruong)
    TextView mTvTienDoSinhTruong;
    @ViewById(R.id.recyclerview)
    RecyclerView mRecyclerView;
    private int maHeo;
    private HealthAdapter mAdapter;
    private boolean isCheck=false;


    @AfterViews
    void afterView() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        int id = Integer.parseInt(getIntent().getStringExtra("ID"));
        if(checkInternetConnection(this)) {
            ApiClient api = new ApiClient(this);
            PigDetailServer server = api.getClient().create(PigDetailServer.class);
            final Call<ResultPig> resultPigCall = server.getDetailPig(id);
            resultPigCall.enqueue(new Callback<ResultPig>() {
                @Override
                public void onResponse(Call<ResultPig> call, Response<ResultPig> response) {
                    ResultPig resultPig = response.body();
                    maHeo = resultPig.getId();
                    Race race = resultPig.getRace();
                    if (race != null) {
                        isCheck = true;
                        List<HealthJournalList> healthJournalLists = resultPig.getHealthJournalLists();
                        if(healthJournalLists==null){
                            Log.i("TAG11","NULLL");
                        }else{
                            Log.i("TAG11","size"+healthJournalLists.size());
                        }
                        mAdapter = new HealthAdapter(healthJournalLists);
                        mRecyclerView.setAdapter(mAdapter);
                        if (resultPig != null) {
                            mTvMaSo.setText(resultPig.getId() + "");
                            mTvKHoiLuong.setText(resultPig.getWeight() + "");
                            mTvMaChuong.setText(resultPig.getPigpenId() + "");
                            mTvGiong.setText(race.getName());
                            long currentTime = new Date().getTime();
                            long percent = Math.round((float) (currentTime - resultPig.getCreatedAt()) / 86400000 / race.getTotalGrowingDays() * 100);
                            mTvTienDoSinhTruong.setText(percent + "%");
                            if (race.isValid()) {
                                mTvDangNuoi.setText("Đang nuôi");
                            }

                        } else {
                            Log.i("TAG11", "222222222222222222");
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "ID Không đúng", Toast.LENGTH_LONG).show();
                        isCheck = false;
                    }
                }

                @Override
                public void onFailure(Call<ResultPig> call, Throwable t) {
                    Log.i("TAG11", t.toString());
                }
            });
        }else{
            Toast.makeText(getApplicationContext(),"Vui lòng kiểm tra internet",Toast.LENGTH_SHORT).show();
        }

    }

    @Click(R.id.btnCapNhat)
    void update() {
        if(isCheck) {
            Intent intent = new Intent(this, UpdateHeathPig_.class);
            intent.putExtra("ID", maHeo);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(),"Vui lòng quét lại mã một lần nữa",Toast.LENGTH_SHORT).show();
        }
    }
    public static boolean checkInternetConnection(Context context) {
        ConnectivityManager connManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected() && networkInfo.isAvailable();
    }
}
