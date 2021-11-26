package ru.samsung.itschool.mdev.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    private TextView tv;
    private Button btn3;
    private EditText ed2;
    public static final int RESULT_INFOACTIVITY_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        tv = findViewById(R.id.textView);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            tv.setText(bundle.getString("ccc"));
        }

        //---------------------------------------------------------
        btn3 = findViewById(R.id.button3);
        ed2 = findViewById(R.id.editText2);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("ppp",ed2.getText().toString());
                setResult(RESULT_INFOACTIVITY_CODE,intent); // возврат кода InfoActivity и передача intent
                finish(); // завершение работы InfoActivity
            }
        });
    }
}