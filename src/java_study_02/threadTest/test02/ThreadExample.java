package java_study_02.threadTest.test02;

public class ThreadExample {

      public static void main(String[] args) {
            SharedCounter sharedCounter = new SharedCounter();

            CounterThread counterThread1 = new CounterThread(sharedCounter);
            CounterThread counterThread2 = new CounterThread(sharedCounter);
            CounterThread counterThread3 = new CounterThread(sharedCounter);

            counterThread1.start();
            counterThread2.start();
            counterThread3.start();

            try {
                  counterThread1.join();
                  counterThread2.join();
                  counterThread3.join();
            } catch (InterruptedException e) {
                  throw new RuntimeException(e);
            }

            System.out.println("최종 카운터 값: " + sharedCounter.getCounter());
      }
}
