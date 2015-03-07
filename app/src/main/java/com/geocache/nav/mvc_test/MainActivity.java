package com.geocache.nav.mvc_test;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;


public class MainActivity extends Activity implements Observer, View.OnClickListener {

    private Model model;
    private Button mButton;
    private TextView mTextView;
    private TextView mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);
        mTextView = (TextView) findViewById(R.id.textView);
        mEditText = (EditText) findViewById(R.id.editText);
        model = Model.get(this);
        model.addObserver(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void update(Observable observable, Object data) {
        mTextView.setText(model.getData());
    }

    @Override
    public void onClick(View v) {
        model.setData(mEditText.getText().toString());
    }
}