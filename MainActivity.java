package com.application.qatarmotorsports;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;

import com.application.qatarmotorsports.ui.home.HomeFragment;
import com.application.qatarmotorsports.ui.home.HomeViewModel;
import com.application.qatarmotorsports.ui.slideshow.SlideshowFragment;
import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.text.Layout;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    ImageView imageView;
    TextView username,useremail;

    public static String user;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        /* navigationView.bringToFront(); */



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {

                    case R.id.nav_home:
                        Toast toast = Toast.makeText(getApplicationContext(), "Home Is Selected", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                        toast.show();

                        break;

                    case R.id.nav_gallery:
                        Toast toast2 = Toast.makeText(getApplicationContext(), "National Baja Form", Toast.LENGTH_SHORT);
                        toast2.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                        toast2.show();

                        Intent intent1 = new Intent(MainActivity.this, ForumOneActivity.class);
                        MainActivity.this.startActivity(intent1);
                        break;

                    case R.id.nav_slideshow:
                        Toast toast3 = Toast.makeText(getApplicationContext(), "SlidShow Is Selected", Toast.LENGTH_SHORT);
                        toast3.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                        toast3.show();
                        break;
                    case R.id.nav_admin:
                        Toast toast4 = Toast.makeText(getApplicationContext(), "Admin Is Selected", Toast.LENGTH_SHORT);
                        toast4.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                        toast4.show();

                        Intent intent6 = new Intent(MainActivity.this, AdminPassword.class);
                        MainActivity.this.startActivity(intent6);

                        break;



                }

                drawer.closeDrawers();
                return false;
            }
        });


        View navView = navigationView.getHeaderView(0);
        //reference to views


        Button bajab = findViewById(R.id.buttonBaja);
         bajab.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View v) {
                 Toast toast3 = Toast.makeText(getApplicationContext(), "National Baja Form", Toast.LENGTH_SHORT);
                 toast3.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                 toast3.show();
                 Intent intent6 = new Intent(MainActivity.this, ForumOneActivity.class);
                 MainActivity.this.startActivity(intent6);
             }
         });





        username = (TextView)navView.findViewById(R.id.tName);
        useremail = (TextView)navView.findViewById(R.id.tEmail);
         imageView = (ImageView) navView.findViewById(R.id.imageViewNav);
        //TextView username = findViewById(R.id.tName);
        //TextView useremail = findViewById(R.id.tEmail);




        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            String personName = acct.getDisplayName();
            String personEmail = acct.getEmail();
            String personId = acct.getId();
            Uri personPhoto = acct.getPhotoUrl();




            username.setText(personName);
            useremail.setText(personEmail);

            user = personName;

           // Glide.with(getApplicationContext()).load(personPhoto).into(imageViewn);
           Glide.with(this).load(String.valueOf(personPhoto)).into(imageView);
            //Glide.with(this).load("http://goo.gl/gEgYUd").into(imageView);

           // navigationView.setNavigationItemSelectedListener(this);

        }



        Button signout = (Button) navView.findViewById(R.id.signoutButton);
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    // ...
                    case R.id.signoutButton:
                        signOut();
                        break;
                    // ...
                }


            }
        });




    }
    private void signOut() {

        auth.getInstance().signOut();
        finish();


        Intent finishlogout = new Intent(this,StartScreenActivity.class);
        startActivity(finishlogout);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
