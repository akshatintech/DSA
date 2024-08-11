package Heaps;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
public class Heap {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(42);
        pq.add(32);
        pq.add(12);
        pq.add(6);

        while (!pq.isEmpty()){
            System.out.println(pq.peek());
            pq.remove();
        }

    }
}


