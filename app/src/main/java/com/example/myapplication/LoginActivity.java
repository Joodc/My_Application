package com.example.myapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    MaterialEditText id_Text, password_Text;
    CheckBox login_Checkbox;
    Button login_Button;
    TextView register_Button, search_id_Button, search_password_Button;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);

        id_Text = findViewById(R.id.id_Text);
        password_Text = findViewById(R.id.password_Text);
        login_Checkbox = findViewById(R.id.login_Checkbox);
        login_Button = findViewById(R.id.login_Button);
        register_Button = findViewById(R.id.register_Button);
        search_id_Button = findViewById(R.id.search_id_Button);
        search_password_Button = findViewById(R.id.search_password_Button);

        register_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
                finish();
            }
        });

        login_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String txtId = id_Text.getText().toString();
                String txtPassword = password_Text.getText().toString();
                if (TextUtils.isEmpty(txtId) || TextUtils.isEmpty(txtPassword)) {
                    Toast.makeText(LoginActivity.this, "All fields required", Toast.LENGTH_SHORT).show();
                } else {
                    login(txtId, txtPassword);
                }
            }
        });

        String loginStatus = sharedPreferences.getString(getResources().getString(R.string.prefLoginState), "");
        if (loginStatus.equals("log-in")) {
            LoginActivity.this.startActivity(new Intent(LoginActivity.this, MainActivity.class));
        }

        search_id_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent searchIdIntent = new Intent(LoginActivity.this, FindActivity.class);
                searchIdIntent.putExtra("key", getString(R.string.find_id));
                LoginActivity.this.startActivity(searchIdIntent);
                finish();
            }
        });

        search_password_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent searchPwIntent = new Intent(LoginActivity.this, FindActivity.class);
                searchPwIntent.putExtra("key", getString(R.string.find_password));
                LoginActivity.this.startActivity(searchPwIntent);
                finish();
            }
        });
    }

    private void login(final String userid, final String password) {
        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(false);
        progressDialog.setTitle("로그인 중...");
        progressDialog.show();

        String URL = "http://ykh3587.dothome.co.kr/login.php";
        StringRequest request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("Login Success")) {
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this, response, Toast.LENGTH_SHORT).show();

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    if (login_Checkbox.isChecked()) {
                        editor.putString(getResources().getString(R.string.prefLoginState), "log-in");
                    }
                    else {
                        editor.putString(getResources().getString(R.string.prefLoginState), "log-out");
                    }
                    editor.apply();

                    LoginActivity.this.startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }

                else {
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this, response, Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> param = new HashMap<>();
                param.put("userid", userid);
                param.put("password", password);

                return param;
            }
        };

        request.setRetryPolicy(new DefaultRetryPolicy(30000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        MySingleton.getmInstance(LoginActivity.this).addToRequestQueue(request);

    }
}