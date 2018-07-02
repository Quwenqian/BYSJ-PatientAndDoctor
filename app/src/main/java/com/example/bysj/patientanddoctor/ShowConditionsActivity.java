package com.example.bysj.patientanddoctor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ShowConditionsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView listView;
    private List<Condition> dataList;
    private DBManager dbManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("症状信息");
        setContentView(R.layout.activity_show_conditions);

        //初始化对象
        dbManager = new DBManager(this);
        listView = (ListView) findViewById(R.id.show_lv_conditisons);

        //根据角色获得数据
        initData();

        MyAdpater adpater = new MyAdpater(ShowConditionsActivity.this,R.layout.adapter_condition,dataList);
        listView.setAdapter(adpater);


        int role  = SPUtil.getRole(ShowConditionsActivity.this);
        if(role==1){
            listView.setOnItemClickListener(this);
        }
    }


    private void initData(){
        dbManager.openDB();
        int role  = SPUtil.getRole(ShowConditionsActivity.this);
        if(role==0){
            //病人用户登录，查看个人病症信息
            int userid = SPUtil.getId(ShowConditionsActivity.this);
            dataList = dbManager.getConditionsByUserId(userid);
        }else {
            //管理员用户登录，查看所有病症信息
            dataList = dbManager.getConditions();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //管理员点击每一病人病情信息后，跳转到回复页面
        Intent intent = new Intent(ShowConditionsActivity.this,AddReplyActivity.class);
        intent.putExtra("cid",dataList.get(position).getId()+"");
        startActivity(intent);

    }


    class MyAdpater extends ArrayAdapter<Condition>{

        private Context context;
        private List<Condition> dataList;
        private int resourceId;


        public MyAdpater(Context context, int resource, List<Condition> objects) {
            super(context, resource, objects);
            this.resourceId = resource;
            this.context = context;
            this.dataList = objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = LayoutInflater.from(getContext()).inflate(resourceId, null);

            TextView userid = view.findViewById(R.id.adapter_user_id);
            TextView time = view.findViewById(R.id.adapter_time);
            TextView detial = view.findViewById(R.id.adapter_detial);

            userid.setText(dataList.get(position).getUserid()+"");
            time.setText(dataList.get(position).getTime());
            detial.setText(dataList.get(position).getDetial());

            return view;
        }
    }
}




