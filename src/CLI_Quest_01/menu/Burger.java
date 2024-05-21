package CLI_Quest_01.menu;

public class Burger extends Menu {

      private final int preparationTime; // 조리 시간
      private final int spicinessLevel; // 매운맛 정도

      public Burger(String name, int price, int preparationTime, int spicinessLevel) {
            super(name, price);
            this.preparationTime = preparationTime;
            this.spicinessLevel = spicinessLevel;
      }

      public int getPreparationTime() {
            return preparationTime;
      }

      public int getSpicinessLevel() {
            return spicinessLevel;
      }

      @Override
      public void display() {
            System.out.println("** 고객님이 선택하신 메뉴는 ");
            System.out.println("일반 햄버거: " + getName() + " / 가격: " + getPrice() + "원");
            System.out.println("조리 시간: " + getPreparationTime() + "분 / 매운맛 정도: " + getSpicinessLevel() + "단계\n");
      }
}
