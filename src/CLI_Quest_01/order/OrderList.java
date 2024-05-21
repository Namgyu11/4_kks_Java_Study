package CLI_Quest_01.order;

import CLI_Quest_01.menu.Menu;
import java.util.ArrayList;

/**
 * 주문 내역을 관리
 */
public class OrderList {
      private final ArrayList<Menu> orderList;


      public OrderList(){
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
