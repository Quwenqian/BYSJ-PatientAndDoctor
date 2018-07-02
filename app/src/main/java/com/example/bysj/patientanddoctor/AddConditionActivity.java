package com.example.bysj.patientanddoctor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddConditionActivity extends AppCompatActivity {

    private EditText symptoms;
    private Spinner time;
    private EditText detial;
    private Button confrim;
    private DBManager dbManager=new DBManager(this);
    private Condition condition = new Condition();
    private List<String> data_list;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_condition);
        initView();

        data_list = new ArrayList<String>();
        data_list.add("");
        data_list.add("三天以内");
        data_list.add("一周以内");
        data_list.add("一月以内");
        data_list.add("一年以内");
        data_list.add("一年以上");



        time.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                condition.setTime(data_list.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        confrim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                condition.setSymptoms(symptoms.getText().toString());
                condition.setDetial(detial.getText().toString());
                condition.setUserid(SPUtil.getId(AddConditionActivity.this));

                dbManager.openDB();
                long res = dbManager.addConditio(condition);
                if(res>=1){
                    Toast.makeText(AddConditionActivity.this,"提交成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AddConditionActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(AddConditionActivity.this,"提交失败，请重试",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


    /**
     * 初始化视图
     */
    private void initView(){
        symptoms = (EditText) findViewById(R.id.add_c_symptoms);
        time = (Spinner) findViewById(R.id.time);
        detial = (EditText) findViewById(R.id.add_c_detial);
        confrim = (Button) findViewById(R.id.add_c_btn_confrim);
    }




}
