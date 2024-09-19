package com.numad24fa_yonghuafu;

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
    }
}