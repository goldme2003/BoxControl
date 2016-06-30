package com.nari.boxcontrol.Activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nari.boxcontrol.JSON.JSONParser;
import com.nari.boxcontrol.R;

public class LoginActivity extends AppCompatActivity {

    private LoginTask user_login = null;

    private EditText et_login_id;
    private EditText et_login_key;
    private TextView tv_login_status;
    private String start_url = "http://192.168.3.55/start";
    private String login_url = "http://192.168.3.55/login";
    private JSONParser jsonparser = new JSONParser();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_login_id = (EditText)findViewById(R.id.et_login_id);
        et_login_key = (EditText)findViewById(R.id.et_login_key);
        tv_login_status = (TextView)findViewById(R.id.tv_login_status);
        Button btn_login_login = (Button) findViewById(R.id.btn_login_login);

        /*Waiting for box side completation*/
        /*
        List<NameValuePair> start_param = new ArrayList<NameValuePair>();
        start_param.add(new BasicNameValuePair("start", "START"));
        JSONArray login_info = jsonparser.makeHttpRequest(start_url, "GET", null);

        try{

            JSONObject jsonobj_feedback = login_info.getJSONObject(0);

            String device_status = jsonobj_feedback.getString("status");
            tv_login_status.setText(device_status);
        }catch (JSONException je){
            je.printStackTrace();
        }*/


        btn_login_login.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view){

                attemptLogin();
            }
        });

    }

    public void attemptLogin(){
        String id = et_login_id.getText().toString();
        String key = et_login_key.getText().toString();
        user_login = new LoginTask(id, key);
        user_login.execute((Void) null);
    }

    public class LoginTask extends AsyncTask<Void, Void, Boolean>{
        private final String login_id;
        private final String login_key;

        LoginTask(String id, String key){
            this.login_id = id;
            this.login_key = key;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            /*TODO: send login user info. as JSON to box*/
            return null;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            Intent shot_app = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(shot_app);
            finish();
        }
    }
}


