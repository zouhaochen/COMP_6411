package Assignment1;

public class QuickSortInJava
{

    /**
     * Sort the array from small to large
     * @param array the content of the array to sort
     * @param p the start index of the array
     * @param r the end index of the array
     */
    public static void QuickSort(int[] array, int p, int r)
    {
        if(p < r)
        {
            int q = Partition(array, p, r);
            QuickSort(array, p, q-1);
            QuickSort(array, q+1, r);
        }
    }

    /**
     * Partition the array into 2 subarray around pivot
     * @param array the content of the array
     * @param p the start index of the array
     * @param r the end index of the array
     * @return
     */
    public static int Partition(int[] array, int p, int r)
    {
        int x = array[r];
        int i = p - 1;
        for (int j = p; j < r; j ++)
        {
            if(array[j] <= x)
            {
                i = i + 1;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int exchange = array[r];
        array[r] = array[i + 1];
        array[i + 1] = exchange;
        return i + 1;
    }
}
