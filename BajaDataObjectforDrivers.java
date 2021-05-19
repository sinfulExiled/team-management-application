package com.application.qatarmotorsports;

public class BajaDataObjectforDrivers {

    String TeamName,FirstName,FamilyName,DateofBirth,Nationality,Gender,PassportNumber,IssuingDate,ExiryDate,PostalAddress,
            FiaLicence,IssuingASNNumber,MobileTelephoneNumber,EmailAddress,NextofKin,Relationship,TelNumber,SignatureImage ,Licence,ID;

    public BajaDataObjectforDrivers(){

        this.TeamName = null;
    }

    public BajaDataObjectforDrivers(String teamName, String firstName, String familyName, String dateofBirth, String nationality, String gender, String passportNumber, String issuingDate, String exiryDate, String postalAddress, String fiaLicence, String issuingASNNumber, String mobileTelephoneNumber, String emailAddress, String nextofKin, String relationship, String telNumber,String signatureImage ,String licence,String id) {
        TeamName = teamName;
        FirstName = firstName;
        FamilyName = familyName;
        DateofBirth = dateofBirth;
        Nationality = nationality;
        Gender = gender;
        PassportNumber = passportNumber;
        IssuingDate = issuingDate;
        ExiryDate = exiryDate;
        PostalAddress = postalAddress;
        FiaLicence = fiaLicence;
        IssuingASNNumber = issuingASNNumber;
        MobileTelephoneNumber = mobileTelephoneNumber;
        EmailAddress = emailAddress;
        NextofKin = nextofKin;
        Relationship = relationship;
        TelNumber = telNumber;
        SignatureImage  = signatureImage ;
        Licence = licence;
        ID = id;
    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getFamilyName() {
        return FamilyName;
    }

    public void setFamilyName(String familyName) {
        FamilyName = familyName;
    }

    public String getDateofBirth() {
        return DateofBirth;
    }

    public void setDateofBirth(String dateofBirth) {
        DateofBirth = dateofBirth;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPassportNumber() {
        return PassportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        PassportNumber = passportNumber;
    }

    public String getIssuingDate() {
        return IssuingDate;
    }

    public void setIssuingDate(String issuingDate) {
        IssuingDate = issuingDate;
    }

    public String getExiryDate() {
        return ExiryDate;
    }

    public void setExiryDate(String exiryDate) {
        ExiryDate = exiryDate;
    }

    public String getPostalAddress() {
        return PostalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        PostalAddress = postalAddress;
    }

    public String getFiaLicence() {
        return FiaLicence;
    }

    public void setFiaLicence(String fiaLicence) {
        FiaLicence = fiaLicence;
    }

    public String getIssuingASNNumber() {
        return IssuingASNNumber;
    }

    public void setIssuingASNNumber(String issuingASNNumber) {
        IssuingASNNumber = issuingASNNumber;
    }

    public String getMobileTelephoneNumber() {
        return MobileTelephoneNumber;
    }

    public void setMobileTelephoneNumber(String mobileTelephoneNumber) {
        MobileTelephoneNumber = mobileTelephoneNumber;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public String getNextofKin() {
        return NextofKin;
    }

    public void setNextofKin(String nextofKin) {
        NextofKin = nextofKin;
    }

    public String getRelationship() {
        return Relationship;
    }

    public void setRelationship(String relationship) {
        Relationship = relationship;
    }

    public String getTelNumber() {
        return TelNumber;
    }

    public void setTelNumber(String telNumber) {
        TelNumber = telNumber;
    }

    public String getSignatureImage() {
        return SignatureImage;
    }

    public void setSignatureImage(String signatureImage) {
        SignatureImage = signatureImage;
    }

    public String getLicence() {
        return Licence;
    }

    public void setLicence(String licence) {
        Licence = licence;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}

