package com.company;

public class Bai2 {
    public static double tong(double[] n){
        double result = 0;
        for (int i = 0; i < n.length; i++) {
            result = result + n[i];
        }
        return result;
    }
     static int sum1(int[] a, int i)
    {
        if(i == 0){
            return a[0];
        }

        int kq = a[i] + sum1(a,i -1);
        return kq;
    }

    public static void main(String[] args) {
        int [] s = {1,2,3,4,5,6,7,8,9};
        double [] s1 = {1,2,3,4,5,6,7,8,9};
        System.out.print(sum1(s,8));
//        System.out.println(tong( s1));
    }
}
