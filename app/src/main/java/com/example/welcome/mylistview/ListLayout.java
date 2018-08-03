package com.example.welcome.mylistview;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListLayout extends AppCompatActivity {

    private static final String TAG ="ListLayout";

    DbHelper MyDb;
    private static ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        mListView = (ListView)findViewById(R.id.listView);
        MyDb = new DbHelper(this);

        populateListView();
    }
    private void populateListView(){
        Log.d(TAG,

                "populateListView: Displaying data into ListView.");

        Cursor data = MyDb.getData();
        ArrayList<String> listData = new ArrayList<>();
        while (data.moveToNext()){
            listData.add(data.getString(1));
        }

        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);
    }
}
