package com.example.vikram.digihunt;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class gamestart extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();

    }

    @Override
    protected void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("HERE GOES UR CLUE");
            builder.setMessage(result.getText());
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            //setContentView(R.layout.activity_welcome);
            //mScannerView.stopCamera();
            mScannerView.resumeCameraPreview(this);
    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        gamestart.this.finish();

                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}
