package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.tabs.TabLayout;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindActivity extends AppCompatActivity {

    TextView title_Text;
    TabLayout tabs_Layout;
    LinearLayout find_id_Content, find_password_Content;
    MaterialEditText find_id_by_email_Text, find_pw_by_id_Text, find_pw_by_email_Text;
    Button find_id_Button, find_pw_Button;

    Random rand = new Random();
    int emailcode = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);

        title_Text = findViewById(R.id.title_Text);
        tabs_Layout = findViewById(R.id.tabs_Layout);

        find_id_Content = findViewById(R.id.find_id_Content);
        find_password_Content = findViewById(R.id.find_password_Content);

        find_id_by_email_Text = findViewById(R.id.find_id_by_email_Text);
        find_pw_by_id_Text = findViewById(R.id.find_pw_by_id_Text);
        find_pw_by_email_Text = findViewById(R.id.find_pw_by_email_Text);

        find_id_Button = findViewById(R.id.find_id_Button);
        find_pw_Button = findViewById(R.id.find_pw_Button);

        Intent intent = getIntent();
        String key = intent.getExtras().getString("key");

        //아이디찾기로 들어오면 아이디찾기 출력
        if (key.equals(getString(R.string.find_id))) {
            title_Text.setText(key);
            find_id_Content.setVisibility(View.VISIBLE);
            find_password_Content.setVisibility(View.INVISIBLE);
        }
        //비밀번호찾기로 들어오면 비밀번호찾기 출력
        else if (key.equals(getString(R.string.find_password))) {
            title_Text.setText(key);
            find_id_Content.setVisibility(View.INVISIBLE);
            find_password_Content.setVisibility(View.VISIBLE);
        }

        tabs_Layout.addTab(tabs_Layout.newTab().setText(getString(R.string.find_id)));
        tabs_Layout.addTab(tabs_Layout.newTab().setText(getString(R.string.find_password)));
        tabs_Layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition();
                changeView(pos);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        find_id_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailcode = 0;
                String txtEmail = find_id_by_email_Text.getText().toString();

                if (android.os.Build.VERSION.SDK_INT > 9) {

                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                            .permitAll().build();

                    StrictMode.setThreadPolicy(policy);
                }
                if (!isEmail(txtEmail)) {
                    Toast.makeText(FindActivity.this, "이메일 형식이 아닙니다", Toast.LENGTH_SHORT).show();
                }
                else {
                    findID(txtEmail);
                }
            }
        });

        find_pw_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailcode = 0;
                String txtId = find_pw_by_id_Text.getText().toString();
                String txtEmail = find_pw_by_email_Text.getText().toString();

                if (android.os.Build.VERSION.SDK_INT > 9) {

                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                            .permitAll().build();

                    StrictMode.setThreadPolicy(policy);
                }
                if (!isEmail(txtEmail)) {
                    Toast.makeText(FindActivity.this, "이메일 형식이 아닙니다", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(txtId)){
                    Toast.makeText(FindActivity.this, "ID를 입력해주세요", Toast.LENGTH_SHORT).show();
                }
                else {
                    findPW(txtId, txtEmail);
                }
            }
        });
    }

    private void changeView(int index) {
        switch (index) {
            case 0:
                title_Text.setText(getString(R.string.find_id));
                find_id_Content.setVisibility(View.VISIBLE);
                find_password_Content.setVisibility(View.INVISIBLE);
                break;
            case 1:
                title_Text.setText(getString(R.string.find_password));
                find_id_Content.setVisibility(View.INVISIBLE);
                find_password_Content.setVisibility(View.VISIBLE);
                break;
        }
    }

    public static boolean isEmail(String email) {
        boolean returnValue = false;
        String regex = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        if (m.matches()) {
            returnValue = true;
        }
        return returnValue;
    }

    private void findID(final String email) {
        final ProgressDialog progressDialog = new ProgressDialog(FindActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(false);
        progressDialog.setTitle("전송중...");
        progressDialog.show();

        String URL = "http://ykh3587.dothome.co.kr/findID.php";
        StringRequest request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("right email")) {
                    MailSender Sender = new MailSender("ykhykh3587@gmail.com", "qexjxbdiizsoqwyj");
                    Toast.makeText(FindActivity.this, response, Toast.LENGTH_SHORT).show();
                    try {
                        int[] value = new int[4];
                        int im = 0;
                        int wait = 1000;
                        for (int a = 0; a < 4; a++) {
                            for (int i = 0; i < 100; i++) {
                                value[a] = rand.nextInt(10);
                                if (value[0] == 0)
                                    value[0]++;
                            }
                        }
                        for (int b = 0; b < 4; b++) {
                            im = value[b] * wait;
                            wait = wait / 10;
                            emailcode += im;
                        }
                        Sender.sendMail(
                                "[ Oishi 인증번호 ]",
                                "\n\n 안녕하세요! Oishi입니다.\n 당신의 인증번호는 [" + emailcode + "] 입니다.",
                                "ykhykh3587@gamil.com",
                                "" + email + ""
                        );
                        progressDialog.dismiss();
                        Toast.makeText(FindActivity.this, "인증번호를 전송했습니다.", Toast.LENGTH_SHORT).show();
                        Intent authenticIdIntent = new Intent(FindActivity.this, AuthenticationActivity.class);
                        authenticIdIntent.putExtra("key", emailcode);
                        authenticIdIntent.putExtra("type", getString(R.string.find_id));
                        authenticIdIntent.putExtra("email", email);
                        FindActivity.this.startActivity(authenticIdIntent);
                        finish();
                    } catch (Exception e) {
                        Log.e("SendMail", e.getMessage(), e);
                    }
                } else {
                    progressDialog.dismiss();
                    Toast.makeText(FindActivity.this, response, Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(FindActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> param = new HashMap<>();
                param.put("email", email);
                return param;
            }
        };

        request.setRetryPolicy(new DefaultRetryPolicy(30000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        MySingleton.getmInstance(FindActivity.this).addToRequestQueue(request);

    }

    private void findPW(final String userid, final String email) {
        final ProgressDialog progressDialog = new ProgressDialog(FindActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(false);
        progressDialog.setTitle("전송중...");
        progressDialog.show();

        String URL = "http://ykh3587.dothome.co.kr/findPW.php";
        StringRequest request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("right email")) {
                    MailSender Sender = new MailSender("ykhykh3587@gmail.com", "qexjxbdiizsoqwyj");
                    Toast.makeText(FindActivity.this, response, Toast.LENGTH_SHORT).show();
                    try {
                        int[] value = new int[4];
                        int im = 0;
                        int wait = 1000;
                        for (int a = 0; a < 4; a++) {
                            for (int i = 0; i < 100; i++) {
                                value[a] = rand.nextInt(10);
                                if (value[0] == 0)
                                    value[0]++;
                            }
                        }
                        for (int b = 0; b < 4; b++) {
                            im = value[b] * wait;
                            wait = wait / 10;
                            emailcode += im;
                        }
                        Sender.sendMail(
                                "[ Oishi 인증번호 ]",
                                "\n\n 안녕하세요! Oishi입니다.\n 당신의 인증번호는 [" + emailcode + "] 입니다.",
                                "ykhykh3587@gamil.com",
                                "" + email + ""
                        );
                        progressDialog.dismiss();
                        Toast.makeText(FindActivity.this, "인증번호를 전송했습니다.", Toast.LENGTH_SHORT).show();
                        Intent authenticPWIntent = new Intent(FindActivity.this, AuthenticationActivity.class);
                        authenticPWIntent.putExtra("key", emailcode);
                        authenticPWIntent.putExtra("type", getString(R.string.find_password));
                        authenticPWIntent.putExtra("email", email);
                        FindActivity.this.startActivity(authenticPWIntent);
                        finish();
                    } catch (Exception e) {
                        Log.e("SendMail", e.getMessage(), e);
                    }
                } else {
                    progressDialog.dismiss();
                    Toast.makeText(FindActivity.this, response, Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(FindActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> param = new HashMap<>();
                param.put("userid", userid);
                param.put("email", email);
                return param;
            }
        };

        request.setRetryPolicy(new DefaultRetryPolicy(30000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        MySingleton.getmInstance(FindActivity.this).addToRequestQueue(request);
    }
}