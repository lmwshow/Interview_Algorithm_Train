package 拼多多秋招;

/**
 * @Auther: minGW
 * @Date: 2018/7/22 20:37
 * @Description:
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

class Car {
    static int MAX_SIZE = 300;
    int id = 0;
    int size;
    int[] store;

    Car(int n) {
        store = new int[n];
    }
}

public class Question3 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String string = in.readLine();
        if (string == null) {
            System.out.println(0);
            return;
        }

        String[] parts = string.split(" ");
        int[] weight = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            weight[i] = Integer.parseInt(parts[i]);
        }
        sort(weight);
        Car Car = new Car(weight.length);

        while (sum(weight) != 0) {
            Car.id++;
            Car.size = Car.MAX_SIZE;
            for (int j = 0; j < weight.length; j++) {
                Car.store[j] = 0;
            }

            for (int i = 0; i < weight.length; i++) {
                while (weight[i] == 0) {
                    if (i == weight.length - 1)
                        break;
                    i++;
                }

                if (weight[i] <= Car.size) {
                    Car.size -= weight[i];
                    Car.store[i] = weight[i];
                    weight[i] = 0;
                    if (Car.size == 0)
                        break;
                }
            }

        }
        System.out.println(Car.id);
        return;
    }

    private static void sort(int[] weight) {
        for (int i = 0; i < weight.length; i++) {
            for (int j = 1; j < weight.length - i; j++) {
                if (weight[j - 1] < weight[j]) {
                    int temp = weight[j];
                    weight[j] = weight[j - 1];
                    weight[j - 1] = temp;
                }
            }
        }
    }

    private static int sum(int[] weight) {
        int sum = 0;
        for (int num : weight) {
            sum += num;
        }
        return sum;
    }
}