package com.example.latihanlogin;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidNetworking.initialize(getApplicationContext());
        setContentView(R.layout.activity_main);

        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);
        Button login = findViewById(R.id.login);
        TextView register = findViewById(R.id.register);

        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (username.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"please fill in the username first", Toast.LENGTH_SHORT).show();
                }else if (password.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill in the password first", Toast.LENGTH_SHORT).show();
                }else{
                    AndroidNetworking.post("http://192.168.6.194/database/db.php")
                            .addBodyParameter("username", username.getText().toString())
                            .addBodyParameter("password", password.getText().toString())
                            .setTag("test")
                            .setPriority(Priority.MEDIUM)
                            .build()
                            .getAsJSONObject(new JSONObjectRequestListener() {

                                @Override
                                public void onResponse(JSONObject response) {
                                    try {
                                        JSONObject hasil = response.getJSONObject("hasil");
                                        if (hasil.getBoolean("sukses")) {
                                            Intent  intent = new Intent(MainActivity.this,MainMenu.class);
                                            startActivity(intent);
                                            Toast.makeText(MainActivity.this, "succesful", Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(MainActivity.this, "username or password false", Toast.LENGTH_SHORT).show();
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                        Toast.makeText(MainActivity.this, "error " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                                @Override
                                public void onError(ANError anError) {
                                      Log.e("", "onError: " + anError.getErrorBody());
                                    Toast.makeText(MainActivity.this, "error" + anError.getErrorDetail(), Toast.LENGTH_SHORT).show();

                                }
                            });
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("are you sure you want exit ?");
        builder.setCancelable(true);
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.super.onBackPressed();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
