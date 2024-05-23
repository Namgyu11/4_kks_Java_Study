package java_study_02.collection;

import java.util.*;
public class Main {



      public static void main(String[] args) {
            ArrayList<Object> objects = new ArrayList<>();



            objects.add("Hello");
            objects.add("Hello");
            objects.add("Hello");
            objects.add("Hello");

            for(Object s : objects){
                  System.out.println(s);
            }
      }
}
