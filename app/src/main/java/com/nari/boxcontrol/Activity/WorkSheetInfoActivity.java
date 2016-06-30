package com.nari.boxcontrol.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.nari.boxcontrol.ExperimentObj.WorkSheet;
import com.nari.boxcontrol.R;

public class WorkSheetInfoActivity extends AppCompatActivity {
    WorkSheet rec_worksheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_sheet_info);

        TextView tv_wsi_info = (TextView)findViewById(R.id.tv_wsi_info);

        rec_worksheet = (WorkSheet)getIntent().getSerializableExtra("worksheetinfo");
        tv_wsi_info.setText("id is " + rec_worksheet.getWorkSheetId() + "; substation name is " + rec_worksheet.getSubstationName() +" ;"+ rec_worksheet.getComInfoId() + ";\n");


    }
}
