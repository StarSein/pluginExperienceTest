# [Class] Print1
* * *
## 1. Code Review
> 코드의 가독성이나 재사용성을 고려한다면, printMap1과 printMap2는 중복되는 코드를 사용하고 있어 중복 부분을 하나의 함수로 추출하여 사용하는 것이 좋습니다. 또한, 반복 횟수와 출력 내용을 함수의 인자로 받아서 가변적으로 처리하는 것이 더 유연한 코드를 작성할 수 있습니다.


## 2. Navigation
* [Source Code](#3-source-code)
* [printMap1()](#5-printmap1)
* [printMap2()](#6-printmap2)
* [printMa3()](#7-printma3)

## 3. Source Code
<details><summary> Commented Code </summary><div markdown="1">

## Commented Code
* * *
 ```java 

//위의 코드는 Print1 클래스 내부에 printMap1, printMap2, printMap3 함수가 정의되어 있습니다. 각 함수는 별표("*")를 출력하고 개행 문자("\n")를 출력하는 반복문으로 구성되어 있습니다. printMap1은 반복문이 1회 실행되고, printMap2는 printMap1과 동일한 내용을 가지며 반복문이 2회 실행됩니다. printMap3는 printMap1이 두 번 반복 실행되는 내용입니다.
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

 ``` 
</div></details><details><summary> Clean Code </summary><div markdown="1">

## Clean Code
* * *
 ```java 
public class Print1 {

    String str1;
    int m;

    public void printMap(int row, int col){ // 반복 횟수와 출력 내용을 인자로 받는 함수
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                System.out.println("*");
            }
            System.out.println("\n");
        }
    }

    public void printMap2(){
        printMap(2, 5); // printMap 함수를 호출하여 사용
    }

    public void printMa3(){
        printMap(2, 5); // printMap 함수를 호출하여 사용
        printMap(2, 5); // printMap 함수를 호출하여 사용
    }
}
 ``` 
</div></details>

## 4. Member Fields
member number | type | variable name 
:-:|:---:|:---:
1 |`String`|`str1`
2 |`int`|`m`


## 5. printMap1()
* * *
### Return Type
- `null`
### Parameter Type
param number | type | variable name 
:-:|:---:|:---:

## 6. printMap2()
* * *
### Return Type
- `null`
### Parameter Type
param number | type | variable name 
:-:|:---:|:---:

## 7. printMa3()
* * *
### Return Type
- `null`
### Parameter Type
param number | type | variable name 
:-:|:---:|:---:

* * *
