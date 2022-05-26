package com.example;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    //constructor
    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact) {
        int position = findContact(contact);
        String name = contact.getName();
        if(position >= 0 || findContact(name) >= 0) {
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean removeContact(Contact contact) {
        if(findContact(contact) >= 0) {
            myContacts.remove(contact);
            return true;
        }
        return false;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int position = findContact(oldContact);
        if(position >= 0) {
            myContacts.set(position, newContact);
            return true;
        }
        return false;
    }

    public Contact queryContact(String name) {
        int position = findContact(name);
        if(position >= 0) {
            return myContacts.get(position);
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Contact List:");
        for (int i = 0; i < myContacts.size(); i++) {
            System.out.println((i + 1) + ". " + myContacts.get(i).getName() + " -> " + myContacts.get(i).getPhoneNumber());
        }
    }

    //find contact methods

    private int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    private int findContact(String name) {
        for(int i = 0; i < myContacts.size(); i++){
            String contactName = myContacts.get(i).getName();
            if(contactName == name) {
                return i;
            }
        }
        return -1;
    }

}
