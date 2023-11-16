# [Class] Calculator
* * *
## 1. Code Review
> 코드 자체는 간단하고 이해하기 쉬우며, 클린 코드 규칙에도 일치합니다. 리뷰할 부분은 없습니다.


## 2. Navigation
* [Source Code](#3-source-code)
* [main(String[] args)](#5-mainstring[]-args)

## 3. Source Code
<details><summary> Commented Code </summary><div markdown="1">

## Commented Code
* * *
 ```java 

//이 코드는 간단한 계산기를 만들기 위한 코드입니다. 사용자로부터 두 개의 숫자를 입력받고, 연산 종류를 선택하면 해당 연산을 수행한 결과를 출력합니다. 사용자가 잘못된 입력을 할 경우에는 오류 메시지를 출력합니다.
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
