// Given two lists, concatenate the second list in reverse order to the first
// list and return the concatenated list. Implement the logic inside the
// concatenateLists() method.

// Note - use the descendingIterator() method to iterate over the elements
// in reverse order

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;

class Tester {
    public static List<Object> concatenateLists(List<Object> listOne, List<Object>listTwo) {
        // code implementation here
        ListIterator<Object> item = listTwo.listIterator(listTwo.size());
        while(item.hasPrevious()) {
            listOne.add(item.previous());
        }
        return listOne;
    }

    public static void main(String[] args) {
        List<Object> listOne = new LinkedList<Object>();
        listOne.add("Hello");
        listOne.add(102);
        listOne.add(25);
        listOne.add(38.5);

        List<Object> listTwo = new LinkedList<Object>();
        listTwo.add(150);
        listTwo.add(200);
        listTwo.add('A');
        listTwo.add("Welcome");

        List<Object> concatenatedList = concatenateLists(listOne, listTwo);

        System.out.println("Concatenated linked list:");
        for (Object value : concatenatedList) {
            System.out.print(value + " ");
        }
    }
}