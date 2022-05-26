package com.example;

public class Main {
    public static void main(String[] args) {


        MobilePhone mobilePhone = new MobilePhone("4196891061");
        Contact devin = Contact.createContact("Devin", "4196891061");
        Contact carrie = Contact.createContact("Carrie", "4196895678");
        Contact carrie2 = Contact.createContact("Carrie", "4196895678");

//        add contacts test
        mobilePhone.addNewContact(devin);
        mobilePhone.addNewContact(carrie);

//        remove contact test
        mobilePhone.removeContact(carrie);

//        update contact test
        mobilePhone.updateContact(devin, carrie);

//        query contact test
//        System.out.println(mobilePhone.queryContact("Carrie"));


        mobilePhone.addNewContact(carrie2);


//        print contact test
        mobilePhone.printContacts();

    }
}
