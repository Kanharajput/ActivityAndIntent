package com.example.talktoyourself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class AnotherOne extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextView show;
    public static final String ExtraReply = "com.example.talktoyourself.extra.Message";
    private Spinner spinner;
    private TextView phone_label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another_one);
        Intent intent = getIntent();
        String user_message = intent.getStringExtra(MainActivity.ExtraMessage);
        // getting the view where we have to display this text
        show = findViewById(R.id.displayUserMessage2);
        show.setText(user_message);
        phone_label = findViewById(R.id.phone_label);

        // getting the spinner
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

    }

    public void replyActivity1(View view) {
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        phone_label.setText(parent.getItemAtPosition(position).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}