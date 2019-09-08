/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanakasalo.model;

import java.sql.Date;

/**
 *
 * @author Ivana
 */
public class Patient extends Person {

    private Sex sex;
    private Date DateOfBirth;
    private Address PermanentAddress;
    private NextOfKin nextOfKin;
    private MaritalStatus maritalStatus;
    private int noOfDependents;
    private int height;
    private int weight;
    private BloodType bloodType;
    private Occupation occupation;
    private double grossAnnualIncome;
    private boolean vegetarian;
    private boolean smoker;
    private int noCigarettesADay;
    private boolean consumesAlcohol;
    private int noDrinksADay;
    private String stimulants;
    private int coffeeTeaDay;
    private int softDrinksDay;
    private String regularMeals;
    private boolean homeFood;
    private String statementOfComplaint;
    private String previousTreatments;
    private String physicianHospitalTreated;
    private String Diabetic;
    private String Hypertensive;
    private String CardiacCondition;
    private String RespiratoryCondition;
    private String DigestiveCondition;
    private String OrthopedicCondtion;
    private String MuscularCondition;
    private String KnownAllergies;
    private String KnownReactionToSpecificDrug;
    private String MajorSurgeriesHistory;
    private Date EntryTime;

    public Patient(String firstName, String middleName, String surname, Sex sex, Date DateOfBirth, Contact contact, NextOfKin nextOfKin, String statementOfComplaint) {
        super(firstName, middleName, surname, contact);
        this.sex = sex;
        this.DateOfBirth = DateOfBirth;
        this.nextOfKin = nextOfKin;
        this.statementOfComplaint = statementOfComplaint;
    }

    public Patient(int id, String firstName, String middleName, String surname, Sex sex, Date DateOfBirth, Address presentAddress, Address PermanentAddress, Contact contact, NextOfKin nextOfKin, MaritalStatus maritalStatus, int noOfDependents, int height, int weight, BloodType bloodType, Occupation occupation, double grossAnnualIncome, boolean vegetarian, boolean smoker, int noCigarettesADay, boolean consumesAlcohol, int noDrinksADay, String stimulants, int coffeeTeaDay, int softDrinksDay, String regularMeals, boolean homeFood, String statementOfComplaint, String previousTreatments, String physicianHospitalTreated, String Diabetic, String Hypertensive, String CardiacCondition, String RespiratoryCondition, String DigestiveCondition, String OrthopedicCondtion, String MuscularCondition, String KnownAllergies, String KnownReactionToSpecificDrug, String MajorSurgeriesHistory, Date EntryTime) {
        super(id, firstName, middleName, surname, presentAddress, contact);
        this.sex = sex;
        this.DateOfBirth = DateOfBirth;
        this.PermanentAddress = PermanentAddress;
        this.nextOfKin = nextOfKin;
        this.maritalStatus = maritalStatus;
        this.noOfDependents = noOfDependents;
        this.height = height;
        this.weight = weight;
        this.bloodType = bloodType;
        this.occupation = occupation;
        this.grossAnnualIncome = grossAnnualIncome;
        this.vegetarian = vegetarian;
        this.smoker = smoker;
        this.noCigarettesADay = noCigarettesADay;
        this.consumesAlcohol = consumesAlcohol;
        this.noDrinksADay = noDrinksADay;
        this.stimulants = stimulants;
        this.coffeeTeaDay = coffeeTeaDay;
        this.softDrinksDay = softDrinksDay;
        this.regularMeals = regularMeals;
        this.homeFood = homeFood;
        this.statementOfComplaint = statementOfComplaint;
        this.previousTreatments = previousTreatments;
        this.physicianHospitalTreated = physicianHospitalTreated;
        this.Diabetic = Diabetic;
        this.Hypertensive = Hypertensive;
        this.CardiacCondition = CardiacCondition;
        this.RespiratoryCondition = RespiratoryCondition;
        this.DigestiveCondition = DigestiveCondition;
        this.OrthopedicCondtion = OrthopedicCondtion;
        this.MuscularCondition = MuscularCondition;
        this.KnownAllergies = KnownAllergies;
        this.KnownReactionToSpecificDrug = KnownReactionToSpecificDrug;
        this.MajorSurgeriesHistory = MajorSurgeriesHistory;
        this.EntryTime = EntryTime;
    }

