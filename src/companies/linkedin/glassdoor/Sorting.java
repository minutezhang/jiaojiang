package companies.linkedin.glassdoor;

/**
 * @author: zhang
 * @since: Aug 29, 2010 2:37:39 PM
 */
public class Sorting {
    public static void mergeSort(int[] array) {
        mergeSort(array, new int[array.length], 0, array.length);
    }

    public static void mergeSort(int[] array, int[] tmp, int from, int to) {
        if (to - from <= 1) {
            return;
        }

        int mid = from + to >> 1;
        mergeSort(array, tmp, from, mid);
        mergeSort(array, tmp, mid, to);
        merge(array, tmp, from, mid, to);
    }

    public static void merge(int[] array, int[] tmp, int frontFrom, int frontTo, int backTo) {
        if (frontFrom >= backTo) {
            return;
        }

        int fromA = frontFrom;
        int fromB = frontTo;
        int index = frontFrom;

        while (fromA < frontTo && fromB < backTo) {
            if (array[fromA] < array[fromB]) {
                tmp[index++] = array[fromA++];
            } else {
                tmp[index++] = array[fromB++];
            }
        }

        if (fromA < frontTo) {
            System.arraycopy(array, fromA, tmp, index, backTo - index);
            System.arraycopy(tmp, frontFrom, array, frontFrom, backTo - frontFrom);
        } else {
            System.arraycopy(tmp, frontFrom, array, frontFrom, index - frontFrom);
        }
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] argv) {
        int[] a = {4, 5, 8, 1, 20, 16, 11, 15, 3};
        print(a);
        mergeSort(a);
        print(a);
    }

}
