package com.nari.boxcontrol.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.nari.boxcontrol.ExperimentObj.WorkSheet;
import com.nari.boxcontrol.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WorkSheetActivity extends AppCompatActivity {

    JSONObject jo_test_ws_item1 = new JSONObject();
    JSONObject jo_test_ws_item2 = new JSONObject();
    /*ArrayList for store json object*/
    ArrayList<JSONObject> jol_test_ws_list = new ArrayList<JSONObject>();

    /*ArrayList for fulfill the item in listview*/
    ArrayList<Map<String, Object>> m_ws_list= new ArrayList<Map<String, Object>>();

    /*ArrayList for next Activity*/
    ArrayList<WorkSheet> worksheetlist = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_sheet);
        ListView ws_list = (ListView)findViewById(R.id.listview_ws);

        /*generate test work sheet items for display
        * in published version, work sheet items is loaded
        * from box*/

        try {
            jo_test_ws_item1.put("workSheetId", "1");
            jo_test_ws_item1.put("substationName", "楚雄站");
            jo_test_ws_item1.put("workTeamMember", "张三，李四");
            jo_test_ws_item1.put("workAdress", "楚雄变电站");
            jo_test_ws_item1.put("planStartTime", "2016-6-30 8:30");

            jo_test_ws_item2.put("workSheetId", "2");
            jo_test_ws_item2.put("substationName", "荆门站");
            jo_test_ws_item2.put("workTeamMember", "张亮，xx");
            jo_test_ws_item2.put("workAdress", "荆门变电站");
            jo_test_ws_item2.put("planStartTime", "2016-7-5 8:30");

            jol_test_ws_list.add(jo_test_ws_item1);
            jol_test_ws_list.add(jo_test_ws_item2);

            for (int i = 0; i < jol_test_ws_list.size(); i ++){
                JSONObject temp_jobj = jol_test_ws_list.get(i);
                int temp_worksheetid = temp_jobj.getInt("workSheetId");
                String temp_time = temp_jobj.getString("planStartTime");
                String temp_subname = temp_jobj.getString("substationName");
                String temp_teammemb= temp_jobj.getString("workTeamMember");
                String temp_addr = temp_jobj.getString("workAdress");
                Map<String, Object> item = new HashMap<String, Object>();
                item.put("workSheetId", temp_worksheetid);
                item.put("substationName", temp_subname);
                item.put("workTeamMember", temp_teammemb);
                item.put("workAdress", temp_addr);
                item.put("planStartTime", temp_time);
                m_ws_list.add(item);

                /*set WorkSheet List for deliver information*/
                WorkSheet ws_item = new WorkSheet();
                ws_item.setWorkSheetId(temp_worksheetid);
                ws_item.setSubstationName(temp_subname);
                ws_item.setTeamMember(temp_teammemb);
                ws_item.setWorkAdress(temp_addr);
                worksheetlist.add(ws_item);
            }





        } catch (JSONException e) {
            e.printStackTrace();
        }
        SimpleAdapter ws_adapter = new SimpleAdapter(this, m_ws_list, R.layout.worksheet_list, new String[]{"workSheetId", "substationName","workTeamMember", "workAdress", "planStartTime"}, new int[] {R.id.mt_wsid, R.id.mt_ws_substationName, R.id.mt_ws_members, R.id.mt_ws_wlocation, R.id.st_ws_wtime});
        ws_list.setAdapter(ws_adapter);

        //set list item OnClickListener
        ws_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                WorkSheet deliver_worksheet = worksheetlist.get(((int) id));
                Intent deliver_intent = new Intent(getBaseContext(), WorkSheetInfoActivity.class);
                Bundle deliver_info = new Bundle();
                deliver_info.putSerializable("worksheetinfo", deliver_worksheet);

                deliver_intent.putExtras(deliver_info);
                startActivity(deliver_intent);


            }
        });

    }
}
