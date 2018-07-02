package com.example.bysj.patientanddoctor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class AddReplyActivity extends AppCompatActivity {

    private TextView username;
    private TextView sex;
    private TextView age;
    private TextView symptom;
    private TextView time;
    private TextView detial;
    private EditText reply;
    private Button doBtn;
    private DBManager dbManager;

    private User u;
    private Condition c;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reply);
        initView();
        initDate();
        showData();


        doBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    Reply r = new Reply();
                    r.setContent(reply.getText().toString());
                    r.setCid(c.getId());
                    r.setUid(u.getId());
                    dbManager.openDB();
                    dbManager.addReply(r);
                    Toast.makeText(AddReplyActivity.this,"添加成功",Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(AddReplyActivity.this,"添加失败，请重试",Toast.LENGTH_SHORT).show();

                }
                finish();
//                Intent intent = new Intent(AddReplyActivity.this,ShowConditionsActivity.class);
//                startActivity(intent);
            }
        });

    }




    private void initView(){
        username=(TextView) findViewById(R.id.add_reply_user_name);
        sex = (TextView) findViewById(R.id.add_reply_user_sex);
        age = (TextView) findViewById(R.id.add_reply_user_age);
        symptom = (TextView) findViewById(R.id.add_reply_cond_symptom);
        time = (TextView) findViewById(R.id.add_reply_cond_time);
        detial = (TextView) findViewById(R.id.add_reply_cond_detial);
        reply = (EditText) findViewById(R.id.add_reply_et);
        doBtn = (Button) findViewById(R.id.add_reply_btn);

    }



    private void initDate(){
        Intent intent = getIntent();
        String cid = intent.getStringExtra("cid");

        dbManager = new DBManager(this);
        dbManager.openDB();
        c = dbManager.getConditionById(Integer.parseInt(cid));
        u = dbManager.getUserById(c.getUserid());

    }

    private void showData(){
        if(c!=null && u!=null){
            username.setText("用户姓名："+u.getName());
            sex.setText("用户性别："+u.getSex());
            age.setText("用户年龄："+u.getAge());
            symptom.setText("主要症状："+c.getSymptoms());
            time.setText("持续时间："+c.getTime());
            detial.setText("详细描述:"+c.getDetial());
        }
    }


}
