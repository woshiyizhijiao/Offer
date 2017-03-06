package com.wsyzj.android.offer.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
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
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 20);
        map.put(1, 10);
        map.put(2, 30);
        System.out.println(map);
        LinkedHashMap<Integer, Integer> linkedHashMap = sortHashMap(map);
        System.out.println(linkedHashMap);
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
}
