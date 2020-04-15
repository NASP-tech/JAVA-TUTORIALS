package com.NASP.x00120319;

//Extends means inheritance relationship
//Button one is subclass and the one that extends is superclass
public class Main extends ex2{

    String name;

    //This is an object
    public void sayName(){
        System.out.println("My name!");
    }
    //Polymorphism: multiple methods with the same name

    public void sayName(String name){
        System.out.println("My name is " + name);
    }
    //Overriding same method
    public void sayHi(){

    }
    public static void main(String[] args){
        Main e1 = new Main();
        e1.sayHi();
    }

    //Encapsulation access modifiers
    String flavor;

    public void openBag(){
        System.out.println("Bag is opened!");
    }

    //Setter and getters
    public void setFlavor(String newFlavor){
        flavor = newFlavor;
    }
    public String getFlavor(){
        return flavor;
    }

}
