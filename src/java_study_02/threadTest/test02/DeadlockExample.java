package java_study_02.threadTest.test02;

public class DeadlockExample {
      public static void main(String[] args) {
            // 두 개의 리소스 객체
            final Object resource1 = new Object();
            final Object resource2 = new Object();

            // 첫 번째 스레드는 resource1을 먼저 잠그고, 그 다음 resource2를 잠그려고 함
            Thread thread1 = new Thread(() -> {
                  synchronized (resource1) {
                        System.out.println("Thread 1: Resource 1 locked");

                        try {
                              Thread.sleep(100); // 스레드 1이 resource2를 요구하기 전에 약간의 딜레이
                        } catch (InterruptedException e) {
                              Thread.currentThread().interrupt();
                        }

                        synchronized (resource2) {
                              System.out.println("Thread 1: Resource 2 locked");
                        }
                  }
            });

            // 두 번째 스레드는 resource2를 먼저 잠그고, 그 다음 resource1를 잠그려고 함
            Thread thread2 = new Thread(() -> {
                  synchronized (resource2) {
                        System.out.println("Thread 2: Resource 2 locked");

                        try {
                              Thread.sleep(100); // 스레드 2가 resource1을 요구하기 전에 약간의 딜레이
                        } catch (InterruptedException e) {
                              Thread.currentThread().interrupt();
                        }

                        synchronized (resource1) {
                              System.out.println("Thread 2: Resource 1 locked");
                        }
                  }
            });

            // 스레드 시작
            thread1.start();
            thread2.start();
      }
}