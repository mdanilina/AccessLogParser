package ru.stepup.payments;

public class LocalDateTime {

    Integer minTime, maxTime;

    public LocalDateTime (int minTime, int maxTime){
        this.minTime = minTime;
        this.maxTime = maxTime;
    }

    public Integer getMinTime() {
            return minTime;
    }

    public Integer getMaxTime() {
        return maxTime;
    }
//реализуйте в классе метод getTrafficRate, в котором вычисляйте разницу между maxTime и minTime в часах и делите общий объём трафика на эту разницу.
    public int getTrafficRate() {
        return maxTime - minTime;
    }
}
