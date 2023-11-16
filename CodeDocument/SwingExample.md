# [Class] SwingExample
* * *
## 1. Code Review
> 해당 코드는 완전하고 깔끔하게 작성되어 있으며 수정할 점이 없습니다.


## 2. Navigation
* [Source Code](#3-source-code)
* [SwingExample()](#5-swingexample)
* [main(String[] args)](#6-mainstring[]-args)

## 3. Source Code
<details><summary> Commented Code </summary><div markdown="1">

## Commented Code
* * *
 ```java 

//이 코드는 Java Swing을 사용하여 간단한 GUI 창을 생성하고 버튼을
// 클릭하면 텍스트가 변경되는 예제입니다. 코드의 주석을 통해 코드의
// 목적과 각각의 동작 방식이 명확히 설명되어 있습니다.
public class SwingExample extends JFrame {
    private JTextField textField;
    private JButton button;

    public SwingExample() {
        setTitle("Swing Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new FlowLayout());

        textField = new JTextField("Hello, Swing!", 20);
        button = new JButton("Change Text");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("Text Changed!");
            }
        });

        add(textField);
        add(button);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingExample();
            }
        });
    }
}
 ``` 
</div></details><details><summary> Clean Code </summary><div markdown="1">

## Clean Code
* * *
 ```java 
public class SwingExample extends JFrame {
    private JTextField textField;
    private JButton button;

    public SwingExample() {
        setTitle("Swing Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new FlowLayout());

        textField = new JTextField("Hello, Swing!", 20);
        button = new JButton("Change Text");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("Text Changed!");
            }
        });

        add(textField);
        add(button);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingExample();
            }
        });
    }
}
 ``` 
</div></details>

## 4. Member Fields
member number | type | variable name 
:-:|:---:|:---:
1 |`JTextField`|`textField`
2 |`JButton`|`button`


## 5. SwingExample()
* * *
### Return Type
- `null`
### Parameter Type
param number | type | variable name 
:-:|:---:|:---:

## 6. main(String[] args)
* * *
### Return Type
- `null`
### Parameter Type
param number | type | variable name 
:-:|:---:|:---:
1 |`String[]`|`args`

* * *
