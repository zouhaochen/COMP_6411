package assignment1;

public class QuickSortAlgo {

    private int iterations;

    public int getIterations() {
        return iterations;
    }

    /**
     * Sort the array from small to large
     * @param list the content of the list to sort
     * @param p the start index of the array list
     * @param r the end index of the array list
     */
    public void QuickSort(int[] list, int p, int r)
    {
        if(p < r)
        {
            int q = Partition(list, p, r);
            QuickSort(list, p, q-1);
            iterations ++;
            QuickSort(list, q+1, r);
            iterations ++;
        }
    }

    /**
     * Partition the array into 2 subarray around pivot
     * @param list the content of the list
     * @param p the start index of the array list
     * @param r the end index of the array list
     * @return
     */
    public int Partition(int[] list, int p , int r)
    {
        int x = list[r];
        int i = p - 1;

        for (int j = p ; j < r ;j ++)
        {
            if(list[j] <= x)
            {
                i = i + 1;
                int temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }
        }

        int exchange = list[r];
        list[r] = list[i + 1];
        list[i + 1] = exchange;
        return i + 1;
    }
}
