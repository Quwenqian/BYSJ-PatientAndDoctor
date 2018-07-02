package com.example.bysj.patientanddoctor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText name;
    private EditText pwd;
    private Button loginBtn;
    private Button registerBtn;
    private RadioButton rb1;
    private RadioButton rb2;
    private User user;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        loginBtn.setOnClickListener(this);
        registerBtn.setOnClickListener(this);
    }


    /**
     * 视图对象初始化
     */
    private void initView() {
        name = (EditText) findViewById(R.id.editText_name);
        pwd = (EditText) findViewById(R.id.editText_pwd);

        rb1 = (RadioButton) findViewById(R.id.radioButton1);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);

        loginBtn = (Button) findViewById(R.id.login);
        registerBtn = (Button) findViewById(R.id.register);

        dbManager = new DBManager(this);

    }

    /**
     * 点击事件实现
     * @param v
     */
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.login:
                //login
                login();
                break;
            case R.id.register:
                //register
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }


    /**
     * 登录功能实现
     */
    public void login(){
        dbManager.openDB();
        user = new User();
        user.setName(name.getText().toString());
        user.setPwd(pwd.getText().toString());

        if(rb1.isChecked()){
            user.setRole(0);
        }else{
            user.setRole(1);
        }

        User loginUser = dbManager.userLogin(user);


        if(loginUser!=null){
            Toast.makeText(LoginActivity.this,"登录成功，即将进入首页",Toast.LENGTH_SHORT)
                    .show();
            SPUtil.setName(LoginActivity.this,loginUser.getName());
            SPUtil.setRole(LoginActivity.this,loginUser.getRole());
            SPUtil.setId(LoginActivity.this,loginUser.getId());

            Intent intent = null;
            if(loginUser.getRole()==0){
                intent = new Intent(LoginActivity.this,MainActivity.class);
            }else{
                intent = new Intent(LoginActivity.this,AdminActivity.class);
            }

            startActivity(intent);
        }else{
            Toast.makeText(LoginActivity.this,"登录失败，请重新输入",Toast.LENGTH_SHORT)
                    .show();
        }


    }



}
