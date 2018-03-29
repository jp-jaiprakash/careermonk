package in.jaiprakash.chp4;

import java.util.Scanner;

public class TestDynamicArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements you want to enter");
        int n = sc.nextInt();
        DynArrayStack dynArrayStack = new DynArrayStack();
        while( n> 0){
            int i = sc.nextInt();
            dynArrayStack.push(i);
            n--;
        }
        dynArrayStack.printStack();
    }
}
