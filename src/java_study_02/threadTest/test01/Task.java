package java_study_02.threadTest.test01;

public class Task extends Thread {
      private String taskName;

      public Task(String taskName) {
            this.taskName = taskName;
      }

      @Override
      public void run() {
            System.out.println(taskName + " 를 시작합니다.");
            try {
             Thread.sleep(2000);
            }catch (InterruptedException e) {
                  System.out.println(taskName + " 작업중단.");
            }
            System.out.println(taskName + " 를 종료합니다.");
      }
}
