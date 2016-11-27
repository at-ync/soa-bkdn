package com.example.asiantech.scanqrcode;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.example.asiantech.scanqrcode.network.ApiClient;
import com.example.asiantech.scanqrcode.network.PigDetailServer;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Copyright © 2016 AsianTech inc.
 * Created by ync on 26/11/2016.
 */
@EActivity(R.layout.activity_update_heath_pig)
public class UpdateHeathPig extends AppCompatActivity {
    @ViewById(R.id.edtNote)
    EditText mEdtNote;
    @ViewById(R.id.edtWeight)
    EditText mEdtWeight;
    @ViewById(R.id.spinner)
    Spinner mSpinner;
    @ViewById(R.id.progressBar)
    ProgressBar mProgressbar;
    private int mId;
    private String mToken;
    private int mHeathId;
    private static String arrays[] = {
            "Bình thường",
            "Hơi xấu",
            "Rất xấu",
            "Nguy hiểm"};

    private SharedPreferences mPre;

    @AfterViews
    void afterView() {
        mPre = getSharedPreferences("LOGIN",MODE_PRIVATE);
        mToken = mPre.getString("TOKEN",null);
        Log.i("TAG11",mToken);
        mId = getIntent().getIntExtra("ID", 0);
        Log.i("TAG11",mId+" heo");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_spinner_item,
                        arrays
                );
        mSpinner.setAdapter(adapter);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mHeathId = i+1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    @Click(R.id.btnCapNhat)
    void update() {
        mProgressbar.setVisibility(View.VISIBLE);
        ApiClient api = new ApiClient(this);
        PigDetailServer server = api.getClient().create(PigDetailServer.class);
        Call<Object> call = server.updatePig(mId,mToken,Integer.parseInt(mEdtWeight.getText().toString()),mHeathId,mEdtNote.getText().toString());
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Log.i("TAG11","AAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                mProgressbar.setVisibility(View.GONE);
                onBackPressed();
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Log.i("TAG11",t.toString());

            }
        });
    }
}
