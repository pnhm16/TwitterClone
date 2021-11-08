package vn.edu.usth.twitterclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;

public class SignUpActivity extends AppCompatActivity {
    private Button buSignUpAct;
    private EditText edtSignUpEmail, edtSignUpUserName, edtSignUpPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        buSignUpAct = findViewById(R.id.buSignUpAct);
        edtSignUpEmail = findViewById(R.id.edtSignUpEmail);
        edtSignUpUserName = findViewById(R.id.edtSignUpUsername);
        edtSignUpPassword = findViewById(R.id.edtSignUpPassword);
        buSignUpAct.setOnClickListener(new View v) {
            ParseUser appUser = new ParseUser();
            appUser.setEmail(edtSignUpEmail.getText()+"");
            appUser.setUserName(edtSignUpUserName.getText()+"");
            appUser.setPassword(edtSignUpPassword.getText()+"");
            appUser.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e){
                    if (e==null) {
                        Toast.makeText(SignUpActivity.this, "Signed Up", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(SignUpActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            })
        };
    }
}