package com.fanhanfei.p1_ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TitleLayout extends LinearLayout {
    public TitleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title,this);
        Button backButton = (Button) findViewById(R.id.title_b_1);
        Button editButton = (Button) findViewById(R.id.title_b_2);
        backButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"点击了返回",Toast.LENGTH_SHORT).show();
            }
        });
        editButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"点击了编辑",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
