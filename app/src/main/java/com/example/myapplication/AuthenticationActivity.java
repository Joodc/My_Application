package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
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

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationActivity extends AppCompatActivity {

    TextView found_Text, login_Button, search_id_Button, search_password_Button;
    LinearLayout found_Content;
    MaterialEditText authentic_Text;
    Button confirm_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        found_Text = findViewById(R.id.found_Text);
        login_Button = findViewById(R.id.login_Button);
        search_id_Button = findViewById(R.id.search_id_Button);
        search_password_Button = findViewById(R.id.search_password_Button);

        found_Content = findViewById(R.id.found_Content);
        authentic_Text = findViewById(R.id.authentic_Text);
        confirm_Button = findViewById(R.id.confirm_Button);

        Intent intent = getIntent();
        final int key = intent.getExtras().getInt("key");
        final String type = intent.getExtras().getString("type");
        final String email = intent.getExtras().getString("email");

        confirm_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtAuthentic = authentic_Text.getText().toString();
                if (key == Integer.parseInt(txtAuthentic)) {
                    if(type.equals(getString(R.string.find_id))) {
                        showID(email);
                    }
                    else {
                        showPW(email);
                    }
                    found_Content.setVisibility(View.VISIBLE);
                    Toast.makeText(AuthenticationActivity.this, "인증번호가 맞습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    found_Content.setVisibility(View.INVISIBLE);
                    Toast.makeText(AuthenticationActivity.this, "잘못된 인증번호입니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        login_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(AuthenticationActivity.this, LoginActivity.class);
                AuthenticationActivity.this.startActivity(loginIntent);
                finish();
            }
        });

        search_id_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent searchIdIntent = new Intent(AuthenticationActivity.this, FindActivity.class);
                searchIdIntent.putExtra("key", getString(R.string.find_id));
                AuthenticationActivity.this.startActivity(searchIdIntent);
                finish();
            }
        });

        search_password_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent searchPwIntent = new Intent(AuthenticationActivity.this, FindActivity.class);
                searchPwIntent.putExtra("key", getString(R.string.find_password));
                AuthenticationActivity.this.startActivity(searchPwIntent);
                finish();
            }
        });
    }

    private void showID(final String email) {
        String URL = "http://ykh3587.dothome.co.kr/showID.php";
        StringRequest request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("response");
                    String userid, e_mail;

                    for(int count = 0 ; count < jsonArray.length() ; count++) {
                        JSONObject object = jsonArray.getJSONObject(count);
                        //count는 배열의 인덱스를 의미
                        userid = object.getString("userid");//여기서 ID가 대문자임을 유의
                        e_mail = object.getString("email");
                        if (email.equals(e_mail)) {
                            found_Text.setText("ID : " + userid);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(AuthenticationActivity.this, response, Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AuthenticationActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> param = new HashMap<>();
                return param;
            }
        };
        request.setRetryPolicy(new DefaultRetryPolicy(30000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        MySingleton.getmInstance(AuthenticationActivity.this).addToRequestQueue(request);
    }

    private void showPW(final String email) {
        String URL = "http://ykh3587.dothome.co.kr/showPW.php";
        StringRequest request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("response");
                    String password, e_mail;

                    for(int count = 0 ; count < jsonArray.length() ; count++) {
                        JSONObject object = jsonArray.getJSONObject(count);
                        //count는 배열의 인덱스를 의미
                        password = object.getString("password");//여기서 ID가 대문자임을 유의
                        e_mail = object.getString("email");
                        if (email.equals(e_mail)) {
                            found_Text.setText("PW : " + password);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(AuthenticationActivity.this, response, Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AuthenticationActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> param = new HashMap<>();
                return param;
            }
        };
        request.setRetryPolicy(new DefaultRetryPolicy(30000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        MySingleton.getmInstance(AuthenticationActivity.this).addToRequestQueue(request);
    }

    //모든회원에 대한 정보를 가져오기 위한 쓰레드
    /*
    class BackgroundTask extends AsyncTask<Void, Void, String> {
        String target;

        @Override
        protected void onPreExecute() {
            //List.php은 파싱으로 가져올 웹페이지
            target = "http://ykh3587.dothome.co.kr/showme.php";
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL(target);//URL 객체 생성
                //URL을 이용해서 웹페이지에 연결하는 부분
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                //바이트단위 입력스트림 생성 소스는 httpURLConnection
                InputStream inputStream = httpURLConnection.getInputStream();
                //웹페이지 출력물을 버퍼로 받음 버퍼로 하면 속도가 더 빨라짐
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;
                //문자열 처리를 더 빠르게 하기 위해 StringBuilder클래스를 사용함
                StringBuilder stringBuilder = new StringBuilder();
                //한줄씩 읽어서 stringBuilder에 저장함
                while ((temp = bufferedReader.readLine()) != null) {
                    stringBuilder.append(temp + "\n");//stringBuilder에 넣어줌
                }
                //사용했던 것도 다 닫아줌
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();//trim은 앞뒤의 공백을 제거함
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            try {
                //intent로 값을 가져옵니다 이때 JSONObject타입으로 가져옵니다
                JSONObject jsonObject = new JSONObject(result);
                //List.php 웹페이지에서 response라는 변수명으로 JSON 배열을 만들었음..
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                String txtEmail = email.getText().toString();
                String userid, e_mail;
                int count = 0;
                while (count < jsonArray.length()) {
                    JSONObject object = jsonArray.getJSONObject(count);
                    //count는 배열의 인덱스를 의미
                    userid = object.getString("userid");//여기서 ID가 대문자임을 유의
                    e_mail = object.getString("email");
                    if(txtEmail == e_mail) {
                        youremail.setText("D");
                    }
                    count++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
     */
}