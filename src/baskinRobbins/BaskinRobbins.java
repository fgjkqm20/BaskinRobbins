package baskinRobbins;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class BaskinRobbins {
    public void run() {
        int select;
        Score score = new Score();

        while (true) {
            select = showMenu();

            switch (select) {
                case 1:
                    start(score);
                    break;
                case 2:
                    System.out.println("WIN : " + score.getWin());
                    System.out.println("LOSE : " + score.getLose());
                    System.out.println();
                    break;
                case 3:
                    break;
            }

            if (select == 3)
                break;
        }
    }

    private int showMenu() {
        Scanner sc = new Scanner(System.in);

        int select;

        System.out.println("===== Baskin Robbins31 Game =====");
        System.out.println("1. Game Start");
        System.out.println("2. Game Score");
        System.out.println("3. End Game");

        while (true) {
            System.out.print("선택 > ");

            try {
                select = sc.nextInt();
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println();
                System.out.println("잘못입력하셨습니다.");
                System.out.println();
                continue;
            }

            if (select == 1 || select == 2 || select == 3) {
                break;
            } else {
                System.out.println();
                System.out.println("잘못 입력하셨습니다.");
                System.out.println();
            }
        }
        System.out.println();

        return select;
    }

    private void start(Score score) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int me, cpu;
        int count = 0;

        System.out.println("<< Game Start >>");
        while (true) {
            while (true) {
                System.out.println();
                System.out.println("<< Your Turn >>");
                System.out.print("Input Number : ");

                try {
                    me = sc.nextInt();
                } catch (InputMismatchException e) {
                    sc.nextLine();
                    System.out.println();
                    System.out.println("잘못 입력하셨습니다.");
                    System.out.println();
                    continue;
                }

                if (me == 1 || me == 2 || me == 3) {
                    break;
                } else {
                    System.out.println();
                    System.out.println("잘못 입력하셨습니다.");
                    System.out.println();
                }
            }

            for (int i = 0; i < me; i++) {
                System.out.println(++count + "!");

                if (count == 31) {
                    score.addLose();
                    System.out.println();
                    System.out.println("패배");
                    System.out.println();
                    break;
                }
            }

            if (count == 31)
                break;

            System.out.println();
            System.out.println("<< Computer Turn >>");

            if (count == 27)
                cpu = 3;
            else if (count == 28)
                cpu = 2;
            else if (count == 29)
                cpu = 1;
            else
                cpu = r.nextInt(3) + 1;

            for (int i = 0; i < cpu; i++) {
                System.out.println(++count + "!");

                if (count == 31) {
                    score.addWin();
                    System.out.println();
                    System.out.println("승리");
                    System.out.println();
                    break;
                }
            }

            if (count == 31)
                break;
        }
    }
}
