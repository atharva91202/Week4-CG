package listinterface.reverselist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class reverseList {
    public static List<Integer> reverseByArraylist(List<Integer> list){
        List<Integer> reverseList = new ArrayList<>();
        for (int i = list.size() -1; i >=0;i--){
            reverseList.add(list.get(i));
        }
        return reverseList;
    }
    public static LinkedList<Integer> reverseByLinkedList(LinkedList<Integer> ll){
        LinkedList<Integer> reversedList =new LinkedList<>();
        for (Integer num : ll){
            reversedList.addFirst(num);
        }
        return reversedList;
    }

    public static void main(String[] args) {
       List<Integer> arrayList = Arrays.asList(1,2,3,4,5,6);
       LinkedList<Integer> linkedList = new LinkedList<>(arrayList);

        System.out.println(reverseByArraylist(arrayList));
        System.out.println(reverseByLinkedList(linkedList));
    }
}
