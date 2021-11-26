package ru.samsung.itschool.mdev.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn, btn2;
    private EditText ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(this);
        btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(this);
        ed = findViewById(R.id.editText);
    }

         ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == InfoActivity.RESULT_INFOACTIVITY_CODE) {
                        // вызов маленького окна с текстом из InfoActivity
                        Toast.makeText(getApplicationContext(),result.getData().getStringExtra("ppp"),Toast.LENGTH_LONG).show();
                    }
                }
            });

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button) {
            String url = "tel:";
            // Намерение
            // Неявное намерение
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
            // 1. Вызвать камеру
            // 2. Вызвать карты
        } else {
            // Явное намерение
            Intent intent = new Intent(this,InfoActivity.class);
            intent.putExtra("ccc",ed.getText().toString());
            // startActivity(intent); // - вызов активности без возврата данных
            someActivityResultLauncher.launch(intent);
        }
    }
}