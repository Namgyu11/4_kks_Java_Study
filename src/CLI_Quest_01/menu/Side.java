package CLI_Quest_01.menu;

public class Side extends Menu {

      private final int calories; // 칼로리 정보

      public Side(String name, int price, int calories) {
            super(name, price);
            this.calories = calories;
      }

      public int getCalories() {
            return calories;
      }

      @Override
      public void display() {
            System.out.println("사이드 메뉴: " + getName() + " / 가격: " + getPrice() + "원");
            System.out.println("칼로리: " + getCalories() + "kcal\n");
      }
}
