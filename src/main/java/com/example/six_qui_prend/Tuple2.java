package com.example.six_qui_prend;

public class Tuple2 {
    private int row;
    private int value;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Tuple2(int row, int value) {
        this.row = row;
        this.value = value;
    }
}
