package com.application.qatarmotorsports;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;

public class NoteAdapter extends FirestoreRecyclerAdapter<AllDataFromObjects, NoteAdapter.NoteHolder> {

    private OnItemClickListener listener;

    public NoteAdapter(@NonNull FirestoreRecyclerOptions<AllDataFromObjects> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull NoteHolder holder, int position, @NonNull AllDataFromObjects model) {


        holder.textViewTeamNameone.setText(model.getTeamName1());
        holder.textViewFirstNameone.setText(model.getFirstName1());
       /*
        holder.textViewEntrantTeamName.setText(model.getTeamName());
        holder.textViewFirstName.setText(model.getFirstName());
       holder.textViewFamilyName.setText(model.getFamilyName());
        holder.textViewDateofBirth.setText(model.getDateofBirth());
        holder.textViewNationality.setText(model.getNationality());
        holder.textViewGender.setText(model.getGender());
        holder.textViewPassportNumber.setText(model.getPassportNumber());
        holder.textViewIssuingDate.setText(model.getIssuingDate());
        holder.textViewExpiryDate.setText(model.getExiryDate());
        holder.textViewPostalAddress.setText(model.getPostalAddress());
        holder.textViewFiaLicence.setText(model.getFiaLicence());
        holder.textViewIssuingASNNumber.setText(model.getIssuingASNNumber());
        holder.textViewMobileTelephoneNumber.setText(model.getMobileTelephoneNumber());
        holder.textViewEmailAddress.setText(model.getEmailAddress());
        holder.textViewNextofKin.setText(model.getNextofKin());
        holder.textViewRelationship.setText(model.getRelationship());
        holder.textViewTelNumber.setText(model.getTelNumber());
        holder.textViewSignatureImage.setText(model.getSignatureImage());
        holder.textViewTeamNameone.setText(model.getTeamName1());
        holder.textViewFirstNameone.setText(model.getFirstName1());
        holder.textViewFamilyNameone.setText(model.getFamilyName1());
        holder.textViewDateofBirthone.setText(model.getDateofBirth1());
        holder.textViewNationalityone.setText(model.getNationality1());
        holder.textViewGenderone.setText(model.getGender1());
        holder.textViewPassportNumberone.setText(model.getPassportNumber1());
        holder.textViewIssuingDateone.setText(model.getIssuingDate1());
        holder.textViewExpiryDateone.setText(model.getExiryDate1());
        holder.textViewPostalAddressone.setText(model.getPostalAddress1());
        holder.textViewFiaLicenceone.setText(model.getFiaLicence1());
        holder.textViewIssuingASNNumberone.setText(model.getIssuingASNNumber1());
        holder.textViewMobileTelephoneNumberone.setText(model.getMobileTelephoneNumber1());
        holder.textViewEmailAddressone.setText(model.getEmailAddress1());
        holder.textViewNextofKinone.setText(model.getNextofKin1());
        holder.textViewRelationshipone.setText(model.getRelationship1());
        holder.textViewTelNumberone.setText(model.getTelNumber1());
        holder.TextViewSignatureImageone.setText(model.getSignatureImage1());
        holder.textViewLicenceone.setText(model.getLicence1());
        holder.textViewIDone.setText(model.getID1());
        holder.textViewTeamNametwo.setText(model.getTeamName2());
        holder.textViewFirstNametwo.setText(model.getFirstName2());
        holder.textViewFamilyNametwo.setText(model.getFamilyName2());
        holder.textViewDateofBirthtwo.setText(model.getDateofBirth2());
        holder.textViewNationalitytwo.setText(model.getNationality2());
        holder.textViewGendertwo.setText(model.getGender2());
        holder.textViewPassportNumbertwo.setText(model.getPassportNumber2());
        holder.textViewIssuingDatetwo.setText(model.getIssuingDate2());
        holder.textViewExpiryDatetwo.setText(model.getExiryDate2());
        holder.textViewPostalAddresstwo.setText(model.getPostalAddress2());
        holder.textViewFiaLicencetwo.setText(model.getFiaLicence2());
        holder.textViewIssuingASNNumbertwo.setText(model.getIssuingASNNumber2());
        holder.textViewMobileTelephoneNumbertwo.setText(model.getMobileTelephoneNumber2());
        holder.textViewEmailAddresstwo.setText(model.getEmailAddress2());
        holder.textViewNextofKintwo.setText(model.getNextofKin2());
        holder.textViewRelationshiptwo.setText(model.getRelationship2());
        holder.textViewTelNumbertwo.setText(model.getTelNumber2());
        holder.textViewSignatureImagetwo.setText(model.getSignatureImage2());
        holder.textViewLicetwo.setText(model.getLicence2());
        holder.textViewIDtwo.setText(model.getID2());
        holder.textViewCarMake.setText(model.getCarMake());
        holder.textViewRegistrationNumber.setText(model.getRegistrationNumber());
        holder.textViewModel.setText(model.getModel());
        holder.textViewCubicCapacity.setText(model.getCubicCapacity());
        holder.textViewYearofManufac.setText(model.getYearofManufac());
        holder.textViewChassisNumber.setText(model.getChassisNumber());
        holder.textViewGrouporClass.setText(model.getGrouporClass());
        holder.textViewEngineNumber.setText(model.getEngineNumber());
        holder.textViewHomologationNumber.setText(model.getHomologationNumber());
        holder.textViewPredominantColor.setText(model.getPredominantColor());
        holder.textViewCountryofReg.setText(model.getCountryofReg());
        holder.textViewTechPassportNumber.setText(model.getTechPassportNumber());
        holder.textViewPayedforIndividualRound.setText(model.getPayedforIndividualRound());*/
    }


    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item,parent,false);
        return new NoteHolder(v);
    }



    public void DeleteItem(int position){
        getSnapshots().getSnapshot(position).getReference().delete();


    }

    class NoteHolder extends RecyclerView.ViewHolder{
        TextView textViewEntrantTeamName,textViewFirstName,textViewFamilyName,textViewDateofBirth,textViewNationality,textViewGender,textViewPassportNumber,
                textViewIssuingDate,textViewExpiryDate,textViewPostalAddress,textViewFiaLicence,textViewIssuingASNNumber,textViewMobileTelephoneNumber,textViewEmailAddress,
                textViewNextofKin,textViewRelationship,textViewTelNumber,textViewSignatureImage,textViewTeamNameone,textViewFirstNameone,textViewFamilyNameone,
                textViewDateofBirthone,textViewNationalityone,textViewGenderone,textViewPassportNumberone,textViewIssuingDateone,textViewExpiryDateone,
                textViewPostalAddressone,textViewFiaLicenceone,
                textViewIssuingASNNumberone,textViewMobileTelephoneNumberone, textViewEmailAddressone,textViewNextofKinone,textViewRelationshipone,
                textViewTelNumberone,TextViewSignatureImageone,textViewLicenceone,textViewIDone,textViewTeamNametwo,textViewFirstNametwo,textViewFamilyNametwo,textViewDateofBirthtwo,
                textViewNationalitytwo,textViewGendertwo,
                textViewPassportNumbertwo,textViewIssuingDatetwo,textViewExpiryDatetwo,textViewPostalAddresstwo,textViewFiaLicencetwo,textViewIssuingASNNumbertwo,
                textViewMobileTelephoneNumbertwo,textViewEmailAddresstwo,textViewNextofKintwo,textViewRelationshiptwo,textViewTelNumbertwo,textViewSignatureImagetwo,
                textViewLicetwo,textViewIDtwo,textViewCarMake,
                textViewRegistrationNumber,textViewModel,textViewCubicCapacity,textViewYearofManufac,textViewChassisNumber,textViewGrouporClass,textViewEngineNumber,
                textViewHomologationNumber,textViewPredominantColor,textViewCountryofReg,textViewTechPassportNumber,textViewPayedforIndividualRound;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            textViewTeamNameone = itemView.findViewById(R.id.text_view_TeamNameone);
            textViewFirstNameone = itemView.findViewById(R.id.text_view_FirstNameone);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION && listener != null){
                        listener.onItemClick(getSnapshots().getSnapshot(position),position);
                    }
                }
            });
        }
    }
    public interface OnItemClickListener{
        void onItemClick(DocumentSnapshot documentSnapshot,int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
}
