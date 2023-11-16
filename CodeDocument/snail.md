# [Class] snail
* * *
## 1. Code Review
> 코드 자체는 문제의 요구사항에 맞게 달팽이 배열을 생성하는 알고리즘을 잘 구현하고 있습니다. 다만, 코드의 가독성을 높이기 위해 변수와 메소드의 이름을 조금 더 명확하게 작성하는 것이 좋을 것 같습니다.


## 2. Navigation
* [Source Code](#3-source-code)
* [main(String[] args)](#5-mainstring[]-args)
* [right()](#6-right)
* [down()](#7-down)
* [left()](#8-left)
* [up()](#9-up)

## 3. Source Code
<details><summary> Commented Code </summary><div markdown="1">

## Commented Code
* * *
 ```java 

//이 코드는 달팽이 배열을 생성하는 알고리즘입니다. 사용자로부터 정수 T를 입력받아 T번 반복하며, 각 반복마다 달팽이 배열을 생성하여 출력합니다. 달팽이 배열은 1부터 num * num까지의 숫자가 오른쪽, 아래쪽, 왼쪽, 위쪽 방향으로 차례대로 채워진 배열입니다.
public class snail {
    static int v=1;
    static int r =0;
    static int c=-1;
    static int num;
    static int [][] arr;
    public static void main(String[] args) throws Exception {

        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(b.readLine());
        for(int i=1;i<=T;i++) {
            num = Integer.parseInt(b.readLine());
            arr = new int[num][num];

            r=0;
            c=-1;
            v=1;


            while(v <= num*num) {
                if(right()) break;
                if(down()) break;
                if(left())break;
                if(up())break;


            }
            System.out.println("# "+i);
            for(int a =0;a<num;a++){
                for(int j =0;j<num;j++){
                    System.out.print(arr[a][j]+" ");
                }
                System.out.println();
            }



        }

    }
    static boolean right() { //처음 위치포함
        while(true) {
            c++;
            //System.out.println(c);
            if(c>=num || arr[r][c] != 0) {
                c--;
                return false;
            }else {
                arr[r][c] = v;

                v++;

            }

            if(v == num*num+1) {return true;}
        }

    }
    static boolean down() { //처음 위치포함
        while(true) {
            r++;
            if(r>=num || arr[r][c] != 0) {
                r--;
                return false;
            }else {
                arr[r][c] = v;
                v++;
            }
            if(v == num*num+1) {return true;}
        }

    }
    static boolean left() { //처음 위치포함
        while(true) {
            c--;
            if(c<0 || arr[r][c] != 0) {
                c++;
                return false;
            }else {
                arr[r][c] = v;
                v++;
            }
            if(v == num*num+1) {return true;}
        }

    }
    static boolean up() { //처음 위치포함
        while(true) {
            r--;
            if(r<0 || arr[r][c] != 0) {
                r++;

                return false;
            }else {
                arr[r][c] = v;
                v++;
            }
            if(v == num*num+1) {return true;}
        }

    }


}

 ``` 
</div></details><details><summary> Clean Code </summary><div markdown="1">

## Clean Code
* * *
 ```java 
public class Snail {
    static int v = 1;
    static int r = 0;
    static int c = -1;
    static int num;
    static int [][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 1; i <= T; i++) {
            num = Integer.parseInt(br.readLine());
            arr = new int[num][num];

            r = 0;
            c = -1;
            v = 1;

            while(v <= num * num) {
                if(moveRight()) break;
                if(moveDown()) break;
                if(moveLeft()) break;
                if(moveUp()) break;
            }

            System.out.println("# " + i);
            for(int a = 0; a < num; a++) {
                for(int j = 0; j < num; j++) {
                    System.out.print(arr[a][j] + " ");
                }
                System.out.println();
            }
        }
    }

    static boolean moveRight() {
        while(true) {
            c++;
            if(c >= num || arr[r][c] != 0) {
                c--;
                return false;
            }else {
                arr[r][c] = v;
                v++;
            }

            if(v == num * num + 1) {
                return true;
            }
        }
    }

    static boolean moveDown() {
        while(true) {
            r++;
            if(r >= num || arr[r][c] != 0) {
                r--;
                return false;
            }else {
                arr[r][c] = v;
                v++;
            }
            if(v == num * num + 1) {
                return true;
            }
        }
    }

    static boolean moveLeft() {
        while(true) {
            c--;
            if(c < 0 || arr[r][c] != 0) {
                c++;
                return false;
            }else {
                arr[r][c] = v;
                v++;
            }
            if(v == num * num + 1) {
                return true;
            }
        }
    }

    static boolean moveUp() {
        while(true) {
            r--;
            if(r < 0 || arr[r][c] != 0) {
                r++;
                return false;
            }else {
                arr[r][c] = v;
                v++;
            }
            if(v == num * num + 1) {
                return true;
            }
        }
    }
}
 ``` 
</div></details>

## 4. Member Fields
member number | type | variable name 
:-:|:---:|:---:
1 |`int`|`v`
2 |`int`|`r`
3 |`int`|`c`
4 |`int`|`num`
5 |`int[][]`|`arr`


## 5. main(String[] args)
* * *
### Return Type
- `null`
### Parameter Type
param number | type | variable name 
:-:|:---:|:---:
1 |`String[]`|`args`

## 6. right()
* * *
### Return Type
- `null`
### Parameter Type
param number | type | variable name 
:-:|:---:|:---:

## 7. down()
* * *
### Return Type
- `null`
### Parameter Type
param number | type | variable name 
:-:|:---:|:---:

## 8. left()
* * *
### Return Type
- `null`
### Parameter Type
param number | type | variable name 
:-:|:---:|:---:

## 9. up()
* * *
### Return Type
- `null`
### Parameter Type
param number | type | variable name 
:-:|:---:|:---:

* * *
