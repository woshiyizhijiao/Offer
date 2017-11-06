package com.wsyzj.android.offer.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;

import com.google.gson.Gson;
import com.wsyzj.android.offer.R;
import com.wsyzj.android.offer.bean.AcupointA;
import com.wsyzj.android.offer.bean.AcupointB;
import com.wsyzj.android.offer.bean.AcupointC;
import com.wsyzj.android.offer.tools.LogUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: wsyzj
 * @date: 2017-05-09 13:14
 * @comment:
 */
public class TestActivity extends AppCompatActivity {
    public String[] alphabets = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private List<AcupointA> mAcupoints = new LinkedList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    public void onClick(View view) {
        String t1 = getString(R.string.t1);
        String t2 = getString(R.string.t2);
        String t3 = getString(R.string.t3);
        String t4 = getString(R.string.t4);
        String t5 = getString(R.string.t5);
        String t6 = getString(R.string.t6);
        jsonToList(t1, "t1");
        jsonToList(t2, "t2");
        jsonToList(t3, "t3");
        jsonToList(t4, "t4");
        jsonToList(t5, "t5");
        jsonToList(t6, "t6");
        LogUtil.e("解析之前的数据 " + new Gson().toJson(mAcupoints));
        listToData();
    }

    private void jsonToList(String t1, String type) {
        AcupointB acupointB = new Gson().fromJson(t1, AcupointB.class);
        List<AcupointB.TBean> beanList = null;
        if (TextUtils.equals(type, "t1")) {
            beanList = acupointB.T1;
        } else if (TextUtils.equals(type, "t2")) {
            beanList = acupointB.T2;
        } else if (TextUtils.equals(type, "t3")) {
            beanList = acupointB.T3;
        } else if (TextUtils.equals(type, "t4")) {
            beanList = acupointB.T4;
        } else if (TextUtils.equals(type, "t5")) {
            beanList = acupointB.T5;
        } else if (TextUtils.equals(type, "t6")) {
            beanList = acupointB.T6;
        }

        for (int x = 0; x < beanList.size(); x++) {
            AcupointB.TBean tBean = beanList.get(x);
            List<AcupointB.TBean.ContentBean> content = tBean.Content;
            for (int y = 0; y < content.size(); y++) {
                AcupointB.TBean.ContentBean contentBean = content.get(y);

                AcupointA acupointA = new AcupointA();
                acupointA.Letters = tBean.Letters;
                acupointA.ArticleID = contentBean.ArticleID;
                acupointA.ClassID = contentBean.ClassID;
                acupointA.Title = contentBean.Title;
                mAcupoints.add(acupointA);
            }
        }
    }

    private void listToData() {
        List<AcupointC> acupointCs = new ArrayList<>();

        for (int x = 0; x < alphabets.length; x++) {
            String alphabet = alphabets[x];
            AcupointC acupointC = new AcupointC();
            List<AcupointB.TBean.ContentBean> contents = new ArrayList<>();

            for (int y = 0; y < mAcupoints.size(); y++) {
                AcupointA acupointA = mAcupoints.get(y);
                if (TextUtils.equals(alphabet, acupointA.Letters)) {
                    AcupointB.TBean.ContentBean bean = new AcupointB.TBean.ContentBean();
                    bean.ArticleID = acupointA.ArticleID;
                    bean.ClassID = acupointA.ClassID;
                    bean.Title = acupointA.Title;
                    contents.add(bean);
                }

            }
            acupointC.Letters = alphabet;
            acupointC.Content = contents;
            acupointCs.add(acupointC);
        }

        LogUtil.e("解析之前的数据 " + new Gson().toJson(acupointCs));
    }
}
