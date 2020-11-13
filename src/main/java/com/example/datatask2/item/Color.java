package com.example.datatask2.item;

public enum Color {
    RED(1),BLUE(2),GREEN(3),YELLOW(4),WHITE(5),BLACK(6);


    private final int value;

    // 构造器默认也只能是private, 从而保证构造函数只能在内部使用
    Color(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }


    public static Color valueOf(int value) {
        switch (value) {
            case 1:
                return Color.RED;
            case 2:
                return Color.BLUE;
            case 3:
                return Color.GREEN;
            case 4:
                return Color.YELLOW;
            case 5:
                return Color.WHITE;
            case 6:
                return Color.BLACK;
            default:
                return null;
        }
    }
}