    public Patient(int id, String firstName, String middleName, String surname, Sex sex, Date DateOfBirth, Address presentAddress, Address PermanentAddress, Contact contact, NextOfKin nextOfKin, MaritalStatus maritalStatus, int noOfDependents, int height, int weight, BloodType bloodType, Occupation occupation, double grossAnnualIncome, boolean vegetarian, boolean smoker, int noCigarettesADay, boolean consumesAlcohol, int noDrinksADay, String stimulants, int coffeeTeaDay, int softDrinksDay, String regularMeals, boolean homeFood, String statementOfComplaint, String previousTreatments, String physicianHospitalTreated, String Diabetic, String Hypertensive, String CardiacCondition, String RespiratoryCondition, String DigestiveCondition, String OrthopedicCondtion, String MuscularCondition, String KnownAllergies, String KnownReactionToSpecificDrug, String MajorSurgeriesHistory) {
        super(id, firstName, middleName, surname, presentAddress, contact);
        this.sex = sex;
        this.DateOfBirth = DateOfBirth;
        this.PermanentAddress = PermanentAddress;
        this.nextOfKin = nextOfKin;
        this.maritalStatus = maritalStatus;
        this.noOfDependents = noOfDependents;
        this.height = height;
        this.weight = weight;
        this.bloodType = bloodType;
        this.occupation = occupation;
        this.grossAnnualIncome = grossAnnualIncome;
        this.vegetarian = vegetarian;
        this.smoker = smoker;
        this.noCigarettesADay = noCigarettesADay;
        this.consumesAlcohol = consumesAlcohol;
        this.noDrinksADay = noDrinksADay;
        this.stimulants = stimulants;
        this.coffeeTeaDay = coffeeTeaDay;
        this.softDrinksDay = softDrinksDay;
        this.regularMeals = regularMeals;
        this.homeFood = homeFood;
        this.statementOfComplaint = statementOfComplaint;
        this.previousTreatments = previousTreatments;
        this.physicianHospitalTreated = physicianHospitalTreated;
        this.Diabetic = Diabetic;
        this.Hypertensive = Hypertensive;
        this.CardiacCondition = CardiacCondition;
        this.RespiratoryCondition = RespiratoryCondition;
        this.DigestiveCondition = DigestiveCondition;
        this.OrthopedicCondtion = OrthopedicCondtion;
        this.MuscularCondition = MuscularCondition;
        this.KnownAllergies = KnownAllergies;
        this.KnownReactionToSpecificDrug = KnownReactionToSpecificDrug;
        this.MajorSurgeriesHistory = MajorSurgeriesHistory;
    }

    public Patient(String firstName, String middleName, String surname, Sex sex, Date DateOfBirth, Address presentAddress, Address PermanentAddress, Contact contact, NextOfKin nextOfKin, MaritalStatus maritalStatus, int noOfDependents, int height, int weight, BloodType bloodType, Occupation occupation, double grossAnnualIncome, boolean vegetarian, boolean smoker, int noCigarettesADay, boolean consumesAlcohol, int noDrinksADay, String stimulants, int coffeeTeaDay, int softDrinksDay, String regularMeals, boolean homeFood, String statementOfComplaint, String previousTreatments, String physicianHospitalTreated, String Diabetic, String Hypertensive, String CardiacCondition, String RespiratoryCondition, String DigestiveCondition, String OrthopedicCondtion, String MuscularCondition, String KnownAllergies, String KnownReactionToSpecificDrug, String MajorSurgeriesHistory) {
        super(firstName, middleName, surname, presentAddress, contact);
        this.sex = sex;
        this.DateOfBirth = DateOfBirth;
        this.PermanentAddress = PermanentAddress;
        this.nextOfKin = nextOfKin;
        this.maritalStatus = maritalStatus;
        this.noOfDependents = noOfDependents;
        this.height = height;
        this.weight = weight;
        this.bloodType = bloodType;
        this.occupation = occupation;
        this.grossAnnualIncome = grossAnnualIncome;
        this.vegetarian = vegetarian;
        this.smoker = smoker;
        this.noCigarettesADay = noCigarettesADay;
        this.consumesAlcohol = consumesAlcohol;
        this.noDrinksADay = noDrinksADay;
        this.stimulants = stimulants;
        this.coffeeTeaDay = coffeeTeaDay;
        this.softDrinksDay = softDrinksDay;
        this.regularMeals = regularMeals;
        this.homeFood = homeFood;
        this.statementOfComplaint = statementOfComplaint;
        this.previousTreatments = previousTreatments;
        this.physicianHospitalTreated = physicianHospitalTreated;
        this.Diabetic = Diabetic;
        this.Hypertensive = Hypertensive;
        this.CardiacCondition = CardiacCondition;
        this.RespiratoryCondition = RespiratoryCondition;
        this.DigestiveCondition = DigestiveCondition;
        this.OrthopedicCondtion = OrthopedicCondtion;
        this.MuscularCondition = MuscularCondition;
        this.KnownAllergies = KnownAllergies;
        this.KnownReactionToSpecificDrug = KnownReactionToSpecificDrug;
        this.MajorSurgeriesHistory = MajorSurgeriesHistory;

    }

