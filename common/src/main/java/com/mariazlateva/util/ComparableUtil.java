package com.mariazlateva.util;

/**
 * Bill Pugh singleton design pattern implementation
 * See https://medium.com/geekculture/one-stop-shop-for-singleton-pattern-creation-in-java-c48bdbf30d5d
 */
public final class ComparableUtil {

    private ComparableUtil() {
    }

    public static ComparableUtil getInstance() {
        return ComparableUtilHelper.INSTANCE;
    }

    //== private static inner helper class for the singleton design pattern ==
    private static class ComparableUtilHelper {
        private static final ComparableUtil INSTANCE = new ComparableUtil();
    }

    //== public methods ==
    public <T extends Comparable<T>> boolean leftIsEqual(T left, T right) {
        return left.compareTo(right) == 0;
    }

    public <T extends Comparable<T>> boolean leftIsBefore(T left, T right) {
        return left.compareTo(right) < 0;
    }

    public <T extends Comparable<T>> boolean leftIsAfter(T left, T right) {
        return left.compareTo(right) > 0;
    }

}
