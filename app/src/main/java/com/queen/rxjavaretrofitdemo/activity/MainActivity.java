package com.queen.rxjavaretrofitdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.queen.rxjavaretrofitdemo.R;
import com.queen.rxjavaretrofitdemo.entity.Subject;
import com.queen.rxjavaretrofitdemo.http.HttpMethods;
import com.queen.rxjavaretrofitdemo.subscribers.ProgressSubscriber;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.click_me_BN)
    Button clickMeBN;
    @Bind(R.id.result_TV)
    TextView resultTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @OnClick(R.id.click_me_BN)
    public void onClick() {
        getMovie();
    }

    //进行网络请求
    private void getMovie(){
        HttpMethods.getInstance().getTopMovie(new ProgressSubscriber(MainActivity.this) {

            @Override
            public void onNext(Object o) {
                resultTV.setText("第3个数据的标题:"+((List<Subject>)o).get(2).getOriginal_title()
                        +"\n"+"数据内容:"+"\n"+
                        o.toString()
                );
            }
        }, 0, 10);
    }
}
