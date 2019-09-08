/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanakasalo.dal;

import com.ivanakasalo.dal.sql.DataSourceSingleton;
import com.ivanakasalo.model.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

/**
 *
 * @author Ivana
 */
public class SqlRepo implements IRepo {

    //o is object abbreviation
    private static final String ADD_DOCTOR = "{CALL addDoctor (?,?,?,?,?,?)}";
    private static final String EDIT_DOCTOR = "{CALL editDoctor (?,?,?,?,?,?,?)}";
    private static final String GET_DOCTOR = "{CALL getDoctor (?)}";
    private static final String GET_DOCTORS = "{CALL getDoctors}";

    private static final String ADD_NEXTOFKIN = "{CALL addNextOfKin(?,?,?,?,?,?)}";
    private static final String ADD_EMERGENCY_NEXTOFKIN = "{CALL addEmergencyNextOfKin(?,?,?,?)}";
    private static final String EDIT_NEXTOFKIN = "{CALL editNextOfKin(?,?,?,?,?,?,?)}";
    private static final String GET_NEXTOFKIN = "{CALL getNextOfKin (?)}";
    private static final String GET_NEXTOFKINS = "{CALL getNextOfKins }";
    private static final String GET_NEXTOFKIN_O = "{CALL getNextOfKinO (?,?)}";

    private static final String ADD_MEDICAL_PERSONNEL = "{CALL addMedicalPersonnel(?,?,?,?,?,?)}";
    private static final String EDIT_MEDICAL_PERSONNEL = "{CALL editMedicalPersonnel(?,?,?,?,?,?,?)}";
    private static final String GET_MEDICAL_PERSONNEL = "{CALL getMedicalPersonnel (?)}";
    private static final String GET_MEDICAL_PERSONNELS = "{CALL getMedicalPersonnels}";

    private static final String ADD_EMERGENCY_PATIENT = "{CALL addEmergencyPatient(?,?,?,?,?,?,?,?)}";
    private static final String ADD_PATIENT = "{CALL addPatient(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
    private static final String EDIT_PATIENT = "{CALL editPatient(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
    private static final String GET_PATIENT = "{CALL getPatient(?)}";
    private static final String GET_PATIENTS = "{CALL getPatients}";
    private static final String GET_DOCTORS_PER_PATIENT = "{CALL getDoctorsForPatient(?)}";

    private static final String ADD_ADDRESS = "{CALL addAddress (?,?,?)}";
    private static final String EDIT_ADDRESS = "{CALL editAddress (?,?,?,?)}";
    private static final String GET_ADDRESS = "{CALL getAddress (?)}";
    private static final String GET_ADDRESS_O = "{CALL getAddressO (?,?,?)}";

    private static final String ADD_CONTACT = "{CALL addContact (?,?)}";
    private static final String EDIT_CONTACT = "{CALL editContact (?,?,?)}";
    private static final String GET_CONTACT = "{CALL getContact(?)}";
    private static final String GET_CONTACT_O = "{CALL getContactO(?)}";

    private static final String GET_CONTACT_TYPE = "{CALL getContactType(?)}";
    private static final String GET_CONTACT_TYPES = "{CALL getContactTypes}";

    private static final String GET_PINCODE = "{CALL getPincode(?)}";
    private static final String GET_PINCODES = "{CALL getPincodes}";

    private static final String GET_CITY = "{CALL getCity(?)}";
    private static final String GET_CITIES = "{CALL getCities}";

    private static final String GET_STATE = "{CALL getState(?)}";
    private static final String GET_STATES = "{CALL getStates}";

    private static final String GET_OCCUPATION = "{CALL getOccupation(?)}";
    private static final String GET_OCCUPATIONS = "{CALL getOccupations}";

    private static final String GET_RELATIONSHIP = "{CALL getRelationship(?)}";
    private static final String GET_RELATIONSHIPS = "{CALL getRelationships}";

    private static final String GET_MARITAL_STATUS = "{CALL getMaritalStatus(?)}";
    private static final String GET_MARITAL_STATUSES = "{CALL getMaritalStatuses}";

    private static final String GET_SEX = "{CALL getSex(?)}";
    private static final String GET_SEXES = "{CALL getSexes}";
    private static final String GET_BLOODTYPE = "{CALL getBloodType(?)}";
    private static final String GET_BLOODTYPES = "{CALL getBloodTypes}";
    private static final String GET_PAYMENTTYPE = "{CALL getPaymentType(?)}";
    private static final String GET_PAYMENTTYPES = "{CALL getPaymentTypes}";
    private static final String GET_CONSULTATIONS = "{CALL getConsultations}";
    private static final String GET_CONSULTATION = "{CALL getConsultation(?)}";
    private static final String GET_TESTS = "{CALL getTests}";
    private static final String GET_TEST = "{CALL getTest(?)}";
    private static final String GET_MEDICINES = "{CALL getMedicines}";
    private static final String GET_MEDICINE = "{CALL getMedicine(?)}";
    private static final String DELETE_MEDICAL_PERSONNEL = "{CALL deleteMedicalPersonnel(?)}";
    private static final String DELETE_DOCTOR = "{CALL deleteDoctor(?)}";
    private static final String ADD_DOCTOR_PATIENT = "{CALL addDoctorPatient (?,?)}";

