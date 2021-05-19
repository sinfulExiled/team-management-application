 package com.application.qatarmotorsports;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FormThreeBajaActivity extends AppCompatActivity {

    Button nextbtn,attachLicencebtn,attachID,sigenatureBtn;
    TextInputEditText car;
    ImageView attachedviewLicenceDriver1,attachedIDDriver1;
    Bitmap licenceImagesave;


    String currentPhotoPath;

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_IMAGE_CAPTURE2 = 2;
    static final int REQUEST_IMAGE_CAPTURE3 = 3;
    private static final String IMAGE_DIRECTORY2 = "/signdemo";
    private DatePickerDialog.OnDateSetListener mDatesetListener;
    private DatePickerDialog.OnDateSetListener mDatesetListener2;
    private DatePickerDialog.OnDateSetListener mDatesetListener3;

    public  static BajaDataObjectforDrivers driver1obj2;
    public static List<BajaDataObjectforDrivers> addNewDriver2;


    ImageView signimagesave,idsave,licencesave;

    public static String TeamName;
    String FirstName,FamilyName,DateofBirth,Nationality,Gender,PassportNumber,IssuingDate,ExiryDate,PostalAddress,
            FiaLicence,IssuingASNNumber,MobileTelephoneNumber,EmailAddress,NextofKin,Relationship,TelNumber,picturePathLicence,picturePathID;


    TextInputEditText TeamNametv,FirstNametv,FamilyNametv,DateofBirthtv,Nationalitytv,Gendertv,PassportNumbertv,IssuingDatetv,ExiryDatetv,PostalAddresstv,
            FiaLicencetv,IssuingASNNumbertv,MobileTelephoneNumbertv,EmailAddresstv,NextofKintv,Relationshiptv,TelNumbertv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_three_baja);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(this.getResources().getColor(R.color.colorPrimary));
        }


        toolbar.setTitle("National Baja");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


        signimagesave = (ImageView) findViewById(R.id.imagesignatureDriver2);
        TeamNametv = findViewById(R.id.teamNameDriver2);
        FirstNametv = findViewById(R.id.firstNameDriver2);
        FamilyNametv = findViewById(R.id.familyNameDriver2);
        DateofBirthtv = findViewById(R.id.dateofBirthDriver2);
        Nationalitytv = findViewById(R.id.nationalityDriver2);
        Gendertv =  findViewById(R.id.genderDriver2);
        PassportNumbertv = findViewById(R.id.passportDriver2);
        IssuingDatetv = findViewById(R.id.issuingdateDriver2);
        ExiryDatetv = findViewById(R.id.ExpiryDriver2);
        PostalAddresstv = findViewById(R.id.postalDriver2);
        FiaLicencetv = findViewById(R.id.fianumberDriver2);
        IssuingASNNumbertv = findViewById(R.id.issuingasnDriver2);
        MobileTelephoneNumbertv = findViewById(R.id.mobilenumberDriver2);
        EmailAddresstv = findViewById(R.id.emailaddreesDriver2);
        NextofKintv = findViewById(R.id.nextofkinDriver2);
        Relationshiptv = findViewById(R.id.relationshipDriver2);
        TelNumbertv = findViewById(R.id.telnumberDriver2);



        /*Intent intent = getIntent();

        String nameofEntrant = intent.getStringExtra(ForumOneActivity.ExtraText);
        car.setText(nameofEntrant);*/
        sigenatureBtn = findViewById(R.id.signatureDriver2);
        attachedviewLicenceDriver1 = findViewById(R.id.attachedviewLicenceDriver2);
        attachedIDDriver1 = findViewById(R.id.attachviewIDDriver2);
        attachLicencebtn = findViewById(R.id.attachLicenceDriver2);
        attachID = findViewById(R.id.attachIDDriver2);


        DateofBirthtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(FormThreeBajaActivity.this,android.R.style.Theme_Holo_Dialog_MinWidth,
                        mDatesetListener,
                        year,month,day);
                dialog.updateDate(1990,01,01);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDatesetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                DateofBirth = dayOfMonth+"/"+month+"/"+year;
                DateofBirthtv.setText(DateofBirth);
            }
        };

        IssuingDatetv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(FormThreeBajaActivity.this,android.R.style.Theme_Holo_Dialog_MinWidth,
                        mDatesetListener2,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDatesetListener2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                IssuingDate = dayOfMonth+"/"+month+"/"+year;
                IssuingDatetv.setText(IssuingDate);
            }
        };

        ExiryDatetv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(FormThreeBajaActivity.this,android.R.style.Theme_Holo_Dialog_MinWidth,
                        mDatesetListener3,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDatesetListener3 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                ExiryDate = dayOfMonth+"/"+month+"/"+year;
                ExiryDatetv.setText(ExiryDate);
            }
        };


        sigenatureBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                Toast toast3 = Toast.makeText(getApplicationContext(), "Enter Driver2 Signature", Toast.LENGTH_SHORT);
                toast3.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                toast3.show();

                Intent intent6 = new Intent(FormThreeBajaActivity.this, TakeSignature.class);

                startActivityForResult(intent6,3);

            }
        });
        attachLicencebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, 1);

            }
        });

        attachID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, 2);

            }
        });



        nextbtn = findViewById(R.id.nextbtnDriver2);

        nextbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){

                addNewDriver2 = new ArrayList<>();
                TeamName = TeamNametv.getText().toString();
                FirstName = FirstNametv.getText().toString();
                FamilyName = FamilyNametv.getText().toString();
                DateofBirth = DateofBirthtv.getText().toString();
                Nationality = Nationalitytv.getText().toString();
                Gender = Gendertv.getText().toString();
                PassportNumber = PassportNumbertv.getText().toString();
                IssuingDate = IssuingDatetv.getText().toString();
                ExiryDate = ExiryDatetv.getText().toString();
                PostalAddress = PostalAddresstv.getText().toString();
                FiaLicence = FiaLicencetv.getText().toString();
                IssuingASNNumber = IssuingASNNumbertv.getText().toString();
                MobileTelephoneNumber = MobileTelephoneNumbertv.getText().toString();
                EmailAddress = EmailAddresstv.getText().toString();
                NextofKin = NextofKintv.getText().toString();
                Relationship = Relationshiptv.getText().toString();
                TelNumber = TelNumbertv.getText().toString();
                String getUriofSignature = TakeSignature.signatureEntrantpass;





                if ((TeamName.length()!=0) && (FirstName.length()!=0) && (FamilyName.length()!=0) && (DateofBirth.length()!=0) && (Nationality.length()!=0) && (Gender.length()!=0)
                        && (PassportNumber.length()!=0) && (IssuingDate.length()!=0) && (ExiryDate.length()!=0) && (PostalAddress.length()!=0) && (FiaLicence.length()!=0) && (IssuingASNNumber.length()!=0)
                        && (MobileTelephoneNumber.length()!=0) && (EmailAddress.length()!=0) && (NextofKin.length()!=0) && (Relationship.length()!=0) && (TelNumber.length()!=0) ){

                    driver1obj2 = new BajaDataObjectforDrivers(TeamName,FirstName,FamilyName,DateofBirth,Nationality,Gender,PassportNumber,IssuingDate,ExiryDate,PostalAddress,
                            FiaLicence,IssuingASNNumber,MobileTelephoneNumber,EmailAddress,NextofKin,Relationship,TelNumber,getUriofSignature,picturePathLicence,picturePathID);

                    addNewDriver2.add(driver1obj2);

                    Toast toast3 = Toast.makeText(getApplicationContext(), "Enter Car details", Toast.LENGTH_SHORT);
                    toast3.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast3.show();
                    Intent intent6 = new Intent(FormThreeBajaActivity.this, FormCarDetails.class);
                    FormThreeBajaActivity.this.startActivity(intent6);




                }else{
                    Toast toast6 = Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT);
                    toast6.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast6.show();

                }



            }
        });


    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {





            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(selectedImage,filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            picturePathLicence = cursor.getString(columnIndex);
            cursor.close();



            attachedviewLicenceDriver1.setVisibility(View.VISIBLE);
            attachedviewLicenceDriver1.setImageBitmap(BitmapFactory.decodeFile(picturePathLicence));
            Toast toast3 = Toast.makeText(getApplicationContext(), "licence added for driver 2", Toast.LENGTH_SHORT);
            toast3.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast3.show();

        }
        if (requestCode == 2 && resultCode == RESULT_OK) {





            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(selectedImage,filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            picturePathID = cursor.getString(columnIndex);
            cursor.close();



            attachedIDDriver1.setVisibility(View.VISIBLE);
            attachedIDDriver1.setImageBitmap(BitmapFactory.decodeFile(picturePathID));
            Toast toast3 = Toast.makeText(getApplicationContext(), "ID added for driver 1", Toast.LENGTH_SHORT);
            toast3.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
            toast3.show();



        }
        if (requestCode == 3 && resultCode == RESULT_OK) {



            Bitmap myBitmap = BitmapFactory.decodeFile(TakeSignature.signatureEntrantpass);

            ImageView myImage = (ImageView) findViewById(R.id.imagesignatureDriver2);
            myImage.setVisibility(View.VISIBLE);

            myImage.setImageBitmap(myBitmap);

        }
    }


    public String saveImage(Bitmap myBitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        myBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File wallpaperDirectory = new File(
                Environment.getExternalStorageDirectory() + IMAGE_DIRECTORY2 /*iDyme folder*/);
        // have the object build the directory structure, if needed.
        if (!wallpaperDirectory.exists()) {

            wallpaperDirectory.mkdirs();
            Log.d("hhhhh",wallpaperDirectory.toString());
        }

        try {
            File f = new File(wallpaperDirectory, Calendar.getInstance()
                    .getTimeInMillis() + ".jpg");
            f.createNewFile();
            FileOutputStream fo = new FileOutputStream(f);
            fo.write(bytes.toByteArray());
            MediaScannerConnection.scanFile(FormThreeBajaActivity.this,
                    new String[]{f.getPath()},
                    new String[]{"image/jpeg"}, null);

            fo.close();

            Log.d("TAG", "File Saved::--->" + f.getAbsolutePath());



            return f.getAbsolutePath();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return "";

    }
}


