package vn.edu.usth.twitterclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;

public class LoginActivity extends AppCompatActivity {
    private EditText edtUserName, edtLoginPassword;
    private Button buSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        edtUserName = findViewById(R.id.edtUsername);
        edtLoginPassword = findViewById(R.id.edtLoginPassword);
        buSignIn = findViewById(R.id.buSignIn);
        buSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Parse.logInInBackground(edtUserName.getText()+"",edtLoginPassword.getText()+"", new LogInCallBack {
                    @Override
                        public void done(ParseUser user, ParseException e) {
                            if(user!=null && e==null) {
                                Toast.makeText(LoginActivity.this, "Logged In", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                    }
                });
            }
        });
    }
}