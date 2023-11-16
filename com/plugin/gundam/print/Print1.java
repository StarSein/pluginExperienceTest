package com.plugin.gundam.print;

public class Print1 {

    String str1;
    int m;

    public void printMap1(){
        for (int i=0;i<2;i++){
            for (int j=0;j<5;j++){
                System.out.println("*");
            }
            System.out.println("\n");
        }
    }
    public void printMap2(){ //printMap1과 동일한 함수
        for (int i=0;i<2;i++){
            for (int j=0;j<5;j++){
                System.out.println("*");
            }
            System.out.println("\n");
        }
    }
    public void printMa3(){ //printMap1이 두번 반복되는 함수
        for (int i=0;i<2;i++){
            for (int j=0;j<5;j++){
                System.out.println("*");
            }
            System.out.println("\n");
        }

        for (int i=0;i<2;i++){
            for (int j=0;j<5;j++){
                System.out.println("*");
            }
            System.out.println("\n");
        }
    }
}
