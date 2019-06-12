import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by cwilmer on 5/22/2019.
 */
public class Main {


        static String name = "charles wilmer";
        static String name2 = "eric schaetzle";
        static String name3 = "angela stamatelos";


        public static String intialsOfName(String name) {
            return Arrays.stream(name.split(" "))
                    .map(String::toUpperCase)
                    .map(word -> word.substring(0, 1))
                    .collect(Collectors.joining("."));
        }

        public static String rev1(String name) {
            String revName = "";
            for (int i = name.length() - 1; i >= 0; i--) {
                revName += name.charAt(i);
            }

            return revName;
        }

        public static String rev2(String name) {
            return new StringBuilder(name).reverse().toString();
        }

        public static int[] arr = {3,6,2,4,5,1,0,1,8,8,8675309};
        public static int[] bubbleSort( int[] arr){
//            this.arr = arr;
            boolean flag = false;
            while(flag){
                flag = false;
                for (int i = 0; i <arr.length-1 ; i++) {
                        if(arr[i]>arr[i+1]){
                            int temp = arr[i];
                            arr[i] = arr[i+1];
                            arr[i+1] = temp;
                        }
                }

            }
            return arr;
        }





        public static String s = "welcometojava";
        public static int k = 3;
        public static String getSmallestAndLargest(String s, int k) {
//        Main.s = s;
//        Main.k = k;

            String smallest = "";
            String largest = "";
            smallest = s.substring(0,k);
            largest = s.substring(0,k);
            for (int i = 0; i <=s.length()-k ; i++) {
                String sub = s.substring(i,k+i);
                if(smallest.compareTo(sub)>0){
                    smallest = sub;
                }
                if(largest.compareTo(sub)<0){
                    largest=sub;
                }
            }


            return smallest + "\n" + largest;
        }

        public static void main(String[] args) {
            System.out.println(intialsOfName(name));
            System.out.println(intialsOfName(name2));
            System.out.println(intialsOfName(name3));
            System.out.println(rev1(name));
            System.out.println(rev2(name2));
            System.out.println(getSmallestAndLargest(s,k));
            System.out.println(bubbleSort(arr).toString());

        }




//        int[] arr = {5, 11, 32, 5, 7, 8, 92, 1, 22, 45, 6, 7, 8};
//       Set<Integer> noDups = new HashSet<>();
//        for (Integer x :arr) {
//            noDups.add(x);
//        }
//        Integer [] arr1 = noDups.toArray(new Integer[noDups.size()]);
//
//        boolean flag = true;
//        while(flag){
//            flag = false;
//            for (int i = 0; i <arr1.length-1 ; i++) {
//                if(arr1[i] > arr1[i+1]){
//                    flag = true;
//                    int temp = arr1[i];
//                    arr1[i] = arr1[i+1];
//                    arr1[i+1] = temp;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr1));
//// 1 5 6 7 8 11 22 32 45 92
//
//            int max = arr1.length -1;
//            int min = arr1[0];
//        System.out.println(max);
//        System.out.println(min);

    }



