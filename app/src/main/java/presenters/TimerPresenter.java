package presenters;

import java.util.TimerTask;

import models.Timer;

public class TimerPresenter implements ContractTimer.TimerPresenter {
    private int time;
    Timer timer =  Timer.getInstance();

    @Override
    public int getTime() {
        if (time != 0) {
           return this.time;
        }
        return timer.getTimeToActive();
    }

    @Override
    public int getMinutes() {
        return time / 60;
    }

    @Override
    public int getHours() {
        return (time / 60) / 60;
    }

    @Override
    public int getSeconds() {
        return time;
    }

    @Override
    public void init() {
        this.time = this.getTime();
        new java.util.Timer().scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run(){
                time = time - 1;
            }
        },0,1000);
    }
}
