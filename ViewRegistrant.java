package com.application.qatarmotorsports;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

import static android.net.Uri.fromFile;

public class ViewRegistrant extends AppCompatActivity {

    private StorageReference mStorageRef;

    TextView textViewEntrantTeamName,textViewFirstName,textViewFamilyName,textViewDateofBirth,textViewNationality,textViewGender,textViewPassportNumber,
            textViewIssuingDate,textViewExpiryDate,textViewPostalAddress,textViewFiaLicence,textViewIssuingASNNumber,textViewMobileTelephoneNumber,textViewEmailAddress,
            textViewNextofKin,textViewRelationship,textViewTelNumber,textViewSignatureImage,textViewTeamNameone,textViewFirstNameone,textViewFamilyNameone,
            textViewDateofBirthone,textViewNationalityone,textViewGenderone,textViewPassportNumberone,textViewIssuingDateone,textViewExpiryDateone,
            textViewPostalAddressone,textViewFiaLicenceone,
            textViewIssuingASNNumberone,textViewMobileTelephoneNumberone, textViewEmailAddressone,textViewNextofKinone,textViewRelationshipone,
            textViewTelNumberone,TextViewSignatureImageone,textViewLicenceone,textViewIDone,textViewTeamNametwo,textViewFirstNametwo,textViewFamilyNametwo,textViewDateofBirthtwo,
            textViewNationalitytwo,textViewGendertwo,
            textViewPassportNumbertwo,textViewIssuingDatetwo,textViewExpiryDatetwo,textViewPostalAddresstwo,textViewFiaLicencetwo,textViewIssuingASNNumbertwo,
            textViewMobileTelephoneNumbertwo,textViewEmailAddresstwo,textViewNextofKintwo,textViewRelationshiptwo,textViewTelNumbertwo,textViewSignatureImagetwo,AttendeeTV,
            textViewLicetwo,textViewIDtwo,textViewCarMake,
            textViewRegistrationNumber,textViewModel,textViewCubicCapacity,textViewYearofManufac,textViewChassisNumber,textViewGrouporClass,textViewEngineNumber,
            textViewHomologationNumber,textViewPredominantColor,textViewCountryofReg,textViewTechPassportNumber,textViewPayedforIndividualRound,headteam1nameTV,headteamoneTV,headenreantTV,headteam2TV;

    String TeamName,FirstName,FamilyName,DateofBirth,Nationality,Gender,PassportNumber,IssuingDate,ExiryDate,PostalAddress,
            FiaLicence,IssuingASNNumber,MobileTelephoneNumber,EmailAddress,NextofKin,Relationship,TelNumber,SignatureImage,
            TeamName1,FirstName1,FamilyName1,DateofBirth1,Nationality1,Gender1,PassportNumber1,IssuingDate1,ExiryDate1,PostalAddress1,
            FiaLicence1,IssuingASNNumber1,MobileTelephoneNumber1,EmailAddress1,NextofKin1,Relationship1,TelNumber1,SignatureImage1 ,Licence1,ID1,
            TeamName2,FirstName2,FamilyName2,DateofBirth2,Nationality2,Gender2,PassportNumber2,IssuingDate2,ExiryDate2,PostalAddress2,
            FiaLicence2,IssuingASNNumber2,MobileTelephoneNumber2,EmailAddress2,NextofKin2,Relationship2,TelNumber2,SignatureImage2 ,Licence2,ID2,
            CarMake,RegistrationNumber,Model,CubicCapacity,YearofManufac,ChassisNumber,GrouporClass,EngineNumber,HomologationNumber,PredominantColor,
            CountryofReg,TechPassportNumber,PayedforIndividualRound,headteam1name,headteamone,headenreant,geadteam2,User;

    ImageView headingdriverimage,signatureentrantImage,driver1signatureimage,driver1licenceimage,driver1idimage,driver2signatureimage,driver2licenceimage,driver2idimage;

