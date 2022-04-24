package com.example.touchsomegrass;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.menu_activity_presentation:
                intent = new Intent(this, Presentation.class);
                startActivity(intent);
                return true;
            case R.id.menu_activity_configuration:
                intent = new Intent(this, Configuration.class);
                startActivity(intent);
                return true;
            case R.id.menu_activity_about:
                intent = new Intent(this, About.class);
                startActivity(intent);
            default:
                return super.onContextItemSelected(item);
        }
    }
}
