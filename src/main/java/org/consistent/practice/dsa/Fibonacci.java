package org.consistent.practice.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fibonacci {
    public static void main(String[] args) {
        ArrayList<Integer> res = new ArrayList<>();
        int n =2;
//        res.add(0);
        fib(n,res);
        System.out.println(res);
    }

    public static void fib(int n,ArrayList<Integer> res) {

        if(res.size()>n)
            return;
        if (n == 0){
            res.add(0);
        }
        else if (n == 1){
            res.add(1);
        }else{
            fib(n-1,res);
            res.add(res.get(n-1) + res.get(n-2));
        }
//        fib(n-1,res);
//        int sum = 0;
//        if (res.size()>=1) {
//            sum +=res.get(res.size()-1);
//        }
//        if (res.size()>=2) {
//            sum +=res.get(res.size()-2);
//        }
//        res.add(sum);
    }
}
