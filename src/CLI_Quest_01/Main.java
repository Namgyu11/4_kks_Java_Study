package CLI_Quest_01;

import CLI_Quest_01.menu.*;
import CLI_Quest_01.util.MenuUtils;

import java.util.Scanner;

public class Main {

      public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Order order = new Order();
            System.out.println("=======================================================\n");
            System.out.println("환영합니다. 햄버거 가게입니다.");
            System.out.println("주문을 도와드리겠습니다.");
            boolean exit = false;
            while (!exit) {
                  System.out.println("\n=======================================================\n");
                  System.out.println("*** 메인 메뉴\n메뉴를 선택해주세요.\n");
                  System.out.println("0. 주문 나가기\n1. 햄버거\n2. 스페셜 햄버거\n");
                  System.out.print("메뉴 번호 입력 : ");
                  int choice = scanner.nextInt();
                  System.out.println();
                  switch (choice) {
                        case 0:
                              System.out.println("이용해주셔서 감사합니다. 안녕히 가세요.");
                              return;
                        case 1:
                              if (MenuUtils.addMainMenu(order, MenuType.BURGER, scanner)) {
                                    exit = true;
                              }
                              break;
                        case 2:
                              if (MenuUtils.addMainMenu(order, MenuType.SPECIAL_BURGER, scanner)) {
                                    exit = true;
                              }
                              break;
                        default:
                              System.out.println("잘못된 입력입니다.");
                  }
            }
            int totalPrice = order.displayOrder(MenuUtils.selectQuantity(scanner));
            MenuUtils.calculation(totalPrice, scanner);

            System.out.println("주문이 완료되었습니다. 이용해주셔서 감사합니다.");
            System.out.println("================  주문 종료  ==================\n");
      }
}
