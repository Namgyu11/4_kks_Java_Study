package CLI_Quest_01.util;

import CLI_Quest_01.menu.*;
import CLI_Quest_01.order.OrderList;

import CLI_Quest_01.type.MenuType;
import CLI_Quest_01.type.OrderConstants;
import java.util.Scanner;

public class MenuUtils {

      private static MenuUtils instance = null;

      private MenuUtils() {}

      public static MenuUtils getInstance() {
            if (instance == null) {
                  instance = new MenuUtils();
            }
            return instance;
      }

      public final String[][] BURGERS = {
              {"빅맥", "5000", "5", "1"},
              {"치킨 버거", "4500", "6", "2"},
              {"새우 버거", "4000", "4", "1"},
              {"치즈 버거", "3500", "3", "0"},
              {"불고기 버거", "6000", "7", "3"},
              {"미니 햄버거", "2000", "2", "0"},
              {"더블 치즈 버거", "7000", "8", "2"},
              {"더블 불고기 버거", "6500", "9", "3"},
              {"더블 햄버거", "6000", "7", "1"}
      };

      public final String[][] SPECIAL_BURGERS = {
              {"슈퍼 메가 베이컨 버거", "9800", "10", "4", "메가 베이컨"},
              {"빅 징거 와퍼 버거", "10000", "12", "5", "매우 큰 닭다리 치킨 패티"},
              {"장어탕", "200000", "15", "5", "기력 회복 만땅 장어"},
              {"호주산 와규 버거", "20000", "13", "3", "사실 미국산"},
              {"토종 재래식 비건 버거", "45000", "9", "2", "한우 업진살"},
              {"머쉬룸 치킨 쉬림프 피자 마라탕후루 버거", "100000", "20", "5", "블랙 사파이어(가지 포도), 포두부"}
      };

      public final String[][] SIDES = {
              {"감자 튀김 S 사이즈", "0", "150"},
              {"감자 튀김 L 사이즈", "500", "300"},
              {"치즈스틱", "2000", "200"},
              {"치킨 너겟", "3000", "250"},
              {"치킨 스트립", "4000", "350"},
              {"치킨 윙", "5000", "400"},
              {"콘샐러드", "1000", "100"},
              {"콘샐러드 L 사이즈", "2000", "150"},
              {"콘샐러드 XL 사이즈", "3000", "200"}
      };

      public final String[][] DRINKS = {
              {"콜라", "0", "500"},
              {"사이다", "0", "500"},
              {"제로 콜라", "500", "500"},
              {"콜라 L 사이즈", "500", "700"},
              {"사이다 L 사이즈", "500", "700"},
              {"제로 콜라 L 사이즈", "1000", "700"},
              {"오렌지 주스", "1000", "400"}
      };

      public void addMainMenu(OrderList orderList, MenuType menuType, Scanner scanner) {
            String[][] menuList = switch (menuType) {
                  case BURGER -> BURGERS;
                  case SPECIAL_BURGER -> SPECIAL_BURGERS;
                  default -> throw new IllegalArgumentException("잘못된 메뉴 타입입니다.");
            };

            System.out.println("=======================================================\n");
            System.out.println(menuType + " 종류 : \n");
            for (int i = 0; i < menuList.length; i++) {
                  System.out.println((i + 1) + ". " + menuList[i][0] + " : " + menuList[i][1] + "원");
            }
            System.out.println("0. 뒤로 가기\n");
            System.out.print("메뉴 번호 입력 : ");
            int menuChoice = scanner.nextInt();
            scanner.nextLine(); // 입력 버퍼 비우기
            if (menuChoice == 0) {
                  return;
            }
            if (menuChoice > 0 && menuChoice <= menuList.length) {
                  String name = menuList[menuChoice - 1][0];
                  int price = Integer.parseInt(menuList[menuChoice - 1][1]);
                  int preparationTime = Integer.parseInt(menuList[menuChoice - 1][2]);
                  int spicinessLevel = Integer.parseInt(menuList[menuChoice - 1][3]);
                  String specialIngredient = menuType == MenuType.SPECIAL_BURGER ? menuList[menuChoice - 1][4] : "";

                  System.out.println(name + "를 주문하셨습니다.\n");

                  System.out.println("=======================================================\n");
                  System.out.println("** 세트로 하시겠습니까?\n");
                  System.out.print("세트 여부 입력 (Y / N) : ");
                  String setChoice = InputUtils.getYesOrNoInput(scanner, "");
                  if (setChoice.equals("y")) {
                        System.out.println("세트로 주문하셨습니다.\n");
                        addSideMenu(orderList, scanner);
                  } else {
                        System.out.println("세트로 주문하지 않으셨습니다.\n");
                  }

                  if (menuType == MenuType.BURGER) {
                        orderList.addMenu(new Burger(name, price, preparationTime, spicinessLevel));
                  } else {
                        orderList.addMenu(new SpecialBurger(name, price, preparationTime, spicinessLevel, specialIngredient));
                  }
            } else {
                  System.out.println("잘못된 입력입니다.");
            }
      }

