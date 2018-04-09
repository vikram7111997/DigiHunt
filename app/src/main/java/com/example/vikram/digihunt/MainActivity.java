package com.example.vikram.digihunt;

import android.content.ComponentCallbacks2;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String user="DISGUSTING";
    String pass="2018";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if( getIntent().getBooleanExtra("Exit me", false)){
            finish();
            //return; // add this to prevent from doing unnecessary stuffs
        }


        Button button = (Button) findViewById(R.id.login);
        final EditText ed1 = (EditText) findViewById(R.id.username);
        final EditText ed2 = (EditText) findViewById(R.id.password);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((ed1.getText().toString()).equals(user) && (ed2.getText().toString()).equals(pass))
                {
                    Intent i = new Intent(MainActivity.this, secondpage.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "PLEASE ENTER CORRECT CREDENTIALS", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.this.finish();

                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    @Override
    public void onTrimMemory(final int level) {
        if (level == ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN) {
            Toast.makeText(MainActivity.this, " SORRY U EXITED THE APP \n U R DISQUALIFIED !!! ", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("Exit me", true);
            startActivity(intent);
            //finish();




        }


    }


}
