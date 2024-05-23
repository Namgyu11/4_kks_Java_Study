package CLI_Quest_01.order;

import CLI_Quest_01.music.BackgroundMusic;
import CLI_Quest_01.util.InputUtils;
import CLI_Quest_01.util.MenuUtils;
import CLI_Quest_01.type.MenuType;

import java.util.Scanner;

public class OrderProcessor {
      private final String name;
      private final OrderList orderList;
      private final MenuUtils menuUtils;
      private final Scanner scanner;
      private final BackgroundMusic backgroundMusic;

      public OrderProcessor(String name, OrderList orderList,
              MenuUtils menuUtils, Scanner scanner, BackgroundMusic backgroundMusic) {
            this.name = name;
            this.orderList = orderList;
            this.menuUtils = menuUtils;
            this.scanner = scanner;
            this.backgroundMusic = backgroundMusic;
      }

      public void processOrder() {
            System.out.println();
            System.out.println(name + "님이 주문을 시작합니다.");

            boolean exit = false;
            while (!exit) {
                  System.out.println("\n=======================================================\n");
                  System.out.println("*** 메인 메뉴\n메뉴를 선택해주세요.\n");
                  System.out.println("0. 주문 나가기\n1. 햄버거\n2. 스페셜 햄버거\n");

                  int choice = InputUtils.getValidIntInput(scanner, "메뉴 번호 입력 : ",
                          0, 2);

                  switch (choice) {
                        case 0 -> exit = true;
                        case 1 -> menuUtils.addMainMenu(orderList, MenuType.BURGER, scanner);
                        case 2 -> menuUtils.addMainMenu(orderList, MenuType.SPECIAL_BURGER, scanner);
                        default -> System.out.println("잘못된 입력입니다.");
                  }

                  if (!exit) {
                        String continueOrder = InputUtils.getYesOrNoInput(scanner,
                                "주문을 계속하시겠습니까? (Y/N): ");
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

            backgroundMusic.nextTrack();
      }

      public String getName() {
            return name;
      }
}
