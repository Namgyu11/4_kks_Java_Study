package CLI_Quest_01.util;

public enum OrderConstants {
      MAX_PERSONS(5, "최대 주문 인원수"),
      MAX_QUANTITY(10, "최대 주문 수량"),
      MIN_ORDER_PERSONS(1, "최소 주문 인원수"),
      MIN_MENU_CHOICE(0, "메뉴 선택 최소값"),
      MAX_BURGER_CHOICE(2, "버거 메뉴 선택 최대값");

      private final int value;
      private final String description; // 설명 필드. 호출할 필요 없음

      OrderConstants(int value, String description) {
            this.value = value;
            this.description = description;
      }

      public int getValue() {
            return value;
      }

      public String getDescription() {
            return description;
      }
}
