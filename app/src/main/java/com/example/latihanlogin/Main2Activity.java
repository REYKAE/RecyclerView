package com.example.latihanlogin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);
        final EditText confirmpassword = findViewById(R.id.confirmpassword);
        Button register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().isEmpty()) {
                    Toast.makeText(Main2Activity.this,"please fill in the username first", Toast.LENGTH_SHORT).show();
                } else if (password.getText().toString().isEmpty()) {
                    Toast.makeText(Main2Activity.this,"please fill in the password first",Toast.LENGTH_SHORT).show();
                } else if (!confirmpassword.getText().toString().equals(password.getText().toString())) {

                    Toast.makeText(Main2Activity.this, "password not same", Toast.LENGTH_SHORT).show();
                } else {
                    AndroidNetworking.post("http://192.168.6.194/database/insert.php")
                            .addBodyParameter("username", username.getText().toString())
                            .addBodyParameter("password", password.getText().toString())
                            .addBodyParameter("confirmpassword", confirmpassword.getText().toString())
                            .setTag("test")
                            .setPriority(Priority.MEDIUM)
                            .build()
                            .getAsJSONObject(new JSONObjectRequestListener() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    JSONObject hasil = null;
                                    try {
                                        hasil = response.getJSONObject("hasil");
                                        boolean respon = hasil.getBoolean("respon");
                                        if (respon) {
                                            Toast.makeText(getApplicationContext(), "Succesful Regisration", Toast.LENGTH_SHORT).show();
                                            finish();
                                        } else {
                                            Toast.makeText(getApplicationContext(), "Faillure", Toast.LENGTH_SHORT).show();
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    try {
                                        boolean respon = hasil.getBoolean("sukses");
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }

                                @Override
                                public void onError(ANError anError) {
                                    System.out.println("error " + anError.getErrorBody());
                                    System.out.println("error " + anError.getErrorDetail());
                                    System.out.println("error " + anError.getMessage());
                                    finish();
                                }

                            });
                }
            }
        });
    }
}
