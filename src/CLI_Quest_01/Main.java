package CLI_Quest_01;

import CLI_Quest_01.music.BackgroundMusic;
import CLI_Quest_01.order.OrderManager;
import CLI_Quest_01.util.MenuUtils;

import java.util.Scanner;

public class Main {

      public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            MenuUtils menuUtils = MenuUtils.getInstance();
            Object lock = new Object();

            BackgroundMusic backgroundMusic = new BackgroundMusic();
            Thread musicThread = new Thread(backgroundMusic);
            musicThread.start();

            OrderManager orderManager = new OrderManager(scanner, menuUtils, lock, backgroundMusic);

            synchronized (lock) {
                  orderManager.startOrdering();
                  try {
                        lock.wait(); // 주문 완료까지 대기
                  } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                  }
            }

            try {
                  musicThread.join(); // 음악 스레드가 종료될 때까지 대기
            } catch (InterruptedException e) {
                  Thread.currentThread().interrupt();
            }

            System.out.println("프로그램이 정상적으로 종료되었습니다.");
      }
}
