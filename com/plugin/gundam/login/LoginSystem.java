package com.plugin.gundam.login;

import java.util.Scanner;
public class LoginSystem {
    private static final String CORRECT_USERNAME = "admin";
    private static final String CORRECT_PASSWORD = "admin123";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("사용자 이름을 입력하세요: ");
        String inputUsername = scanner.nextLine();

        System.out.print("비밀번호를 입력하세요: ");
        String inputPassword = scanner.nextLine();

        if (inputUsername.equals(CORRECT_USERNAME) && inputPassword.equals(CORRECT_PASSWORD)) {
            System.out.println("로그인 성공!");
            System.out.println("환영합니다, " + CORRECT_USERNAME + "님.");
        } else {
            System.out.println("로그인 실패. 사용자 이름 또는 비밀번호가 올바르지 않습니다.");
        }
    }
}

