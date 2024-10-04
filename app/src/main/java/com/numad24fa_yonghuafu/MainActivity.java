package com.numad24fa_yonghuafu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // Set the XML layout as the content view

        // Find the "About" button from the layout
        Button aboutButton = findViewById(R.id.button_about);

        // Set an onClickListener on the button to show the toast
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Name: Yonghua Fu\nEmail: fu.yong@northeastern.edu", Toast.LENGTH_LONG).show();
            }
        });
        Button quicCalcButton = findViewById(R.id.btn_quic_calc);
        // 设置点击事件监听器，跳转到 CalcActivity
        quicCalcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalcActivity.class);
                startActivity(intent);
            }
        });
    }
}