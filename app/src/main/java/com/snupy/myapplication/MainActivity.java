package com.snupy.myapplication;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Scroller;

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

        final ArrayList<item> dataset = new ArrayList<item>();

        mContext = getApplicationContext();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        adapter = new ChatAdapter(dataset);
        recyclerView.setAdapter(adapter);

        dataset.add( new item( "Android charting application xml ui design tutorial with example. Android charting application xml ui design tutorial with example. Android charting application xml ui design tutorial with example. Android charting application xml ui design tutorial with example.", R.mipmap.see) );
        dataset.add( new item("Android charting application xml ui design tutorial with example. Android charting application xml ui design tutorial with example. Android charting application xml ui design tutorial with example. Android charting application xml ui design tutorial with example.", R.mipmap.stand) );
        dataset.add( new item(  "Android charting application xml ui design tutorial with example. Android charting application xml ui design tutorial with example. Android charting application xml ui design tutorial with example. Android charting application xml ui design tutorial with example.", R.mipmap.close) );
        final EditText txt_to_send = (EditText) findViewById(R.id.txt_to_send) ;

        ImageButton txt_send_button = (ImageButton) findViewById(R.id.txt_send_btn);
        txt_send_button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg_to_send = txt_to_send.getText().toString();
                dataset.add(new item(msg_to_send,0));
                recyclerView.smoothScrollToPosition(dataset.size() - 1);
                // TODO : click event
            }
        });

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

