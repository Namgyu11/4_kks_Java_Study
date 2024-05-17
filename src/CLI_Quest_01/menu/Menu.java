package CLI_Quest_01.menu;

public abstract class Menu {

      private final String name;
      private final int price;

      public Menu(String name, int price) {
            this.name = name;
            this.price = price;
      }

      public String getName() {
            return this.name;
      }

      public int getPrice() {
            return this.price;
      }

      public abstract void display();

}