      public void addSideMenu(OrderList orderList, Scanner scanner) {
            System.out.println("=======================================================\n");
            System.out.println("세트 사이드 메뉴 종류 : \n");
            for (int i = 0; i < SIDES.length; i++) {
                  System.out.println((i + 1) + ". " + SIDES[i][0] + " : +" + SIDES[i][1] + "원");
            }
            while (true) {
                  System.out.print("메뉴 번호 입력 : ");
                  int menuChoice = scanner.nextInt();
                  scanner.nextLine(); // 입력 버퍼 비우기
                  if (menuChoice == 0) {
                        return;
                  }
                  if (menuChoice > 0 && menuChoice <= SIDES.length) {
                        String name = SIDES[menuChoice - 1][0];
                        int price = Integer.parseInt(SIDES[menuChoice - 1][1]);
                        int calories = Integer.parseInt(SIDES[menuChoice - 1][2]);

                        System.out.println(name + "를 주문하셨습니다.\n");
                        addDrinkMenu(orderList, scanner);
                        orderList.addMenu(new Side(name, price, calories));
                        break;
                  } else {
                        System.out.println("잘못된 입력입니다.");
                  }
            }
      }

      public void addDrinkMenu(OrderList orderList, Scanner scanner) {
            System.out.println("=======================================================\n");
            System.out.println("음료 메뉴 종류 : \n");
            for (int i = 0; i < DRINKS.length; i++) {
                  System.out.println((i + 1) + ". " + DRINKS[i][0] + " : +" + DRINKS[i][1] + "원");
            }
            while (true) {
                  System.out.print("메뉴 번호 입력 : ");
                  int menuChoice = scanner.nextInt();
                  scanner.nextLine(); // 입력 버퍼 비우기
                  if (menuChoice == 0) {
                        return;
                  }
                  if (menuChoice > 0 && menuChoice <= DRINKS.length) {
                        String name = DRINKS[menuChoice - 1][0];
                        int price = Integer.parseInt(DRINKS[menuChoice - 1][1]);
                        int volume = Integer.parseInt(DRINKS[menuChoice - 1][2]);

                        System.out.println(name + "를 주문하셨습니다.");
                        orderList.addMenu(new Drink(name, price, volume));
                        break;
                  } else {
                        System.out.println("잘못된 입력입니다.");
                  }
            }
      }

      public int selectQuantity(Scanner scanner) {
            int count;
            while (true) {
                  System.out.println("=======================================================\n");
                  System.out.println("** 수량을 선택해주세요(최대 10까지 주문 가능)");
                  System.out.print("수량 입력 : ");
                  count = scanner.nextInt();
                  if (count > 0 && count <= OrderConstants.MAX_QUANTITY.getValue()) {
                        break; // 유효한 입력이면 루프 탈출
                  } else {
                        System.out.println("잘못된 입력입니다. 1에서 10 사이의 값을 입력해주세요.");
                  }
            }
            System.out.println("\n=======================================================\n");
            return count;
      }

      public void calculation(int totalPrice, Scanner scanner) {
            System.out.println("=======================================================\n");
            System.out.println("** 결제를 도와드리겠습니다.");
            System.out.println("- 결제하실 금액을 투입해주세요.");
            System.out.print("- 투입할 금액 입력 : ");
            int money = scanner.nextInt();
            scanner.nextLine(); // 입력 버퍼 비우기

            while (money < totalPrice) {
                  System.out.println("- 입금액이 부족합니다. 다시 투입해주세요.");
                  System.out.println(" (결제하실 금액 :" + totalPrice + "원)");
                  System.out.print("- 투입할 금액 입력 : ");
                  money = scanner.nextInt();
                  scanner.nextLine(); // 입력 버퍼 비우기
            }
            System.out.println("결제 금액 : " + totalPrice + "원");
            System.out.println("투입 금액 : " + money + "원");
            System.out.println("거스름돈은 " + (money - totalPrice) + "원 입니다.");
            System.out.println("=======================================================\n");
      }
}
