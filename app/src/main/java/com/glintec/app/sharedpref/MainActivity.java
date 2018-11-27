package com.glintec.app.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btnLog;
    private EditText edt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLog = findViewById(R.id.btn_LOGIN);
        edt1 = findViewById(R.id.edTxt_MAIL);

        loadEmail();

        View.OnClickListener cl = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                saveEmail();
            }
        };

        btnLog.setOnClickListener(cl);
    }

    public void loadEmail(){
        SharedPreferences preferencia = getSharedPreferences("datos",Context.MODE_PRIVATE);
        String email = preferencia.getString("email","");
        edt1.setText(email);
    }

    public void saveEmail(){
        SharedPreferences preferencias = getSharedPreferences("datos",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("email", edt1.getText().toString());
        editor.commit();
        finish();
    }
}
