package bsz.ui;

import java.util.Scanner;

public class Console {
    public static String readLine(String message) {
        String input;

        if (null != message && !"".equals(message)) {
            System.out.println(message);
        }

        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();

        return input;
    }
}
