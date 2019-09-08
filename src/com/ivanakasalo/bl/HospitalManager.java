/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanakasalo.bl;

import com.ivanakasalo.dal.*;
import com.ivanakasalo.model.*;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Ivana
 */
public class HospitalManager implements IManager {

    private final IRepo repo = RepoFactory.getRepo();

    @Override
    public void addDoctor(Doctor doctor) {
        repo.addDoctor(doctor);
    }

    @Override
    public void editDoctor(Doctor doctor) {
        repo.editDoctor(doctor);
    }

    @Override
    public List<Doctor> getDoctors() {
        return repo.getDoctors();
    }

    @Override
    public Doctor getDoctor(int idDoctor) {
        return repo.getDoctor(idDoctor);
    }

    @Override
    public synchronized void addNextOfKin(NextOfKin nextOfKin) {
        repo.addNextOfKin(nextOfKin);
    }

    @Override
    public void editNextOfKin(NextOfKin nextOfKin) {
        repo.editNextOfKin(nextOfKin);
    }

    @Override
    public List<NextOfKin> getNextOfKins() {
        return repo.getNextOfKins();
    }

    @Override
    public NextOfKin getNextOfKin(int idNextOfKin) {
        return repo.getNextOfKin(idNextOfKin);
    }

    @Override
    public void addMedicalPersonnel(MedicalPersonnel medicalPersonnel) {
        repo.addMedicalPersonnel(medicalPersonnel);
    }

    @Override
    public void editMedicalPersonnel(MedicalPersonnel medicalPersonnel) {
        repo.editMedicalPersonnel(medicalPersonnel);
    }

    @Override
    public MedicalPersonnel getMedicalPersonnel(int idMedicalPersonnel) {
        return repo.getMedicalPersonnel(idMedicalPersonnel);
    }

    @Override
    public List<MedicalPersonnel> getMedicalPersonnels() {
        return repo.getMedicalPersonnels();
    }

    @Override
    public synchronized void addEmergencyPatient(Patient patient) {
        repo.addEmergencyPatient(patient);
    }

    @Override
    public void addPatient(Patient patient) {
        repo.addPatient(patient);
    }

    @Override
    public void editPatient(Patient patient) {
        repo.editPatient(patient);
    }

    @Override
    public Patient getPatient(int idPatient) {
        return repo.getPatient(idPatient);
    }

    @Override
    public List<Patient> getPatients() {
        return repo.getPatients();
    }

    @Override
    public void addAddress(Address address) {
        repo.addAddress(address);
    }

    @Override
    public void editAddress(Address address) {
        repo.editAddress(address);
    }

    @Override
    public Address getAddress(int idAddress) {
        return repo.getAddress(idAddress);
    }

    @Override
    public void addContact(Contact contact) {
        repo.addContact(contact);
    }

    @Override
    public void editContact(Contact contact) {
        repo.editContact(contact);
    }

    @Override
    public Contact getContact(int idContact) {
        return repo.getContact(idContact);
    }

    @Override
    public ContactType getContactType(int idContactType) {
        return repo.getContactType(idContactType);
    }

    @Override
    public List<ContactType> getContactTypes() {
        return repo.getContactTypes();
    }

    @Override
    public Pincode getPincode(int idPincode) {
        return repo.getPincode(idPincode);
    }

    @Override
    public List<Pincode> getPincodes() {
        return repo.getPincodes();
    }

    @Override
    public City getCity(int idCity) {
        return repo.getCity(idCity);
    }

    @Override
    public List<City> geCities() {
        return repo.geCities();
    }

    @Override
    public List<Sex> getSexes() {
        return repo.getSexes();
    }

    @Override
    public Sex getSex(int idSex) {
        return repo.getSex(idSex);
    }

    @Override
    public List<BloodType> getBloodTypes() {
        return repo.getBloodTypes();
    }

    @Override
    public BloodType getBloodType(int idBloodType) {
        return repo.getBloodType(idBloodType);
    }

    @Override
    public List<PaymentType> getPaymentTypes() {
        return repo.getPaymentTypes();
    }

    @Override
    public PaymentType getPaymentType(int idPaymentType) {
        return repo.getPaymentType(idPaymentType);
    }

    @Override
    public List<Medicine> getMedicines() {
        return repo.getMedicines();
    }

    @Override
    public Medicine getMedicine(int idMedicine) {
        return repo.getMedicine(idMedicine);
    }

    @Override
    public List<Test> getTests() {
        return repo.getTests();
    }

    @Override
    public Test getTest(int idTest) {
        return repo.getTest(idTest);
    }

    @Override
    public List<Consultation> getConsultations() {
        return repo.getConsultations();
    }

