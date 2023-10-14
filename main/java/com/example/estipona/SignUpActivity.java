package com.example.estipona;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.EditText;
import com.example.estipona.MainActivity;


import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class SignUpActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private EditText emailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        emailEditText = findViewById(R.id.email);

        MaterialButton signUpButton = findViewById(R.id.signup_button);
        MaterialButton backButton = findViewById(R.id.gotologin);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String email = emailEditText.getText().toString();

                if (isValidSignup(username, password, email)) {
                    Toast.makeText(SignUpActivity.this, "Sign up successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SignUpActivity.this, "Sign up failed. Please check your inputs.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set up an OnClickListener for the "BACK TO LOGIN" button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to the login page (MainActivity)
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean isValidSignup(String username, String password, String email) {
        // Add your signup validation logic here
        // For now, this example just checks if the fields are not empty
        return !username.isEmpty() && !password.isEmpty() && !email.isEmpty();
    }
}
