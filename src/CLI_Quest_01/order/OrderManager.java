package CLI_Quest_01.order;

import CLI_Quest_01.music.BackgroundMusic;
import CLI_Quest_01.util.InputUtils;
import CLI_Quest_01.type.OrderConstants;
import CLI_Quest_01.util.MenuUtils;

import java.util.Scanner;

public class OrderManager {

      private final Scanner scanner;
      private final MenuUtils menuUtils;
      private final Object lock;
      private final BackgroundMusic backgroundMusic;

      public OrderManager(Scanner scanner, MenuUtils menuUtils, Object lock, BackgroundMusic backgroundMusic) {
            this.scanner = scanner;
            this.menuUtils = menuUtils;
            this.lock = lock;
            this.backgroundMusic = backgroundMusic;
      }

      public void startOrdering() {
            System.out.println("=======================================================\n");
            System.out.println("환영합니다. 햄버거 가게입니다.");
            System.out.println("주문을 도와드리겠습니다.\n");

            int numPersons = InputUtils.getValidIntInput(scanner,
                    "몇 명이 주문하시겠습니까? (최대 5명) : ",
                    OrderConstants.MIN_ORDER_PERSONS.getValue(),
                    OrderConstants.MAX_PERSONS.getValue());

            for (int i = 0; i < numPersons; i++) {
                  String name = InputUtils.getValidStringInput(scanner,
                          "고객님의 이름을 입력하세요: ",
                          "^[^\\d]*$",
                          "이름에는 숫자가 포함될 수 없습니다. 다시 입력해 주세요.");
                  OrderList orderList = new OrderList();
                  OrderProcessor orderProcessor = new OrderProcessor(name, orderList, menuUtils, scanner, backgroundMusic);
                  orderProcessor.processOrder();
            }

            System.out.println("================  모든 주문이 완료되었습니다.  ==================\n");

            synchronized (lock) {
                  lock.notifyAll(); // 주문 완료 후 notifyAll() 호출
            }

            backgroundMusic.stopMusic(); // 주문 완료 후 음악 스레드 종료
      }
}
