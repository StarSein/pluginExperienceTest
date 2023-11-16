# [Class] MyGundamTest
* * *
## 1. Code Review
> 주어진 코드에서 개선할 점은 다음과 같습니다.
> - 클래스와 필드의 접근 제어자를 명시적으로 지정해야 합니다.
> - 주석으로 코드의 기능과 작동 방식을 더 자세히 설명해야 합니다.
> - 사용되지 않는 import문을 정리해야 합니다.
> - 상수 이름인 LIMIT_LEN은 모두 대문자로 작성해야 합니다.
> - 정적 변수인 colors를 상수로 선언하고, 배열을 별도의 라인에 초기화하는 것이 좋습니다.
> - showDialog 메서드에서 dialog.dispose() 호출 부분이 주석 처리되어 있습니다. 이 부분을 주석 해제해야 합니다.
> - getDir 메서드에서 좌표 및 각도 계산에 관한 주석 설명이 필요합니다.
> - print 메서드에서 "*"을 출력하는 부분은 for문의 인덱스 변수 i와 j를 활용하여 출력해야 합니다.
>


## 2. Navigation
* [Source Code](#3-source-code)
* [show()](#5-show)
* [getDir(Point startPoint, Point endPoint)](#6-getdirpoint-startpoint-point-endpoint)
* [print()](#7-print)

## 3. Source Code
<details><summary> Commented Code </summary><div markdown="1">

## Commented Code
* * *
 ```java 

//이 코드는 MyGundamTest 클래스를 정의하고, 해당 클래스에는 다양한 필드와 메서드가 포함되어 있습니다. 코드의 목적은 주어진 조건에 따라 코드를 리뷰하고, 클린 코드 규칙을 적용하여 수정하는 것입니다.
public class MyGundamTest {
    public int ProjectCount;
    public String[] ProjectName;
    public String description;
    private static final int LIMIT_LEN = 20;
    Color[] colors = {new Color(246, 86, 86),
            new Color(86, 91, 180),
            new Color(54, 122, 67),
            new Color(117, 133, 42)};

    public void show(){
        JDialog dialog = new JDialog();
        dialog.setSize(50, 50);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Set the title bar to null to hide it
        dialog.setUndecorated(true);

        JLabel label = new JLabel("This is a dialog with no title.");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        dialog.add(label);
        dialog.setVisible(true);
        //dialog.dispose();

    }

    public static char getDir(Point startPoint, Point endPoint) {
        double y = -endPoint.y + startPoint.y;

        double x = endPoint.x - startPoint.x;

        double len = Math.sqrt(y * y + x * x);

        if (len < LIMIT_LEN) return 'X';

        y /= len;
        x /= len;

        double deg = Math.atan2(y, x) * 180 / Math.PI;

        if (deg >= 45 && deg < 135) return 'U';
        else if (deg < -45 && deg >= -135) return 'D';
        else if (deg >= 135 || deg < -135) return 'L';
        else if (deg >= -45 || deg < 45) return 'R';
        return 'X';
    }

    public void print(){
        for(int i=0;i<5;i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println("*");
            }
        }
    }

}

 ``` 
</div></details><details><summary> Clean Code </summary><div markdown="1">

## Clean Code
* * *
 ```java 
 public class MyGundamTest {
     private static final int LIMIT_LEN = 20;
     private int projectCount;
     private String[] projectName;
     private String description;
     private Color[] colors = {
                     new Color(246, 86, 86),
         new Color(86, 91, 180),
         new Color(54, 122, 67),
         new Color(117, 133, 42)
     };

             public void show() {
                 JDialog dialog = new JDialog();
                 dialog.setSize(50, 50);
                 dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
                 // 타이틀 바를 숨기기 위해 null로 설정
                 dialog.setUndecorated(true);
        
                 JLabel label = new JLabel("This is a dialog with no title.");
                 label.setHorizontalAlignment(SwingConstants.CENTER);
        
                 dialog.add(label);
                 dialog.setVisible(true);
                 dialog.dispose();
             }
        
             public static char getDir(Point startPoint, Point endPoint) {
                 double y = -endPoint.y + startPoint.y;
                 double x = endPoint.x - startPoint.x;
                 double len = Math.sqrt(y * y + x * x);
        
                 if (len < LIMIT_LEN) return 'X';
        
                 y /= len;
                 x /= len;
        
                 double deg = Math.atan2(y, x) * 180 / Math.PI;
        
                 if (deg >= 45 && deg < 135) return 'U';
                 else if (deg < -45 && deg >= -135) return 'D';
                 else if (deg >= 135 || deg < -135) return 'L';
                 else if (deg >= -45 || deg < 45) return 'R';
                 return 'X';
             }
        
             public void print() {
                 for (int i = 0; i < 5; i++) {
                     for (int j = 0; j < 5; j++) {
                         System.out.print("*");
                     }
                     System.out.println();
                 }
             }
         }
 ``` 
</div></details>

## 4. Member Fields
member number | type | variable name 
:-:|:---:|:---:
1 |`int`|`ProjectCount`
2 |`String[]`|`ProjectName`
3 |`String`|`description`
4 |`int`|`LIMIT_LEN`
5 |`Color[]`|`colors`


## 5. show()
* * *
### Return Type
- `null`
### Parameter Type
param number | type | variable name 
:-:|:---:|:---:

## 6. getDir(Point startPoint, Point endPoint)
* * *
### Return Type
- `null`
### Parameter Type
param number | type | variable name 
:-:|:---:|:---:
1 |`Point`|`startPoint`
2 |`Point`|`endPoint`

## 7. print()
* * *
### Return Type
- `null`
### Parameter Type
param number | type | variable name 
:-:|:---:|:---:

* * *
