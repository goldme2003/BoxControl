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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WorkSheetActivity extends AppCompatActivity {

    JSONObject jo_test_ws_item1 = new JSONObject();
    JSONObject jo_test_ws_item2 = new JSONObject();

    JSONArray jarray_wslist =new JSONArray();

    JSONArray rec_json_ws_list = null;
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

        try{
            rec_json_ws_list = new JSONArray(getIntent().getExtras().getString("worksheetlist"));

            if (rec_json_ws_list.length() != 0){
                jarray_wslist = rec_json_ws_list;
            }
            //jarray_wslist = new JSONArray(getIntent().getExtras().getString("worksheetlist"));
            for (int i = 0; i < jarray_wslist.length(); i ++){
                jol_test_ws_list.add(jarray_wslist.getJSONObject(i));

                JSONObject temp_jobj = jol_test_ws_list.get(i);

                int temp_worksheetid = temp_jobj.getInt("workSheetId");
                String temp_pstime = temp_jobj.getString("planStartTime");
                String temp_petime = temp_jobj.getString("planEndTime");
                String temp_m_ws_id = temp_jobj.getString("mobileWorksheetID");

                int temp_comid;
                try{
                    temp_comid = temp_jobj.getInt("comInfoId");
                }catch (Exception e){
                    temp_comid = 0;
                }
                int temp_sid;
                try{
                    temp_sid = temp_jobj.getInt("substationId");
                }catch (Exception e){
                    temp_sid = 0;
                }

                String temp_wd = temp_jobj.getString("workDepartment");
                String temp_wsn = temp_jobj.getString("workSheetNum");
                String temp_r = temp_jobj.getString("responsible");
                String temp_tm = temp_jobj.getString("teamMember");
                String temp_sn = temp_jobj.getString("substationName");
                String temp_teammemb = temp_jobj.getString("workTeamMember");
                String temp_addr = temp_jobj.getString("workAdress");
                String temp_wc = temp_jobj.getString("workContent");
                String temp_wcond = temp_jobj.getString("workCondition");
                String temp_pc = temp_jobj.getString("precaution");
                String temp_wsi = temp_jobj.getString("workSheetIssuer");
                String temp_issd = temp_jobj.getString("issuerDate");
                String temp_sm = temp_jobj.getString("addSafetyMeasure");
                String temp_pwt = temp_jobj.getString("permitWorkTime");
                String temp_wp = temp_jobj.getString("workPermit");
                String temp_wr = temp_jobj.getString("workResponsible");
                String temp_vtd = temp_jobj.getString("validTimeDelay");
                String temp_vrw = temp_jobj.getString("validResponsibleWorker");
                String temp_vrt = temp_jobj.getString("validWorkResponsibleTime");
                String temp_vwp = temp_jobj.getString("validWorkPermit");
                String temp_vwpt = temp_jobj.getString("validWorkPermitTime");
                String temp_fwr = temp_jobj.getString("finishedWorkResponsible");
                String temp_fwrt = temp_jobj.getString("finishedWorkResponsibleTime");
                String temp_fwp = temp_jobj.getString("finishedWorkPermit");
                String temp_fwpt = temp_jobj.getString("finishedWorkPermitTime");
                String temp_rem = temp_jobj.getString("remark");
                String temp_oper = temp_jobj.getString("operate");
                Map<String, Object> item = new HashMap<String, Object>();
                item.put("workSheetId", temp_worksheetid);
                item.put("substationName", temp_sn);
                item.put("workTeamMember", temp_teammemb);
                item.put("workAdress", temp_addr);
                item.put("planStartTime", temp_pstime);
                m_ws_list.add(item);

                WorkSheet ws_item = new WorkSheet();
                ws_item.setWorkSheetId(temp_worksheetid);
                ws_item.setMobileWorkSheetID(temp_m_ws_id);
                ws_item.setComInfoId(temp_comid);
                ws_item.setSubstationId(temp_sid);

                ws_item.setSubstationName(temp_sn);
                ws_item.setTeamMember(temp_tm);
                ws_item.setWorkAdress(temp_addr);

                ws_item.setWorkDepartment(temp_wd);
                ws_item.setWorkSheetNum(temp_wsn);
                ws_item.setResponsible(temp_r);
                ws_item.setSubstationName(temp_sn);
                ws_item.setWorkCondition(temp_wcond);
                ws_item.setPlanStartTime(temp_pstime);
                ws_item.setPlanEndTime(temp_petime);
                ws_item.setWorkContent(temp_wc);
                ws_item.setPrecaution(temp_pc);
                ws_item.setWorkSheetIssuer(temp_wsi);
                ws_item.setIssuerDate(temp_issd);
                ws_item.setAddSafetyMeasure(temp_sm);
                ws_item.setPermitWorkTime(temp_pwt);
                ws_item.setWorkPermit(temp_wp);
                ws_item.setWorkResponsible(temp_wr);
                ws_item.setWorkTeamMember(temp_teammemb);
                ws_item.setValidTimeDelay(temp_vtd);
                ws_item.setValidResponsibleWorker(temp_vrw);
                ws_item.setValidWorkResponsibleTime(temp_vrt);
                ws_item.setValidWorkPermit(temp_vwp);
                ws_item.setValidWorkPermitTime(temp_vwpt);
                ws_item.setFinishedWorkResponsible(temp_fwr);
                ws_item.setFinishedWorkPermitTime(temp_fwrt);
                ws_item.setFinishedWorkPermit(temp_fwp);
                ws_item.setFinishedWorkPermitTime(temp_fwpt);
                ws_item.setRemark(temp_rem);
                ws_item.setOperate(temp_oper);
                worksheetlist.add(ws_item);
            }

        }catch (JSONException je){
            je.printStackTrace();
        }





        /*generate test work sheet items for display
        * in published version, work sheet items is loaded
        * from box*/

        /*try {

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

                //set WorkSheet List for deliver information
                WorkSheet ws_item = new WorkSheet();
                ws_item.setWorkSheetId(temp_worksheetid);
                ws_item.setSubstationName(temp_subname);
                ws_item.setTeamMember(temp_teammemb);
                ws_item.setWorkAdress(temp_addr);
                worksheetlist.add(ws_item);
            }





        } catch (JSONException e) {
            e.printStackTrace();
        }*/
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
