package CLI_Quest_01;

public class Burger extends Menu{

      public Burger(String name, int price) {
            super(name, price);
      }

      @Override
      public void display() {
            System.out.println(getName()  );
      }
}
