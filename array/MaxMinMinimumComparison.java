package array;

public class MaxMinMinimumComparison {


    public static void main(String[] args) {
        int[] arr = {1000, 11, 445, 1, 330, 3000};

        getMinMax(arr);
    }

    public static void getMinMax(int[] arr) {
        int min = 0;
        int max = 0;
        int i = 0;
        if (arr.length % 2 == 0) {
            if (arr[0] > arr[1]) {

                min = arr[0];
                max = arr[1];

            } else {
                max = arr[0];
                min = arr[1];
            }
            i = 2;
        } else {
            max = arr[0];
            min = arr[0];
            i = 1;
        }

        while (i < arr.length - 1) {

            if (arr[i] > arr[i + 1]) {
                if (arr[i] > max) {
                    max = arr[i];
                }
                if (arr[i + 1] < min) {
                    min = arr[i + 1];
                }


            } else {
                if (arr[i + 1] > max) {
                    max = arr[i + 1];
                }
                if (arr[i] < min) {
                    min = arr[i];
                }


            }

            i = i + 2;


        }

        System.out.println(min + "  " + max);

    }

}
