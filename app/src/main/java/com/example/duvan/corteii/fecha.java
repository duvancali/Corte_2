package com.example.duvan.corteii;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import java.util.Calendar;

import static com.example.duvan.corteii.R.layout.activity_fecha;

public class fecha extends AppCompatActivity implements View.OnClickListener{

    Button aceptar3;
    EditText editTextN;
    EditText editTextN1;


    private int año;
    private int mes;
    private int dia;
    private EditText campoFecha;
    private Button Fecha;
    private static final int TIPO_DIALOGO = 0;
    private static DatePickerDialog.OnDateSetListener oyenteSelectorFecha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_fecha);
        aceptar3 = (Button) findViewById(R.id.aceptar3);
        editTextN = (EditText)findViewById(R.id.txtUsu);
        editTextN1 = (EditText)findViewById(R.id.campofecha);
        aceptar3.setOnClickListener(this);


        campoFecha =(EditText) findViewById(R.id.campofecha);
         Fecha =(Button) findViewById(R.id.fecha);
         Calendar calendario= Calendar.getInstance();
         dia =calendario.get(Calendar.DAY_OF_MONTH);
         mes =calendario.get(Calendar.MONTH);
         año =calendario.get(Calendar.YEAR);
        mostrarFecha();
        oyenteSelectorFecha=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int dayOfMonth, int monthOfyear, int year ) {

                dia=dayOfMonth;
                mes=monthOfyear;
                año=year;
                mostrarFecha();

            }
        };
    }

    @Override
    protected Dialog onCreateDialog(int id) {
       switch (id) {
           case 0:
               return new DatePickerDialog(this, oyenteSelectorFecha, dia, mes, año);


       }
       return null;

       }
    public void mostrarCalendario(View control){
        showDialog(TIPO_DIALOGO);
    }

    public void mostrarFecha(){
        campoFecha.setText(dia+"/"+(mes+1)+"/"+año);    }


    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.aceptar3:
                String DatoN = editTextN.getText().toString();
                String DatoC = editTextN1.getText().toString();
                Intent intent = new Intent(fecha.this ,datos.class);
                intent.putExtra("DatoUsu", DatoN);
                intent.putExtra("campofecha", DatoC);
                startActivity(intent);
                break;
        }



    }


    }




