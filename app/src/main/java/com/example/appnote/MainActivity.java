package com.example.appnote;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_title, et_notes;
    Button btn;
    String st1, st2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.BTN);
        et_title = (EditText) findViewById(R.id.ET1);
        et_notes = (EditText) findViewById(R.id.ET2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = getIntent();

                st1 = et_title.getText().toString();
                st2 = et_notes.getText().toString();
                intent.putExtra("title", st1);
                intent.putExtra("description", st2);
                setResult(ListNotes.RESULT_CODE_ADD_NOTES, intent);
                finish();
            }
        });
    }
}
