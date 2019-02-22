package com.example.saif.shop;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class Registeration extends AppCompatActivity {

    private String email,password,firstname,lastname;
    private EditText et_email,et_pass,et_fname,et_lname;
    private Button btn_login,btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);

        et_email=(EditText)findViewById(R.id.et_email);
        et_pass=(EditText)findViewById(R.id.et_pass);
        et_fname=(EditText)findViewById(R.id.et_fname);
        et_lname=(EditText)findViewById(R.id.et_lname);
        btn_login=(Button)findViewById(R.id.btn_login);
        btn_register=(Button)findViewById(R.id.btn_register);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registeration.this,Login.class);
                startActivity(intent);
                finish();
            }
        });


        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = et_email.getText().toString().trim();
                password = et_pass.getText().toString().trim();
                firstname= et_fname.getText().toString().trim();
                lastname= et_lname.getText().toString().trim();



                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url = "https://myappwithvolley.000webhostapp.com/register.php?email="+email+"&password="+password+"&firstname="+firstname+"&lastname="+lastname+"";

                final SharedPreferences sharedpreferences = getSharedPreferences("loginDetails", Context.MODE_PRIVATE);

                // Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                // Display the first 500 characters of the response string.
                                if (response.equals("error")) {
                                    Toast.makeText(Registeration.this, "Invalid input", Toast.LENGTH_SHORT).show();

                                } else {



                                    Intent intent = new Intent(Registeration.this, Login.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Registeration.this, "Error in connecting", Toast.LENGTH_SHORT).show();
                    }
                });

                // Add the request to the RequestQueue.
                queue.add(stringRequest);
            }
        });
    }
}