    @Override
    public Consultation getConsultation(int idConsultation) {
        return repo.getConsultation(idConsultation);
    }

    @Override
    public List<State> getStates() {
        return repo.getStates();
    }

    @Override
    public State getState(int idState) {
        return repo.getState(idState);
    }

    @Override
    public List<Occupation> getOccupations() {
        return repo.geOccupations();
    }

    @Override
    public Occupation getOccupation(int idOccupation) {
        return repo.getOccupation(idOccupation);
    }

    @Override
    public List<Relationship> getRelationships() {
        return repo.getRelationships();
    }

    @Override
    public Relationship getRelationship(int idRelationship) {
        return repo.getRelationship(idRelationship);
    }

    @Override
    public void addEmergencyNextOfKin(NextOfKin nextOfKin) {
        repo.addEmergencyNextOfKin(nextOfKin);
    }

    @Override
    public List<MaritalStatus> getMaritalStatuses() {
        return repo.getMaritalStatuses();
    }

    @Override
    public MaritalStatus getMaritalStatus(int idMaritalStatus) {
        return repo.getMaritalStatus(idMaritalStatus);
    }

    @Override
    public NextOfKin getNextOfKin(NextOfKin kin) {
        return repo.getNextOfKin(kin);
    }

    @Override
    public Contact getContact(Contact contact) {
        return repo.getContact(contact);
    }

    @Override
    public Address getAddress(Address Address) {
        return repo.getAddress(Address);
    }

    @Override
    public void addInvoice(Invoice invoice) {
        repo.addInvoice(invoice);
    }

    @Override
    public void addInvoiceSum(Invoice invoice) {
        repo.addInvoiceSum(invoice);
    }

    @Override
    public List<Item> getItemsPerInvoice(Invoice invoice) {
        return repo.getItemsPerInvoice(invoice);
    }

    @Override
    public Invoice getInvoice(int idInvoice) {
        return repo.getInvoice(idInvoice);
    }

    @Override
    public Invoice getInvoice(Invoice invoice) {
        return repo.getInvoice(invoice);
    }

    @Override
    public List<DoctorPatient> getPatientsPerDoctor(int idDoctor) {
        return repo.getPatientsPerDoctor(idDoctor);
    }

    @Override
    public int getNoOfPatientsSeenByVariousDoctors(Date date) {
        return repo.getNoOfPatientsSeenByVariousDoctors(date);
    }

    @Override
    public int getNoOfFollowUpPatients(Date date) {
        return repo.getNoOfFollowUpPatients(date);
    }

    @Override
    public int getNoOfFollowUpPatientsForPeriod(Date today, Date dateStart, Date dateEnd) {
        return repo.getNoOfFollowUpPatientsForPeriod(today, dateStart, dateEnd);
    }

    @Override
    public HashMap<Integer, Integer> getAvgnumberOfPatientPerDoctor(Date dateStart, Date dateEnd) {
        return repo.getAvgnumberOfPatientPerDoctor(dateStart, dateEnd);
    }

    @Override
    public int getNoOfNewPatients(Date today) {
        return repo.getNoOfNewPatients(today);
    }

    @Override
    public int getNoOfNewPatientsForPeriod(Date dateStart, Date dateEnd) {
        return repo.getNoOfNewPatientsForPeriod(dateStart, dateEnd);
    }

    @Override
    public List<Integer> itemsSummaryForPatient(int idPatient, Date today) {
        return repo.itemsSummaryForPatient(idPatient, today);
    }

    @Override
    public int getNoOfPatientsTreatedByDoctor(int idDoctor, Date dateStart, Date dateEnd) {
        return repo.getNoOfPatientsTreatedByDoctor(idDoctor, dateStart, dateEnd);
    }

    @Override
    public Patient getPatient(Patient patient) {
        return repo.getPatient(patient);
    }

    @Override
    public void addItem(Item item) {
        repo.addItem(item);
    }

    @Override
    public List<Item> getItemsPerPatient(Patient patient) {
        return repo.getItemsPerPatient(patient);
    }

    @Override
    public void deleteMedicalPersonnel(int idMedicalPersonnel) {
        repo.deleteMedicalPersonnel(idMedicalPersonnel);
    }

    @Override
    public void deleteDoctor(int idDoctor) {
        repo.deleteDoctor(idDoctor);
    }

    @Override
    public void addFutureAppointement(Patient patient, Doctor doctor, Date date) {
        repo.addFutureAppointement(patient, doctor, date);
    }

    @Override
    public List<DoctorPatient> getDoctorsPerPatient(int idPatient) {
        return repo.getDoctorsPerPatient(idPatient);
    }

    @Override
    public void addDoctorPatient(int idPatient, int idDoctor) {
        repo.addDoctorPatient(idPatient, idDoctor);
    }

}
