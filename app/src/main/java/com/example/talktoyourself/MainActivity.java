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
    private TextView show_message;
    public static final int TextRequest = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pick_message = findViewById(R.id.placeOfMessage);
        show_message = findViewById(R.id.displayUserMessage1);
    }

    public void goToAnotherActivity(View view) {
        String user_message = pick_message.getText().toString();
        Intent intent = new Intent(this,AnotherOne.class);
        intent.putExtra(ExtraMessage,user_message);
        startActivityForResult(intent,TextRequest);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TextRequest){
            if(resultCode == RESULT_OK){
                String message = data.getStringExtra(AnotherOne.ExtraReply);
                show_message.setText(message);
                show_message.setVisibility(View.VISIBLE);
            }
        }
    }
}