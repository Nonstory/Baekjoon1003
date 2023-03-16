//백준 1003번 : https://www.acmicpc.net/problem/1003
//피보나치 수열

//f(0)는 0을 반환, f(1)은 1을 반환
//그 외에는 f(n-1) + f(n-2)
//f(0)와 f(1)이 각각 몇번 호출되었는지 출력하는 프로그램 작성하기

import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Scanner;

//public class Main {
//
//    static int numOfFib0;
//    static int numOfFib1;
//
//    public void initNumOfFib() {
//        numOfFib0 = 0;
//        numOfFib1 = 0;
//    }
//
//    //피보나치 메서드
//    public int fib(int n) {
//        if (n == 0) {
//            numOfFib0++;
//            return 0;
//
//        } else if (n == 1) {
//            numOfFib1++;
//            return 1;
//
//        } else return fib(n - 1) + fib(n - 2);
//    }
//
//
//    public static void main(String[] args) {
//
//        Main main = new Main();
//
//        int count = 0;
//        Scanner sc = new Scanner(System.in);
//        count = sc.nextInt();//n번 시행
//
//        for (int i = 0; i < count; i++) {
//
//            //n번 피보나치를 구하고시어
//            int fibNum = sc.nextInt();
//            //저장변수가 static이므로 초기화
//            main.initNumOfFib();
//            //피보나치 수열 시작
//            main.fib(fibNum);
//            //f0과 f1 출력
//            System.out.println(numOfFib0 + " " + numOfFib1);
//
//        }
//
//    }
//
//}

// 함수의 호출로 구하려하였으나 시간초과로 통과되지 못했다. 다른방법을 찾아보자

public class Main {

    int[] f0 = {1, 0};
    int[] f1 = {0, 1};

    int[] oldFib = f0;
    int[] newFib = f1;

    int[] answer = {0, 0};

    void setFib(int count) {
        if (count == 0)
            answer = f0;

        else if (count == 1)
            answer = f1;

        for (int i = 1; i < count; i++) {
            answer[0] = oldFib[0] + newFib[0];
            answer[1] = oldFib[1] + newFib[1];


            oldFib[0] = newFib[0];
            oldFib[1] = newFib[1];

            newFib[0] = answer[0];
            newFib[1] = answer[1];

        }

    }

    int[] getFib() {
        return this.answer;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<int[]> answers = new ArrayList<>();

        //n번 시행
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {

            int n = sc.nextInt();//fib n번째 구하기
            Main fib = new Main();//fib 객체 선언
            fib.setFib(n);
            fib.answer = fib.getFib();
            answers.add(fib.answer);

        }

        for (int[] answer : answers) {
            System.out.println(answer[0] + " " + answer[1]);
        }
    }
}