package CLI_Quest_01.util;

import java.util.Scanner;

public class InputUtils {

      private InputUtils() {}

      public static int getValidIntInput(Scanner scanner, String prompt, int minValue, int maxValue) {
            int input = -1;
            while (true) {
                  try {
                        System.out.print(prompt);
                        input = Integer.parseInt(scanner.nextLine());
                        if (input < minValue || input > maxValue) {
                              throw new NumberFormatException();
                        }
                        break;
                  } catch (NumberFormatException e) {
                        System.out.println("유효한 숫자를 입력해 주세요.");
                  }
            }
            return input;
      }

      public static String getValidStringInput(Scanner scanner, String prompt, String regex, String errorMsg) {
            String input;
            while (true) {
                  System.out.print(prompt);
                  input = scanner.nextLine();
                  if (input.matches(regex)) {
                        break;
                  }
                  System.out.println(errorMsg);
            }
            return input;
      }

      public static String getYesOrNoInput(Scanner scanner, String prompt) {
            String input;
            while (true) {
                  System.out.print(prompt);
                  input = scanner.nextLine().toLowerCase();
                  if (input.equals("y") || input.equals("n")) {
                        break;
                  }
                  System.out.println("Y 또는 N을 입력해 주세요.");
            }
            return input;
      }
}
