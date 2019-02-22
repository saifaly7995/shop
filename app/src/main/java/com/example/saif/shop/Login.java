package com.example.saif.shop;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Login extends AppCompatActivity {

    private String email,password;
    private EditText et_email,et_pass;
    private Button btn_login,btn_register;
    public static String customerName;
    public static boolean checkuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_email=(EditText)findViewById(R.id.et_email);
        et_pass=(EditText)findViewById(R.id.et_pass);
        btn_login=(Button)findViewById(R.id.btn_login);
        btn_register=(Button)findViewById(R.id.btn_register);



        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Registeration.class);
                startActivity(intent);
                finish();
            }
        });


            btn_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    email = et_email.getText().toString().trim();
                    password = et_pass.getText().toString().trim();




                    // Instantiate the RequestQueue.
                    RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                    String url = "http://myappwithvolley.000webhostapp.com/connection.php?email=" + email + "&password=" + password + "";

                    final SharedPreferences sharedpreferences = getSharedPreferences("loginDetails", Context.MODE_PRIVATE);

                    // Request a string response from the provided URL.
                    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {

                                    // Display the first 500 characters of the response string.
                                    if (response.equals("fail")) {
                                        Toast.makeText(Login.this, "Invalid ID or Password", Toast.LENGTH_SHORT).show();

                                    } else {

                                        SharedPreferences.Editor editor = sharedpreferences.edit();

                                        editor.putString("customerName", response);
                                        checkuser = true;
                                        editor.commit();
                                        Login.customerName=sharedpreferences.getString("customerName",response);
                                        Intent intent = new Intent(Login.this, MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(Login.this, "Error in connecting", Toast.LENGTH_SHORT).show();
                        }
                    });

// Add the request to the RequestQueue.
                    queue.add(stringRequest);
                }
            });

    }


}
