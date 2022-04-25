package com.example.touchsomegrass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.TimerTask;

import presenters.ConfigurationContract;
import presenters.ConfigurationPresenter;
import presenters.ContractTimer;
import presenters.TimerPresenter;

public class Timer extends BaseActivity implements ContractTimer.TimerView {
    private ContractTimer.TimerPresenter timerPresenter = new TimerPresenter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        setInitialValues();
        this.timerPresenter.init();

        new java.util.Timer().scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run(){
                changeState();
            }
        },0,1000);
    }

    @Override
    protected void onResume() {
        super.onResume();

        setInitialValues();
    }

    @Override
    public void changeState() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (timerPresenter.isFinished()) {
                    showMessage();
                }

                setTimer();
            }
        });
    }

    /**
     * Exibe o logo e a mensagem quando o timer atinge zero
     */
    public void showMessage() {
        LinearLayout additionalInfoView = (LinearLayout) findViewById(R.id.additional_info_container);
        LinearLayout logoView = (LinearLayout) findViewById(R.id.timer_break_logo_container);

        logoView.setAlpha(1);
        additionalInfoView.setAlpha(1);
    }

    public void setInitialValues() {
        String name = models.Timer.getInstance().getName();
        String message = models.Timer.getInstance().getMessage();

        TextView nameView = (TextView) findViewById(R.id.timer_additional_info_name);
        TextView messageView = (TextView) findViewById(R.id.timer_additional_info_message);

        nameView.setText(name);
        messageView.setText(message);

        // Esconde o logo e a mensagem
        LinearLayout additionalInfoView = (LinearLayout) findViewById(R.id.additional_info_container);
        LinearLayout logoView = (LinearLayout) findViewById(R.id.timer_break_logo_container);
        logoView.setAlpha(0);
        additionalInfoView.setAlpha(0);

        setTimer();
    }

    public void setTimer() {
        TextView hours = (TextView) findViewById(R.id.timer_hours);
        TextView minutes = (TextView) findViewById(R.id.timer_minutes);
        TextView seconds = (TextView) findViewById(R.id.timer_seconds);

        hours.setText(
                String.format("%02d", this.timerPresenter.getHours())
        );
        minutes.setText(
                String.format("%02d", this.timerPresenter.getMinutes())
        );
        seconds.setText(
                String.format("%02d", this.timerPresenter.getSeconds())
        );
    }


    /**
     * Abre a tela de configuração de parâmetros
     * @param view
     */
    public void openConfigurations(View view) {
        startActivity(new Intent(this, Configuration.class));
    }
}