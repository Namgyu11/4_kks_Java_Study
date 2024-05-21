package CLI_Quest_01.order;

import CLI_Quest_01.menu.MenuType;
import CLI_Quest_01.util.MenuUtils;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 주문을 처리하는 클래스
 */
public class OrderProcessor {
      private final String name;
      private final OrderList orderList;
      private final MenuUtils menuUtils;
      private final Scanner scanner;

      public OrderProcessor(String name, OrderList orderList, MenuUtils menuUtils, Scanner scanner) {
            this.name = name;
            this.orderList = orderList;
            this.menuUtils = menuUtils;
            this.scanner = scanner;
      }

      /**
       * 주문을 처리하는 메서드
       */
      public void processOrder() {
            System.out.println();
            System.out.println(name + "님이 주문을 시작합니다.");

            boolean exit = false;
            while (!exit) {
                  System.out.println("\n=======================================================\n");
                  System.out.println("*** 메인 메뉴\n메뉴를 선택해주세요.\n");
                  System.out.println("0. 주문 나가기\n1. 햄버거\n2. 스페셜 햄버거\n");

                  int choice = -1;
                  while (true) {
                        try {
                              System.out.print("메뉴 번호 입력 : ");
                              choice = scanner.nextInt();
                              scanner.nextLine(); // 입력 버퍼 비우기
                              if (choice < 0 || choice > 2) {
                                    throw new InputMismatchException("유효한 메뉴 번호를 입력해 주세요.");
                              }
                              break;
                        } catch (InputMismatchException e) {
                              System.out.println("유효한 메뉴 번호를 입력해 주세요.");
                              scanner.nextLine(); // 입력 버퍼 비우기
                        }
                  }

                  switch (choice) {
                        case 0:
                              exit = true;
                              break;
                        case 1:
                              menuUtils.addMainMenu(orderList, MenuType.BURGER, scanner);
                              break;
                        case 2:
                              menuUtils.addMainMenu(orderList, MenuType.SPECIAL_BURGER, scanner);
                              break;
                        default:
                              System.out.println("잘못된 입력입니다.");
                  }

                  if (!exit) {
                        String continueOrder;
                        while (true) {
                              System.out.print("주문을 계속하시겠습니까? (Y/N): ");
                              continueOrder = scanner.next().toLowerCase();
                              scanner.nextLine(); // 입력 버퍼 비우기
                              if (continueOrder.equals("y") || continueOrder.equals("n")) {
                                    break;
                              }
                              System.out.println("Y 또는 N을 입력해 주세요.");
                        }
                        if (continueOrder.equals("n")) {
                              exit = true;
                        }
                  }
            }

            if (!orderList.getOrderList().isEmpty()) {
                  int totalPrice = orderList.displayOrder(menuUtils.selectQuantity(scanner));
                  menuUtils.calculation(totalPrice, scanner);
                  System.out.println(name + "님의 주문이 완료되었습니다.");
            }
            System.out.println(name + "님이 주문을 종료합니다.\n");
      }

      public String getName() {
            return name;
      }

}
