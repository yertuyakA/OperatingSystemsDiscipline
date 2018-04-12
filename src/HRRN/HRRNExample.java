package HRRN;

import java.util.ArrayList;
import java.util.List;

public class HRRNExample {
    public static void main(String[] args) {
        String[][] array = {{"A", "0", "3"},
                {"B", "2", "6"},
                {"C", "4", "4"},
                {"D", "6", "5"},
                {"E", "8", "2"}};

        List<String> hrrn = new ArrayList<>();
        int waiting = 0;
        int count = 0;
        int i = 0;
        int k = 0;
        int ki = 0;
        int h = 0;
        double n = 0;
        int g = 0;
        double npast = 0;
        int secondCount = 0;
        int lastCount = 0;
        for (int j = 0; j < 3; j++) hrrn.add(array[0][0]);

        do {

            lastCount = count;

            if(lastCount == 0) lastCount = 1;

            count += Integer.parseInt(array[k][2]);

            for (int y = 0; y < 5; y++) {

                for (int j = Integer.parseInt(array[k][1]) + 1; j < count; j++) {

                  if(checkIt(hrrn, array[y][0])){
                    if (Integer.parseInt(array[y][1]) == j) {
                        n = ((count -Double.parseDouble(array[y][1])) + Double.parseDouble(array[y][2])) / Double.parseDouble(array[y][2]);
                        secondCount++;
                        if (npast < n) {
                            npast = n;
                            h = y;
                            }
                        }
                     }
                }
            }
            g = k;
            k = h;
            npast = 0;

            for (int j = 0; j < Integer.parseInt(array[k][2]); j++) {
                hrrn.add(array[k][0]);
            }

            if(secondCount>1)
                k = g;


            secondCount = 0;
        if(count > 20){
            ki = 2;
        }

        } while (ki!=2);


        for (int j = 0; j < hrrn.size(); j++) {
            System.out.print(hrrn.get(j));
        }
    }

    public static boolean checkIt(List<String> list, String a){
        if(!list.contains(a)){
            return true;
        }else return false;
    }
}
