package com.fanhanfei.p1_ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FruitListViewActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<Fruit>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fruit_list_view);
        initFruit();
        FruitAdapter fruitAdapter = new FruitAdapter(FruitListViewActivity.this, R.layout.fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(fruitAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast toast = Toast.makeText(FruitListViewActivity.this, fruit.getName(), Toast.LENGTH_SHORT);
                toast.show();
            }
        });


    }
    private void initFruit(){
        for (int i= 0;i<2;i++){
            Fruit fruit = new Fruit("Apple", R.drawable.ic_launcher_foreground);
            fruitList.add(fruit);
            Fruit banana = new Fruit("banana", R.drawable.ic_launcher_foreground);
            fruitList.add(banana);
            Fruit Orange = new Fruit("Orange", R.drawable.ic_launcher_foreground);
            fruitList.add(Orange);
            Fruit watermelon = new Fruit("watermelon", R.drawable.ic_launcher_foreground);
            fruitList.add(watermelon);
            Fruit pear = new Fruit("pear", R.drawable.ic_launcher_foreground);
            fruitList.add(pear);
            Fruit grap = new Fruit("grap", R.drawable.ic_launcher_foreground);
            fruitList.add(grap);
        }

    }
}
