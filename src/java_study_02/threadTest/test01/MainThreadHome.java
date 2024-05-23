package java_study_02.threadTest.test01;

public class MainThreadHome {

      public static void main(String[] args) {
            Task cleaning = new Task("집 청소");
            Task cooking = new Task("요리");
            Task takingOutTrash = new Task("쓰레기 버리기");
            Task laundry = new Task("빨래");

            // 각 작업을 수행할 사람(스레드)를 생성
            Thread father = new Thread(cleaning);
            Thread mother = new Thread(cooking);
            Thread son = new Thread(takingOutTrash);
            Thread daughter = new Thread(laundry);

            father.start();
            mother.start();
            son.start();
            daughter.start();
      }

}
