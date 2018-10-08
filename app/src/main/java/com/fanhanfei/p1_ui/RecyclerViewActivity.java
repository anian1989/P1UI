package com.fanhanfei.p1_ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecyclerViewActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<Fruit>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitFruitList();
        setContentView(R.layout.activity_recycler_view);
        RecyclerView recyclerView = findViewById(R.id.recycler_vew);
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);//横向布局
//        recyclerView.setLayoutManager(linearLayoutManager);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);//瀑布流布局
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(fruitList);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private void InitFruitList(){
        for (int i = 0 ; i<10;i++){
            Fruit fruit = new Fruit(getRandomLengthName("Apple"), R.drawable.meituan);
            fruitList.add(fruit);
            Fruit fruit1 = new Fruit(getRandomLengthName("苹果"), R.drawable.jinmao);
            fruitList.add(fruit1);
        }
    }
    private String getRandomLengthName(String name){
        Random random = new Random();
        int i = random.nextInt(20) + 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int j =0;j<i;j++){
            stringBuilder.append(name);
        }
        return stringBuilder.toString();
    }
}
