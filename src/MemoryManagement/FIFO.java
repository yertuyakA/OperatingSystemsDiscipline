package MemoryManagement;

import java.util.ArrayList;
import java.util.List;

public class FIFO {
    public static void main(String[] args) {
        List<Integer> box = new ArrayList<>();
        int[] usl = {1,7,6,7,0,1,0,2,0,3,0,4,5,1,5,2,4,5,6,7,6,7,2,4,3,3,2,3};
        int count = 0;
        int last = 0;
        int[] queue = {0,1,2,3};
        int iter = 0;
        box.add(1);
        box.add(0);
        box.add(2);
        box.add(3);

        int u = 0;
        do{
            if(!checkIt(box,usl[count])){
                box.add(queue[0],usl[count]);
                changeArray(queue);
            }else{
                for (int i = 0; i <4; i++) {
                       if(box.size()==3){
                           if(i != 3){
                           if (usl[count] == box.get(i)) {
                               u = i;
                           }
                       }
                    }else {
                           if (usl[count] == box.get(i)) {
                               u = i;
                           }
                       }
                }
                changeArray(queue, u);
            }
            count++;
            if(count == 5){
                for (int i = 0; i < 4; i++) {
                    System.out.print(box.get(i)+"  ");
                }
                System.out.println();
            }
        }while(count != usl.length);
    }

    private static void changeArray(int[] queue) {
        int n = queue.length;
        int first = queue[0];
        int second = queue[1];
        int third = queue[2];
        int fourth = queue[3];
        queue[0] = second;
        queue[1] = third;
        queue[2] = fourth;
        queue[3] = first;
    }
    private static void changeArray(int[] queue, int i){
        int change = queue[i];
        int n = queue.length;
        int j = 0;
        while(i<n-1){
            queue = swap(queue, i,i+1);
            i++;
        }
    }
    private static int[] swap(int[] queue, int i, int i1) {
        int temp = queue[i];
        queue[i] = queue[i1];
        queue[i1] = temp;
        return queue;
    }


    public static boolean checkIt(List<Integer> l, int s){
        if(l.contains(s)){
            return true;
        }else return false;
    }

}
