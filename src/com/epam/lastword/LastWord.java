package com.epam.lastword;

public class LastWord {
    public static void main(String[] args) {
        String s = ("Spring is coming in a few months");
        String[] sArray;
        sArray = s.split(" ");
        for (int i=0;i<=sArray.length;i++) {
            if (i==sArray.length-1){
                String str = sArray[i];
                System.out.println(str.length());
            }
        }





    }
}
