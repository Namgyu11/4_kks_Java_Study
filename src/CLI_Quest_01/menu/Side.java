package CLI_Quest_01.menu;

public class Side extends Menu {

      public Side(String name, int price) {
            super(name, price);
      }

      @Override
      public void display() {
            System.out.println("사이드 메뉴: " + getName() + " / 가격: +" + getPrice() + "원");
      }

}
