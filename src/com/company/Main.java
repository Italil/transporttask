package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String buyer;
        String warehouse;
        String price;

        int z = -1;
        int sum1 = 0;
        int sum2 = 0;
//buyer = "22,45,20,18,30";
        //warehouse = "60,35,40";
        //price = "4,1,3,4,4,2,3,2,2,3,3,5,2,4,4";

        System.out.print("Введите потребности покупателей через ',' и без пробелов: ");
        buyer = sc.nextLine();//22,45,20,18,30
        String FbuyerArr[] = buyer.split(",");
        int buyerArr[] = new int[FbuyerArr.length];

        for (int i = 0; i < FbuyerArr.length; i++)
        {
            buyerArr[i] = Integer.parseInt(FbuyerArr[i]);
        }

        for (int i = 0; i < buyerArr.length; i++)
        {
            sum1 += buyerArr[i];
        }

        System.out.print("Введите кол-во товара на складах через ',' и без пробелов: ");
        warehouse = sc.nextLine();//60,35,40
        String FwarehouseArr[] = warehouse.split(",");
        int warehouseArr[] = new int[FwarehouseArr.length];

        for (int i = 0; i < FwarehouseArr.length; i++)
        {
            warehouseArr[i] = Integer.parseInt(FwarehouseArr[i]);
        }

        for (int i = 0; i < warehouseArr.length; i++)
        {
            sum2 += warehouseArr[i];
        }

        if (sum1 == sum2) {

            System.out.print("Введите стоимость доставок через ',' и без пробелов: ");
            price = sc.nextLine();//4,1,3,4,4,2,3,2,2,3,3,5,2,4,4
            String FpriceArr[] = price.split(",");
            int priceArr[][] = new int[FwarehouseArr.length][FbuyerArr.length];

            for (int i = 0; i < FwarehouseArr.length; i++) {
                for (int j = 0; j < FbuyerArr.length; j++) {
                    z++;
                    priceArr[i][j] = Integer.parseInt(FpriceArr[z]);
                }
            }

            System.out.println("Таблица с веденными вами данными: ");
            System.out.print(" ");//вывщд
            for (int i = 0; i < buyerArr.length; i++) {
                System.out.print(" | " + buyerArr[i]);
            }
            System.out.println();
            for (int i = 0; i < FwarehouseArr.length; i++) {
                System.out.print(warehouseArr[i]);
                for (int j = 0; j < FbuyerArr.length; j++) {
                    System.out.print(" | " + priceArr[i][j]);
                }
                System.out.println();
            }

            int result = 0;//задаем переменную для подсчета итога
            int res[][] = new int[FwarehouseArr.length][FbuyerArr.length];

            int a = warehouseArr.length - 1;
            int b = buyerArr.length - 1;

            int max = priceArr[a][b];// находим элемент в правом нижнем углу

            while (warehouseArr[0] > 0) {
                if (warehouseArr[a] >= buyerArr[b])// сравниваем последний элемент buyerArr и warehouseArr
                {
                    res[a][b] = buyerArr[b];
                    warehouseArr[a] = warehouseArr[a] - buyerArr[b];

                    result = result + (buyerArr[b] * max);
                    buyerArr[b] = 0;

                    b--;

                    if (b >= 0)
                        max = priceArr[a][b];
                    else
                        break;

                } else {
                    res[a][b] = warehouseArr[a];
                    buyerArr[b] = buyerArr[b] - warehouseArr[a];

                    result = result + (warehouseArr[a] * max);
                    warehouseArr[a] = 0;

                    a--;

                    if (a >= 0)
                        max = priceArr[a][b];
                    else
                        break;

                }
            }

            System.out.println("Матрица с поставками");
            System.out.print(" ");//вывод с матрицей кол-ва поставок
            for (int i = 0; i < buyerArr.length; i++) {
                System.out.print(" | " + buyerArr[i]);
            }
            System.out.println();
            for (int i = 0; i < FwarehouseArr.length; i++) {
                System.out.print(warehouseArr[i]);
                for (int j = 0; j < FbuyerArr.length; j++) {
                    System.out.print(" | " + res[i][j]);
                }
                System.out.println();
            }

            System.out.print("Итоговый результат: " + result);

        }else {
            System.out.println("Сумма двух вводимых вами последовательностей не может быть равной");
        }

        sc.close();

    }
}