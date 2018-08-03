package com.example.welcome.mylistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ViewList extends AppCompatActivity {

    private static final String TAG = "ViewList";

    DbHelper MyDb;
    private EditText name;
    private Button add, view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        name = (EditText)findViewById(R.id.etName);
        add = (Button) findViewById(R.id.btAdd);
        view = (Button) findViewById(R.id.btView);

        MyDb = new DbHelper(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = name.getText().toString();
                if (name.length() !=0){
                    AddData(newEntry);
                    name.setText("");
                }else {
                    Toast.makeText(ViewList.this, "You must put anything", Toast.LENGTH_SHORT).show();
                }
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewList.this, ListLayout.class);
                startActivity(intent);
            }
        });

    }
    public void AddData(String newEntry){
        boolean insertdata = MyDb.addData(newEntry);

        if (insertdata){

            Toast.makeText(this, "Data Successfully inserted", Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(this, "Data not inserted", Toast.LENGTH_SHORT).show();
        }

    }

}