    private static final String ADD_INVOICE = "{CALL addInvoice (?,?)}";
    private static final String ADD_INVOICE_SUM = "{CALL addInvoiceSum (?,?)}";
    private static final String GET_ITEMS_PER_INVOICE = "{CALL getItemsPerInvoice(?)}";
    private static final String GET_INVOICE = "{CALL getInvoice(?)}";
    private static final String GET_INVOICE_O = "{CALL getInvoiceO(?,?)}";

    private static final String GET_PATIENT_O = "{CALL getPatientO(?,?)}";

    private static final String ADD_ITEM = "{CALL addItem (?,?,?,?)}";
    private static final String GET_ITEMS_PER_PATIENT = "{CALL getItemsPerPatient(?)}";
    private static final String ADD_FUTURE_APPOINTEMENT = "{CALL addFutureAppointemnt (?,?,?)}";

    //report
    private static final String GET_PATIENTS_PER_DOCTOR = "{CALL getPatientsPerDoctor(?,?)}";
    private static final String GET_NO_OF_PATIENTS_SEEN_BY_VARIOUS_DOCTORS = "{CALL getNoOfPatientsSeenByVariousDoctors(?)}";
    private static final String GET_NO_OF_FOLLOWUP_PATIENTS_FOR_PERIOD = "{CALL getNoOfFollowUpPatientsForPeriod(?,?,?)}";
    private static final String GET_NO_OF_FOLLOWUP_PATIENTS = "{CALL getNoOfFollowUpPatients(?)}";
    private static final String GET_AVG_NUMBER_OF_PATIENTS_PER_DOCTOR = "{CALL getAvgnumberOfPatientPerDoctor(?,?)}";
    private static final String GET_NO_OF_NEW_PATIENTS = "{CALL getNoOfNewPatients(?)}";
    private static final String GET_NO_OF_NEW_PATIENTS_FOR_PERIOD = "{CALL getNoOfNewPatientsForPeriod(?,?)}";
    private static final String ITEMS_SUMMARY_FOR_PATIENT = "{CALL itemsSummaryForPatient(?,?)}";
    private static final String GET_NO_OF_PATIENTS_TREATED_BY_DOCTOR = "{CALL getNoOfPatientsTreatedByDoctor(?,?,?)}";

    private final DataSource ds = DataSourceSingleton.getInstance();

