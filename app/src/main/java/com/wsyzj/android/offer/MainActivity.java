package com.wsyzj.android.offer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.wsyzj.android.offer.activity.LottieAct;

import java.util.Arrays;

/**
 * Offer
 */
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView list_view;
    private String[] mDatas = new String[]{"Lottie"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list_view = (ListView) findViewById(R.id.list_view);
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Arrays.asList(mDatas));
        list_view.setAdapter(arrayAdapter);
        list_view.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                startAct(LottieAct.class);
                break;
        }
    }

    private void startAct(Class clas) {
        startActivity(new Intent(this, clas));
    }
}
