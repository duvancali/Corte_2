package com.example.duvan.corteii;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Segunda extends AppCompatActivity {

    private Button btnregistrar;
    private Button btnlogin;
    private EditText nombre;
    private EditText tvemail;
    private EditText tvpassword;
    private FirebaseAuth auth=FirebaseAuth.getInstance();
    private FirebaseAuth.AuthStateListener listener;
    private ProgressDialog pbprogreso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        tvemail = (EditText) findViewById(R.id.remail);
        tvpassword = (EditText) findViewById(R.id.rpassword);
        nombre = (EditText) findViewById(R.id.rnombre);
        btnregistrar = (Button) findViewById(R.id.rregistro);
        //btnlogin = (Button) findViewById(R.id.rlogin);

        pbprogreso = new ProgressDialog(this);
        pbprogreso.setIndeterminate(true);

        btnregistrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                registrar();
            }
        });


//        listener = (FirebaseAuth.AuthStateListener) (FirebaseAuth)
//                FirebaseUser FirebaseUser user = mAuth.getCurrentUser();
//        if (user != null) {
//            abrirfecha();
//        }
    }

//    private void abrilogin() {
//    }
//
//    Intent i = new Intent(this, Registro.class);
//
//    starActivity(i);
//
//    finish();
//
//    ;


    //
    private void registrar() {

        final String email = tvemail.getText().toString();
        final String password = tvpassword.getText().toString();
        auth.createUserWithEmailAndPassword("j@hotmail.com","1234567890").addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                            Intent intent = new Intent(Segunda.this, Registro.class);
                            startActivity(intent);


                            Toast.makeText(Segunda.this, "Correcto",
                                    Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(Segunda.this, "Incorrecto",
                                    Toast.LENGTH_SHORT).show();
                        }
            }
        });
//        Auth.createUserWithEmailAndPassword("Jach@gmail.com", "1234567890")
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            Intent intent = new Intent(Segunda.this, Registro.class);
//                            startActivity(intent);
//
//
//                            Toast.makeText(Segunda.this, "Correcto",
//                                    Toast.LENGTH_SHORT).show();
//                        }
//                        else{
//                            Toast.makeText(Segunda.this, "Incorrecto",
//                                    Toast.LENGTH_SHORT).show();
//                        }
//
//                    }
//                });
    }
}

//private void abrirMicuenta(){
//
//        Inten i=new Intent(this,fecha.class);
//        starActivity(i);
//        finish();
//        }
//
//
//@Override
//protected void onStart(){
//        super.onStart();
//        mAuth.addAuthStateListener(Listener);
//        }
//
//@Override
//protected void onStop(){
//        super.onStop();
//        mAuth.addAuthStateListener(Listener);
//
//        }
//        }
