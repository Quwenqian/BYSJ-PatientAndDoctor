package com.example.bysj.patientanddoctor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private Button addBtn;
    private Button showBtn;
    private Button showConditionsBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        addBtn.setOnClickListener(this);
        showBtn.setOnClickListener(this);
        showConditionsBtn.setOnClickListener(this);
    }


    /**
     * 初始化视图
     */
    private void initView(){

        addBtn = (Button) findViewById(R.id.main_addBtn);
        showBtn = (Button) findViewById(R.id.main_showComBtn);
        showConditionsBtn = (Button) findViewById(R.id.main_shwoConsBtn);

    }


    //按钮点击事件
    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent = null;
        switch (id){
            case R.id.main_addBtn:
                //进入病情录入界面
                intent = new Intent(MainActivity.this,AddConditionActivity.class);
                break;
            case R.id.main_showComBtn:
                //进入回复查看界面
                intent = new Intent(MainActivity.this,ShowReplyActivity.class);
                break;
            case R.id.main_shwoConsBtn:
                //进入病症查看页面
                intent = new Intent(MainActivity.this,ShowConditionsActivity.class);
                break;
        }
        startActivity(intent);
    }
}
