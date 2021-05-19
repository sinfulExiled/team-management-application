package com.application.qatarmotorsports;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class AdminPassword extends AppCompatActivity {

    Button nextbtn;
    String adminnameget,adminPasswordget;
    TextInputEditText adminnameTv,adminpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passwordvalidate);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(this.getResources().getColor(R.color.colorPrimary));
        }

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);




        adminnameTv = (TextInputEditText) findViewById(R.id.adminNameTiv);
        adminpass = findViewById(R.id.passwordTV);



        nextbtn = findViewById(R.id.btnNextadmin);
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                adminnameget = adminnameTv.getText().toString();
                adminPasswordget = adminpass.getText().toString();



               if(adminnameget.equals("admin") && adminPasswordget.equals("qmmfadmin")){
                    Toast toast3 = Toast.makeText(getApplicationContext(), "Registrations Baja", Toast.LENGTH_SHORT);
                    toast3.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast3.show();
                    Intent intent6 = new Intent(AdminPassword.this, AdminBajaRegistrationsView.class);


                    AdminPassword.this.startActivity(intent6);

              }else{
                   if(!adminnameget.equals("admin")&& adminPasswordget.equals("qmmfadmin")){
                       Toast toast3 = Toast.makeText(getApplicationContext(), "Incorrect Admin Name", Toast.LENGTH_SHORT);
                       toast3.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                       toast3.show();
                   }

                   if(adminnameget.equals("admin")&& !adminPasswordget.equals("qmmfadmin")) {
                       Toast toast3 = Toast.makeText(getApplicationContext(), "Incorrect Password", Toast.LENGTH_SHORT);
                       toast3.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                       toast3.show();
                   }

                   if(!adminnameget.equals("admin") && !adminPasswordget.equals("qmmfadmin")){
                       Toast toast3 = Toast.makeText(getApplicationContext(), "This forum is admin access only", Toast.LENGTH_SHORT);
                       toast3.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                       toast3.show();


                   }


               }

            }
        });

    }

}
