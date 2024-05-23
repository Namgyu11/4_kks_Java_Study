package java_study_02.throwTest;

import java.util.ArrayList;

public class Main {

      public static void main(String[] args) {
            // 만약 문자열의 길이가 5를 넘는 경우 예외를 발생
            ArrayList<String> list = new ArrayList<>();
            list.add("Hello");
            list.add("hello World");
            list.add("Hello");

            for(String s : list){
                  if(s.length() > 5){
                        throw new IllegalArgumentException("문자열의 길이가 5를 넘습니다.");
                  }
            }
      }
}
// 키워드를 명확히 구분해야한다.
// 예외를 일으킨다.