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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
        parseJson();
//        String t1 = getString(R.string.t1);
//        String t2 = getString(R.string.t2);
//        String t3 = getString(R.string.t3);
//        String t4 = getString(R.string.t4);
//        String t5 = getString(R.string.t5);
//        String t6 = getString(R.string.t6);
//        jsonToList(t1, "t1");
//        jsonToList(t2, "t2");
//        jsonToList(t3, "t3");
//        jsonToList(t4, "t4");
//        jsonToList(t5, "t5");
//        jsonToList(t6, "t6");
//        LogUtil.e("解析之前的数据 " + new Gson().toJson(mAcupoints));
//        listToData();

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
            if (contents.size() != 0) {
                acupointC.Letters = alphabet;
                acupointC.Content = contents;
                acupointCs.add(acupointC);
            }
        }
        LogUtil.e("解析之后的数据 " + new Gson().toJson(acupointCs));
    }

    private void parseJson() {
        JSONArray array = new JSONArray();
        for (int x = 0; x < 12; x++) {
            switch (x) {
                case 0:
                    array.put(addJsonObject("足太阳膀胱经", R.string.c1));
                    break;
                case 1:
                    array.put(addJsonObject("足厥阴肝经", R.string.c2));
                    break;
                case 2:
                    array.put(addJsonObject("足少阳胆经", R.string.c3));
                    break;
                case 3:
                    array.put(addJsonObject("手少阴心经", R.string.c4));
                    break;
                case 4:
                    array.put(addJsonObject("足太阴脾经", R.string.c5));
                    break;
                case 5:
                    array.put(addJsonObject("手阳明大肠经", R.string.c6));
                    break;
                case 6:
                    array.put(addJsonObject("手太阳小肠经", R.string.c7));
                    break;
                case 7:
                    array.put(addJsonObject("手太阴肺经", R.string.c8));
                    break;
                case 8:
                    array.put(addJsonObject("足阳明胃经", R.string.c9));
                    break;
                case 9:
                    array.put(addJsonObject("手厥阴心包经", R.string.c10));
                    break;
                case 10:
                    array.put(addJsonObject("足少阴肾经", R.string.c11));
                    break;
                case 11:
                    array.put(addJsonObject("手少阳三焦经", R.string.c12));
                    break;
                default:
                    break;
            }
        }
        LogUtil.e(array.toString());
    }

    private JSONObject addJsonObject(String clazz, int resId) {
        String json = getString(resId);
        String[] split = json.split("、");

        try {
            JSONObject obj1 = new JSONObject();
            obj1.put("class", clazz);

            JSONArray array = new JSONArray();
            for (int x = 0; x < split.length; x++) {
                JSONObject obj2 = new JSONObject();
                obj2.put("acupoint", split[x]);
                array.put(obj2);
            }
            obj1.put("content", array);
            return obj1;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
