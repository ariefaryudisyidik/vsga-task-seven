package id.vsga.ariefaryudisyidik.taskseven.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import id.vsga.ariefaryudisyidik.taskseven.R;
import id.vsga.ariefaryudisyidik.taskseven.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private String validUsername, validPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        userData();
        login();
    }

    private void userData() {
        validUsername = getString(R.string.valid_username);
        validPassword = getString(R.string.valid_password);
    }

    private void login() {
        binding.btnLogin.setOnClickListener(view -> {
            String username = Objects.requireNonNull(binding.edtUsername.getText()).toString().trim();
            String password = Objects.requireNonNull(binding.edtPassword.getText()).toString().trim();

            if (username.isEmpty()) {
                binding.tilUsername.setError(getString(R.string.empty_username));
            } else {
                binding.tilUsername.setErrorEnabled(false);
            }

            if (password.isEmpty()) {
                binding.tilPassword.setError(getString(R.string.empty_password));
            } else {
                binding.tilPassword.setErrorEnabled(false);
            }

            if (!username.isEmpty() && !password.isEmpty()) {
                if (username.equals(validUsername) && password.equals(validPassword)) {
                    startActivity(new Intent(this, MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(this, getString(R.string.wrong_username_password), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}