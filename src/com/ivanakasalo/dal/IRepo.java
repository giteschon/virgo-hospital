/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanakasalo.dal;

import com.ivanakasalo.model.*;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Ivana
 */
public interface IRepo {

    public void addDoctor(Doctor doctor);

    public void editDoctor(Doctor doctor);

    public List<Doctor> getDoctors();

    public Doctor getDoctor(int idDoctor);

    public void addNextOfKin(NextOfKin nextOfKin);

    public void addEmergencyNextOfKin(NextOfKin nextOfKin);

    public void editNextOfKin(NextOfKin nextOfKin);

    public List<NextOfKin> getNextOfKins();

    public NextOfKin getNextOfKin(int idNextOfKin);

    public NextOfKin getNextOfKin(NextOfKin kin);

    public void addMedicalPersonnel(MedicalPersonnel medicalPersonnel);

    public void editMedicalPersonnel(MedicalPersonnel medicalPersonnel);

    public MedicalPersonnel getMedicalPersonnel(int idMedicalPersonnel);

    public List<MedicalPersonnel> getMedicalPersonnels();

    public void addEmergencyPatient(Patient patient);

    public void addPatient(Patient patient);

    public void editPatient(Patient patient);

    public Patient getPatient(int idPatient);

    public List<Patient> getPatients();

    public void addAddress(Address address);

    public void editAddress(Address address);

    public Address getAddress(int idAddress);

    public Address getAddress(Address Address);

    public void addContact(Contact contact);

    public void editContact(Contact contact);

    public Contact getContact(int idContact);

    public Contact getContact(Contact contact);

    public ContactType getContactType(int idContactType);

    public List<ContactType> getContactTypes();

    public Pincode getPincode(int idPincode);

    public List<Pincode> getPincodes();

    public City getCity(int idCity);

    public List<City> geCities();

    public List<Sex> getSexes();

    public Sex getSex(int idSex);

    public List<BloodType> getBloodTypes();

    public BloodType getBloodType(int idBloodType);

    public List<PaymentType> getPaymentTypes();

    public PaymentType getPaymentType(int idPaymentType);

    public List<Medicine> getMedicines();

    public Medicine getMedicine(int idMedicine);

    public List<Test> getTests();

    public Test getTest(int idTest);

    public List<Consultation> getConsultations();

    public Consultation getConsultation(int idConsultation);

    public List<State> getStates();

    public State getState(int idState);

    public List<Occupation> geOccupations();

    public Occupation getOccupation(int idOccupation);

    public List<Relationship> getRelationships();

    public Relationship getRelationship(int idRelationship);

    public List<MaritalStatus> getMaritalStatuses();

    public MaritalStatus getMaritalStatus(int idMaritalStatus);

    public void addInvoice(Invoice invoice);

    public void addInvoiceSum(Invoice invoice);

    public Invoice getInvoice(int idInvoice);

    public Invoice getInvoice(Invoice invoice);

    public List<Item> getItemsPerInvoice(Invoice invoice);

    public void addItem(Item item);

    public List<DoctorPatient> getPatientsPerDoctor(int idDoctor);

    public int getNoOfPatientsSeenByVariousDoctors(Date date);

    public int getNoOfFollowUpPatients(Date date);

    public int getNoOfFollowUpPatientsForPeriod(Date today, Date dateStart, Date dateEnd);

    public HashMap<Integer, Integer> getAvgnumberOfPatientPerDoctor(Date dateStart, Date dateEnd);

    public int getNoOfNewPatients(Date today);

    public int getNoOfNewPatientsForPeriod(Date dateStart, Date dateEnd);

    public List<Integer> itemsSummaryForPatient(int idPatient, Date today);

    public int getNoOfPatientsTreatedByDoctor(int idDoctor, Date dateStart, Date dateEnd);

    public Patient getPatient(Patient patient);

    public List<Item> getItemsPerPatient(Patient patient);

    public void deleteMedicalPersonnel(int idMedicalPersonnel);

    public void deleteDoctor(int idDoctor);

    public void addFutureAppointement(Patient patient, Doctor doctor, Date date);

    public List<DoctorPatient> getDoctorsPerPatient(int idPatient);

    public void addDoctorPatient(int idPatient, int idDoctor);

}
