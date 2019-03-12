package com.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    public static String doMasking(String target, String patternString) {
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(target);
        if (matcher.matches()) {
            if (matcher.groupCount() < 1) {
                return target;
            }
            String group = matcher.group(1);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < group.length(); i++) {
                stringBuilder.append("*");
            }
            return target.replace(group, stringBuilder.toString());
        }
        return target;
    }
}
