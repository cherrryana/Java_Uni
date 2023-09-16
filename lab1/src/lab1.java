import java.util.Scanner;
import java.util.ArrayList;

public class lab1 {
    public static void main(String[] args) {
        firstTask();
        secondTask();
        thirdTask();
        fourthTask();
        fifthTask();

    }

    public static void firstTask() {
        System.out.println("Первая задача");

        Scanner in = new Scanner(System.in);
        System.out.print("Число для сиракузской последовательности: ");
        long number = in.nextInt();
        int stepsCount = 0;

        while (number > 1) {
            number = (number % 2 == 0) ? (number / 2) : (3 * number + 1);
            stepsCount++;
        }

        System.out.println("Кол-во шагов = " + stepsCount + '\n');
    }

    public static void secondTask() {
        System.out.println("Вторая задача");

        Scanner in = new Scanner(System.in);
        System.out.print("Кол-во чисел: ");
        int numberAmount = in.nextInt();
        int result = 0;
        int count = 0;

        while (numberAmount != 0) {
            System.out.println("Введите число:");
            int number = in.nextInt();
            result = (count % 2 == 0) ? (result + number) : (result - number);
            count++;
            numberAmount--;
        }

        System.out.println("Знакочередующаяся сумма = " + result + '\n');
    }

    public static void thirdTask() {
        System.out.println("Третья задача");
        int x = 0;
        int y = 0;

        Scanner in = new Scanner(System.in);
        System.out.print("Координата клада по иксу: ");
        int xTreasure = in.nextInt();
        System.out.print("Координата клада по игреку: ");
        int yTreasure = in.nextInt();

        ArrayList<String> directions = new ArrayList<String>();
        ArrayList<Integer> coords = new ArrayList<Integer>();

        while (true) {
            System.out.print("Указание карты, направление / стоп: ");
            String text = in.next();
            if (!text.equals("стоп"))
                directions.add(text);
            else break;

            System.out.print("Указание карты, кол-во шагов: ");
            coords.add(in.nextInt());
        }

        int k = 0;
        while (x != xTreasure || y != yTreasure) {
            int steps = coords.get(k);
            String currentDirection = directions.get(k);

            switch (currentDirection) {
                case "юг": {
                    if (y != yTreasure)
                        y -= steps;
                    break;
                }
                case "север": {
                    if (y != yTreasure)
                        y += steps;
                    break;
                }
                case "восток": {
                    if (x != xTreasure)
                        x += steps;
                    break;
                }
                case "запад": {
                    if (x != xTreasure)
                        x -= steps;
                    break;
                }
            }
            k++;
        }

        System.out.println("Кол-во указаний карты: " + k + '\n');
    }

    public static void fourthTask() {
        System.out.println("Четвертая задача");

        Scanner in = new Scanner(System.in);
        System.out.print("Кол-во дорог: ");
        int roadCount = in.nextInt();
        int maxHeight = 0;
        int roadNum = 0;

        for (int i = 0; i != roadCount; i++) {
            System.out.print("Кол-во туннелей:");
            int tunnelsCount = in.nextInt();
            int minHeight = 0;

            while (tunnelsCount != 0) {
                System.out.print("Высота туннеля:");
                int height = in.nextInt();
                if (height < minHeight || minHeight == 0)
                    minHeight = height;

                tunnelsCount--;
            }
            if (maxHeight < minHeight) {
                maxHeight = minHeight;
                roadNum = i + 1;
            }
        }

        System.out.println("Номер дороги " + roadNum);
        System.out.println("Максимальная высота грузовика " + maxHeight + '\n');
    }

    public static void fifthTask() {
        System.out.println("Пятая задача");

        Scanner in = new Scanner(System.in);
        System.out.print("Трехзначное число: ");
        int number = in.nextInt();
        in.close();
        int sum = 0;
        int mult = 1;


        while (number > 0) {
            sum += (number % 10);
            mult *= (number % 10);
            number /= 10;
        }

        if (sum % 2 == 0 && mult % 2== 0)
            System.out.println("Дважды четное");
        else System.out.println("Не является дважды четным");
    }
}
