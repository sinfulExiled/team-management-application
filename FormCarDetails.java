package com.application.qatarmotorsports;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.application.qatarmotorsports.FormThreeBajaActivity.driver1obj2;
import static com.application.qatarmotorsports.FormTwoBajaActivity.driver1obj;
import static com.application.qatarmotorsports.ForumOneActivity.entrantobj;

public class FormCarDetails extends AppCompatActivity {

    TextInputEditText car;

    public  static NewCarObj CarObj;
    public   ArrayList<Object> addNewCar;



    private Uri urisignatureentrantss,urilicenced1,uriidd1,urisignatured1,urilicenced2,uriidd2,urisignatured2;

    private StorageReference mStorageRef;


    String CarMake,RegistrationNumber,Model,CubicCapacity,YearofManufac,ChassisNumber,GrouporClass,EngineNumber,HomologationNumber,PredominantColor,CountryofReg,TechPassportNumber,PayedforIndividualRound;


    CheckBox IndivisualRoundChecked;

    TextInputEditText CarMakeTI,RegistrationNumberTI,ModelTI,CubicCapacityTI,YearofManufacTI,ChassisNumberTI,GrouporClassTI,EngineNumberTI,HomologationNumberTI,PredominantColorTI,CountryofRegTI,TechPassportNumberTI;


