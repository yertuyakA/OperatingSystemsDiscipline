package MemoryManagement;

public class NRU {
    public static void main(String[] args) {

        int[] usl = {1,7,6,7,0,1,0,2,0,3,0,4,5,1,5,2,4,5,6,7,6,7,2,4,3,3,2,3};
        //List<Integer> frame = new ArrayList<>();
        int[]frame = new int[3];
        int[][] box = {{0,0,0},  //0..7
                       {0,0,1},
                       {0,0,0},
                       {0,0,1},
                       {0,0,0},
                       {0,0,1},
                       {0,0,0},
                       {0,0,1},
                       {0,0,0}};
        int count = 0;
        int last = 0;
//        frame.add(1);
//        frame.add(2);
//        frame.add(3);
        int c = 0;
        int countMain = 0;

        do{
            int countTwo = 0;
        do {
            if (checkIt(box)) {
                if (!checkItForIdentically(box, usl[c])) {
                    box[usl[c]][0] = 1;
                    box[usl[c]][1] = 1;
//                    frame.add(countMain,usl[c]);
                    frame[countMain] = usl[c];
                    countMain++;
                }else box[usl[c]][1] = 1;
            } else {
                for (int i = 0; i < 7; i++) {
                    {
                        if (box[i][1] == 0 && box[i][2] == 0){
                            last = i;
                        }else if(box[i][1] == 0 && box[i][2] ==1){
                            last = i;
                        }else if(box[i][1] == 1 && box[i][2] == 0){
                            last = i;
                        }
                    }
                    box[last][0] = 0;
                    box[last][1] = 0;
                    box[usl[c]][0] = 1;
                    box[usl[c]][1] = 1;
                }
            }
            c++;
            countTwo++;
        }while(countTwo!=2);
           if(countMain!=2) {
               countMain = 0;
           }

            if(count == 5){
                for (int s : frame) {
                    System.out.print(s+" ");
                }

            }

            for (int i = 0; i < 7; i++) {
                box[i][1] = 0;
            }


        count++;
        }while(count!=7);
    }

    private static boolean checkItForIdentically(int box[][], int numb) {
        int count = 0;
        for (int i = 0; i < 7; i++) {
            if (box[numb][0] == 1) {
                count++;
            }
        }
        if(count!=0) {
            return true;
        }else return false;

    }


    public static boolean checkIt(int[][] box){
        int count = 0;
        for (int i = 0; i < 7;i++) {
           if(box[i][0] == 1){
               count++;
           }
        }
        if(count<2){
            return true;
        }else{
            return false;
        }
    }
}
