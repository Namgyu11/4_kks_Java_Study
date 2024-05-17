package miniQuest;

public class Animal {

      private final String name;
      private final int age;


      public Animal(String name, int age) {
            this.name = name;
            this.age = age;
      }

      public void eat() {
            System.out.println(name + ": eat");
      }

      public void run() {
            System.out.println(name + ": run");
      }

      public void sleep() {
            System.out.println(name + ": sleep");
      }
}

