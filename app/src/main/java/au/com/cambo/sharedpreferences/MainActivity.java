package au.com.cambo.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText inUsername, inPassword;
    TextView txtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inUsername = (EditText)findViewById(R.id.inUsername);
        inPassword = (EditText)findViewById(R.id.inPassword);
        txtInfo = (TextView)findViewById(R.id.txtInfo);
    }

    public void saveInfo(View view)
    {
        SharedPreferences sharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", inUsername.getText().toString());
        editor.putString("password", inPassword.getText().toString());
        editor.apply();

        Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show();
    }

    public void displayInfo(View view)
    {
        SharedPreferences sharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        String name = sharedPreferences.getString("username", "");
        String pw = sharedPreferences.getString("password", "");
        txtInfo.setText(name + ", " + pw);
    }
}


























