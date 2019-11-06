package com.laidani.librairie;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Youcef LAIDANI
 */
public class LdnCollections {

    public static <T> List<List<T>> partition(List<T> list, int partSize) {
        if (list == null) {
            throw new NullPointerException();
        }
        if (partSize <= 0) {
            throw new IllegalArgumentException("Parts size should be > 0");
        }
        List<List<T>> parts = new ArrayList<>();
        final int s = list.size();
        for (int i = 0; i < s; i += partSize) {
            parts.add(list.subList(i, Math.min(s, i + partSize)));
        }
        return parts;
    }
}
