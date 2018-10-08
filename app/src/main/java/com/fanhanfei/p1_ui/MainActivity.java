package com.fanhanfei.p1_ui;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText;
    private ImageView imageView;
    /**
     * 进度条
     */
    private ProgressBar progressBar;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.edit_text);
        Button button = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        imageView = (ImageView) findViewById(R.id.image);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);


    }
    /**
     * 获取EditText内容
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                String inputText = editText.getText().toString();
                Toast.makeText(MainActivity.this,inputText,Toast.LENGTH_SHORT).show();
                imageView.setImageResource(R.drawable.ic_launcher_foreground);
                if (progressBar.getVisibility() == View.GONE){
                    progressBar.setVisibility(View.VISIBLE);
                }else{
                    progressBar.setVisibility(View.GONE);
                }
                dialogShow();
                break;
            case R.id.button2:
                Log.d("调试","到这里button");
                progressDialog();
                break;
            case R.id.button3:
                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(intent);
                break;
            case R.id.button4:
                Intent intent1 = new Intent(MainActivity.this, FruitListViewActivity.class);
                startActivity(intent1);
                break;
            case R.id.button5:
                Intent intent5 = new Intent(MainActivity.this, RecyclerViewActivity.class);
                startActivity(intent5);
                break;
                case R.id.button6:
                Intent intent6 = new Intent(MainActivity.this, LiaoTianActivity.class);
                startActivity(intent6);
                break;
            default:break;

        }
    }

    /**
     * 弹出对话框
     */
    private void dialogShow(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("这是dialog");
        builder.setMessage("弹出框");
        builder.setCancelable(false);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("dialog OK","点击了这里");
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("dialog OK","点击了这里222222");
            }
        });
        builder.show();
    }

    /**
     * 进度弹出框
     */
    private void progressDialog(){
        Log.d("调试","到这里了");
        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("ProcessDialog");
        progressDialog.setMessage("Loading**********");
        progressDialog.setCancelable(true);
        progressDialog.show();
    }
}
