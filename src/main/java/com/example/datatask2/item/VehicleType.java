package com.example.datatask2.item;

public enum VehicleType {
    SALOON(1),MOTORBIKE(2),TRUCK(3);

    private final int value;

    // 构造器默认也只能是private, 从而保证构造函数只能在内部使用
    VehicleType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static VehicleType valueOf(int value) {
        switch (value) {
            case 1:
                return VehicleType.SALOON;
            case 2:
                return VehicleType.MOTORBIKE;
            case 3:
                return VehicleType.TRUCK;
            default:
                return null;
        }
    }
}
