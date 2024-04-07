package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static int getSum(int a, int b){
        return a + b;
    }
    public static void testGetSum(){
        System.out.println(getSum(0,0) == 0);
        System.out.println(getSum(5,5) == 10);
        System.out.println(getSum(100_000_000,100000000) == 200000000);
        System.out.println(getSum(-5,-5) == -10);
    }

    public static void main(String[] args) {
        testGetSum();
    }
}