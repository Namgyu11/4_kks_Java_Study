package CLI_Quest_01;

import CLI_Quest_01.order.OrderManager;
import CLI_Quest_01.util.MenuUtils;

import java.util.Scanner;

public class Main {

      public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            MenuUtils menuUtils = MenuUtils.getInstance();
            OrderManager orderManager = new OrderManager(scanner, menuUtils);
            orderManager.startOrdering();
      }
}
