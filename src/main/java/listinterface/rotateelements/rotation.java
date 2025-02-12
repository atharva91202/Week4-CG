package listinterface.rotateelements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class rotation {
    public static List<Integer> rotateList(List<Integer> list,int k){
        int n = list.size();
        k = k % n;
        List<Integer> rotatedList = new ArrayList<>();
        rotatedList.addAll(list.subList(k,n));
        rotatedList.addAll(list.subList(0,k));
          return rotatedList;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,20,30,40,50,60);
        System.out.println(rotateList(list,3));
    }
}
