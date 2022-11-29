package com.leetcode.easy;

import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/***
 * 
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * If there is no common prefix, return an empty string "".
 */
public class LongestCommonPrefix {

    private LongestCommonPrefix() {
    }

    public static String resolution(String[] strings) {
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < strings[0].length(); i++) {
            List<Character> chars = collectCharsAtIndex(i, List.of(strings));

            if (isLettersCommon(chars)) {
                result.append(getLetter(chars));
            } else {
                break;
            }
        }
        return result.toString();
    }

    private static String getLetter(List<Character> letters) {
        return Character.toString(letters.get(0));
    }

    private static boolean isLettersCommon(List<Character> letters) {
        if (Objects.isNull(letters)) {
            return false;
        }

        Long l = letters.stream().distinct().count();

        return l.equals(1L);
    }

    private static List<Character> collectCharsAtIndex(int index, List<String> words) {

        List<Character> chars = null;
        try {
            chars = words.stream().map(w -> w.charAt(index)).collect(Collectors.toList());
        } catch (IndexOutOfBoundsException ex) {
            Logger.getLogger("my log").log(Level.WARNING, ex.getMessage());
        }
        return chars;
    }

}
