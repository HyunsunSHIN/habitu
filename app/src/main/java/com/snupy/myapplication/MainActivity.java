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
import android.widget.Toast;

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

        final EditText txt_to_send = (EditText) findViewById(R.id.txt_to_send) ;
        final ImageButton txt_send_button = (ImageButton) findViewById(R.id.txt_send_btn);

//        txt_to_send.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if(hasFocus == true ){
//                recyclerView.smoothScrollToPosition( dataset.size() - 1 ); }
//            }
//        });

        txt_send_button.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View view) {
                String msg_to_send = txt_to_send.getText().toString();
                dataset.add(new item(msg_to_send,0));
               // dataset.add( new item("ITs nice to see you",0));
                adapter.notifyDataSetChanged();
                recyclerView.smoothScrollToPosition( dataset.size() - 1 );
                 txt_to_send.setText("");
                // TODO : click event
            }
        });

    }


}

