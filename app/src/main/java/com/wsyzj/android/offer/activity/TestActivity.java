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
//        parseJson();
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
        test();
        test1();
    }

    private void test1() {
        try {
            JSONObject obj1 = new JSONObject();
            JSONArray array1 = new JSONArray();

            array1.put(obj1("461", "32", "会阴穴"));
            array1.put(obj1("499", "30", "曲骨穴"));
            array1.put(obj1("508", "30", "中极穴"));
            array1.put(obj1("491", "30", "关元穴"));
            array1.put(obj1("501", "30", "石门穴"));
            array1.put(obj1("497", "30", "气海穴"));
            array1.put(obj1("507", "30", "阴交穴"));
            array1.put(obj1("507", "30", "神厥穴"));
            array1.put(obj1("518", "30", "水分穴"));
            array1.put(obj1("521", "30", "下脘穴"));
            array1.put(obj1("251", "30", "建里穴"));
            array1.put(obj1("520", "30", "中脘穴"));
            array1.put(obj1("333", "30", "上脘穴"));
            array1.put(obj1("333", "30", "巨厥穴"));
            array1.put(obj1("261", "30", "鸠尾穴"));
            array1.put(obj1("479", "30", "中庭穴"));
            array1.put(obj1("479", "30", "颤中穴"));
            array1.put(obj1("454", "30", "玉堂穴"));
            array1.put(obj1("484", "30", "紫宫穴"));
            array1.put(obj1("228", "30", "华盖穴"));
            array1.put(obj1("418", "30", "璇玑穴"));
            array1.put(obj1("380", "34", "天突穴"));
            array1.put(obj1("523", "34", "廉泉穴"));
            array1.put(obj1("162", "29", "承浆穴"));


            // 神厥穴 巨厥穴 颤中穴
//            会阴穴
//                    曲骨穴
//            中极穴
//                    关元穴
//            石门穴
//                    气海穴
//            阴交穴
//                    神厥穴
//            水分穴
//                    下脘穴
//            建里穴
//                    中脘穴
//            上脘穴
//                    巨厥穴
//            鸠尾穴
//                    中庭穴
//            颤中穴
//                    玉堂穴
//            紫宫穴
//                    华盖穴
//            璇玑穴
//                    天突穴
//            廉泉穴
//                    承浆穴

            obj1.put("dict", array1);
            LogUtil.e(obj1.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void test() {
        try {
            JSONObject obj1 = new JSONObject();
            JSONArray array1 = new JSONArray();

            array1.put(obj1("461", "32", "长强穴"));
            array1.put(obj1("433", "32", "腰俞穴"));
            array1.put(obj1("432", "32", "腰阳关"));
            array1.put(obj1("286", "32", "命门穴"));
            array1.put(obj1("416", "32", "悬枢穴"));
            array1.put(obj1("238", "32", "脊中穴"));
            array1.put(obj1("478", "32", "中枢穴"));
            array1.put(obj1("432", "32", "筋缩穴"));
            array1.put(obj1("467", "32", "至阳穴"));
            array1.put(obj1("280", "32", "灵台穴"));
            array1.put(obj1("343", "32", "神道穴"));
            array1.put(obj1("341", "32", "身柱穴"));
            array1.put(obj1("371", "32", "陶道穴"));
            array1.put(obj1("181", "32", "大椎穴"));
            array1.put(obj1("649", "29", "哑门穴"));
            array1.put(obj1("621", "29", "风府穴"));
            array1.put(obj1("630", "29", "脑户穴"));
            array1.put(obj1("633", "29", "强间穴"));
            array1.put(obj1("624", "29", "后顶穴"));
            array1.put(obj1("432", "32", "百会穴"));
            array1.put(obj1("632", "29", "前顶穴"));
            array1.put(obj1("432", "32", "卤会穴"));
            array1.put(obj1("636", "29", "上星穴"));
            array1.put(obj1("637", "29", "神庭穴"));
            array1.put(obj1("364", "29", "素髎穴"));
            array1.put(obj1("357", "29", "水沟穴"));
            array1.put(obj1("192", "29", "兑端穴"));
            array1.put(obj1("432", "32", "龈交穴"));


//            卤会穴 龈交穴 百会穴 筋缩穴

//            命门穴
//                    悬枢穴
//            脊中穴
//                    中枢穴
//            筋缩穴
//                    至阳穴
//            灵台穴
//                    神道穴
//            身柱穴
//                    陶道穴
//            大椎穴
//                    哑门穴
//            风府穴
//                    脑户穴
//            强间穴
//                    后顶穴
//            百会穴
//                    前顶穴
//            卤会穴
//                    上星穴
//            神庭穴
//                    素髎穴
//            水沟穴
//                    兑端穴
//            龈交穴


            obj1.put("dict", array1);
            LogUtil.e(obj1.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private JSONObject obj1(String ArticleID, String ClassID, String Title) {
        try {
            JSONObject object = new JSONObject();
            object.put("key", array());
            object.put("string", array2(ArticleID, ClassID, Title));
            return object;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }


    public JSONArray array() {
        try {
            JSONArray array = new JSONArray();
            array.put(0, "ArticleID");
            array.put(1, "ClassID");
            array.put(2, "Title");
            return array;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONArray array2(String ArticleID, String ClassID, String Title) {
        try {
            JSONArray array = new JSONArray();
            array.put(0, ArticleID);
            array.put(1, ClassID);
            array.put(2, Title);
            return array;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
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
