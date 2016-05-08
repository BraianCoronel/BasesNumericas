package com.lslfra.livefull.java;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Cadenas6 extends AppCompatActivity{

    EditText valor, valor_2;
    RadioGroup group;
    TextView resultado;
    Button bt;
    int X, X2;
    String sBaseN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valor = (EditText) findViewById(R.id.editText);
        group = (RadioGroup) findViewById(R.id.radioGroup);
        valor_2 = (EditText) findViewById(R.id.editText2);
        resultado = (TextView) findViewById(R.id.textView);
        bt = (Button)findViewById(R.id.button);

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (valor.getText().toString().isEmpty()) {
                    valor.setError("Intruduzca un número");
                } else {

                    X = Integer.parseInt(valor.getText().toString());

                    if (checkedId == R.id.Binario) {
                        resultado.setText(String.valueOf(Integer.toBinaryString(X)));
                    } else if (checkedId == R.id.Octal) {
                        resultado.setText(String.valueOf(Integer.toOctalString(X)));
                    } else if (checkedId == R.id.Hexadecimal) {
                        resultado.setText(String.valueOf(Integer.toHexString(X)));
                    }
                }
            }

        });

        bt.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (valor.getText().toString().isEmpty()) {
                    valor.setError("Intruduzca un número");
                } else if (valor_2.getText().toString().isEmpty()) {
                    valor_2.setError("Intruduzca una base");
                } else {

                    X = Integer.parseInt(valor.getText().toString());
                    X2 = Integer.parseInt(valor_2.getText().toString());
                    sBaseN = Integer.toString(X, X2);
                    bt.setText(String.valueOf(sBaseN));
                }
            }
        });
    }
}