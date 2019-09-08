/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanakasalo.console;

import com.ivanakasalo.bl.HospitalManager;
import com.ivanakasalo.bl.IManager;
import com.ivanakasalo.model.*;

/**
 *
 * @author Ivy
 */
public class ConsoleVirgoHospital {

    private static final int MAX_OPTION = 5;

    private IManager manager = new HospitalManager();

    public ConsoleVirgoHospital() {
        start();
    }

    private void start() {
        System.out.println("MENU");
        System.out.println("Choose Action (pick a number");
        System.out.println("1. Add Emergency Patient");
        System.out.println("2. Add Medical Personnel");
        System.out.println("3. View Medical Personnel");
        System.out.println("4. Exit");

        System.out.println("Your choice: ");

        int choice = 0;
        do {
            choice = ConsoleUtilities.readInt(System.in);
        } while (choice > MAX_OPTION || choice < 0);

        openChoice(choice);

    }

    private void openChoice(int choice) {

        switch (choice) {
            case 1:
                openEmergencyPatient();
                break;
            case 2:
                openAddDoctor();
                break;
            case 3:
                openMedicalPersonnels();
                break;
            case 4:
                Runtime.getRuntime().exit(0);
                break;

        }

    }

    private void openEmergencyPatient() {
        try {
            Patient patient = new Patient();
            System.out.println("Add emergency patient");
            System.out.println("First name:");
            patient.setFirstName(ConsoleUtilities.readString(System.in));

            System.out.println("Middle name:");
            patient.setMiddleName(ConsoleUtilities.readString(System.in));

            System.out.println("Surname name:");
            patient.setSurname(ConsoleUtilities.readString(System.in));

            int id;
            do {
                System.out.println("Sex::");
                for (int i = 0; i < manager.getSexes().size(); i++) {
                    System.out.println((i + 1) + ": " + manager.getSexes().get(i).getSex());
                }
                id = ConsoleUtilities.readInt(System.in);
                Sex sex = manager.getSex(id);
                patient.setSex(sex);
            } while (id < 1 || id > 3);

            System.out.println("Statemtnt of complaint:");
            patient.setStatementOfComplaint(ConsoleUtilities.readString(System.in));

            System.out.println("Telephone number:");
            Contact contact = new Contact(ConsoleUtilities.readString(System.in), manager.getContactType(1));

            NextOfKin kin = new NextOfKin();
            System.out.println("Next of Kin First name:");
            kin.setFirstName(ConsoleUtilities.readString(System.in));

            System.out.println("Next of Kin Middle name:");
            kin.setMiddleName(ConsoleUtilities.readString(System.in));

            System.out.println("Next of Kin Surname name:");
            kin.setSurname(ConsoleUtilities.readString(System.in));

            System.out.println("Relationship with Patient:");
            for (int i = 0; i < manager.getRelationships().size(); i++) {
                System.out.println((i + 1) + ": " + manager.getRelationships().get(i).getName());
            }

            kin.setRelationship(manager.getRelationship(ConsoleUtilities.readInt(System.in)));

            manager.addContact(contact);
            manager.addEmergencyNextOfKin(kin);

            patient.setNextOfKin(manager.getNextOfKin(kin));
            patient.setContact(manager.getContact(contact));
            manager.addEmergencyPatient(patient);

            start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void openMedicalPersonnels() {
        System.out.println("This is a list od employed medical personnel");
        System.out.println("");

        for (MedicalPersonnel medicalPersonnel : manager.getMedicalPersonnels()) {
            System.out.println(medicalPersonnel.toString());
        }

        start();
    }

    private void openAddDoctor() {
        int id;

        MedicalPersonnel medicalPersonnel = new MedicalPersonnel();
        Address address = new Address();

        System.out.println("Add new Medical Personnel");

        System.out.println("First name:");
        medicalPersonnel.setFirstName(ConsoleUtilities.readString(System.in));

        System.out.println("Middle name:");
        medicalPersonnel.setMiddleName(ConsoleUtilities.readString(System.in));

        System.out.println("Surname name:");
        medicalPersonnel.setSurname(ConsoleUtilities.readString(System.in));

        System.out.println("Address");
        System.out.println("Street:");
        address.setStreet(ConsoleUtilities.readString(System.in));
        System.out.println("Door No:");
        address.setDoorNo(ConsoleUtilities.readString(System.in));

        do {
            System.out.println("Pincode");
            for (int i = 0; i < manager.getPincodes().size(); i++) {
                System.out.println((i + 1) + ": " + manager.getPincodes().get(i).getValue() + ", " + manager.getPincodes().get(i).getCity().getName());
            }

            id = ConsoleUtilities.readInt(System.in);
            Pincode pincode = manager.getPincode(id);
            address.setPincode(pincode);
        } while (id < 0 || id > manager.getPincodes().size());

        System.out.println("Telephone number:");
        Contact contact = new Contact(ConsoleUtilities.readString(System.in), manager.getContactType(1));
        medicalPersonnel.setContact(contact);

        do {
            System.out.println("Occupation");
            for (int i = 0; i < manager.getOccupations().size(); i++) {
                System.out.println((i + 1) + ": " + manager.getOccupations().get(i).getOccupation());
            }
            id = ConsoleUtilities.readInt(System.in);
            Occupation occupation = manager.getOccupation(id);
            medicalPersonnel.setOccupation(occupation);
        } while (id < 0 || id > manager.getOccupations().size());

        manager.addAddress(address);
        manager.addContact(contact);

        medicalPersonnel.setPresentAddress(manager.getAddress(address));
        medicalPersonnel.setContact(manager.getContact(contact));
        manager.addMedicalPersonnel(medicalPersonnel);

        start();

    }

}
