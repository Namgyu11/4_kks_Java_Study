package java_study_02.threadTest.test02;

public class CounterThread extends Thread{
      private SharedCounter sharedCounter;

      public CounterThread(SharedCounter sharedCounter) {
            this.sharedCounter = sharedCounter;
      }

      @Override
      public void run() {
            for(int i = 0; i < 1000; i++) {
                  sharedCounter.increment();
                  try {
                        Thread.sleep(5);
                  }catch (InterruptedException e) {
                        e.printStackTrace();
                  }
            }
      }

}
