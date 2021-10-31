package com.example.talktoyourself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AnotherOne extends AppCompatActivity {
    private TextView show;
    private EditText pickUp;
    public static final String ExtraReply = "com.example.talktoyourself.extra.Message";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another_one);
        Intent intent = getIntent();
        String user_message = intent.getStringExtra(MainActivity.ExtraMessage);
        // getting the view where we have to display this text
        show = findViewById(R.id.displayUserMessage2);
        show.setText(user_message);
        // picking up the reply
        pickUp = findViewById(R.id.userMessageHere);
    }

    public void replyActivity1(View view) {
        Intent intent = new Intent();
        String message = pickUp.getText().toString();
        intent.putExtra(ExtraReply,message);
        setResult(RESULT_OK,intent);
        finish();
    }
}