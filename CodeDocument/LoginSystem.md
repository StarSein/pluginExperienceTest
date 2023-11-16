# [Class] LoginSystem
* * *
## 1. Code Review
> 본 코드는 이미 클린 코드에 기반하여 작성되어 있고, 보완할 점은 없습니다.


## 2. Navigation
* [Source Code](#3-source-code)
* [main(String[] args)](#5-mainstring[]-args)

## 3. Source Code
<details><summary> Commented Code </summary><div markdown="1">

## Commented Code
* * *
 ```java 

//이 코드는 로그인 시스템을 구현하는 데 사용되며, 사용자로부터 입력 받은 사용자 이름과 비밀번호를 기존의 정확한 사용자 이름과 비밀번호와 비교하여 로그인 성공 여부를 반환합니다. 사용자가 올바른 사용자 이름과 비밀번호를 입력하면 "로그인 성공!" 메시지와 함께 환영 메시지를 출력하고, 그렇지 않으면 "로그인 실패. 사용자 이름 또는 비밀번호가 올바르지 않습니다."라는 메시지를 출력합니다.
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


 ``` 
</div></details><details><summary> Clean Code </summary><div markdown="1">

## Clean Code
* * *
 ```java 
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
 ``` 
</div></details>

## 4. Member Fields
member number | type | variable name 
:-:|:---:|:---:
1 |`String`|`CORRECT_USERNAME`
2 |`String`|`CORRECT_PASSWORD`


## 5. main(String[] args)
* * *
### Return Type
- `null`
### Parameter Type
param number | type | variable name 
:-:|:---:|:---:
1 |`String[]`|`args`

* * *
