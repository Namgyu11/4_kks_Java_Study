package CLI_Quest_01.menu;

public class SpecialBurger extends Burger {
      private final String specialIngredient;

      public SpecialBurger(String name, int price, String specialIngredient) {
            super(name, price);
            this.specialIngredient = specialIngredient;
      }

      public String getSpecialIngredient() {
            return this.specialIngredient;
      }

      @Override
      public void display() {
            System.out.print("** 고객님이 선택하신 메뉴는 ");
            System.out.print("스페셜 햄버거: " + getName() + " / 가격: " + getPrice() + "원 / ");
            System.out.println("특별 재료: " + getSpecialIngredient());
      }
}
