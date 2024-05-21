package CLI_Quest_01.util;

import java.util.Scanner;

/**
 * 입력값을 검사하는 유틸리티 클래스
 */
public class InputUtils {

      private InputUtils() {}

      /**
       * 입력값이 유효한지 검사하는 메소드
       * @param scanner 입력을 받을 Scanner 객체
       * @param prompt 입력을 유도할 메시지
       * @param minValue 입력값의 최소값
       * @param maxValue 입력값의 최대값
       * @return 유효한 정수값
       */
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

      /**
       * 입력값이 유효한지 검사하는 메소드
       * @param scanner 입력을 받을 Scanner 객체
       * @param prompt 입력을 유도할 메시지
       * @param regex 입력값이 만족해야 하는 정규표현식
       * @param errorMsg 입력값이 정규표현식을 만족하지 않을 때 출력할 에러 메시지
       * @return 유효한 문자열
       */
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

      /**
       * 입력값이 Y 또는 N인지 검사하는 메소드
       * @param scanner 입력을 받을 Scanner 객체
       * @param prompt 입력을 유도할 메시지
       * @return Y 또는 N
       */
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
