package com.example;

public class Main {
    public static void main(String[] args) {
        //write code below
        GroceryList groceryList = new GroceryList();
        groceryList.addGroceryItem("potatoes");
        groceryList.addGroceryItem("corn");
        groceryList.printGroceryList();
        groceryList.modifyGroceryItem(1, "olives");
        groceryList.printGroceryList();
    }
}
