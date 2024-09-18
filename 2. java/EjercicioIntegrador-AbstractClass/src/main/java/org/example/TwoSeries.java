package org.example;

public class TwoSeries extends ProgressiveSeries{

    public TwoSeries(int initialValue) {
        super(initialValue);
    }

    @Override
    int nextValue(int initialValue) {
        return initialValue + 2;
    }
}
