package com.example.bysj.patientanddoctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminActivity extends AppCompatActivity {

    private Button showConditionsBtn;
    private Button showReplysBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        showConditionsBtn = (Button) findViewById(R.id.show_conditisons_btn);
        showReplysBtn = (Button) findViewById(R.id.show_replys_btn);

        showConditionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this,ShowConditionsActivity.class);
                startActivity(intent);
            }
        });
        showReplysBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this,ShowReplyActivity.class);
                startActivity(intent);
            }
        });


    }
}
