import java.util.ArrayList;
import java.util.List;

public class HLRR {
    public static void main(String[] args) {
        String[][] arr = {  {"A", "0", "3"},
                            {"B", "2", "6"},
                            {"C", "4", "4"},
                            {"D", "6", "5"},
                            {"E", "8", "2"}};

        List<String> hlrr = new ArrayList<>();
        int t = 0;
        int count = 0;
        double u[] ={0,0,0,0,0};
        double c = 0;
        int k = 0;
        int statusOfOldest[]= {6,6,6,6,6};
        double p[] = {10,10,10,10,10};
        boolean[] status = {false, false, false, false, false};
        do{
                checkIt(arr, t, status, hlrr);
                int iter = compareTo(status,p);
               // arr[iter][3] =Integer.toString(Integer.parseInt(arr[iter][3]) - 1);

                hlrr.add(arr[iter][0]);
                u[iter] = 2 + u[iter];
                u[iter]/= 2;
                p[iter]= p[iter] + (u[iter] / 2); //or p[iter] = 10 + (u[iter]/2);
            t++;
            count++;
        }while (count != 20);
        for (String s : hlrr) {
            System.out.print(s+" ");
        }
    }

    public static void checkIt(String arr[][], int t, boolean[] a, List<String> hlrr){
       int count = 0;
        for (int i = 0; i < 5; i++) {
            if(t == Integer.parseInt(arr[i][1])){
              a[i] = true;
            }
            count = 0;
            for (int j = 0; j < hlrr.size(); j++) {
                if(hlrr.get(j).equals(arr[i][0])){
                    count++;
                    if(count == Integer.parseInt(arr[i][2])){
                        a[i] = false;
                    }
                }
            }
        }
    }

    public static int compareTo(boolean a[], double p[]){
        int count = 0;
        double f = 100;
        int howIteration = 0;
        for (int i = 0; i < 5; i++) {
            if(a[i]) {
                if(f>p[i]) {
                    f = p[i];
                    howIteration = i;
                }
            }
        }
        return howIteration;
    }
}
