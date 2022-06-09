package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {
        String inputString;
        Pattern p = Pattern.compile("\\d+\\s[+,\\-, *, %, /, ^]\\s\\d+");
        Matcher m;
        double result = 0;
        System.out.println("Введите пример: ");
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                if (scanner.hasNextLine()) {
                    inputString = scanner.nextLine();
                    m = p.matcher(inputString);
                    if (m.find()) {
                        result = split(inputString.split(" "), result);
                        System.out.println(result);
                    } else {
                        System.out.println("Ввод не корректен!");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static double split(String[] array, double previousResult) throws Exception {
        String operand;
        double num1;
        double num2;
        if (array.length == 3) {
            num1 = Double.parseDouble(array[0]);
            operand = array[1];
            num2 = Double.parseDouble(array[2]);
            return calculate(num1, num2, operand);
        } else {
            throw new Exception("Ввод не корректен");
        }
    }
    private static double calculate(double num1, double num2, String operand) throws Exception {
        switch (operand) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            case "^":
                return Math.pow(num1, num2);
            case "%":
                return num1 % num2;
            default:
                throw new Exception("Ввод не корректен");
        }
    }
}