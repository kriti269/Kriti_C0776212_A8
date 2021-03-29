package com;

/**
 * Represents days of week with index 0 starting from Sunday.
 * @author Kriti - C0776212
 */
public enum Day {
    SUNDAY(0), MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6);

    private int index;
    Day(int index){
        this.index = index;
    }
    public int getIndex(){
        return this.index;
    }
}
