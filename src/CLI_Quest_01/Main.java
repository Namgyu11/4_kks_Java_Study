package CLI_Quest_01;

import CLI_Quest_01.menu.Burger;
import CLI_Quest_01.menu.Drink;
import CLI_Quest_01.menu.Side;
import CLI_Quest_01.menu.SpecialBurger;

import java.util.Scanner;

public class Main {

      private static final String[][] BURGERS = {
              {"빅맥", "5000"},
              {"치킨 버거", "4500"},
              {"새우 버거", "4000"},
              {"치즈 버거", "3500"},
              {"불고기 버거", "6000"},
              {"미니 햄버거", "2000"},
              {"더블 치즈 버거", "7000"},
              {"더블 불고기 버거", "6500"},
              {"더블 햄버거", "6000"}
      };

      private static final String[][] SPECIAL_BURGERS = {
              {"슈퍼 메가 베이컨 버거", "9800", "메가 베이컨"},
              {"빅 징거 와퍼 버거", "10000", "매우 큰 닭다리 치킨 패티"},
              {"장어탕", "200000", "기력 회복 만땅 장어"},
              {"호주산 와규 버거", "20000", "사실 미국산"},
              {"토종 재래식 비건 버거", "45000", "한우 업진살"},
              {"머쉬룸 치킨 쉬림프 피자 마라탕후루 버거", "100000", "블랙 사파이어(가지 포도), 포두부"}
      };

      private static final String[][] SIDES = {
              {"감자 튀김 S 사이즈", "0"},
              {"감자 튀김 L 사이즈", "500"},
              {"치즈스틱", "2000"},
              {"치킨 너겟", "3000"},
              {"치킨 스트립", "4000"},
              {"치킨 윙", "5000"},
              {"콘샐러드", "1000"},
              {"콘샐러드 L 사이즈", "2000"},
              {"콘샐러드 XL 사이즈", "3000"}
      };

      private static final String[][] DRINKS = {
              {"콜라", "0"},
              {"사이다", "0"},
              {"제로 콜라", "500"},
              {"콜라 L 사이즈", "500"},
              {"사이다 L 사이즈", "500"},
              {"제로 콜라 L 사이즈", "1000"},
              {"오렌지 주스", "1000"}
      };

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
                              if (addMainMenu(order, BURGERS, "일반 햄버거", scanner)) {
                                    exit = true;
                              }
                              break;
                        case 2:
                              if (addMainMenu(order, SPECIAL_BURGERS, "스페셜 햄버거", scanner)) {
                                    exit = true;
                              }
                              break;
                        default:
                              System.out.println("잘못된 입력입니다.");
                  }
            }
            int totalPrice = order.displayOrder(selectQuantity(scanner));
            calculation(totalPrice, scanner);

            System.out.println("주문이 완료되었습니다. 이용해주셔서 감사합니다.");
            System.out.println("================  주문 종료  ==================\n");
      }

      /**
       * 메인 메뉴를 선택하는 메소드
       *
       * @param order    주문 객체
       * @param menuList 메뉴 리스트
       * @param menuType 메뉴 타입
       * @param scanner  입력 스캐너
       * @return 종료 여부
       */
      private static boolean addMainMenu(Order order, String[][] menuList, String menuType,
              Scanner scanner) {
            System.out.println("=======================================================\n");
            System.out.println(menuType + " 종류 : \n");
            for (int i = 0; i < menuList.length; i++) {
                  System.out.println(
                          (i + 1) + ". " + menuList[i][0] + " : " + menuList[i][1] + "원");
            }
            System.out.println("0. 뒤로 가기\n");
            System.out.print("메뉴 번호 입력 : ");
            int menuChoice = scanner.nextInt();
            scanner.nextLine(); // 입력 버퍼 비우기
            if (menuChoice == 0) {
                  return false;
            }
            if (menuChoice > 0 && menuChoice <= menuList.length) {
                  System.out.println(menuList[menuChoice - 1][0] + "를 주문하셨습니다.\n");
                  String name = menuList[menuChoice - 1][0];
                  int price = Integer.parseInt(menuList[menuChoice - 1][1]);
                  String specialIngredient = "";
                  if (menuType.equals("스페셜 햄버거")) {
                        specialIngredient = menuList[menuChoice - 1][2];
                  }
                  System.out.println("=======================================================\n");
                  System.out.println("** 세트로 하시겠습니까?\n");
                  System.out.print("세트 여부 입력 (Y / N) : ");
                  String setChoice = scanner.next().toLowerCase();
                  while (!setChoice.equals("y") && !setChoice.equals("n")) {
                        System.out.println("잘못된 입력입니다.");
                        System.out.print("세트 여부 입력 (Y / N) : ");
                        setChoice = scanner.next().toLowerCase();
                  }
                  if (setChoice.equals("y")) {
                        System.out.println("세트로 주문하셨습니다.\n");
                        addSideMenu(order, scanner);
                  } else {
                        System.out.println("세트로 주문하지 않으셨습니다.\n");
                  }
                  if ("일반 햄버거".equals(menuType)) {
                        order.addMenu(new Burger(name, price));
                  } else {
                        order.addMenu(new SpecialBurger(name, price, specialIngredient));
                  }
            } else {
                  System.out.println("잘못된 입력입니다.");
            }
            return true;
      }

      /**
       * 사이드 메뉴를 선택하는 메소드
       *
       * @param order   주문 객체
       * @param scanner 입력 스캐너
       */
      private static void addSideMenu(Order order, Scanner scanner) {
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
                        System.out.println(SIDES[menuChoice - 1][0] + "를 주문하셨습니다.\n");
                        String name = SIDES[menuChoice - 1][0];
                        int price = Integer.parseInt(SIDES[menuChoice - 1][1]);
                        addDrinkMenu(order, scanner);
                        order.addMenu(new Side(name, price));
                        break;
                  } else {
                        System.out.println("잘못된 입력입니다.");
                  }
            }
      }

      /**
       * 음료 메뉴를 선택하는 메소드
       *
       * @param order   주문 객체
       * @param scanner 입력 스캐너
       */
      private static void addDrinkMenu(Order order, Scanner scanner) {
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
                        System.out.println(DRINKS[menuChoice - 1][0] + "를 주문하셨습니다.");
                        String name = DRINKS[menuChoice - 1][0];
                        int price = Integer.parseInt(DRINKS[menuChoice - 1][1]);
                        order.addMenu(new Drink(name, price));
                        break;
                  } else {
                        System.out.println("잘못된 입력입니다.");
                  }
            }
      }

      /**
       * 수량을 선택하는 메소드
       *
       * @param scanner 입력 스캐너
       * @return 수량
       */
      private static int selectQuantity(Scanner scanner) {
            int count;
            while (true) {
                  System.out.println("=======================================================\n");
                  System.out.println("** 수량을 선택해주세요(최대 10까지 주문 가능)");
                  System.out.print("수량 입력 : ");
                  count = scanner.nextInt();
                  if (count > 0 && count <= 10) {
                        break; // 유효한 입력이면 루프 탈출
                  } else {
                        System.out.println("잘못된 입력입니다. 1에서 10 사이의 값을 입력해주세요.");
                  }
            }
            System.out.println("\n=======================================================\n");
            return count;
      }

      /**
       * 결제 금액을 계산하는 메소드
       *
       * @param totalPrice 총 가격
       * @param scanner    입력 스캐너
       */
      private static void calculation(int totalPrice, Scanner scanner) {
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
