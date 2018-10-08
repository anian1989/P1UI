package com.fanhanfei.p1_ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class LiaoTianActivity extends AppCompatActivity {
    private List<Msg> msgList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liao_tian);
        initMsgs();
        inputText = findViewById(R.id.input_text);
        send = findViewById(R.id.send);
        msgRecyclerView = findViewById(R.id.msg_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(linearLayoutManager);
        adapter = new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = inputText.getText().toString();
                if (!"".equals(s)){
                    Msg msg = new Msg(s, Msg.TYPE_SENT);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size());//当有新消息时，刷新RecyclerView中显示
                    msgRecyclerView.scrollToPosition(msgList.size()-1);//将RecyclerView定位到最后一行
                    inputText.setText("");//清空输入框
                }
            }
        });

    }

    private void initMsgs(){
        Msg hellot = new Msg("Hellot", Msg.TYPE_RECEIVED);
        msgList.add(hellot);
        Msg hellot1 = new Msg("Hellot1111111", Msg.TYPE_SENT);
        msgList.add(hellot1);
        Msg hellot2 = new Msg("Hellot22222222", Msg.TYPE_RECEIVED);
        msgList.add(hellot2);

    }
}
