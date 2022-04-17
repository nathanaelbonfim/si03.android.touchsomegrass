package presenters;

import models.Timer;

public class TimerPresenter implements TimerContract.TimerPresenter {
    private TimerContract.TimerView view;
    private Timer timer;


    @Override
    public void setMessage(String message) {
        if (message.length() > 12) {
            this.view.showError("Mensagem grande demais");
        }
    }

    @Override
    public void setName(String name) {
        if (name.length() < 2) {
            this.view.showError("Nome invalido");
        }
    }

    @Override
    public void setInterval(String interval) {
        this.timer.setInterval(Integer.parseInt(interval));
    }

    @Override
    public void setTimeToActive(String timeToActive) {
        this.timer.setTimeToActive(Integer.parseInt(timeToActive));
    }

    @Override
    public void getListFieldsSelect(String field) {

    }

    @Override
    public void setView(TimerContract.TimerView view) {
        this.view = view;
    }

    @Override
    public boolean verifyFields() {
        boolean isCorrect = this.timer.getInterval() != 0 && this.timer.getTimeToActive() != 0 && this.timer.getName() != null;
        return isCorrect;
    }
}
