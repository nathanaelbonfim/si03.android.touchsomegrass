package presenters;

import android.util.Log;

import models.Timer;

public class ConfigurationPresenter implements ConfigurationContract.ConfigurationPresenter {
    private ConfigurationContract.ConfigurationView view;
    private Timer timer = Timer.getInstance();


    @Override
    public void setMessage(String message) {
        if (message.length() > 12) {
            this.view.showError("Mensagem grande demais");
        } else {
            this.timer.setMessage(message);
        }
    }

    @Override
    public void setName(String name) {
        if (name.length() < 2) {
            this.view.showError("Nome invalido");
        } else {
            this.timer.setName(name);
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
    public void setView(ConfigurationContract.ConfigurationView view) {
        this.view = view;
    }

    @Override
    public boolean verifyFields() {
        boolean isCorrect = this.timer.getInterval() != 0 &&
                this.timer.getTimeToActive() != 0
                && this.timer.getName() != null;

        Log.i("TESTE", isCorrect + "");
        return isCorrect;
    }

}
