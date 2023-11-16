# [Class] Semaphore1
* * *
## 1. Code Review
> 코드에 보완할 점은 없습니다. 코드는 깔끔하게 작성되어 있고, 필요한 동기화와 예외 처리 등이 모두 포함되어 있습니다.


## 2. Navigation
* [Source Code](#3-source-code)
* [main(String[] args)](#5-mainstring[]-args)
* [testIncrement()](#6-testincrement)
* [increment()](#7-increment)

## 3. Source Code
<details><summary> Commented Code </summary><div markdown="1">

## Commented Code
* * *
 ```java 

//이 코드는 Semaphore를 사용하여 count 값을 안전하게 증가시키는 예제입니다. Semaphore는 동기화된 작업에 사용되는 객체로, 이 예제에서는 하나의 스레드만이 count 값을 수정할 수 있도록 제한하고 있습니다. NUM_INCREMENTS로 지정된 횟수만큼 increment 메서드를 병렬로 실행하여 count 값을 증가시키고, 최종적으로 그 값을 출력합니다.
public class Semaphore1 {

    private static final int NUM_INCREMENTS = 10000;

    private static Semaphore semaphore = new Semaphore(1);

    private static int count = 0;

    public static void main(String[] args) {
        testIncrement();
    }

    private static void testIncrement() {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, NUM_INCREMENTS)
                .forEach(i -> executor.submit(Semaphore1::increment));

        ConcurrentUtils.stop(executor);

        System.out.println("Increment: " + count);
    }

    private static void increment() {
        boolean permit = false;
        try {
            permit = semaphore.tryAcquire(5, TimeUnit.SECONDS);
            count++;
        } catch (InterruptedException e) {
            throw new RuntimeException("could not increment");
        } finally {
            if (permit) {
                semaphore.release();
            }
        }
    }
}

 ``` 
</div></details><details><summary> Clean Code </summary><div markdown="1">

## Clean Code
* * *
 ```java 
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Semaphore1 {

    private static final int NUM_INCREMENTS = 10000;
    private static Semaphore semaphore = new Semaphore(1);
    private static int count = 0;

    public static void main(String[] args) {
        testIncrement();
    }

    private static void testIncrement() {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, NUM_INCREMENTS)
                .forEach(i -> executor.submit(Semaphore1::increment));

        ConcurrentUtils.stop(executor);

        System.out.println("Increment: " + count);
    }

    private static void increment() {
        boolean permit = false;
        try {
            permit = semaphore.tryAcquire(5, TimeUnit.SECONDS);
            count++;
        } catch (InterruptedException e) {
            throw new RuntimeException("could not increment");
        } finally {
            if (permit) {
                semaphore.release();
            }
        }
    }
}
 ``` 
</div></details>

## 4. Member Fields
member number | type | variable name 
:-:|:---:|:---:
1 |`int`|`NUM_INCREMENTS`
2 |`Semaphore`|`semaphore`
3 |`int`|`count`


## 5. main(String[] args)
* * *
### Return Type
- `null`
### Parameter Type
param number | type | variable name 
:-:|:---:|:---:
1 |`String[]`|`args`

## 6. testIncrement()
* * *
### Return Type
- `null`
### Parameter Type
param number | type | variable name 
:-:|:---:|:---:

## 7. increment()
* * *
### Return Type
- `null`
### Parameter Type
param number | type | variable name 
:-:|:---:|:---:

* * *
