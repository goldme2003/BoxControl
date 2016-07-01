package com.nari.boxcontrol.Activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nari.boxcontrol.ExperimentObj.TestInfo;
import com.nari.boxcontrol.ExperimentObj.WorkSheet;
import com.nari.boxcontrol.JSON.JSONParser;
import com.nari.boxcontrol.R;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class WorkSheetInfoActivity extends AppCompatActivity {
    WorkSheet rec_worksheet;
    int current_wsid;
    TestInfo linked_testinfo;
    JSONParser testinfo_parser = new JSONParser();
    String testinfo_url = "http://192.168.3.55:5555/work_sheet";
    String teststep_url = "http://192.168.3.55:5555/test_info";
    ArrayList<TestInfo> testinfo_arraylist = null;
    TestInfoRequest testinforequest = null;
    TestStepRequest teststeprequest = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_sheet_info);

        rec_worksheet = (WorkSheet)getIntent().getSerializableExtra("worksheetinfo");
        current_wsid = rec_worksheet.getWorkSheetId();

        //TextView tv_wsi_info = (TextView)findViewById(R.id.tv_wsi_info);
        Button btn_start = (Button)findViewById(R.id.btn_start_exp);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teststeprequest = new TestStepRequest();
                teststeprequest.execute((Void)null);

            }
        });


        //tv_wsi_info.setText("id is " + current_wsid + "; substation name is " + rec_worksheet.getSubstationName() +" ;"+ rec_worksheet.getComInfoId() + ";\n");
        testinforequest = new TestInfoRequest();
        testinforequest.execute((Void)null);


    }



    public class TestInfoRequest extends AsyncTask<Void, Void, String>{
        String testinfo_string;
        @Override
        protected String doInBackground(Void... params) {
            List<NameValuePair> testinfo_param = new ArrayList<NameValuePair>();
            testinfo_param.add(new BasicNameValuePair("sheet", (String.valueOf(current_wsid))));


            JSONArray ws_info = testinfo_parser.makeHttpRequest(testinfo_url, "POST", testinfo_param);
            testinfo_string = ws_info.toString();

            return "OK";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(getBaseContext(), testinfo_string, Toast.LENGTH_LONG).show();
        }
    }

    public class TestStepRequest extends AsyncTask<Void, Void, String>{
        String teststep_string;
        @Override
        protected String doInBackground(Void... params) {
            List<NameValuePair> teststep_param = new ArrayList<NameValuePair>();
            teststep_param.add(new BasicNameValuePair("testInfo", "test"));


            JSONArray teststep_info = testinfo_parser.makeHttpRequest(teststep_url, "POST", teststep_param);
            teststep_string = teststep_info.toString();
            return "OK";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Intent shot_teststep_activity = new Intent(getApplicationContext(), TestStepActivity.class);
            Bundle deliv_teststep = new Bundle();
            deliv_teststep.putString("teststep", teststep_string);
            shot_teststep_activity.putExtras(deliv_teststep);
            startActivity(shot_teststep_activity);

        }
    }
}
