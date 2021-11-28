package com.example.jsonexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    //private EditText etID, etUserName, etName, etEmail;
    private Button btnSend;
    private String API_URL="https://jsonplaceholder.typicode.com/users";
    private RecyclerView recyclerView;
    private List<User> users;
    private recyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // RecyclerViewMargin decoration = new RecyclerViewMargin(itemMargin, numColumns);
        //recyclerView.addItemDecoration(decoration);

       /* etID= findViewById(R.id.etID);
        etUserName= findViewById(R.id.etUserName);
        etName= findViewById(R.id.etName);
        etEmail= findViewById(R.id.etEmail);
        btnSend = findViewById(R.id.btnSend);*/

        recyclerView= findViewById(R.id.recyclerView);
        users= new ArrayList<>();
        makeGetRequest();


    }

    public void sendRequest(View view){

        makeGetRequest();
    }

    private void makeGetRequest(){

        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Request.Method.GET,
                API_URL,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject responseObject = response.getJSONObject(i);
                                User user = new User();
                                user.setId(responseObject.getString("id"));

                                user.setUsername(responseObject.getString("username"));
                                user.setName(responseObject.getString("name"));
                                user.setEmail(responseObject.getString("email"));
                                Log.d("Usuario","For: usuario "+ i+ " "+ user.getUsername());
                                users.add(user);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        adapter = new recyclerViewAdapter(getApplicationContext(), users);
                        recyclerView.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                  Log.d("tag","onErrorResponse: "+ error.getMessage());
            }
        }
        );

        queue.add(jsonArrayRequest);
        //Volley.newRequestQueue(this).add(RequestQueue);

       /* StringRequest stringRequest= new StringRequest(Request.Method.GET,
                API_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject responseObject = new JSONObject(response);
                            //JSONArray usersArray= JSONObject.getJSONArray("users");
                            String userID,userName, name, email;
                            userID= responseObject.getString("id");
                            userName= responseObject.getString("username");
                            name= responseObject.getString("name");
                            email= responseObject.getString("email");

                            //Aquí iría el adaptador
                            //recyclerViewAdapter rvAdapter= new recyclerViewAdapter(this, responseObject.getJSONArray("users"));



                           /* etID.setText(userID);
                            etUserName.setText(userName);
                            etName.setText(name);
                            etEmail.setText(email);*/
                        /*}catch(JSONException e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("[REQUEST ERROR]", error.getMessage());
                    }
                }
    );*/



    }
}