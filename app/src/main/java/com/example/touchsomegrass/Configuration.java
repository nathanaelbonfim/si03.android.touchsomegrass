package com.example.touchsomegrass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import presenters.ConfigurationContract;
import presenters.ConfigurationPresenter;

public class Configuration extends BaseActivity implements ConfigurationContract.ConfigurationView {
    private ConfigurationContract.ConfigurationPresenter configurationPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.configurationPresenter = new ConfigurationPresenter();
        this.configurationPresenter.setView(this);
        setContentView(R.layout.activity_configuration);
        EditText inputName = findViewById(R.id.input_name);
        EditText inputMessage = findViewById(R.id.input_message);
        EditText inputInterval = findViewById(R.id.input_interval);
        inputName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                configurationPresenter.setName(s.toString());
            }
        });
        inputMessage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                configurationPresenter.setMessage(s.toString());
            }
        });
        inputInterval.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                configurationPresenter.setInterval(s.toString());
            }
        });
    }

    @Override
    public void showError(String error) {
    }

    @Override
    public void showSucesss() throws Exception {
    }

    @Override
    protected void onResume() {
        super.onResume();

//        this.setDefinedValues();
    }

    /**
     * Busca os valores do model e define na tela, para quando o usuário
     * voltar de outra tela.
     */
    public void setDefinedValues() {
        models.Timer timer = models.Timer.getInstance();

        TextView inputName = (TextView) findViewById(R.id.input_name);
        TextView inputMessage = (TextView) findViewById(R.id.input_message);
        TextView inputInterval = (TextView) findViewById(R.id.input_interval);

        inputName.setText(timer.getName() == null ? timer.getName() : "");
        inputMessage.setText(timer.getMessage() == null ? timer.getMessage() : "");
        inputInterval.setText(timer.getInterval() == 0 ? Integer.toString(timer.getInterval()) : "");
    }

    public void saveConfigs(View view) {
        if (this.configurationPresenter.verifyFields()) {
            Intent intent = new Intent(this, Timer.class);
            startActivity(intent);
        }
    }
}