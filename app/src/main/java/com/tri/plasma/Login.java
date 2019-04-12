package com.tri.plasma;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Login extends AppCompatActivity {

    private EditText email_login,pass;
    private Button login,register;
    private FirebaseAuth mAuth;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth=FirebaseAuth.getInstance();
        email_login=(EditText)findViewById(R.id.login_email);
        pass=(EditText)findViewById(R.id.login_pass);
        login=(Button)findViewById(R.id.login_login);
        register=(Button)findViewById(R.id.login_register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userLogin();

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void userLogin()
    {
       // final String name = editTextName.getText().toString().trim();
        final String email = email_login.getText().toString().trim();
        String password = pass.getText().toString().trim();
       // final String phone = editTextPhone.getText().toString().trim();



        if (email.isEmpty()) {
            email_login.setError(getString(R.string.input_error_email));
            email_login.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            email_login.setError(getString(R.string.input_error_email_invalid));
            email_login.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            pass.setError(getString(R.string.input_error_password));
            pass.requestFocus();
            return;
        }

        if (password.length() < 6) {
            pass.setError(getString(R.string.input_error_password_length));
            pass.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {
                    Intent intent=new Intent(getApplicationContext(),Home.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Login Unsuccessful",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
