package com.recime.recipeapp.data;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Difficulty {
    EASY, MEDIUM, HARD;

    private static final Map<String, Difficulty> ENUM_MAP =
            Stream.of(Difficulty.values())
                    .collect(Collectors.toMap(Enum::name, e -> e));

    public static Difficulty fromString(String value) {
        return ENUM_MAP.get(value);
    }
}

