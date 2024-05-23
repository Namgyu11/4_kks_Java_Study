package java_study_02.threadTest.test02;

public class SharedCounter {

      private int counter = 0;
      private final Object lock = new Object();

      public void increment() {
            synchronized (lock) { // 동기화를 야기해 lock을 걸어준다. 결과 : 3000까지 출력
                  counter++;
                  System.out.println(Thread.currentThread().getName() + " - 현재 카운터 값: " + counter);

            }
            counter--;
            System.out.println("hello: " + counter);
      }

      public int getCounter() {
            return counter;
      }
}
