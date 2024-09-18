package org.example;

    public abstract class ProgressiveSeries<T extends Number> {

        private int initialValue;
        private int actualValue;

        public ProgressiveSeries(int initialValue) {
            this.initialValue = initialValue;
        }

        public int getInitialValue() {
            return initialValue;
        }

        protected void setInitialValue(int initialValue) {
            this.initialValue = initialValue;
        }

        public int getActualValue() {
            return actualValue;
        }

        public void setActualValue(int actualValue) {
            this.actualValue = actualValue;
        }

        protected int rebootSerie() {
            return this.actualValue = initialValue;
        }

        abstract int nextValue(int initialValue);


    }
