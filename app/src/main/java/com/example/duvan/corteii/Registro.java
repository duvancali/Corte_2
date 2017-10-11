package com.example.duvan.corteii;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Registro extends AppCompatActivity implements View.OnClickListener {

    EditText tvEmail;
    EditText tvPassword;
    Button btningresar;
    Button btnregistrarM;
    private LoginButton loginButton;
    private CallbackManager callbackManager;
    FirebaseAuth mAuth= FirebaseAuth.getInstance();
    FirebaseAuth.AuthStateListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        tvEmail = (EditText) findViewById(R.id.Email);
        tvPassword = (EditText) findViewById(R.id.password);
        btningresar = (Button) findViewById(R.id.login);
        btnregistrarM = (Button) findViewById(R.id.registrarseM);
        final FirebaseAuth mAuth;


        mAuth = FirebaseAuth.getInstance();
        listener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = mAuth.getCurrentUser();
                if (user == null) {
                    //No esta logeado
                } else {
                    //esta logeado
                    Toast.makeText(getApplicationContext(), "correcto y logeado", Toast.LENGTH_LONG).show();
                }

            }
        };
        btningresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ingresar();
            }
        });


        //facebook


        callbackManager = CallbackManager.Factory.create();
        loginButton = (LoginButton) findViewById(R.id.login_button);


        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {


            @Override
            public void onSuccess(LoginResult loginResult) {

            }


            @Override
            public void onCancel() {

            }

            /**
             * Called when the dialog finishes with an error.
             *
             * @param error The error that occurred
             */
            @Override
            public void onError(FacebookException error) {

            }

        });


    }

    private void ingresar() {

        String Email = tvEmail.getText().toString();
        String password = tvPassword.getText().toString();
        mAuth.signInWithEmailAndPassword(Email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Intent intent = new Intent(Registro.this, Segunda.class);
                        startActivity(intent);


                            Toast.makeText(Registro.this, "Correcto",
                                    Toast.LENGTH_SHORT).show();



                    }
                });
    }

    @Override
    public void onClick(View v) {
        {


        }
    }


}



