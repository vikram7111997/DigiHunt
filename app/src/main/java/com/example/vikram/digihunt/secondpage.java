package com.example.vikram.digihunt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class secondpage extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondpage);
        textView = (TextView)findViewById(R.id.textView3);
        textView.setSelected(true);
    }
    public void navigate(View view)
    {
        Intent i = new Intent(secondpage.this, welcome.class);
        startActivity(i);
    }

}
