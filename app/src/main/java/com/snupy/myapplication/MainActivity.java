package com.snupy.myapplication;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
//import android.support.v7.widget.RecyclerView;


public class MainActivity extends AppCompatActivity {
    Context mContext;
    RecyclerView recyclerView ;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<item> dataset = new ArrayList<item>();

        mContext = getApplicationContext();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyAdapter(dataset);
        recyclerView.setAdapter(adapter);

        dataset.add( new item( "#Seeing Far", R.mipmap.see) );
        dataset.add( new item( "#Standing and qurious", R.mipmap.stand) );
        dataset.add( new item(  "#gloomy and regretful", R.mipmap.close) );



        //ArrayList<item> items = new ArrayList<item>();

        //items.add(new item(R.drawable.a, "Chrsitmas"));
        //items.add(new item(R.drawable.b, "aviation dashboard"));
        //layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        //recyclerView.setLayoutManager(layoutManager);

       // adapter = new MyAdapter(items, mContext);

    }
    /*
          <android.support.v7.widget.recyclerview
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/recycler_view"
        android:scrollbars="vertical">
    </android.support.v7.widget.recyclerview>

     */


}

