package com.aequilibrium.transformers.domain;


import java.util.Random;

import static java.lang.String.format;

public final class Score extends Number implements Comparable<Score> {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 10;
    private final Integer value;

    public Score(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE)
            throw new IllegalArgumentException(format("Value should be a number between %d and %d", MIN_VALUE, MAX_VALUE));
        this.value = value;
    }

    public static Score random(){
        return new Score(new Random().nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE);
    }

    @Override
    public int compareTo(Score o) {
        return value.compareTo(o.value);
    }

    @Override
    public int intValue() {
        return value;
    }

    @Override
    public long longValue() {
        return value.longValue();
    }

    @Override
    public float floatValue() {
        return value.floatValue();
    }

    @Override
    public double doubleValue() {
        return value.doubleValue();
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return value.equals(score.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
