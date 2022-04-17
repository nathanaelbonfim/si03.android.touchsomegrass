package com.example.touchsomegrass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class Configuration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        TextInputLayout inputName = findViewById(R.id.configuration_name);
        TextInputLayout inputMessage = findViewById(R.id.configuration_message);
        inputName.addOnEditTextAttachedListener(new TextInputLayout.OnEditTextAttachedListener() {
            @Override
            public void onEditTextAttached(@NonNull TextInputLayout textInputLayout) {
                Log.i("Configuration", "changes");
            }
        });
    }
}