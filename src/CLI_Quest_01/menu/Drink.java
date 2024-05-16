package CLI_Quest_01;

public class Drink extends Menu {
      private final String size;

      public Drink(String name, int price, String size) {
            super(name, price);
            this.size = size;
      }

      @Override
      public void display() {

      }

      public String getSize() {
            return size;
      }


}
