package CLI_Quest_01.menu;

public class Burger extends Menu{

      public Burger(String name, int price) {
            super(name, price);
      }

      @Override
      public void display() {
            System.out.print("** 고객님이 선택하신 메뉴는 ");
            System.out.println("일반 햄버거: " + getName() + " / 가격: " + getPrice() + "원 입니다.");
      }
}
