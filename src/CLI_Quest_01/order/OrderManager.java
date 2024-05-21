package CLI_Quest_01.order;

import CLI_Quest_01.util.InputUtils;
import CLI_Quest_01.util.OrderConstants;
import CLI_Quest_01.util.MenuUtils;

import java.util.Scanner;

public class OrderManager {
      private final Scanner scanner;
      private final MenuUtils menuUtils;

      public OrderManager(Scanner scanner, MenuUtils menuUtils) {
            this.scanner = scanner;
            this.menuUtils = menuUtils;
      }

      public void startOrdering() {
            System.out.println("=======================================================\n");
            System.out.println("환영합니다. 햄버거 가게입니다.");
            System.out.println("주문을 도와드리겠습니다.\n");

            int numPersons = InputUtils.getValidIntInput(scanner, "몇 명이 주문하시겠습니까? (최대 5명) : ", OrderConstants.MIN_ORDER_PERSONS.getValue(), OrderConstants.MAX_PERSONS.getValue());

            for (int i = 0; i < numPersons; i++) {
                  String name = InputUtils.getValidStringInput(scanner, "고객님의 이름을 입력하세요: ", "^[^\\d]*$", "이름에는 숫자가 포함될 수 없습니다. 다시 입력해 주세요.");
                  OrderList orderList = new OrderList();
                  OrderProcessor orderProcessor = new OrderProcessor(name, orderList, menuUtils, scanner);
                  orderProcessor.processOrder();
            }

            System.out.println("================  모든 주문이 완료되었습니다.  ==================\n");
      }
}
