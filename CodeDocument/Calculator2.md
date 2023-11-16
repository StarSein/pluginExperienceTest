# [Class] Calculator
* * *
## 1. Code Review
> 데이터 전달 방식 오류


## 2. Navigation
* [Source Code](#3-source-code)
* [main(String[] args)](#5-mainstring[]-args)

## 3. Source Code
<details><summary> Commented Code </summary><div markdown="1">

## Commented Code
* * *
 ```java 

//이 코드는 사용자로부터 두 개의 숫자와 연산 종류를 입력받아 해당 연산을 수행하고 결과를 출력하는 계산기 프로그램입니다. 
//
//사용자로부터 첫 번째 숫자와 두 번째 숫자, 연산 종류를 입력받기 위해 Scanner 클래스를 사용합니다. 
//- 첫 번째 숫자를 입력받기 위해 "첫 번째 숫자를 입력하세요:"라는 안내 문구를 출력한 후, 사용자로부터 정수 값을 입력받습니다.
//- 두 번째 숫자를 입력받기 위해 "두 번째 숫자를 입력하세요:"라는 안내 문구를 출력한 후, 사용자로부터 정수 값을 입력받습니다.
//- 연산 종류를 입력받기 위해 "연산을 선택하세요 (1: 덧셈, 2: 뺄셈, 3: 곱셈, 4: 나눗셈):"라는 안내 문구를 출력한 후, 사용자로부터 정수 값을 입력받습니다.
//
//입력받은 첫 번째 숫자와 두 번째 숫자, 연산 종류를 바탕으로 계산을 수행합니다.
//- 결과 값을 저장할 변수인 result를 0으로 초기화합니다.
//- 연산 종류에 따라 다음과 같은 계산을 수행합니다.
//  - 연산 종류가 1일 경우, result에 num1과 num2를 더한 값을 저장합니다.
//  - 연산 종류가 2일 경우, result에 num1에서 num2를 뺀 값을 저장합니다.
//  - 연산 종류가 3일 경우, result에 num1과 num2를 곱한 값을 저장합니다.
//  - 연산 종류가 4일 경우, num2가 0이 아닌 경우에만 result에 num1을 num2로 나눈 값을 저장합니다. num2가 0인 경우에는 "0으로 나눌 수 없습니다."라는 메시지를 출력하고 함수를 종료합니다.
//  - 연산 종류가 1, 2, 3, 4에 해당하지 않는 경우에는 "올바른 연산을 선택하세요."라는 메시지를 출력하고 함수를 종료합니다.
//
//계산 결과를 출력합니다.
//- "결과: "라는 문구와 result 값을 결합하여 출력합니다.
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

 ``` 
</div></details><details><summary> Clean Code </summary><div markdown="1">

## Clean Code
* * *
 ```java 
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
 ``` 
</div></details>

## 4. Member Fields
member number | type | variable name 
:-:|:---:|:---:


## 5. main(String[] args)
* * *
### Return Type
- `null`
### Parameter Type
param number | type | variable name 
:-:|:---:|:---:
1 |`String[]`|`args`

* * *
