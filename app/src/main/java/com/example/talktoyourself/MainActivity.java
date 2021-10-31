package com.example.talktoyourself;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText pick_message;
    public static final String ExtraMessage = "com.example.talktoyourself.extra.Message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pick_message = findViewById(R.id.placeOfMessage);
    }

    public void goToAnotherActivity(View view) {
        String user_message = pick_message.getText().toString();
        Intent intent = new Intent(this,AnotherOne.class);
        intent.putExtra(ExtraMessage,user_message);
        startActivity(intent);
    }

}