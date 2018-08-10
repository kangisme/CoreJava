package concurrency.c3;

import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.HashSet;
import java.util.Set;

/**
 * 当满足以下条件时，对象才是不可变的：
 * 1. 对象创建以后其状态就不能修改
 * 2. 对象的所有域都是final类型，实际上不需要，String
 * 3. 对象是正确创建的（在对象的创建期间，this引用没有逸出）
 */
@Immutable
public class ThreeStooges {
    private final Set<String> stooges = new HashSet<>();

    public ThreeStooges() {
        stooges.add("first");
        stooges.add("two");
        stooges.add("three");
    }

    public boolean isStooge(String name) {
        return stooges.contains(name);
    }
}
