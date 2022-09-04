package com.example.calcu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {

    private RadioGroup funcion,grados;
    private ImageView imageAngulo;
    private TextView RESULTADO;
    double angulo;
    int radioButtonId,indice;
    String gra;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.activity_main);

        funcion = findViewById(R.id.funcion);
        grados = findViewById(R.id.grados);
        imageAngulo = findViewById(R.id.imageAngulo);
        RESULTADO = findViewById(R.id.RESULTADO);
    }

    public void Grados(View v){
        radioButtonId = grados.getCheckedRadioButtonId();
        View radioButton = grados.findViewById(radioButtonId);
        indice = grados.indexOfChild(radioButton);
        RadioButton rb = (RadioButton) grados.getChildAt(indice);
        String gra = rb.getText().toString();

        if (grados.getCheckedRadioButtonId()==R.id.rdB45){
            imageAngulo.setImageResource(R.drawable._45);
        }else if(grados.getCheckedRadioButtonId()==R.id.rdB90){
            imageAngulo.setImageResource(R.drawable._90);
        }else if(grados.getCheckedRadioButtonId()==R.id.rdB180){
            imageAngulo.setImageResource(R.drawable._180);
        }
        if (funcion.getCheckedRadioButtonId()==R.id.rdBSIN){
            angulo = (Math.sin(Double.parseDouble(gra)*2.0*Math.PI/360.0));
            RESULTADO.setText(String.valueOf(angulo));
        }
        if (funcion.getCheckedRadioButtonId()==R.id.rdBCOS){
            angulo = (Math.cos(Double.parseDouble(gra)*Math.PI/180.0));
            RESULTADO.setText(String.valueOf(angulo));
        }
        if (funcion.getCheckedRadioButtonId()==R.id.rdBTAN){
            angulo = (Math.tan(Double.parseDouble(gra)*2.0*Math.PI/360.0));
            RESULTADO.setText(String.valueOf(angulo));
        }
    }
}