    private Uri urisignatureentrantss,urilicenced1,uriidd1,urisignatured1,urilicenced2,uriidd2,urisignatured2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_registrant);


        if(Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(this.getResources().getColor(R.color.headings));
        }


        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        mStorageRef = FirebaseStorage.getInstance().getReference("uploads");



        AttendeeTV = findViewById(R.id.text_view_Attendee);
        headteam1nameTV = findViewById(R.id.headdiver1name);
        headteamoneTV = findViewById(R.id.headdriver1team);
        headenreantTV = findViewById(R.id.headentrantname);
        headteam2TV= findViewById(R.id.headdriver2name);

        User = AdminBajaRegistrationsView.alldata.User;
        AttendeeTV.setText(User);
        headteam1name = AdminBajaRegistrationsView.alldata.FirstName1;
        headteam1nameTV.setText(headteam1name);
        headteamone = AdminBajaRegistrationsView.alldata.TeamName1;
        headteamoneTV.setText(headteamone);
        headenreant = AdminBajaRegistrationsView.alldata.FirstName;
        headenreantTV.setText(headenreant);
        geadteam2 = AdminBajaRegistrationsView.alldata.FirstName2;
        headteam2TV.setText(geadteam2);

        textViewEntrantTeamName = findViewById(R.id.text_view_EntrantTeamName);
        textViewFirstName = findViewById(R.id.text_view_FirstName);
        textViewFamilyName = findViewById(R.id.text_view_FamilyName);
        textViewDateofBirth = findViewById(R.id.text_view_DateofBirth);
        textViewNationality = findViewById(R.id.text_view_Nationality);
        textViewGender = findViewById(R.id.text_view_Gender);
        textViewPassportNumber = findViewById(R.id.text_view_PassportNumber);
        textViewIssuingDate = findViewById(R.id.text_view_IssuingDate);
        textViewExpiryDate = findViewById(R.id.text_view_ExpiryDate);
        textViewPostalAddress = findViewById(R.id.text_view_PostalAddress);
        textViewFiaLicence = findViewById(R.id.text_view_FiaLicence);
        textViewIssuingASNNumber = findViewById(R.id.text_view_IssuingASNNumber);
        textViewMobileTelephoneNumber = findViewById(R.id.text_view_MobileTelephoneNumber);
        textViewEmailAddress = findViewById(R.id.text_view_EmailAddress);
        textViewNextofKin = findViewById(R.id.text_view_NextofKin);
        textViewRelationship = findViewById(R.id.text_view_Relationship);
        textViewTelNumber = findViewById(R.id.text_view_TelNumber);
        textViewSignatureImage = findViewById(R.id.text_view_SignatureImage);
        textViewTeamNameone = findViewById(R.id.reg_text_view_TeamNameone);
        textViewFirstNameone = findViewById(R.id.reg_text_view_FirstNameone);
        textViewFamilyNameone = findViewById(R.id.text_view_FamilyNameone);
        textViewDateofBirthone = findViewById(R.id.text_view_DateofBirthone);
        textViewNationalityone = findViewById(R.id.text_view_Nationalityone);
        textViewGenderone = findViewById(R.id.text_view_Genderone);
        textViewPassportNumberone = findViewById(R.id.text_view_PassportNumberone);
        textViewIssuingDateone = findViewById(R.id.text_view_IssuingDateone);
        textViewExpiryDateone = findViewById(R.id.text_view_ExpiryDateone);
        textViewPostalAddressone = findViewById(R.id.text_view_PostalAddressone);
        textViewFiaLicenceone = findViewById(R.id.text_view_FiaLicenceone);
        textViewIssuingASNNumberone = findViewById(R.id.text_view_IssuingASNNumberone);
        textViewMobileTelephoneNumberone = findViewById(R.id.text_view_MobileTelephoneNumberone);
        textViewEmailAddressone = findViewById(R.id.text_view_EmailAddressone);
        textViewNextofKinone = findViewById(R.id.text_view_NextofKinone);
        textViewRelationshipone = findViewById(R.id.text_view_Relationshipone);
        textViewTelNumberone = findViewById(R.id.text_view_TelNumberone);
        TextViewSignatureImageone = findViewById(R.id.text_view_SignatureImageone);
        textViewLicenceone = findViewById(R.id.text_view_Licenceone);
        textViewIDone = findViewById(R.id.text_view_IDone);
        textViewTeamNametwo = findViewById(R.id.text_view_TeamNametwo);
        textViewFirstNametwo = findViewById(R.id.text_view_FirstNametwo);
        textViewFamilyNametwo = findViewById(R.id.text_view_FamilyNametwo);
        textViewDateofBirthtwo = findViewById(R.id.text_view_DateofBirthtwo);
        textViewNationalitytwo = findViewById(R.id.text_view_Nationalitytwo);
        textViewGendertwo = findViewById(R.id.text_view_Gendertwo);
        textViewPassportNumbertwo = findViewById(R.id.text_view_PassportNumbertwo);
        textViewIssuingDatetwo = findViewById(R.id.text_view_IssuingDatetwo);
        textViewExpiryDatetwo = findViewById(R.id.text_view_ExpiryDatetwo);
        textViewPostalAddresstwo = findViewById(R.id.text_view_PostalAddresstwo);
        textViewFiaLicencetwo = findViewById(R.id.text_view_FiaLicencetwo);
        textViewIssuingASNNumbertwo = findViewById(R.id.text_view_IssuingASNNumbertwo);
        textViewMobileTelephoneNumbertwo = findViewById(R.id.text_view_MobileTelephoneNumbertwo);
        textViewEmailAddresstwo = findViewById(R.id.text_view_EmailAddresstwo);
        textViewNextofKintwo = findViewById(R.id.text_view_NextofKintwo);
        textViewRelationshiptwo = findViewById(R.id.text_view_Relationshiptwo);
        textViewTelNumbertwo = findViewById(R.id.text_view_TelNumbertwo);
        textViewSignatureImagetwo = findViewById(R.id.text_view_SignatureImagetwo);
        textViewLicetwo = findViewById(R.id.text_view_Licencetwo);
        textViewIDtwo = findViewById(R.id.text_view_IDtwo);
        textViewCarMake = findViewById(R.id.text_view_CarMake);
        textViewRegistrationNumber = findViewById(R.id.text_view_RegistrationNumber);
        textViewModel = findViewById(R.id.text_view_Model);
        textViewCubicCapacity = findViewById(R.id.text_view_CubicCapacity);
        textViewYearofManufac = findViewById(R.id.text_view_YearofManufac);
        textViewChassisNumber = findViewById(R.id.text_view_ChassisNumber);
        textViewGrouporClass = findViewById(R.id.text_view_GrouporClass);
        textViewEngineNumber = findViewById(R.id.text_view_EngineNumber);
        textViewHomologationNumber = findViewById(R.id.text_view_HomologationNumber);
        textViewPredominantColor = findViewById(R.id.text_view_PredominantColor);
        textViewCountryofReg = findViewById(R.id.text_view_CountryofReg);
        textViewTechPassportNumber = findViewById(R.id.text_view_TechPassportNumber);
        textViewPayedforIndividualRound = findViewById(R.id.text_view_PayedforIndividualRound);

        TeamName = AdminBajaRegistrationsView.alldata.TeamName;
        textViewEntrantTeamName.setText(TeamName);
        FirstName = AdminBajaRegistrationsView.alldata.FirstName;
        textViewFirstName.setText(FirstName);
        FamilyName = AdminBajaRegistrationsView.alldata.FamilyName;
        textViewFamilyName.setText(FamilyName);
        DateofBirth = AdminBajaRegistrationsView.alldata.DateofBirth;
        textViewDateofBirth.setText(DateofBirth);
        Nationality = AdminBajaRegistrationsView.alldata.Nationality;
        textViewNationality.setText(Nationality);
        Gender = AdminBajaRegistrationsView.alldata.Gender;
        textViewGender.setText(Gender);
        PassportNumber = AdminBajaRegistrationsView.alldata.PassportNumber;
        textViewPassportNumber.setText(PassportNumber);
        IssuingDate = AdminBajaRegistrationsView.alldata.IssuingDate;
        textViewIssuingDate.setText(IssuingDate);
        ExiryDate = AdminBajaRegistrationsView.alldata.ExiryDate;
        textViewExpiryDate.setText(ExiryDate);
        PostalAddress = AdminBajaRegistrationsView.alldata.PostalAddress;
        textViewPostalAddress.setText(PostalAddress);
        FiaLicence = AdminBajaRegistrationsView.alldata.FiaLicence;
        textViewFiaLicence.setText(FiaLicence);
        IssuingASNNumber = AdminBajaRegistrationsView.alldata.IssuingASNNumber;
        textViewIssuingASNNumber.setText(IssuingASNNumber);
        MobileTelephoneNumber = AdminBajaRegistrationsView.alldata.MobileTelephoneNumber;
        textViewMobileTelephoneNumber.setText(MobileTelephoneNumber);
        EmailAddress = AdminBajaRegistrationsView.alldata.EmailAddress;
        textViewEmailAddress.setText(EmailAddress);
        NextofKin = AdminBajaRegistrationsView.alldata.NextofKin;
        textViewNextofKin.setText(NextofKin);
        Relationship = AdminBajaRegistrationsView.alldata.Relationship;
        textViewRelationship.setText(Relationship);
        TelNumber = AdminBajaRegistrationsView.alldata.TelNumber;
        textViewTelNumber.setText(TelNumber);
        SignatureImage = AdminBajaRegistrationsView.alldata.SignatureImage;
        textViewSignatureImage.setText(SignatureImage);
        TeamName1 = AdminBajaRegistrationsView.alldata.TeamName1;
        textViewTeamNameone.setText(TeamName1);
        FirstName1 = AdminBajaRegistrationsView.alldata.FirstName1;
        textViewFirstNameone.setText(FirstName1);
        FamilyName1 = AdminBajaRegistrationsView.alldata.FamilyName1;
        textViewFamilyNameone.setText(FamilyName1);
        DateofBirth1 = AdminBajaRegistrationsView.alldata.DateofBirth1;
        textViewDateofBirthone.setText(DateofBirth1);
        Nationality1 = AdminBajaRegistrationsView.alldata.Nationality1;
        textViewNationalityone.setText(Nationality1);
        Gender1 = AdminBajaRegistrationsView.alldata.Gender1;
        textViewGenderone.setText(Gender1);
        PassportNumber1 = AdminBajaRegistrationsView.alldata.PassportNumber1;
        textViewPassportNumberone.setText(PassportNumber1);
        IssuingDate1 = AdminBajaRegistrationsView.alldata.IssuingDate1;
        textViewIssuingDateone.setText(IssuingDate1);
        ExiryDate1 = AdminBajaRegistrationsView.alldata.ExiryDate1;
        textViewExpiryDateone.setText(ExiryDate1);
        PostalAddress1 = AdminBajaRegistrationsView.alldata.PostalAddress1;
        textViewPostalAddressone.setText(PostalAddress1);
        FiaLicence1 = AdminBajaRegistrationsView.alldata.FiaLicence1;
        textViewFiaLicenceone.setText(FiaLicence1);
        IssuingASNNumber1 = AdminBajaRegistrationsView.alldata.IssuingASNNumber1;
        textViewIssuingASNNumberone.setText(IssuingASNNumber1);
        MobileTelephoneNumber1 = AdminBajaRegistrationsView.alldata.MobileTelephoneNumber1;
        textViewMobileTelephoneNumberone.setText(MobileTelephoneNumber1);
        EmailAddress1 = AdminBajaRegistrationsView.alldata.EmailAddress1;
        textViewEmailAddressone.setText(EmailAddress1);
        NextofKin1 = AdminBajaRegistrationsView.alldata.NextofKin1;
        textViewNextofKinone.setText(NextofKin1);
        Relationship1 = AdminBajaRegistrationsView.alldata.Relationship1;
        textViewRelationshipone.setText(Relationship1);
        TelNumber1 = AdminBajaRegistrationsView.alldata.TelNumber1;
        textViewTelNumberone.setText(TelNumber1);
        SignatureImage1 = AdminBajaRegistrationsView.alldata.SignatureImage1;
        TextViewSignatureImageone.setText(SignatureImage1);
        Licence1 = AdminBajaRegistrationsView.alldata.Licence1;
        System.out.println("thiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"+Licence1);
        textViewLicenceone.setText(Licence1);
        ID1 = AdminBajaRegistrationsView.alldata.ID1;
        textViewIDone.setText(ID1);
        TeamName2 = AdminBajaRegistrationsView.alldata.TeamName2;
        textViewTeamNametwo.setText(TeamName2);
        FirstName2 = AdminBajaRegistrationsView.alldata.FirstName2;
        textViewFirstNametwo.setText(FirstName2);
        FamilyName2 = AdminBajaRegistrationsView.alldata.FamilyName2;
        textViewFamilyNametwo.setText(FamilyName2);
        DateofBirth2 = AdminBajaRegistrationsView.alldata.DateofBirth2;
        textViewDateofBirthtwo.setText(DateofBirth2);
        Nationality2 = AdminBajaRegistrationsView.alldata.Nationality2;
        textViewNationalitytwo.setText(Nationality2);
        Gender2 = AdminBajaRegistrationsView.alldata.Gender2;
        textViewGendertwo.setText(Gender2);
        PassportNumber2 = AdminBajaRegistrationsView.alldata.PassportNumber2;
        textViewPassportNumbertwo.setText(PassportNumber2);
        IssuingDate2 = AdminBajaRegistrationsView.alldata.IssuingDate2;
        textViewIssuingDatetwo.setText(IssuingDate2);
        ExiryDate2 = AdminBajaRegistrationsView.alldata.ExiryDate2;
        textViewExpiryDatetwo.setText(ExiryDate2);
        PostalAddress2 = AdminBajaRegistrationsView.alldata.PostalAddress2;
        textViewPostalAddresstwo.setText(PostalAddress2);
        FiaLicence2 = AdminBajaRegistrationsView.alldata.FiaLicence2;
        textViewFiaLicencetwo.setText(FiaLicence2);
        IssuingASNNumber2 = AdminBajaRegistrationsView.alldata.IssuingASNNumber2;
        textViewIssuingASNNumbertwo.setText(IssuingASNNumber2);
        MobileTelephoneNumber2 = AdminBajaRegistrationsView.alldata.MobileTelephoneNumber2;
        textViewMobileTelephoneNumbertwo.setText(MobileTelephoneNumber2);
        EmailAddress2 = AdminBajaRegistrationsView.alldata.EmailAddress2;
        textViewEmailAddresstwo.setText(EmailAddress2);
        NextofKin2 = AdminBajaRegistrationsView.alldata.NextofKin2;
        textViewNextofKintwo.setText(NextofKin2);
        Relationship2 = AdminBajaRegistrationsView.alldata.Relationship2;
        textViewRelationshiptwo.setText(Relationship2);
        TelNumber2 = AdminBajaRegistrationsView.alldata.TelNumber2;
        textViewTelNumbertwo.setText(TelNumber2);
        SignatureImage2 = AdminBajaRegistrationsView.alldata.SignatureImage2;
        textViewSignatureImagetwo.setText(SignatureImage2);
        Licence2 = AdminBajaRegistrationsView.alldata.Licence2;
        textViewLicetwo.setText(Licence2);
        ID2 = AdminBajaRegistrationsView.alldata.ID2;
        textViewIDtwo.setText(ID2);
        CarMake = AdminBajaRegistrationsView.alldata.CarMake;
        textViewCarMake.setText(CarMake);
        RegistrationNumber = AdminBajaRegistrationsView.alldata.RegistrationNumber;
        textViewRegistrationNumber.setText(RegistrationNumber);
        Model = AdminBajaRegistrationsView.alldata.Model;
        textViewModel.setText(Model);
        CubicCapacity = AdminBajaRegistrationsView.alldata.CubicCapacity;
        textViewCubicCapacity.setText(CubicCapacity);
        YearofManufac = AdminBajaRegistrationsView.alldata.YearofManufac;
        textViewYearofManufac.setText(YearofManufac);
        ChassisNumber = AdminBajaRegistrationsView.alldata.ChassisNumber;
        textViewChassisNumber.setText(ChassisNumber);
        GrouporClass = AdminBajaRegistrationsView.alldata.GrouporClass;
        textViewGrouporClass.setText(GrouporClass);
        EngineNumber = AdminBajaRegistrationsView.alldata.EngineNumber;
        textViewEngineNumber.setText(EngineNumber);
        HomologationNumber = AdminBajaRegistrationsView.alldata.HomologationNumber;
        textViewHomologationNumber.setText(HomologationNumber);
        PredominantColor = AdminBajaRegistrationsView.alldata.PredominantColor;
        textViewPredominantColor.setText(PredominantColor);
        CountryofReg = AdminBajaRegistrationsView.alldata.CountryofReg;
        textViewCountryofReg.setText(CountryofReg);
        TechPassportNumber = AdminBajaRegistrationsView.alldata.TechPassportNumber;
        textViewTechPassportNumber.setText(TechPassportNumber);
        PayedforIndividualRound = AdminBajaRegistrationsView.alldata.PayedforIndividualRound;
        textViewPayedforIndividualRound.setText(PayedforIndividualRound);







        urisignatureentrantss = fromFile(new File(SignatureImage));

        urisignatured1 = fromFile(new File(SignatureImage1));
        urilicenced1 = fromFile(new File(Licence1));
        uriidd1 = fromFile(new File(ID1));

        urisignatured2 = fromFile(new File(SignatureImage2));
        urilicenced2 = fromFile(new File(Licence2));
        uriidd2 = fromFile(new File(ID2));


       // headingdriverimage = findViewById(R.id.maindriverimage);

        signatureentrantImage = findViewById(R.id.imageViewentrantsignature);

        driver1signatureimage = findViewById(R.id.imageViewDriver1signature);
        driver1licenceimage = findViewById(R.id.imageViewDriver1Licence);
        driver1idimage = findViewById(R.id.imageViewDriver1ID);

        driver2signatureimage = findViewById(R.id.imageViewDriver2Signature);
        driver2licenceimage = findViewById(R.id.imageViewDriver2Licence);
        driver2idimage = findViewById(R.id.imageViewDriver2ID);

        //RetriveImage(urilicenced1,headingdriverimage);

        RetriveImage(urisignatureentrantss,signatureentrantImage);

        RetriveImage(urisignatured1,driver1signatureimage);
        RetriveImage(urilicenced1,driver1licenceimage);
        RetriveImage(uriidd1,driver1idimage);

        RetriveImage(urisignatured2,driver2signatureimage);
        RetriveImage(urilicenced2,driver2licenceimage);
        RetriveImage(uriidd2,driver2idimage);



        }
        public void RetriveImage(Uri uri,ImageView imageView){


            FirebaseStorage storage = FirebaseStorage.getInstance();

            StorageReference storageRef = storage.getReferenceFromUrl("gs://qatarmotorsports.appspot.com");

            storageRef.child("uploads/"+uri.getLastPathSegment()).getBytes(Long.MAX_VALUE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                @Override
                public void onSuccess(byte[] bytes) {
                    // Use the bytes to display the image
                    Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                    imageView.setImageBitmap(bitmap);
                }
            });
        }

}