    @Override
    public void addDoctor(Doctor doctor) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(ADD_DOCTOR);) {
            stmt.setString(1, doctor.getFirstName());
            stmt.setString(2, doctor.getMiddleName());
            stmt.setString(3, doctor.getSurname());
            stmt.setInt(4, doctor.getPresentAddress().getIdAddress());
            stmt.setInt(5, doctor.getContact().getIdContact());
            stmt.setBoolean(6, doctor.isAvailable());

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void editDoctor(Doctor doctor) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(EDIT_DOCTOR);) {
            stmt.setInt(1, doctor.getId());
            stmt.setString(2, doctor.getFirstName());
            stmt.setString(3, doctor.getMiddleName());
            stmt.setString(4, doctor.getSurname());
            stmt.setInt(5, doctor.getPresentAddress().getIdAddress());
            stmt.setInt(6, doctor.getContact().getIdContact());
            stmt.setBoolean(7, doctor.isAvailable());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Doctor> getDoctors() {
        List<Doctor> list = new ArrayList<>();

        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_DOCTORS);
                ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {

                list.add(new Doctor(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        getAddress(rs.getInt(5)),
                        getContact(rs.getInt(6)),
                        rs.getBoolean(7)
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Doctor getDoctor(int idDoctor) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_DOCTOR);) {
            stmt.setInt(1, idDoctor);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Doctor(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            getAddress(rs.getInt(5)),
                            getContact(rs.getInt(6)),
                            rs.getBoolean(7)
                    );
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void addNextOfKin(NextOfKin nextOfKin) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(ADD_NEXTOFKIN);) {
            stmt.setString(1, nextOfKin.getFirstName());
            stmt.setString(2, nextOfKin.getMiddleName());
            stmt.setString(3, nextOfKin.getSurname());
            stmt.setInt(4, nextOfKin.getPresentAddress().getIdAddress());
            stmt.setInt(5, nextOfKin.getRelationship().getIdRelationship());
            stmt.setInt(6, nextOfKin.getContact().getIdContact());

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addEmergencyNextOfKin(NextOfKin nextOfKin) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(ADD_EMERGENCY_NEXTOFKIN);) {
            stmt.setString(1, nextOfKin.getFirstName());
            stmt.setString(2, nextOfKin.getMiddleName());
            stmt.setString(3, nextOfKin.getSurname());
            stmt.setInt(4, nextOfKin.getRelationship().getIdRelationship());

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void editNextOfKin(NextOfKin nextOfKin) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(EDIT_NEXTOFKIN);) {
            stmt.setString(1, nextOfKin.getFirstName());
            stmt.setString(2, nextOfKin.getMiddleName());
            stmt.setString(3, nextOfKin.getSurname());
            stmt.setInt(4, nextOfKin.getPresentAddress().getIdAddress());
            stmt.setInt(5, nextOfKin.getRelationship().getIdRelationship());
            stmt.setInt(6, nextOfKin.getContact().getIdContact());
            stmt.setInt(7, nextOfKin.getId());

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<NextOfKin> getNextOfKins() {
        List<NextOfKin> list = new ArrayList<>();

        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_NEXTOFKINS);
                ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {

                list.add(new NextOfKin(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        getAddress(rs.getInt(5)),
                        getRelationship(rs.getInt(6)),
                        getContact(rs.getInt(7))
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public NextOfKin getNextOfKin(int idNextOfKin) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_NEXTOFKIN);) {
            stmt.setInt(1, idNextOfKin);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new NextOfKin(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            getAddress(rs.getInt(5)),
                            getRelationship(rs.getInt(6)),
                            getContact(rs.getInt(7))
                    );
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void addMedicalPersonnel(MedicalPersonnel medicalPersonnel) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(ADD_MEDICAL_PERSONNEL);) {
            stmt.setString(1, medicalPersonnel.getFirstName());
            stmt.setString(2, medicalPersonnel.getMiddleName());
            stmt.setString(3, medicalPersonnel.getSurname());
            stmt.setInt(4, medicalPersonnel.getPresentAddress().getIdAddress());
            stmt.setInt(5, medicalPersonnel.getContact().getIdContact());
            stmt.setInt(6, medicalPersonnel.getOccupation().getIdOccupation());

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void editMedicalPersonnel(MedicalPersonnel medicalPersonnel) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(EDIT_MEDICAL_PERSONNEL);) {
            stmt.setString(1, medicalPersonnel.getFirstName());
            stmt.setString(2, medicalPersonnel.getMiddleName());
            stmt.setString(3, medicalPersonnel.getSurname());
            stmt.setInt(4, medicalPersonnel.getPresentAddress().getIdAddress());
            stmt.setInt(5, medicalPersonnel.getContact().getIdContact());
            stmt.setInt(6, medicalPersonnel.getOccupation().getIdOccupation());
            stmt.setInt(7, medicalPersonnel.getId());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public MedicalPersonnel getMedicalPersonnel(int idMedicalPersonnel) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_MEDICAL_PERSONNEL);) {
            stmt.setInt(1, idMedicalPersonnel);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new MedicalPersonnel(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            getAddress(rs.getInt(5)),
                            getContact(rs.getInt(6)),
                            getOccupation(rs.getInt(7))
                    );
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<MedicalPersonnel> getMedicalPersonnels() {
        List<MedicalPersonnel> list = new ArrayList<>();

        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_MEDICAL_PERSONNELS);
                ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {

                list.add(new MedicalPersonnel(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        getAddress(rs.getInt(5)),
                        getContact(rs.getInt(6)),
                        getOccupation(rs.getInt(7))
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void addEmergencyPatient(Patient patient) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(ADD_EMERGENCY_PATIENT);) {
            stmt.setString(1, patient.getFirstName());
            stmt.setString(2, patient.getMiddleName());
            stmt.setString(3, patient.getSurname());
            stmt.setInt(4, patient.getSex().getIdSex());
            stmt.setDate(5, patient.getDateOfBirth());
            stmt.setInt(6, patient.getContact().getIdContact());
            stmt.setInt(7, patient.getNextOfKin().getId());
            stmt.setString(8, patient.getStatementOfComplaint());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addPatient(Patient patient) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(ADD_PATIENT);) {
            stmt.setString(1, patient.getFirstName());
            stmt.setString(2, patient.getMiddleName());
            stmt.setString(3, patient.getSurname());
            stmt.setInt(4, patient.getSex().getIdSex());
            stmt.setDate(5, patient.getDateOfBirth());
            stmt.setInt(6, patient.getPresentAddress().getIdAddress());
            stmt.setInt(7, patient.getPermanentAddress().getIdAddress());
            stmt.setInt(8, patient.getContact().getIdContact());
            stmt.setInt(9, patient.getNextOfKin().getId());
            stmt.setInt(10, patient.getMaritalStatus().getIdMaritalStatus());
            stmt.setInt(11, patient.getNoOfDependents());
            stmt.setInt(12, patient.getHeight());
            stmt.setInt(13, patient.getWeight());
            stmt.setInt(14, patient.getBloodType().getIdBloodType());
            stmt.setInt(15, patient.getOccupation().getIdOccupation());
            stmt.setDouble(16, patient.getGrossAnnualIncome());
            stmt.setBoolean(17, patient.isVegetarian());
            stmt.setBoolean(18, patient.isSmoker());
            stmt.setInt(19, patient.getNoCigarettesADay());
            stmt.setBoolean(20, patient.isConsumesAlcohol());
            stmt.setInt(21, patient.getNoDrinksADay());
            stmt.setString(22, patient.getStimulants());
            stmt.setInt(23, patient.getCoffeeTeaDay());
            stmt.setInt(24, patient.getSoftDrinksDay());
            stmt.setString(25, patient.getRegularMeals());
            stmt.setBoolean(26, patient.isHomeFood());
            stmt.setString(27, patient.getStatementOfComplaint());
            stmt.setString(28, patient.getPreviousTreatments());
            stmt.setString(29, patient.getPhysicianHospitalTreated());
            stmt.setString(30, patient.getDiabetic());
            stmt.setString(31, patient.getHypertensive());
            stmt.setString(32, patient.getCardiacCondition());
            stmt.setString(33, patient.getRespiratoryCondition());
            stmt.setString(34, patient.getDigestiveCondition());
            stmt.setString(35, patient.getOrthopedicCondtion());
            stmt.setString(36, patient.getMuscularCondition());
            stmt.setString(37, patient.getKnownAllergies());
            stmt.setString(38, patient.getKnownReactionToSpecificDrug());
            stmt.setString(39, patient.getMajorSurgeriesHistory());

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void editPatient(Patient patient) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(EDIT_PATIENT);) {
            stmt.setString(1, patient.getFirstName());
            stmt.setString(2, patient.getMiddleName());
            stmt.setString(3, patient.getSurname());
            stmt.setInt(4, patient.getSex().getIdSex());
            stmt.setDate(5, patient.getDateOfBirth());
            stmt.setInt(6, patient.getPresentAddress().getIdAddress());
            stmt.setInt(7, patient.getPermanentAddress().getIdAddress());
            stmt.setInt(8, patient.getContact().getIdContact());
            stmt.setInt(9, patient.getNextOfKin().getId());
            stmt.setInt(10, patient.getMaritalStatus().getIdMaritalStatus());
            stmt.setInt(11, patient.getNoOfDependents());
            stmt.setInt(12, patient.getHeight());
            stmt.setInt(13, patient.getWeight());
            stmt.setInt(14, patient.getBloodType().getIdBloodType());
            stmt.setInt(15, patient.getOccupation().getIdOccupation());
            stmt.setDouble(16, patient.getGrossAnnualIncome());
            stmt.setBoolean(17, patient.isVegetarian());
            stmt.setBoolean(18, patient.isSmoker());
            stmt.setInt(19, patient.getNoCigarettesADay());
            stmt.setBoolean(20, patient.isConsumesAlcohol());
            stmt.setInt(21, patient.getNoDrinksADay());
            stmt.setString(22, patient.getStimulants());
            stmt.setInt(23, patient.getCoffeeTeaDay());
            stmt.setInt(24, patient.getSoftDrinksDay());
            stmt.setString(25, patient.getRegularMeals());
            stmt.setBoolean(26, patient.isHomeFood());
            stmt.setString(27, patient.getStatementOfComplaint());
            stmt.setString(28, patient.getPreviousTreatments());
            stmt.setString(29, patient.getPhysicianHospitalTreated());
            stmt.setString(30, patient.getDiabetic());
            stmt.setString(31, patient.getHypertensive());
            stmt.setString(32, patient.getCardiacCondition());
            stmt.setString(33, patient.getRespiratoryCondition());
            stmt.setString(34, patient.getDigestiveCondition());
            stmt.setString(35, patient.getOrthopedicCondtion());
            stmt.setString(36, patient.getMuscularCondition());
            stmt.setString(37, patient.getKnownAllergies());
            stmt.setString(38, patient.getKnownReactionToSpecificDrug());
            stmt.setString(39, patient.getMajorSurgeriesHistory());
            stmt.setInt(40, patient.getId());

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Patient getPatient(int idPatient) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_PATIENT);) {
            stmt.setInt(1, idPatient);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Patient(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            getSex(rs.getInt(5)),
                            rs.getDate(6),
                            getAddress(rs.getInt(7)),
                            getAddress(rs.getInt(8)),
                            getContact(rs.getInt(9)),
                            getNextOfKin(rs.getInt(10)),
                            getMaritalStatus(rs.getInt(11)),
                            rs.getInt(12),
                            rs.getInt(13),
                            rs.getInt(14),
                            getBloodType(rs.getInt(15)),
                            getOccupation(rs.getInt(16)),
                            rs.getDouble(17),
                            rs.getBoolean(18),
                            rs.getBoolean(19),
                            rs.getInt(20),
                            rs.getBoolean(21),
                            rs.getInt(22),
                            rs.getString(23),
                            rs.getInt(24),
                            rs.getInt(25),
                            rs.getString(26),
                            rs.getBoolean(27),
                            rs.getString(28),
                            rs.getString(29),
                            rs.getString(30),
                            rs.getString(31),
                            rs.getString(32),
                            rs.getString(33),
                            rs.getString(34),
                            rs.getString(35),
                            rs.getString(36),
                            rs.getString(37),
                            rs.getString(38),
                            rs.getString(39),
                            rs.getString(40),
                            rs.getDate(41)
                    );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Patient> getPatients() {
        List<Patient> list = new ArrayList<>();

        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_PATIENTS);
                ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {

                list.add(new Patient(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        getSex(rs.getInt(5)),
                        rs.getDate(6),
                        getAddress(rs.getInt(7)),
                        getAddress(rs.getInt(8)),
                        getContact(rs.getInt(9)),
                        getNextOfKin(rs.getInt(10)),
                        getMaritalStatus(rs.getInt(11)),
                        rs.getInt(12),
                        rs.getInt(13),
                        rs.getInt(14),
                        getBloodType(rs.getInt(15)),
                        getOccupation(rs.getInt(16)),
                        rs.getDouble(17),
                        rs.getBoolean(18),
                        rs.getBoolean(19),
                        rs.getInt(20),
                        rs.getBoolean(21),
                        rs.getInt(22),
                        rs.getString(23),
                        rs.getInt(24),
                        rs.getInt(25),
                        rs.getString(26),
                        rs.getBoolean(27),
                        rs.getString(28),
                        rs.getString(29),
                        rs.getString(30),
                        rs.getString(31),
                        rs.getString(32),
                        rs.getString(33),
                        rs.getString(34),
                        rs.getString(35),
                        rs.getString(36),
                        rs.getString(37),
                        rs.getString(38),
                        rs.getString(39),
                        rs.getString(40),
                        rs.getDate(41)
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Sex> getSexes() {
        List<Sex> list = new ArrayList<>();

        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_SEXES);
                ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {

                list.add(new Sex(
                        rs.getInt(1),
                        rs.getString(2)
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Sex getSex(int idSex) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_SEX);) {
            stmt.setInt(1, idSex);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Sex(
                            rs.getInt(1),
                            rs.getString(2)
                    );
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<BloodType> getBloodTypes() {
        List<BloodType> list = new ArrayList<>();

        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_BLOODTYPES);
                ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {

                list.add(new BloodType(
                        rs.getInt(1),
                        rs.getString(2)
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public BloodType getBloodType(int idBloodType) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_BLOODTYPE);) {
            stmt.setInt(1, idBloodType);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new BloodType(
                            rs.getInt(1),
                            rs.getString(2)
                    );
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<PaymentType> getPaymentTypes() {
        List<PaymentType> list = new ArrayList<>();

        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_PAYMENTTYPES);
                ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {

                list.add(new PaymentType(
                        rs.getInt(1),
                        rs.getString(2)
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public PaymentType getPaymentType(int idPaymentType) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_PAYMENTTYPE);) {
            stmt.setInt(1, idPaymentType);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new PaymentType(
                            rs.getInt(1),
                            rs.getString(2)
                    );
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Medicine> getMedicines() {
        List<Medicine> list = new ArrayList<>();

        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_MEDICINES);
                ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {

                list.add(new Medicine(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3)
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Medicine getMedicine(int idMedicine) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_MEDICINE);) {
            stmt.setInt(1, idMedicine);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Medicine(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getDouble(3)
                    );
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Test> getTests() {
        List<Test> list = new ArrayList<>();

        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_TESTS);
                ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {

                list.add(new Test(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3)
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Test getTest(int idTest) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_TEST);) {
            stmt.setInt(1, idTest);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Test(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getDouble(3)
                    );
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Consultation> getConsultations() {
        List<Consultation> list = new ArrayList<>();

        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_CONSULTATIONS);
                ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {

                list.add(new Consultation(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3)
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Consultation getConsultation(int idConsultation) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_CONSULTATION);) {
            stmt.setInt(1, idConsultation);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Consultation(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getDouble(3)
                    );
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void addAddress(Address address) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(ADD_ADDRESS);) {
            stmt.setString(1, address.getStreet());
            stmt.setString(2, address.getDoorNo());
            stmt.setInt(3, address.getPincode().getIdPincode());

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void editAddress(Address address) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(EDIT_ADDRESS);) {
            stmt.setString(1, address.getStreet());
            stmt.setString(2, address.getDoorNo());
            stmt.setInt(3, address.getPincode().getIdPincode());
            stmt.setInt(4, address.getIdAddress());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Address getAddress(int idAddress) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_ADDRESS);) {
            stmt.setInt(1, idAddress);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Address(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            getPincode(rs.getInt(4))
                    );
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void addContact(Contact contact) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(ADD_CONTACT);) {
            stmt.setString(1, contact.getContactDetail());
            stmt.setInt(2, contact.getContactType().getIdContactType());

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void editContact(Contact contact) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(EDIT_CONTACT);) {
            stmt.setString(1, contact.getContactDetail());
            stmt.setInt(2, contact.getContactType().getIdContactType());
            stmt.setInt(3, contact.getIdContact());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Contact getContact(int idContact) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_CONTACT);) {
            stmt.setInt(1, idContact);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Contact(
                            rs.getInt(1),
                            rs.getString(2),
                            getContactType(3)
                    );
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ContactType getContactType(int idContactType) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_CONTACT_TYPE);) {
            stmt.setInt(1, idContactType);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new ContactType(
                            rs.getInt(1),
                            rs.getString(2)
                    );
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<ContactType> getContactTypes() {
        List<ContactType> list = new ArrayList<>();

        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_CONTACT_TYPES);
                ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {

                list.add(new ContactType(
                        rs.getInt(1),
                        rs.getString(2)
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Pincode getPincode(int idPincode) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_PINCODE);) {
            stmt.setInt(1, idPincode);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Pincode(
                            rs.getInt(1),
                            rs.getString(2),
                            getCity(3),
                            rs.getString(4)
                    );
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Pincode> getPincodes() {
        List<Pincode> list = new ArrayList<>();

        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_PINCODES);
                ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {

                list.add(new Pincode(
                        rs.getInt(1),
                        rs.getString(2),
                        getCity(3),
                        rs.getString(4)
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public City getCity(int idCity) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_CITY);) {
            stmt.setInt(1, idCity);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new City(
                            rs.getInt(1),
                            rs.getString(2),
                            getState(3)
                    );
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<City> geCities() {
        List<City> list = new ArrayList<>();

        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_CITIES);
                ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {

                list.add(new City(
                        rs.getInt(1),
                        rs.getString(2),
                        getState(3)
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<State> getStates() {
        List<State> list = new ArrayList<>();

        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_STATES);
                ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {

                list.add(new State(
                        rs.getInt(1),
                        rs.getString(2)
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public State getState(int idState) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_STATE);) {
            stmt.setInt(1, idState);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new State(
                            rs.getInt(1),
                            rs.getString(2)
                    );
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Occupation> geOccupations() {
        List<Occupation> list = new ArrayList<>();

        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_OCCUPATIONS);
                ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {

                list.add(new Occupation(
                        rs.getInt(1),
                        rs.getString(2)
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Occupation getOccupation(int idOccupation) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_OCCUPATION);) {
            stmt.setInt(1, idOccupation);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Occupation(
                            rs.getInt(1),
                            rs.getString(2)
                    );
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Relationship> getRelationships() {
        List<Relationship> list = new ArrayList<>();

        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_RELATIONSHIPS);
                ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {

                list.add(new Relationship(
                        rs.getInt(1),
                        rs.getString(2)
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Relationship getRelationship(int idRelationship) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_RELATIONSHIP);) {
            stmt.setInt(1, idRelationship);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Relationship(
                            rs.getInt(1),
                            rs.getString(2)
                    );
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<MaritalStatus> getMaritalStatuses() {
        List<MaritalStatus> list = new ArrayList<>();

        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_MARITAL_STATUSES);
                ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {

                list.add(new MaritalStatus(
                        rs.getInt(1),
                        rs.getString(2)
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public MaritalStatus getMaritalStatus(int idMaritalStatus) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_MARITAL_STATUS);) {
            stmt.setInt(1, idMaritalStatus);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new MaritalStatus(
                            rs.getInt(1),
                            rs.getString(2)
                    );
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public NextOfKin getNextOfKin(NextOfKin kin) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_NEXTOFKIN_O);) {
            stmt.setString(1, kin.getFirstName());
            stmt.setString(2, kin.getSurname());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new NextOfKin(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            getAddress(5),
                            getRelationship(6),
                            getContact(7)
                    );
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Contact getContact(Contact contact) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_CONTACT_O);) {
            stmt.setString(1, contact.getContactDetail());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Contact(
                            rs.getInt(1),
                            rs.getString(2),
                            getContactType(3)
                    );
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Address getAddress(Address address) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_ADDRESS_O);) {
            stmt.setString(1, address.getStreet());
            stmt.setString(2, address.getDoorNo());
            stmt.setInt(3, address.getPincode().getIdPincode());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Address(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            getPincode(rs.getInt(4))
                    );
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void addInvoice(Invoice invoice) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(ADD_INVOICE);) {
            stmt.setInt(1, invoice.getPatient().getId());
            stmt.setInt(2, invoice.getPaymentType().getIdPaymentType());

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addInvoiceSum(Invoice invoice) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(ADD_INVOICE_SUM);) {
            stmt.setDouble(1, invoice.getSum());
            stmt.setInt(2, invoice.getIdInvoice());

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Item> getItemsPerInvoice(Invoice invoice) {
        List<Item> list = new ArrayList<>();

        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_ITEMS_PER_INVOICE);) {
            stmt.setInt(1, invoice.getIdInvoice());
            try (ResultSet rs = stmt.executeQuery();) {

                while (rs.next()) {

                    list.add(new Item(
                            rs.getInt(1),
                            getInvoice(rs.getInt(2)),
                            getMedicine(rs.getInt(3)),
                            getTest(rs.getInt(4)),
                            getConsultation(rs.getInt(5)),
                            getPatient(rs.getInt(6)),
                            rs.getDate(7)
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Invoice getInvoice(int idInvoice) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_INVOICE);) {
            stmt.setInt(1, idInvoice);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Invoice(
                            rs.getInt(1),
                            rs.getString(2),
                            getPatient(rs.getInt(3)),
                            getPaymentType(rs.getInt(4)),
                            rs.getDouble(5),
                            rs.getDate(6)
                    );
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Invoice getInvoice(Invoice invoice) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_INVOICE_O);) {
            stmt.setDate(1, invoice.getDate());
            stmt.setInt(2, invoice.getPatient().getId());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Invoice(
                            rs.getInt(1),
                            rs.getString(2),
                            getPatient(rs.getInt(3)),
                            getPaymentType(rs.getInt(4)),
                            rs.getDouble(5),
                            rs.getDate(6)
                    );
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public List<DoctorPatient> getPatientsPerDoctor(int idDoctor) {
        List<DoctorPatient> list = new ArrayList<>();

        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_PATIENTS_PER_DOCTOR);) {
            stmt.setInt(1, idDoctor);
            try (ResultSet rs = stmt.executeQuery();) {

                while (rs.next()) {

                    list.add(new DoctorPatient(
                            rs.getInt(1),
                            getDoctor(rs.getInt(2)),
                            getPatient(rs.getInt(3)),
                            rs.getDate(4)
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public int getNoOfPatientsSeenByVariousDoctors(Date date) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_NO_OF_PATIENTS_SEEN_BY_VARIOUS_DOCTORS);) {
            stmt.setDate(1, date);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);

                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int getNoOfFollowUpPatients(Date date) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_NO_OF_FOLLOWUP_PATIENTS);) {
            stmt.setDate(1, date);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);

                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int getNoOfFollowUpPatientsForPeriod(Date today, Date dateStart, Date dateEnd) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_NO_OF_FOLLOWUP_PATIENTS_FOR_PERIOD);) {
            stmt.setDate(1, today);
            stmt.setDate(2, dateStart);
            stmt.setDate(3, dateEnd);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);

                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public HashMap<Integer, Integer> getAvgnumberOfPatientPerDoctor(Date dateStart, Date dateEnd) {
        HashMap<Integer, Integer> map = new HashMap<>();

        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_AVG_NUMBER_OF_PATIENTS_PER_DOCTOR);) {
            stmt.setDate(1, dateStart);
            stmt.setDate(2, dateStart);
            try (ResultSet rs = stmt.executeQuery();) {

                while (rs.next()) {

                    map.put(rs.getInt(1), rs.getInt(2));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

    @Override
    public int getNoOfNewPatients(Date today) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_NO_OF_NEW_PATIENTS);) {
            stmt.setDate(1, today);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);

                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int getNoOfNewPatientsForPeriod(Date dateStart, Date dateEnd) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_NO_OF_NEW_PATIENTS_FOR_PERIOD);) {
            stmt.setDate(1, dateStart);
            stmt.setDate(2, dateEnd);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);

                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Integer> itemsSummaryForPatient(int idPatient, Date today) {
        List<Integer> list = new ArrayList<>();

        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(ITEMS_SUMMARY_FOR_PATIENT);) {
            stmt.setInt(1, idPatient);
            try (ResultSet rs = stmt.executeQuery();) {

                list.add(rs.getInt(1));
                list.add(rs.getInt(2));
                list.add(rs.getInt(3));

            }
        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public int getNoOfPatientsTreatedByDoctor(int idDoctor, Date dateStart, Date dateEnd) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_NO_OF_PATIENTS_TREATED_BY_DOCTOR);) {
            stmt.setInt(1, idDoctor);
            stmt.setDate(2, dateStart);
            stmt.setDate(3, dateEnd);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);

                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Patient getPatient(Patient patient) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_PATIENT_O);) {
            stmt.setString(1, patient.getFirstName());
            stmt.setString(2, patient.getSurname());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Patient(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            getSex(rs.getInt(5)),
                            rs.getDate(6),
                            getAddress(rs.getInt(7)),
                            getAddress(rs.getInt(8)),
                            getContact(rs.getInt(9)),
                            getNextOfKin(rs.getInt(10)),
                            getMaritalStatus(rs.getInt(11)),
                            rs.getInt(12),
                            rs.getInt(13),
                            rs.getInt(14),
                            getBloodType(rs.getInt(15)),
                            getOccupation(rs.getInt(16)),
                            rs.getDouble(17),
                            rs.getBoolean(18),
                            rs.getBoolean(19),
                            rs.getInt(20),
                            rs.getBoolean(21),
                            rs.getInt(22),
                            rs.getString(23),
                            rs.getInt(24),
                            rs.getInt(25),
                            rs.getString(26),
                            rs.getBoolean(27),
                            rs.getString(28),
                            rs.getString(29),
                            rs.getString(30),
                            rs.getString(31),
                            rs.getString(32),
                            rs.getString(33),
                            rs.getString(34),
                            rs.getString(35),
                            rs.getString(36),
                            rs.getString(37),
                            rs.getString(38),
                            rs.getString(39),
                            rs.getString(40),
                            rs.getDate(41)
                    );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addItem(Item item) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(ADD_ITEM);) {
            stmt.setInt(1, item.getMedicine().getIdMedicine());
            stmt.setInt(2, item.getTest().getIdTest());
            stmt.setInt(3, item.getConsultation().getIdConsultation());
            stmt.setInt(4, item.getPatient().getId());

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Item> getItemsPerPatient(Patient patient) {
        List<Item> list = new ArrayList<>();

        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_ITEMS_PER_PATIENT);) {
            stmt.setInt(1, patient.getId());
            try (ResultSet rs = stmt.executeQuery();) {
                while (rs.next()) {
                    list.add(new Item(
                            rs.getInt(1),
                            // getInvoice(rs.getInt(2)),
                            getMedicine(rs.getInt(3)),
                            getTest(rs.getInt(4)),
                            getConsultation(rs.getInt(5)),
                            patient,
                            rs.getDate(7)
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }

        return list;

    }

    @Override
    public void deleteMedicalPersonnel(int idMedicalPersonnel) {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (
                Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_MEDICAL_PERSONNEL);) {
            stmt.setInt(1, idMedicalPersonnel);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDoctor(int idDoctor) {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (
                Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_DOCTOR);) {
            stmt.setInt(1, idDoctor);
            try (ResultSet rs = stmt.executeQuery()) {
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addFutureAppointement(Patient patient, Doctor doctor, Date date) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(ADD_FUTURE_APPOINTEMENT);) {
            stmt.setInt(1, patient.getId());
            stmt.setInt(2, doctor.getId());
            stmt.setDate(3, date);

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<DoctorPatient> getDoctorsPerPatient(int idPatient) {
        List<DoctorPatient> list = new ArrayList<>();

        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(GET_DOCTORS_PER_PATIENT);) {
            stmt.setInt(1, idPatient);
            try (ResultSet rs = stmt.executeQuery();) {
                while (rs.next()) {
                    list.add(new DoctorPatient(
                            rs.getInt(1),
                            getDoctor(rs.getInt(3)),
                            getPatient(idPatient),
                            rs.getDate(4)
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }

        return list;

    }

    @Override
    public void addDoctorPatient(int idPatient, int idDoctor) {
        try (
                Connection con = ds.getConnection();
                CallableStatement stmt = con.prepareCall(ADD_DOCTOR_PATIENT);) {
            stmt.setInt(1, idDoctor);
            stmt.setInt(2, idPatient);

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
