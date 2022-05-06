package Assignment1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class QuickSortInJava
{
    //input and output file path
    private static String randomNumberPath = "src/Assignment1/rand.txt";
    private static String outputPath = "src/Assignment1/output.txt";

    private static long iterations = 0;

    public static void main(String[] args)
    {
        File randomNumber = new File(randomNumberPath);
        System.out.println("The random number file read.");

        //use array list to store the random number information
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList = txtToArrayList(randomNumber);
        int[] list = Arrays.stream(arrayList.toArray(new Integer[0])).mapToInt(Integer::intValue).toArray();

        //initialize counting data
        long startTime = 0;
        long endTime = 0;

        //counting time usage
        startTime = System.currentTimeMillis();
        QuickSort(list, 0, list.length - 1);
        endTime = System.currentTimeMillis();

        //counting memory usage
        System.gc();
        Runtime runtimeForQuickSort = Runtime.getRuntime();
        long usedMemoryForQuickSort = (runtimeForQuickSort.totalMemory() - runtimeForQuickSort.freeMemory());

        //write result in the output file
        BufferedWriter bufferedWriter = null;
        try
        {
            FileWriter fileWriter = new FileWriter(outputPath);
            bufferedWriter = new BufferedWriter(fileWriter);
            for(int i = 0; i < arrayList.size(); i++)
            {
                bufferedWriter.write(String.valueOf(list[i]));
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }

            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.write("Statistics record:");
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.write("Number of random number in  the list: " + list.length);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.write("Quick sort time in milliseconds: " + (endTime - startTime));
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.write("Memory usage: " + usedMemoryForQuickSort);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.write("Number of iterations: " + iterations);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            bufferedWriter.close();
        }
        catch(IOException e)
        {
            throw new RuntimeException("Failed to write file.");
        }
        finally
        {
            try
            {
                if(bufferedWriter != null)
                {
                    bufferedWriter.close();
                }
            }
            catch (IOException e)
            {
                throw new RuntimeException("Failed to close file.");
            }
        }

        System.out.println("The result output file create.");
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
     * @param list the content of the list to sort
     * @param p the start index of the array list
     * @param r the end index of the array list
     */
    public static void QuickSort(int[] list, int p, int r)
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
    public static int Partition(int[] list, int p , int r)
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
