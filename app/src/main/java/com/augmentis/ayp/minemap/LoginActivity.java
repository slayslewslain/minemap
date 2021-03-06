package com.augmentis.ayp.minemap;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class LoginActivity extends AppCompatActivity {

    private static String TAG = "LoginActivity";

    private EditText inputEmail,
            inputPassword;

    protected TextInputLayout inputLayoutName,
            inputLayoutEmail,
            inputLayoutPassword;

    private Button btnSignIn;
    private ImageView imgLogo;
    private TextView tvRegis;
    private String email;
    private String password;
    public String statusUrl;
    public String id_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Drawable logo = ResourcesCompat
                .getDrawable(getResources(), R.drawable.logo, null);

        imgLogo = (ImageView) findViewById(R.id.imageView);
        imgLogo.setImageDrawable(logo);

        inputLayoutEmail = (TextInputLayout) findViewById(R.id.input_layout_email);
        inputLayoutPassword = (TextInputLayout) findViewById(R.id.input_layout_password);

        inputEmail = (EditText) findViewById(R.id.input_email);
        inputPassword = (EditText) findViewById(R.id.input_password);

        btnSignIn = (Button) findViewById(R.id.btn_signin);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendToDatabase();
            }
        });

        tvRegis = (TextView) findViewById(R.id.registerView);
        tvRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    public void sendToDatabase() {
        email = inputEmail.getText().toString();
        password = inputPassword.getText().toString();

        new sendToBackground().execute(email, password);
    }

    public class sendToBackground extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            email = strings[0];
            password = strings[1];

            String url = "http://minemap.hol.es/login.php?email=" + email + "&password=" + password;


            JsonHttp jsonHttp = new JsonHttp();
            String strJson = null;
            try {
                strJson = jsonHttp.getJSONUrl(url);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {

                JSONObject json = new JSONObject(strJson);
                String success = json.getString("status");

                if (success.equals("OK") == true) {
                    statusUrl = "OK";

                    JSONArray Json_array_size = json.getJSONArray("result");
                    for (int i = 0; i < Json_array_size.length(); i++) {
                        JSONObject item = Json_array_size.getJSONObject(i);
                        id_user = item.getString("id");

                    }
                } else {
                    if (success.equals("NODATA") == true) {
                        statusUrl = "NODATA";
                    }
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return statusUrl;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            if (s.equals("OK") == true) {
                Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LoginActivity.this, MapMainActivity.class);
                startActivity(intent);

                MinemapPreference.setStoredSearchKey(getApplicationContext(), id_user);
            } else {
                if (s.equals("NODATA") == true) {
                    Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_LONG).show();
                }
            }

        }
    }
}
