package models;

public class Timer {
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public int getTimeToActive() {
        return timeToActive;
    }

    public void setTimeToActive(int timeToActive) {
        this.timeToActive = timeToActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String message;
    private int interval;
    private int timeToActive;
    private String name;


    public Timer(String message, int interval, int timeToActive) {
        this.message = message;
        this.interval = interval;
        this.timeToActive = timeToActive;
        this.message = message;
    }


}