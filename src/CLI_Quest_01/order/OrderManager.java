package CLI_Quest_01.order;

import CLI_Quest_01.util.MenuUtils;

import java.util.Scanner;

/**
 * 주문을 관리하는 클래스
 */
public class OrderManager {
      private final Scanner scanner;
      private final MenuUtils menuUtils;

      public OrderManager(Scanner scanner, MenuUtils menuUtils) {
            this.scanner = scanner;
            this.menuUtils = menuUtils;
      }

      /**
       * 주문을 시작하는 메서드
       */
      public void startOrdering() {
            System.out.println("=======================================================\n");
            System.out.println("환영합니다. 햄버거 가게입니다.");
            System.out.println("주문을 도와드리겠습니다.\n");

            int numPersons = 0;
            while (true) {
                  try {
                        System.out.print("몇 명이 주문하시겠습니까? (최대 5명) : ");
                        numPersons = Integer.parseInt(scanner.nextLine()); // 입력 버퍼 비우기
                        if (numPersons <= 0) {
                              System.out.println("0보다 큰 숫자를 입력해야 합니다.");
                        } else if (numPersons > 5) {
                              System.out.println("최대 5명까지 주문 가능합니다.");
                        } else {
                              break;
                        }
                  } catch (NumberFormatException e) {
                        System.out.println("유효한 숫자를 입력해 주세요.");
                  }
            }

            for (int i = 0; i < numPersons; i++) {
                  String name;
                  while (true) {
                        System.out.println("=======================================================\n");
                        System.out.print("고객님의 이름을 입력하세요: ");
                        name = scanner.nextLine();
                        if (!name.matches(".*\\d.*")) {
                              break;
                        }
                        System.out.println("이름에는 숫자가 포함될 수 없습니다. 다시 입력해 주세요.");
                  }
                  OrderList orderList = new OrderList();
                  OrderProcessor orderProcessor = new OrderProcessor(name, orderList, menuUtils, scanner);
                  orderProcessor.processOrder();
            }

            System.out.println("================  모든 주문이 완료되었습니다.  ==================\n");
      }
}
