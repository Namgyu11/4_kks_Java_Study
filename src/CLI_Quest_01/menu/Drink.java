package CLI_Quest_01.menu;

public class Drink extends Menu {

      public Drink(String name, int price) {
            super(name, price);
      }

      @Override
      public void display() {
            System.out.println("음료: " + getName() + " / 가격: +" + getPrice() + "원");
      }

}
