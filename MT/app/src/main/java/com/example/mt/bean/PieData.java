package com.example.mt.bean;

/**
 * Time:2019/8/9
 * Author:zyh
 * Description:
 */
public class PieData {
    private int color;
    private float angle;
    private float value;
    private float percentage;
    private String name;
    private int age;

    public PieData(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }
}
