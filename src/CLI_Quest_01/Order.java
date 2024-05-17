package CLI_Quest_01;

import CLI_Quest_01.menu.Menu;
import java.util.ArrayList;

public class Order {
      private final ArrayList<Menu> orderList;


      public Order(){
            orderList = new ArrayList<Menu>();
      }

      public void addMenu(Menu menu){
            orderList.add(menu);
      }
      public ArrayList<Menu> getOrderList() {
            return orderList;
      }

      public int displayOrder(int count){
            int totalPrice = 0;
            // 역순으로 리스트를 순회
            for (int i = orderList.size() - 1; i >= 0; i--) {
                  Menu menu = orderList.get(i);
                  menu.display();
                  totalPrice += menu.getPrice();
            }
            System.out.println("수량: " + count + "개");
            System.out.println("결제하실 금액은 - " + count * totalPrice + "원 - 입니다.");

            return count * totalPrice;
      }
}
