package com.example.asiantech.scanqrcode;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.asiantech.scanqrcode.model.Account;
import com.example.asiantech.scanqrcode.network.ApiClient;
import com.example.asiantech.scanqrcode.network.LoginService;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText mEdtUsername;
    private EditText mEdtPassword;
    private Button mBtnLogin;
    SharedPreferences mPre;
    SharedPreferences.Editor mEditor;
    private ProgressBar mProgressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        mPre = getSharedPreferences("LOGIN",MODE_PRIVATE);
        mEditor = mPre.edit();
        String user = mPre.getString("USER",null);
        if(user!=null){
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
        mEdtUsername = (EditText) findViewById(R.id.edtUsername);
        mEdtPassword = (EditText) findViewById(R.id.edtPassword);
        mBtnLogin = (Button) findViewById(R.id.btnLogin);
        mProgressbar = (ProgressBar)findViewById(R.id.progressBar);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mProgressbar.setVisibility(View.VISIBLE);
                if ("".equals(mEdtUsername.getText().toString())) {
                    showAlertDialog(getString(R.string.error_emtry_username));
                } else if ("".equals(mEdtPassword.getText().toString())) {
                    showAlertDialog(getString(R.string.error_emtry_password));
                } else {
                    if(checkInternetConnection(getApplicationContext())) {
                        ApiClient api = new ApiClient(getApplicationContext());
                        LoginService service = api.getClient().create(LoginService.class);
                        Call<Account> call = service.login(mEdtUsername.getText().toString(), mEdtPassword.getText().toString());
                        call.enqueue(new Callback<Account>() {
                            @Override
                            public void onResponse(Call<Account> call, Response<Account> response) {
                                String username = response.body().getUsername();
                                Log.i("TAG11",username);
                                mEditor.putString("USER", username);
                                mEditor.putString("TOKEN",response.body().getAuthToken());
                                mEditor.commit();
                                mProgressbar.setVisibility(View.GONE);
                                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                                startActivity(intent);
                                finish();

                            }

                            @Override
                            public void onFailure(Call<Account> call, Throwable t) {

                            }
                        });

                    }else{
                        Toast.makeText(getApplicationContext(),"Vui lòng kiểm tra internet",Toast.LENGTH_SHORT).show();
                        mProgressbar.setVisibility(View.GONE);
                    }

                }

            }
        });

    }

    public void showAlertDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }

    public static boolean checkInternetConnection(Context context) {
        ConnectivityManager connManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected() && networkInfo.isAvailable();
    }
}
