package com.example;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.toggleDoubleSided();
        printer.printPage(6);
        printer.printPage(7);
        printer.addPaper(20);
    }
}
