package com.example.hotels;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login_and_main extends AppCompatActivity {

    private TextView forgotpw;
    private EditText email;
    private EditText Password;
    private Button login;
    private Button register;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        register=(Button) findViewById(R.id.register);

        email=(EditText) findViewById(R.id.email);
        Password=(EditText)findViewById(R.id.password);


        login=(Button)findViewById(R.id.log_in);


        forgotpw=(TextView) findViewById(R.id.forgotpw);

    }



    public void onClick(View view) {
        switch (view.getId()){
            case R.id.register:

                startActivity(new Intent(this,login_and_main.class));break;

            case R.id.log_in:

                userlogin();
                break;

            case R.id.forgotpw:
                startActivity(new Intent(this,login_and_main.class));break;
        }

    }

    private void userlogin() {
        String Email=email.getText().toString().trim();
        String password=Password.getText().toString().trim();

        if(Email.isEmpty()){
            email.setError("Please enter email");
            email.requestFocus();
            return;
        }
        if(password.isEmpty()) {
            Password.setError("Please enter password");
            Password.requestFocus();
            return;

        }
        mAuth.signInWithEmailAndPassword(Email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(login_and_main.this,Booking.class));
                }
                else{
                    Toast.makeText(login_and_main.this, "Please Enter Valid Details", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}