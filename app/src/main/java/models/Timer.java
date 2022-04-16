package models;

import java.util.HashMap;
import java.util.Map;

public class Timer {
    private String message;
    private int interval;
    private int timeToActive;
    private String name;
    public static final Map<Integer, Integer> IntervalOptions = new HashMap<Integer, Integer>();
    public static final Map<Integer, Integer> TimeToActiveOptions = new HashMap<Integer, Integer>();
    public String getMessage() {
        return this.message;
    }

    public Timer(String message, int interval, int timeToActive) {
        this.message = message;
        this.interval = interval;
        this.timeToActive = timeToActive;
        this.message = message;
        this.setIntervalOptions();
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getInterval() {
        return this.interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public int getTimeToActive() {
        return this.timeToActive;
    }

    public void setTimeToActive(int timeToActive) {
        this.timeToActive = timeToActive;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void setIntervalOptions() {
        IntervalOptions.put(0, 1);
        IntervalOptions.put(1, 2);
        IntervalOptions.put(2, 3);
    }

    private void setTimeToActiveOptions() {
        TimeToActiveOptions.put(0, 10);
        TimeToActiveOptions.put(1, 15);
        TimeToActiveOptions.put(2, 30);
    }


}