    public Patient() {

    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public Address getPermanentAddress() {
        return PermanentAddress;
    }

    public void setPermanentAddress(Address PermanentAddress) {
        this.PermanentAddress = PermanentAddress;
    }

    public NextOfKin getNextOfKin() {
        return nextOfKin;
    }

    public void setNextOfKin(NextOfKin nextOfKin) {
        this.nextOfKin = nextOfKin;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public int getNoOfDependents() {
        return noOfDependents;
    }

    public void setNoOfDependents(int noOfDependents) {
        this.noOfDependents = noOfDependents;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public double getGrossAnnualIncome() {
        return grossAnnualIncome;
    }

    public void setGrossAnnualIncome(double grossAnnualIncome) {
        this.grossAnnualIncome = grossAnnualIncome;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public boolean isSmoker() {
        return smoker;
    }

    public void setSmoker(boolean smoker) {
        this.smoker = smoker;
    }

    public int getNoCigarettesADay() {
        return noCigarettesADay;
    }

    public void setNoCigarettesADay(int noCigarettesADay) {
        this.noCigarettesADay = noCigarettesADay;
    }

    public boolean isConsumesAlcohol() {
        return consumesAlcohol;
    }

    public void setConsumesAlcohol(boolean consumesAlcohol) {
        this.consumesAlcohol = consumesAlcohol;
    }

    public int getNoDrinksADay() {
        return noDrinksADay;
    }

    public void setNoDrinksADay(int noDrinksADay) {
        this.noDrinksADay = noDrinksADay;
    }

    public String getStimulants() {
        return stimulants;
    }

    public void setStimulants(String stimulants) {
        this.stimulants = stimulants;
    }

    public int getCoffeeTeaDay() {
        return coffeeTeaDay;
    }

    public void setCoffeeTeaDay(int coffeeTeaDay) {
        this.coffeeTeaDay = coffeeTeaDay;
    }

    public int getSoftDrinksDay() {
        return softDrinksDay;
    }

    public void setSoftDrinksDay(int softDrinksDay) {
        this.softDrinksDay = softDrinksDay;
    }

    public String getRegularMeals() {
        return regularMeals;
    }

    public void setRegularMeals(String regularMeals) {
        this.regularMeals = regularMeals;
    }

    public boolean isHomeFood() {
        return homeFood;
    }

    public void setHomeFood(boolean homeFood) {
        this.homeFood = homeFood;
    }

    public String getStatementOfComplaint() {
        return statementOfComplaint;
    }

    public void setStatementOfComplaint(String statementOfComplaint) {
        this.statementOfComplaint = statementOfComplaint;
    }

    public String getPreviousTreatments() {
        return previousTreatments;
    }

    public void setPreviousTreatments(String previousTreatments) {
        this.previousTreatments = previousTreatments;
    }

    public String getPhysicianHospitalTreated() {
        return physicianHospitalTreated;
    }

    public void setPhysicianHospitalTreated(String physicianHospitalTreated) {
        this.physicianHospitalTreated = physicianHospitalTreated;
    }

    public String getDiabetic() {
        return Diabetic;
    }

    public void setDiabetic(String Diabetic) {
        this.Diabetic = Diabetic;
    }

    public String getHypertensive() {
        return Hypertensive;
    }

    public void setHypertensive(String Hypertensive) {
        this.Hypertensive = Hypertensive;
    }

    public String getCardiacCondition() {
        return CardiacCondition;
    }

    public void setCardiacCondition(String CardiacCondition) {
        this.CardiacCondition = CardiacCondition;
    }

    public String getRespiratoryCondition() {
        return RespiratoryCondition;
    }

    public void setRespiratoryCondition(String RespiratoryCondition) {
        this.RespiratoryCondition = RespiratoryCondition;
    }

    public String getDigestiveCondition() {
        return DigestiveCondition;
    }

    public void setDigestiveCondition(String DigestiveCondition) {
        this.DigestiveCondition = DigestiveCondition;
    }

    public String getOrthopedicCondtion() {
        return OrthopedicCondtion;
    }

    public void setOrthopedicCondtion(String OrthopedicCondtion) {
        this.OrthopedicCondtion = OrthopedicCondtion;
    }

    public String getMuscularCondition() {
        return MuscularCondition;
    }

    public void setMuscularCondition(String MuscularCondition) {
        this.MuscularCondition = MuscularCondition;
    }

    public String getKnownAllergies() {
        return KnownAllergies;
    }

    public void setKnownAllergies(String KnownAllergies) {
        this.KnownAllergies = KnownAllergies;
    }

    public String getKnownReactionToSpecificDrug() {
        return KnownReactionToSpecificDrug;
    }

    public void setKnownReactionToSpecificDrug(String KnownReactionToSpecificDrug) {
        this.KnownReactionToSpecificDrug = KnownReactionToSpecificDrug;
    }

    public String getMajorSurgeriesHistory() {
        return MajorSurgeriesHistory;
    }

    public void setMajorSurgeriesHistory(String MajorSurgeriesHistory) {
        this.MajorSurgeriesHistory = MajorSurgeriesHistory;
    }

    public Date getEntryTime() {
        return EntryTime;
    }

    public void setEntryTime(Date EntryTime) {
        this.EntryTime = EntryTime;
    }

}
