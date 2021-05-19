package com.application.qatarmotorsports;

public class NewCarObj {

    String CarMake,RegistrationNumber,Model,CubicCapacity,YearofManufac,ChassisNumber,GrouporClass,EngineNumber,HomologationNumber,PredominantColor,CountryofReg,TechPassportNumber,PayedforIndividualRound;

    public NewCarObj(String carMake, String registrationNumber, String model, String cubicCapacity, String yearofManufac, String chassisNumber, String grouporClass, String engineNumber, String homologationNumber, String predominantColor, String countryofReg, String techPassportNumber, String payedforIndividualRound) {
        CarMake = carMake;
        RegistrationNumber = registrationNumber;
        Model = model;
        CubicCapacity = cubicCapacity;
        YearofManufac = yearofManufac;
        ChassisNumber = chassisNumber;
        GrouporClass = grouporClass;
        EngineNumber = engineNumber;
        HomologationNumber = homologationNumber;
        PredominantColor = predominantColor;
        CountryofReg = countryofReg;
        TechPassportNumber = techPassportNumber;
        PayedforIndividualRound = payedforIndividualRound;
    }
    public  NewCarObj(){

    }

    public String getCarMake() {
        return CarMake;
    }

    public void setCarMake(String carMake) {
        CarMake = carMake;
    }

    public String getRegistrationNumber() {
        return RegistrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        RegistrationNumber = registrationNumber;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getCubicCapacity() {
        return CubicCapacity;
    }

    public void setCubicCapacity(String cubicCapacity) {
        CubicCapacity = cubicCapacity;
    }

    public String getYearofManufac() {
        return YearofManufac;
    }

    public void setYearofManufac(String yearofManufac) {
        YearofManufac = yearofManufac;
    }

    public String getChassisNumber() {
        return ChassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        ChassisNumber = chassisNumber;
    }

    public String getGrouporClass() {
        return GrouporClass;
    }

    public void setGrouporClass(String grouporClass) {
        GrouporClass = grouporClass;
    }

    public String getEngineNumber() {
        return EngineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        EngineNumber = engineNumber;
    }

    public String getHomologationNumber() {
        return HomologationNumber;
    }

    public void setHomologationNumber(String homologationNumber) {
        HomologationNumber = homologationNumber;
    }

    public String getPredominantColor() {
        return PredominantColor;
    }

    public void setPredominantColor(String predominantColor) {
        PredominantColor = predominantColor;
    }

    public String getCountryofReg() {
        return CountryofReg;
    }

    public void setCountryofReg(String countryofReg) {
        CountryofReg = countryofReg;
    }

    public String getTechPassportNumber() {
        return TechPassportNumber;
    }

    public void setTechPassportNumber(String techPassportNumber) {
        TechPassportNumber = techPassportNumber;
    }

    public String getPayedforIndividualRound() {
        return PayedforIndividualRound;
    }

    public void setPayedforIndividualRound(String payedforIndividualRound) {
        PayedforIndividualRound = payedforIndividualRound;
    }
}
