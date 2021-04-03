package com.crispereira.projectchapapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 10);

        EditText inputName = findViewById(R.id.inputName);
        Button btLogin = findViewById(R.id.btLogin);

        btLogin.setOnClickListener(v -> {

            Intent intent = new Intent(this, ChatActivity.class);
            intent.putExtra("name", inputName.getText().toString());
            startActivity(intent);
        });

        //aqui sera necessario listar os usuarios online
        ListView lista = findViewById(R.id.listUsuarios);
        //lista.setAdapter(new MessageAdapter(this));
    }
}