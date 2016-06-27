package com.nari.boxcontrol.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.nari.boxcontrol.ExperimentActivity;
import com.nari.boxcontrol.R;


public class MainActivity extends AppCompatActivity {
    Button siteExp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button st_exp = (Button)findViewById(R.id.btn_start_exp);
        st_exp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startExp();
            }
        });

        siteExp = (Button)findViewById(R.id.btn_site_exp);
        siteExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shot_siteExp_Activity = new Intent(getApplicationContext(), WorkSheetActivity.class);
                startActivity(shot_siteExp_Activity);
            }
        });





    }

    protected void startExp(){
        Intent start_exp = new Intent(this, ExperimentActivity.class);
        startActivity(start_exp);
    }


}


/*import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.github.mikephil.charting.utils.Utils;
import com.nari.boxcontrol.LineChartActivity1;

import java.util.ArrayList;

public class MainActivity extends Activity implements OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setTitle("MPAndroidChart Example");

        // initialize the utilities
        Utils.init(this);

        ArrayList<ContentItem> objects = new ArrayList<ContentItem>();

        objects.add(new ContentItem("Line Chart", "A simple demonstration of the linechart."));


        MyAdapter adapter = new MyAdapter(this, objects);

        ListView lv = (ListView) findViewById(R.id.listView1);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> av, View v, int pos, long arg3) {

        Intent i;

        switch (pos) {
            case 0:
                i = new Intent(this, LineChartActivity1.class);
                startActivity(i);
                break;

        }

        overridePendingTransition(R.anim.move_right_in_activity, R.anim.move_left_out_activity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent i = null;

        switch (item.getItemId()) {
            case R.id.viewGithub:
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/PhilJay/MPAndroidChart"));
                startActivity(i);
                break;
            case R.id.report:
                i = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "philjay.librarysup@gmail.com", null));
                i.putExtra(Intent.EXTRA_SUBJECT, "MPAndroidChart Issue");
                i.putExtra(Intent.EXTRA_TEXT, "Your error report here...");
                startActivity(Intent.createChooser(i, "Report Problem"));
                break;
            case R.id.blog:
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://www.xxmassdeveloper.com"));
                startActivity(i);
                break;
            case R.id.website:
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://at.linkedin.com/in/philippjahoda"));
                startActivity(i);
                break;
        }

        return true;
    }
}*/