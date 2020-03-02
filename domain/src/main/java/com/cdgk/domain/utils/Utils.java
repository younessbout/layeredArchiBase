package com.cdgk.domain.utils;

import java.util.HashMap;
import java.util.Map;

public class Utils {
    public static Map<Integer, String> constructMessageParams(String... params) {
        Map<Integer, String> paramMap = new HashMap<>();

        for (int i = 0; i < params.length; i++) {
            paramMap.put(i, params[i]);
        }

        return paramMap;
    }
}
