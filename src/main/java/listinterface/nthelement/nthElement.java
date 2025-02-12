package listinterface.nthelement;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class nthElement {
    public static String elementFromLast(LinkedList<String> list , int n){
        Iterator<String> first = list.iterator();
        Iterator<String> second = list.iterator();

        //First iterator moves n steps ahead
        for (int i =0;i<n;i++){
            if (!first.hasNext()) return null; //Edge Case when n is larger than list size
            first.next();
        }
        //Moving both iterators untill first reaches the end
        while (first.hasNext()){
            first.next();
            second.next();
        }
        return second.next();
    }

    public static void main(String[] args) {
        LinkedList<String> newll = new LinkedList<>(Arrays.asList("A","B","C","D","E"));
        System.out.println(elementFromLast(newll,3));
    }
}
