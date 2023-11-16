package com.plugin.gundam.util;
import java.util.Scanner;
public class Calculator {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("첫 번째 숫자를 입력하세요:");
        int num1 = scanner.nextInt();

        System.out.println("두 번째 숫자를 입력하세요:");
        int num2 = scanner.nextInt();

        System.out.println("연산을 선택하세요 (1: 덧셈, 2: 뺄셈, 3: 곱셈, 4: 나눗셈):");
        int operation = scanner.nextInt();

        int result = 0;
        if (operation == 1) {
            result = num1 + num2;
        } else if (operation == 2) {
            result = num1 - num2;
        } else if (operation == 3) {
            result = num1 * num2;
        } else if (operation == 4) {
            if (num2 != 0) {
                result = num1 / num2;
            } else {
                System.out.println("0으로 나눌 수 없습니다.");
                return;
            }
        } else {
            System.out.println("올바른 연산을 선택하세요.");
            return;
        }

        System.out.println("결과: " + result);
    }


}