    private CollectionReference Forumref = FirebaseFirestore.getInstance().collection("BajaRegistrations");
    Button finishbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_car_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(this.getResources().getColor(R.color.colorPrimary));
        }

        toolbar.setTitle("National Baja");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


        CarMakeTI = findViewById(R.id.MakeCar);
        RegistrationNumberTI = findViewById(R.id.registrationNoCar);
        ModelTI = findViewById(R.id.ModelCar);
        CubicCapacityTI = findViewById(R.id.cubicCapacityCar);
        YearofManufacTI = findViewById(R.id.yearofmanufactureCar);
        ChassisNumberTI =  findViewById(R.id.chassisNoCar);
        GrouporClassTI = findViewById(R.id.grouporclassCar);
        EngineNumberTI = findViewById(R.id.engineNoCar);
        HomologationNumberTI = findViewById(R.id.homologationCar);
        PredominantColorTI = findViewById(R.id.predominantcolorCar);
        CountryofRegTI = findViewById(R.id.countryofregCar);
        TechPassportNumberTI = findViewById(R.id.techpassCar);
        IndivisualRoundChecked = findViewById(R.id.individualRound);


        mStorageRef = FirebaseStorage.getInstance().getReference("uploads");

        finishbtn = findViewById(R.id.finishBtnCar);
        finishbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){



                if(IndivisualRoundChecked.isChecked()){
                    PayedforIndividualRound = "Payed for "+IndivisualRoundChecked.getText().toString();

                }

                addNewCar = new ArrayList<>();
                CarMake = CarMakeTI.getText().toString();
                RegistrationNumber = RegistrationNumberTI.getText().toString();
                Model = ModelTI.getText().toString();
                CubicCapacity = CubicCapacityTI.getText().toString();
                YearofManufac = YearofManufacTI.getText().toString();
                ChassisNumber = ChassisNumberTI.getText().toString();
                GrouporClass = GrouporClassTI.getText().toString();
                EngineNumber = EngineNumberTI.getText().toString();
                HomologationNumber = HomologationNumberTI.getText().toString();
                PredominantColor = PredominantColorTI.getText().toString();
                CountryofReg = CountryofRegTI.getText().toString();
                TechPassportNumber = TechPassportNumberTI.getText().toString();


                if ((CarMake.length()!=0) && (RegistrationNumber.length()!=0) && (Model.length()!=0) && (CubicCapacity.length()!=0)&& (YearofManufac.length()!=0) && (ChassisNumber.length()!=0)
                        && (GrouporClass.length()!=0) && (EngineNumber.length()!=0)&& (HomologationNumber.length()!=0) && (PredominantColor.length()!=0) && (CountryofReg.length()!=0) && (TechPassportNumber.length()!=0)){


                    NewCarObj carconstructor = new NewCarObj(CarMake,RegistrationNumber,Model,CubicCapacity,YearofManufac,ChassisNumber,
                            GrouporClass,EngineNumber,HomologationNumber,PredominantColor,CountryofReg,TechPassportNumber,PayedforIndividualRound);

                    addNewCar.add(carconstructor);

                    AllDataFromObjects allDataFromObjects = new AllDataFromObjects(entrantobj.getTeamName(), entrantobj.getFirstName(),
                            entrantobj.getFamilyName(),entrantobj.getDateofBirth(), entrantobj.getNationality(), entrantobj.getGender(),
                            entrantobj.getPassportNumber(),entrantobj.getIssuingDate(), entrantobj.getExiryDate(), entrantobj.getPostalAddress(),
                            entrantobj.getFiaLicence(), entrantobj.getIssuingASNNumber(),entrantobj.getMobileTelephoneNumber(),
                            entrantobj.getEmailAddress(), entrantobj.getNextofKin(), entrantobj.getRelationship(),entrantobj.getTelNumber(),
                            entrantobj.getSignatureImage(), driver1obj.getTeamName(), driver1obj.getFirstName(), driver1obj.getFamilyName(),
                            driver1obj.getDateofBirth(), driver1obj.getNationality(), driver1obj.getGender(), driver1obj.getPassportNumber(),
                            driver1obj.getIssuingDate(),driver1obj.getExiryDate(), driver1obj.getPostalAddress(), driver1obj.getFiaLicence(),
                            driver1obj.getIssuingASNNumber(), driver1obj.getMobileTelephoneNumber(), driver1obj.getEmailAddress(),
                            driver1obj.getNextofKin(), driver1obj.getRelationship(),driver1obj.getTelNumber(), driver1obj.getSignatureImage(),
                            driver1obj.getLicence(), driver1obj.getID(), driver1obj.getTeamName(), driver1obj2.getFirstName(), driver1obj2.getFamilyName(),
                            driver1obj2.getDateofBirth(), driver1obj2.getNationality(), driver1obj2.getGender(), driver1obj2.getPassportNumber(),
                            driver1obj2.getIssuingDate(),driver1obj2.getExiryDate(), driver1obj2.getPostalAddress(), driver1obj2.getFiaLicence(),
                            driver1obj2.getIssuingASNNumber(), driver1obj2.getMobileTelephoneNumber(), driver1obj2.getEmailAddress(),
                            driver1obj2.getNextofKin(), driver1obj2.getRelationship(),driver1obj2.getTelNumber(), driver1obj2.getSignatureImage(),
                            driver1obj2.getLicence(), driver1obj2.getID(),carconstructor.getCarMake(), carconstructor.getRegistrationNumber(), carconstructor.Model, carconstructor.getCubicCapacity(),
                            carconstructor.getYearofManufac(), carconstructor.getChassisNumber(), carconstructor.getGrouporClass(), carconstructor.getEngineNumber(), carconstructor.getHomologationNumber(),
                            carconstructor.getPredominantColor(), carconstructor.getCountryofReg(), carconstructor.getTechPassportNumber(),carconstructor.getPayedforIndividualRound(),MainActivity.user);



                /*Map<String, Object> dataToSave = new HashMap<String, Object>();
                dataToSave.put("Entrant: " +ForumOneActivity.TeamName,entrantobj);
                dataToSave.put("Driver1: " +FormTwoBajaActivity.FirstName,driver1obj);
                dataToSave.put("Driver2: " +FormThreeBajaActivity.TeamName,driver1obj2);
                dataToSave.put("CarDetails: " +CarMake,carconstructor);
                Forumref.add(dataToSave);*/

                    Forumref.add(allDataFromObjects);





                    uploadFile(urisignatureentrantss.fromFile(new File(entrantobj.getSignatureImage())));



                    uploadFile(urisignatured1.fromFile(new File(driver1obj.getSignatureImage())));
                    uploadFile(urilicenced1.fromFile(new File(driver1obj.getLicence())));
                    uploadFile(uriidd1.fromFile(new File(driver1obj.getID())));



                    uploadFile(urisignatured2.fromFile(new File(driver1obj2.getSignatureImage())));
                    uploadFile(urilicenced2.fromFile(new File(driver1obj2.getLicence())));
                    uploadFile(uriidd2.fromFile(new File(driver1obj2.getID())));



                    Toast toast3 = Toast.makeText(getApplicationContext(), "Applicant Successfully added", Toast.LENGTH_SHORT);
                    toast3.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast3.show();

                    Intent intent6 = new Intent(FormCarDetails.this, ForumOneActivity.class);
                    intent6.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    FormCarDetails.this.startActivity(intent6);

                    finish();



                }else{
                    Toast toast6 = Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT);
                    toast6.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast6.show();

                }




            }
        });

    }
    private void uploadFile(Uri mImageUri) {

        StorageReference fileReference = mStorageRef.child(mImageUri.getLastPathSegment());

        fileReference.putFile(mImageUri);
    }

}
