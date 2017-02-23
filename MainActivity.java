package com.example.anshulchawla.latlong;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        Intent intent= new Intent(this,mapImage.class);
        EditText latValue= (EditText)findViewById(R.id.latValue);
        EditText longValue= (EditText)findViewById(R.id.longValue);

        Bundle bundle=new Bundle();
        bundle.putString("latValue",latValue.getText().toString());
        bundle.putString("longValue",longValue.getText().toString());
        //test

        intent.putExtras(bundle);


        startActivity(intent);

    }
}
