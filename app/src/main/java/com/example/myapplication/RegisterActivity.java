package com.example.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

public class RegisterActivity extends AppCompatActivity {

    MaterialEditText id_Text, password_Text, name_Text, email_Text, phone_Text;
    RadioGroup sex_RadioGroup;
    Button register_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        id_Text= findViewById(R.id.id_Text);
        password_Text= findViewById(R.id.password_Text);
        name_Text= findViewById(R.id.name_Text);
        email_Text= findViewById(R.id.email_Text);
        phone_Text= findViewById(R.id.phone_Text);

        sex_RadioGroup = findViewById(R.id.sex_RadioGroup);
        register_Button = findViewById(R.id.register_Button);

        register_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtId = id_Text.getText().toString();
                String txtPassword = password_Text.getText().toString();
                String txtName = name_Text.getText().toString();
                String txtEmail = email_Text.getText().toString();
                String txtPhone = phone_Text.getText().toString();

                //아이디, 비밀번호, 이름, 이메일, 핸드폰 번호 중 하나라도 공백일 경우
                if (TextUtils.isEmpty(txtId) || TextUtils.isEmpty(txtPassword) || TextUtils.isEmpty(txtName) || TextUtils.isEmpty(txtEmail) || TextUtils.isEmpty(txtPhone)) {
                    Toast.makeText(RegisterActivity.this, "All fields required", Toast.LENGTH_SHORT).show();
                }
                //아이디, 비밀번호, 이름, 이메일, 핸드폰 번호 모두 입력 되어 있을 경우
                else {
                    int genderId = sex_RadioGroup.getCheckedRadioButtonId();
                    RadioButton selected_Gender = sex_RadioGroup.findViewById(genderId);
                    //성별 라디오버튼 체크 안했을 경우
                    if (selected_Gender == null) {
                        Toast.makeText(RegisterActivity.this, "Select gender Please", Toast.LENGTH_SHORT).show();
                    }
                    //성별까지 모두 다 입력되어 있을경우
                    else {
                        String selectGender = selected_Gender.getText().toString();
                        registerNewAccount(txtId, txtName, txtEmail, txtPassword, txtPhone, selectGender);
                    }
                }
            }
        });
    }

    //아이디(1), 이름(2), 이메일(3), 비밀번호(4), 핸드폰 번호(5), 성별(6)을 사용자 데이터베이스에 추가
    private void registerNewAccount(final String userid, final String username, final String email, final String password, final String mobile, final String gender) {
        //데이터베이스 URL에 접속해서 register.php 파일을 열어서 진행한 후 결과값 반환까지의 진행기록(progressDialog) 보여줌
        final ProgressDialog progressDialog = new ProgressDialog(RegisterActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(false);
        progressDialog.setTitle("계정 생성 중...");
        progressDialog.show();

        String URL = "http://ykh3587.dothome.co.kr/register.php";
        //register.php파일에서 반환된 응답값을 이용하는 함수
        StringRequest request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //register.php파일의 반환값이 "Successfully Registered"와 일치
                if (response.equals("Successfully Registered")) {
                    progressDialog.dismiss();
                    Toast.makeText(RegisterActivity.this, response, Toast.LENGTH_SHORT).show();
                    RegisterActivity.this.startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    finish();
                }
                //register.php파일의 반환값이 "Successfully Registered"와 불일치
                else {
                    progressDialog.dismiss();
                    Toast.makeText(RegisterActivity.this, response, Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //register.php파일의 반환값이 "Connection Error"와 일치
                progressDialog.dismiss();
                Toast.makeText(RegisterActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            //register.php파일에 전달할 데이터 param으로 반환
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> param = new HashMap<>();
                param.put("userid", userid);
                param.put("username", username);
                param.put("email", email);
                param.put("password", password);
                param.put("mobile", mobile);
                param.put("gender", gender);

                return param;
            }
        };

        request.setRetryPolicy(new DefaultRetryPolicy(30000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        MySingleton.getmInstance(RegisterActivity.this).addToRequestQueue(request);

    }
}