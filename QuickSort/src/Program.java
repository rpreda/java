/**
 * Created by rpreda on 03/05/16.
 */

class QuickSort {

    public static String[] data = { "d", "c", "b", "a"};

    public static int split(int left, int right) {
        String pivot = data[left];
        while (left <= right) {
            while (data[left].compareTo(pivot) < 0)
                left++;
            while (data[right].compareTo(pivot) > 0)
                right--;
            if (left <= right) {
                String temp = data[left];
                data[left] = data[right];
                data[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }
    public static void quickSort(int left, int right)
    {
        if (left < right)
        {
            int splitPlace = split(left, right);

            if (left < splitPlace - 1)
                quickSort(left, splitPlace - 1);
            if (right > splitPlace)
                quickSort(splitPlace, right);
        }
    }
    public static void main(String[] args)
    {
        quickSort(0, data.length - 1);
        for (String s:data)
            System.out.println(s);

    }
}
