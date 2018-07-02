package com.example.bysj.patientanddoctor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText name;
    private EditText pwd;
    private EditText pwdC;
    private EditText age;
    private RadioButton sex1;
    private RadioButton sex2;
    private Button doReg;
    private User user;
    DBManager dbManager ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();


        doReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = new User();
                user.setName(name.getText().toString());
                user.setPwd(pwd.getText().toString());
                user.setAge(Integer.parseInt(age.getText().toString()));
                if(sex1.isChecked()){
                    user.setSex("男");
                }else if(sex2.isChecked()){
                    user.setSex("女");
                }
                user.setRole(0);
                dbManager.openDB();
                User loginUser = dbManager.addUser(user);
                if(loginUser!=null){
                    Toast.makeText(RegisterActivity.this,"注册成功，即将进入首页",Toast.LENGTH_LONG).show();
                    SPUtil.setName(RegisterActivity.this,loginUser.getName());
                    SPUtil.setRole(RegisterActivity.this,loginUser.getRole());
                    SPUtil.setId(RegisterActivity.this,loginUser.getId());
                    Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(RegisterActivity.this,"注册失败",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    /**
     * 初始化控件对象
     */
    private void initView(){
        name = (EditText) findViewById(R.id.et_reg_name);
        pwd = (EditText) findViewById(R.id.et_reg_pwd);
        pwdC = (EditText) findViewById(R.id.et_reg_pwd_comf);
        age = (EditText) findViewById(R.id.et_reg_age);
        sex1 = (RadioButton) findViewById(R.id.sex1);
        sex2 = (RadioButton) findViewById(R.id.sex2);
        doReg = (Button) findViewById(R.id.doregister);

        dbManager = new DBManager(this);

    }





}
