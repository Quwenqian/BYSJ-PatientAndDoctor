package com.example.bysj.patientanddoctor;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ShowReplyActivity extends AppCompatActivity {

    private ListView listView;
    private List<Reply> dataList;
    private DBManager dbManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_reply);


        int role = SPUtil.getRole(ShowReplyActivity.this);


        dbManager = new DBManager(ShowReplyActivity.this);
        dbManager.openDB();
        if(role==1){
            dataList = dbManager.getReplys();
        }else if(role==0){
            int uid = SPUtil.getId(ShowReplyActivity.this);
            dataList = dbManager.getReplysByUid(uid);
        }

        listView = (ListView) findViewById(R.id.lv_show_reply);
        MyAdpater myAdapter = new MyAdpater(ShowReplyActivity.this,R.layout.adapter_reply,dataList);
        listView.setAdapter(myAdapter);


    }










    class MyAdpater extends ArrayAdapter<Reply> {

        private Context context;
        private List<Reply> dataList;
        private int resourceId;


        public MyAdpater(Context context, int resource, List<Reply> objects) {
            super(context, resource, objects);
            this.context = context;
            this.dataList = objects;
            this.resourceId = resource;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(getContext()).inflate(resourceId, null);

            TextView tvId = (TextView)view.findViewById(R.id.tv_id);
            TextView tvContent = (TextView)view.findViewById(R.id.tv_content);

            tvId.setText("用户ID："+dataList.get(position).getUid()+"   症状ID："+dataList.get(position).getCid());
            tvContent.setText("主要症状："+dataList.get(position).getContent());


            return view;
        }
    }










}
