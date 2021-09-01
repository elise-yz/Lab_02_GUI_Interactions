package com.zhuelise.lab02guiinteractions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.internal.SafeIterableMap;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView greeting;
    TextView cycle_textview;
    EditText enterName;
    String[] names;
    String greet_user;
    int count = 0;
    String current = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addName(View view) {
        enterName = (EditText) findViewById(R.id.name_edittext);
        greeting = (TextView) findViewById(R.id.greeting_textview);
        current = enterName.getText().toString();
        greet_user = getString(R.string.greet_user, current);
        greeting.setText(greet_user);
    }

    public void cycle(View view) {
        Resources res = getResources();
        names = (String[]) res.getStringArray(R.array.name_list);
        cycle_textview = (TextView) findViewById(R.id.cycle_textview);
        if(count>=names.length)
            count=0;
        cycle_textview.setText(names[count++]);
    }
}