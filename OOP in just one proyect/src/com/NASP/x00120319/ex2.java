package com.NASP.x00120319;

//Other type of polymorphism is overriding
public class ex2 {
    public void sayHi(){
        System.out.println("Say hi!");
    }

    public static void main(String[] args){
        Main e1 = new Main();
        e1.setFlavor("Beef");
        System.out.println(e1.getFlavor());
    }
}
