package com.wsyzj.android.offer.offer;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: wsyzj
 * @date: 2017-03-01 22:35
 * @comment: 面试时java知识
 */
public class OfferJava {

    public static void main(String[] array) {
        List<String> list = new ArrayList<>();
        System.out.println(removeDuplicate(list));
    }

    /**
     * 对该集合的值按小到大的顺序进行排序，key=value不变，
     *
     * @param ages
     * @return
     */
    private static LinkedHashMap<Integer, Integer> sortHashMap(Map<Integer, Integer> ages) {
        Set<Map.Entry<Integer, Integer>> map = ages.entrySet();
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map);
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;
    }

    /**
     * 去除集合中的重复元素
     * 方法二  ，遍历集合中的元素，创建一个新的集合，如在集合中没有该元素则添加到新的集合中
     *
     * @param list
     * @return
     */
    private static List<String> removeDuplicate(List list) {
        HashSet hashSet = new HashSet(list);
        list.clear();
        list.addAll(hashSet);
        return list;
    }

    /**
     * byte转int
     *
     * @param b
     * @return
     */
    public static int byteToInt(byte b) {
        String s = b + "";
        if (!TextUtils.isEmpty(s)) {
            try {
                return Integer.parseInt(s);
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        } else {
            return -1;
        }
    }
}
