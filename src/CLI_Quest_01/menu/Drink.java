package CLI_Quest_01.menu;

public class Drink extends Menu {

      private final int volume; // 음료 용량 (ml)

      public Drink(String name, int price, int volume) {
            super(name, price);
            this.volume = volume;
      }

      public int getVolume() {
            return volume;
      }

      @Override
      public void display() {
            System.out.println("음료: " + getName() + " / 가격: " + getPrice() + "원");
            System.out.println("용량: " + getVolume() + "ml\n");
      }
}
