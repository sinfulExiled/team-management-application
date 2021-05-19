package com.application.qatarmotorsports;

import android.app.DatePickerDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Handler;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForumOneActivity extends AppCompatActivity {


    public static final String ExtraText = "com.application.qatarmotorsports";

    public  static BajaDataObject entrantobj;
    public static  List<BajaDataObject> addNewEntrant;


    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;


    private Button mButtonChooseImage;
    private Button mButtonUpload;
    private TextView mTextViewShowUploads;
    private EditText mEditTextFileName;
    private ImageView mImageView;
    private ProgressBar mProgressBar;

    private Uri mImageUri;

    //private StorageReference mStorageRef;
    //private DatabaseReference mDatabaseRef;

    private StorageTask mUploadTask;

    //Uri mImageUri;
    Button sigenatureBtn,nextbtn;

    ImageView signimagesave;

    private static String TAG = "ForumOneActivity";
    private DatePickerDialog.OnDateSetListener mDatesetListener;
    private DatePickerDialog.OnDateSetListener mDatesetListener2;
    private DatePickerDialog.OnDateSetListener mDatesetListener3;

    public static String TeamName ;
    String FirstName,FamilyName,DateofBirth,Nationality,Gender,PassportNumber,IssuingDate,ExiryDate,PostalAddress,
            FiaLicence,IssuingASNNumber,MobileTelephoneNumber,EmailAddress,NextofKin,Relationship,TelNumber;


    TextInputEditText TeamNametv,FirstNametv,FamilyNametv,DateofBirthtv,Nationalitytv,Gendertv,PassportNumbertv,IssuingDatetv,ExiryDatetv,PostalAddresstv,
            FiaLicencetv,IssuingASNNumbertv,MobileTelephoneNumbertv,EmailAddresstv,NextofKintv,Relationshiptv,TelNumbertv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum_one);

        if(Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(this.getResources().getColor(R.color.colorPrimary));
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("National Baja");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


        signimagesave = (ImageView) findViewById(R.id.signatureadded);
        TeamNametv = findViewById(R.id.teamNameentrant);
        FirstNametv = findViewById(R.id.firstNameETEntrant);
        FamilyNametv = findViewById(R.id.familyNameEntrant);
        DateofBirthtv = findViewById(R.id.dateofBirthEntrant);
        Nationalitytv = findViewById(R.id.nationalityEntrant);
        Gendertv =  findViewById(R.id.genderEntrant);
        PassportNumbertv = findViewById(R.id.passportEntrant);
        IssuingDatetv = findViewById(R.id.issuingdateEntrant);
        ExiryDatetv = findViewById(R.id.ExpiryEntrant);
        PostalAddresstv = findViewById(R.id.postalEntrant);
        FiaLicencetv = findViewById(R.id.fianumberEntrant);
        IssuingASNNumbertv = findViewById(R.id.issuingasnEntrant);
        MobileTelephoneNumbertv = findViewById(R.id.mobilenumberEntrant);
        EmailAddresstv = findViewById(R.id.emailaddreesEntrant);
        NextofKintv = findViewById(R.id.nextofkinEntrant);
        Relationshiptv = findViewById(R.id.relationshipEntrant);
        TelNumbertv = findViewById(R.id.telnumberEntrant);

        sigenatureBtn = findViewById(R.id.signatureEntrant);
        nextbtn = findViewById(R.id.nextbtnEntrant);

        mStorageRef = FirebaseStorage.getInstance().getReference("uploads");
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("uploads");





        DateofBirthtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(ForumOneActivity.this,android.R.style.Theme_Holo_Dialog_MinWidth,
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

                DatePickerDialog dialog = new DatePickerDialog(ForumOneActivity.this,android.R.style.Theme_Holo_Dialog_MinWidth,
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

                DatePickerDialog dialog = new DatePickerDialog(ForumOneActivity.this,android.R.style.Theme_Holo_Dialog_MinWidth,
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
                ExiryDate = (dayOfMonth+"/"+month+"/"+year);
                ExiryDatetv.setText(ExiryDate);
            }
        };


        sigenatureBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                Toast toast3 = Toast.makeText(getApplicationContext(), "Enter Entrant Signature", Toast.LENGTH_SHORT);
                toast3.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                toast3.show();

                Intent intent6 = new Intent(ForumOneActivity.this, TakeSignature.class);

                startActivityForResult(intent6,1);

            }
        });

        nextbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){

                /*TextInputEditText firstnameET = (TextInputEditText) findViewById(R.id.firstNameETEntrant);
                String firname = firstnameET.getText().toString();*/

                addNewEntrant = new ArrayList<>();
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

              // callTeamName = TeamName;





               /* Toast toast3 = Toast.makeText(getApplicationContext(), "Enter 1st Driver Details", Toast.LENGTH_SHORT);
                toast3.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                toast3.show();*/

                if((TeamName.length()!=0) && (FirstName.length()!=0)  && (FamilyName.length()!=0)  && (DateofBirth.length()!=0)  && (Nationality.length()!=0)  && (Gender.length()!=0)
                        && (PassportNumber.length()!=0) && (IssuingDate.length()!=0) && (ExiryDate.length()!=0) && (PostalAddress.length()!=0) && (FiaLicence.length()!=0) && (IssuingASNNumber.length()!=0)
                        && (MobileTelephoneNumber.length()!=0) && (EmailAddress.length()!=0) && (NextofKin.length()!=0) && (Relationship.length()!=0) && (TelNumber.length()!=0)  ){



                    entrantobj = new BajaDataObject(TeamName,FirstName,FamilyName,DateofBirth,Nationality,Gender,PassportNumber,IssuingDate,ExiryDate,PostalAddress,
                            FiaLicence,IssuingASNNumber,MobileTelephoneNumber,EmailAddress,NextofKin,Relationship,TelNumber,getUriofSignature);



                    uploadFile(mImageUri.fromFile(new File(getUriofSignature)));
                    //mStorageRef.putFile(mImageUri.fromFile(new File(getUriofSignature)));


                    addNewEntrant.add(entrantobj);

                    Intent intent6 = new Intent(ForumOneActivity.this, FormTwoBajaActivity.class);

                    Toast toast6 = Toast.makeText(getApplicationContext(), "Enter 1st Driver Details", Toast.LENGTH_SHORT);
                    toast6.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast6.show();

                    ForumOneActivity.this.startActivity(intent6);

                }else{
                    Toast toast6 = Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT);
                    toast6.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast6.show();

                }


               /* Map<String, Object> dataToSave = new HashMap<String, Object>();
                dataToSave.put(TeamName,entrantobj);
                Forumref.add(dataToSave);*/




            }
        });


    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            if(resultCode == RESULT_OK){


                Bitmap myBitmap = BitmapFactory.decodeFile(TakeSignature.signatureEntrantpass);

                ImageView myImage = (ImageView) findViewById(R.id.signatureadded);
                myImage.setVisibility(View.VISIBLE);

                myImage.setImageBitmap(myBitmap);



            }

        }

    }

    private String getFileExtension(Uri uri){
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));

    }

    private void uploadFile(Uri mImageUri) {

            StorageReference fileReference = mStorageRef.child(mImageUri.getLastPathSegment());

            mUploadTask = fileReference.putFile(mImageUri);
    }

}
