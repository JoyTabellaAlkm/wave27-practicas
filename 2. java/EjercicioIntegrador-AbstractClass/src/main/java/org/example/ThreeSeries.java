package org.example;

public class ThreeSeries extends ProgressiveSeries{

    public ThreeSeries(int initialValue) {
        super(initialValue);
    }

    @Override
    int nextValue(int initialValue) {
        return initialValue +3 ;
    }
}
