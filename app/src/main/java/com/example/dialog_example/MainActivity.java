package com.example.dialog_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomDialog.OnButtonClickListener onButtonClickListener = new CustomDialog.OnButtonClickListener() {

            @Override
            public void onCancelButtonClicked() {
                Toast.makeText(MainActivity.this, "clicked cancel", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onOkButtonClicked() {
                Toast.makeText(MainActivity.this, "clicked ok", Toast.LENGTH_SHORT).show();
            }
        };

        CustomDialog dialog = new CustomDialog(R.layout.custom_dialog, "dialog title", "content", onButtonClickListener);
        dialog.show(getSupportFragmentManager(), "SampleDialog");
    }
}