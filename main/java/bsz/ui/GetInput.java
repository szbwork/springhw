package bsz.ui;

import java.util.Scanner;

public class GetInput {
    public static String read(String message, boolean withLineBreak) {
        String result;

        if (!message.isEmpty()) {
            if (withLineBreak) {
                System.out.println(message);
            } else System.out.print(message);
        }
        return new Scanner(System.in).nextLine();
    }

    public static String read(String message) {
        String input;

        if (null != message && !"".equals(message)) {
            System.out.print(message);
        }
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        return input;
    }

}
