package com.example.touchsomegrass;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.touchsomegrass.databinding.ActivityConfigurationBinding;

import presenters.TimerContract;
import presenters.TimerPresenter;

public class ConfigurationActivity extends AppCompatActivity implements TimerContract.TimerView {

    private AppBarConfiguration appBarConfiguration;
    private ActivityConfigurationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TimerContract.TimerPresenter timerPresenter = new TimerPresenter();
        timerPresenter.setView(this);
        binding = ActivityConfigurationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_configuration);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        EditText inputName = findViewById(R.id.input_name);
        inputName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timerPresenter.setInterval(Integer.parseInt(inputName.getText().toString()));
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_configuration);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void showError(String error) {
        //TODO: Implementar show error
    }

    @Override
    public void showSucesss() throws Exception {
        throw new Exception("Not implemented");
        //TODO: Implementar show success
    }

}