package Assignment1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class QuickSortInJava
{
    private static String randomNumberPath = "src/Assignment1/rand.txt";

    public static void main(String[] args)
    {
        File randomNumber = new File(randomNumberPath);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList = txtToArrayList(randomNumber);
        QuickSort(arrayList, 0, arrayList.size() - 1);
        for(int i = 0; i < arrayList.size(); i++)
        {
            System.out.println(arrayList.get(i));
        }
    }

    /**
     * Transfer txt file into array list
     * @param file file contain random number
     * @return array list with file number
     */
    public static ArrayList txtToArrayList(File file)
    {
        ArrayList<Integer> arrayList = new ArrayList();
        try
        {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String s = null;
            while((s = bufferedReader.readLine())!=null)
            {
                int number = 0;
                try
                {
                    number = Integer.parseInt(s);
                }
                catch (Exception e)
                {
                    System.out.println("Fail to parse string into integer");
                }
                arrayList.add(number);
            }
            bufferedReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return arrayList;
    }

    /**
     * Sort the array from small to large
     * @param array the content of the array to sort list
     * @param p the start index of the array list
     * @param r the end index of the array list
     */
    public static void QuickSort(ArrayList<Integer> array, int p, int r)
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
     * @param array the content of the array list
     * @param p the start index of the array list
     * @param r the end index of the array list
     * @return
     */
    public static int Partition(ArrayList<Integer> array, int p, int r)
    {
        int x = array.get(r);
        int i = p - 1;
        for (int j = p; j < r; j ++)
        {
            if(array.get(j) <= x)
            {
                i = i + 1;
                int temp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);
            }
        }
        int exchange = array.get(r);
        array.set(r, array.get(i + 1));
        array.set(i + 1, exchange);
        return i + 1;
    }
}
