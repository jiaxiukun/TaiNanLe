package baway.com.tainanle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Request;

//recyclerview上拉加载下拉刷新 http://blog.csdn.net/leoleohan/article/details/50989549/

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Bean bean;
    private String path = "http://m.yunifang.com/yunifang/mobile/goods/getall?random=39986&encode=2092d7eb33e8ea0a7a2113f2d9886c90&category_id=17";
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setOkHttp();
    }
    public void setRecyclerView(){
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        //初始化adapter中的构造方法
        adapter = new MyAdapter(this,bean);
        recyclerView.setAdapter(adapter);
    }

    private void setOkHttp() {
        OkHttp.getAsync(path, new OkHttp.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) throws Exception {
                Gson gson=new Gson();
                bean = gson.fromJson(result, Bean.class);
                setRecyclerView();
            }
        });

    }
}
