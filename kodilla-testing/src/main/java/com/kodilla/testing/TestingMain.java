package com.kodilla.testing;
import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;


public class TestingMain {
    public static void main(String[] args){
        SimpleUser user =new SimpleUser("theForumUser");
        String result = user.getUserName();

        if(result.equals("theForumUser")) {
            System.out.println("test OK");
        } else{
            System.out.println("ERROR!");
        }
        //Test jednostkowy klasy calculator
        System.out.println("Test - pierwszy test jednostkowy:");
        Calculator calc = new Calculator();
        int a=5;
        int b=3;
        int sum = calc.add(a,b);
        int sub = calc.substract(a,b);
        //Test add()
        if(a+b==sum){
            System.out.println("Metod add() : Test OK");
        }else{
            System.out.println("Metod add() : ERROR!");
        }
        //Test substract()
        if(a-b==sub){
            System.out.println("Metod substract() : Test OK");
        }else{
            System.out.println("Metod substract() : ERROR!");
        }
    }
}
