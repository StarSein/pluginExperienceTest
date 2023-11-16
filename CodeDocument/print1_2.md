# [Class] Print1
* * *
## 1. Code Review
> - `Print1` 클래스의 멤버 변수인 `str1`과 `m`은 사용되지 않고 있으므로 삭제할 수 있습니다.
> - `printMap2`와 `printMap3` 메소드는 `printMap1`을 호출하고 있으므로, 중복된 코드를 피하기 위해 `printMap1` 메소드를 호출하도록 수정하였습니다.


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

//이 코드는 `Print1` 클래스에 세 개의 메소드를 포함하고 있습니다. 
//- `printMap1` 메소드는 2x5 크기의 맵을 출력하는 역할을 합니다. 
//- `printMap2` 메소드는 `printMap1`과 동일한 역할을 수행합니다.
//- `printMap3` 메소드는 `printMap1`이 두 번 반복되는 역할을 수행합니다.
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

    public void printMap1(){
        for (int i=0;i<2;i++){
            for (int j=0;j<5;j++){
                System.out.println("*");
            }
            System.out.println("\n");
        }
    }
    
    public void printMap2(){ 
        printMap1();
    }
    
    public void printMap3(){ 
        printMap1();
        printMap1();
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
