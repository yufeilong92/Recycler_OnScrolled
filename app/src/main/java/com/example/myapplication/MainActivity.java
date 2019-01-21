package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvContent;
    private LinearLayout mLlBar;
    private RecyclerView mRlvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 80; i++) {
            list.add("String =" + i);
        }
        final GridLayoutManager manager = new GridLayoutManager(this, 1);
        manager.setOrientation(GridLayoutManager.VERTICAL);
        mRlvContent.setLayoutManager(manager);
        RlcAdapter adapter = new RlcAdapter(this, list);
        mRlvContent.setAdapter(adapter);
        mRlvContent.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                float alphaFloat = getAlphaFloat(getScroolY(manager));
                mLlBar.setAlpha(alphaFloat);
            }
        });
    }
    /**
     * 获取滑动距离
     *
     * @param manager
     * @return
     */
    private int getScroolY(GridLayoutManager manager) {
        View c = mRlvContent.getChildAt(0);
        if (c == null)
            return 0;
        int i = manager.findFirstVisibleItemPosition();
        int top = c.getTop();
        /**
         * 声明一下，这里测试得到的top值始终是RecyclerView条目中显示的第一条距离顶部的距离，
         * 而这个在坐标中的表示是一个负数，所以需要对其取一个绝对值
         */
        return i * c.getHeight() + Math.abs(top);
    }

    /**
     * 更具相应位子显示相应的透明度
     *
     * @param dis
     * @return
     */
    private float getAlphaFloat(int dis) {
        int step = 200;
        if (dis == 0) {
            return 0.0f;
        }
        if (dis < step) {
            return (float) (dis * (1.0 / step));
        } else {
            return 1.0f;
        }
    }

    private void initView() {
        mTvContent = (TextView) findViewById(R.id.tv_content);
        mLlBar = (LinearLayout) findViewById(R.id.ll_bar);
        mRlvContent = (RecyclerView) findViewById(R.id.rlv_content);
        mRlvContent.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {

        }
    }
}
