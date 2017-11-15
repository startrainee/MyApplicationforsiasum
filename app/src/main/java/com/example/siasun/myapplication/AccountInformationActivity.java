package com.example.siasun.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class AccountInformationActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    RecyclerViewAdapter mRecyclerViewAdapter;
    Toolbar mToolbar;
    List<String> mDatas;
    SwipeRefreshLayout mSwipeRefreshLayout;
    Handler mHandler = new Handler();

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_information);
        initView();
        initData();
    }

    private void initView() {
        mDatas = getData();
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mRecyclerView = findViewById(R.id.pull_to_refresh_recycler_view);
        mSwipeRefreshLayout = findViewById(R.id.pull_to_refresh_SwipeRefreshLayout);
    }


    private void initData() {
        mToolbar.setBackgroundColor(ContextCompat.getColor(AccountInformationActivity.this, R.color.colorPrimaryDark));
        mToolbar.setTitle(getString(R.string.account_information));
        setSupportActionBar(mToolbar);


        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerViewAdapter = new RecyclerViewAdapter(this,mDatas);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);


        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        addData();
                    }
                }, 2000);
            }
        });
        mSwipeRefreshLayout.setRefreshing(false);
    }

    private void addData() {
        mDatas.add(0,"ReFresh  to add Text Item");
        mRecyclerViewAdapter.notifyDataSetChanged();
        mSwipeRefreshLayout.setRefreshing(false);

    }

    public List<String> getData() {
        List<String> list = new ArrayList<>();
        list.add("text item 1");
        list.add("text item 2");
        list.add("text item 3");
        list.add("text item 4");
        list.add(0,"text item 0");
        return list;
    }


    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

        List<String> list;
        Context context;

        public RecyclerViewAdapter(Context context,List<String> list) {
            this.list = list;
            this.context = context;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(context).inflate(R.layout.recyler_view_item, viewGroup,
                    false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
            myViewHolder.init(list.get(i));
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
        class MyViewHolder extends RecyclerView.ViewHolder{
            TextView textView;
            public MyViewHolder(View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.recycler_view_item_tv);
            }

            public void init(String s) {
                textView.setText(s);

            }
        }
    }
}
