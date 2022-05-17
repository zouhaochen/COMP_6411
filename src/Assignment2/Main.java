package Assignment2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
    //input and output file path
    private static String randomNumberPath = "src/Assignment2/rand.txt";
    private static String outputPath = "src/Assignment2/output.txt";

    public static void main(String[] args)
    {
        File randomNumber = new File(randomNumberPath);
        System.out.println("The random number file read.");

        //use array list to store the random number information
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList = txtToArrayList(randomNumber);
        int[] list = Arrays.stream(arrayList.toArray(new Integer[0])).mapToInt(Integer::intValue).toArray();

        System.out.println();

        //initialize counting data
        long startTime = 0;
        long endTime = 0;

        //counting time usage to construct a binary search tree
        startTime = System.currentTimeMillis();

        BinarySearchTree binarySearchTree = new BinarySearchTree();

        for(int i = 0; i < list.length; i++)
        {
            binarySearchTree.insert(list[i]);
        }

        endTime = System.currentTimeMillis();
        System.out.println("Time to construct a binary search tree: " + (endTime - startTime));

        //counting memory usage to construct a binary search tree
        System.gc();
        Runtime runtimeForBinarySearchTree = Runtime.getRuntime();
        long usedMemoryForQuickSort = (runtimeForBinarySearchTree.totalMemory() - runtimeForBinarySearchTree.freeMemory());
        System.out.println("Memory usage to construct a binary search tree: " + usedMemoryForQuickSort);

        System.out.println();

        startTime = System.currentTimeMillis();

        binarySearchTree.setNumberOfAccesses(0);
        boolean searchResultOne = binarySearchTree.search(522821228);
        int numberOfAccessesOne = binarySearchTree.getNumberOfAccesses();

        binarySearchTree.setNumberOfAccesses(0);
        boolean searchResultTwo = binarySearchTree.search(426088780);
        int numberOfAccessesTwo = binarySearchTree.getNumberOfAccesses();

        binarySearchTree.setNumberOfAccesses(0);
        boolean searchResultThree = binarySearchTree.search(717686692);
        int numberOfAccessesThree = binarySearchTree.getNumberOfAccesses();

        binarySearchTree.setNumberOfAccesses(0);
        boolean searchResultFour = binarySearchTree.search(652705375);
        int numberOfAccessesFour = binarySearchTree.getNumberOfAccesses();

        binarySearchTree.setNumberOfAccesses(0);
        boolean searchResultFive = binarySearchTree.search(207855228);
        int numberOfAccessesFive = binarySearchTree.getNumberOfAccesses();

        endTime = System.currentTimeMillis();

        System.out.println("Result for successful searches:");
        System.out.println("Key value one: " + searchResultOne);
        System.out.println("Number of access for searching value one:" + numberOfAccessesOne);
        System.out.println("Key value two: " + searchResultTwo);
        System.out.println("Number of access for searching value two:" + numberOfAccessesTwo);
        System.out.println("Key value three: " + searchResultThree);
        System.out.println("Number of access for searching value two:" + numberOfAccessesThree);
        System.out.println("Key value four: " + searchResultFour);
        System.out.println("Number of access for searching value two:" + numberOfAccessesFour);
        System.out.println("Key value five: " + searchResultFive);
        System.out.println("Number of access for searching value two:" + numberOfAccessesFive);
        System.out.println("Time to search five values: " + (endTime - startTime));

        System.out.println();

        startTime = System.currentTimeMillis();

        binarySearchTree.setNumberOfAccesses(0);
        boolean searchResultUnsuccessfulOne = binarySearchTree.search(0);
        int numberOfAccessesUnsuccessfulOne = binarySearchTree.getNumberOfAccesses();

        binarySearchTree.setNumberOfAccesses(0);
        boolean searchResultUnsuccessfulTwo = binarySearchTree.search(100000000);
        int numberOfAccessesUnsuccessfulTwo = binarySearchTree.getNumberOfAccesses();

        binarySearchTree.setNumberOfAccesses(0);
        boolean searchResultUnsuccessfulThree = binarySearchTree.search(300000000);
        int numberOfAccessesUnsuccessfulThree = binarySearchTree.getNumberOfAccesses();

        binarySearchTree.setNumberOfAccesses(0);
        boolean searchResultUnSuccessfulFour = binarySearchTree.search(600000000);
        int numberOfAccessesUnsuccessfulFour = binarySearchTree.getNumberOfAccesses();

        binarySearchTree.setNumberOfAccesses(0);
        boolean searchResultUnSuccessfulFive = binarySearchTree.search(1000000000);
        int numberOfAccessesUnsuccessfulFive = binarySearchTree.getNumberOfAccesses();

        endTime = System.currentTimeMillis();

        System.out.println("Result for unsuccessful searches:");
        System.out.println("Key value one: " + searchResultUnsuccessfulOne);
        System.out.println("Number of access for searching value one:" + numberOfAccessesUnsuccessfulOne);
        System.out.println("Key value two: " + searchResultUnsuccessfulTwo);
        System.out.println("Number of access for searching value one:" + numberOfAccessesUnsuccessfulTwo);
        System.out.println("Key value three: " + searchResultUnsuccessfulThree);
        System.out.println("Number of access for searching value one:" + numberOfAccessesUnsuccessfulThree);
        System.out.println("Key value four: " + searchResultUnSuccessfulFour);
        System.out.println("Number of access for searching value one:" + numberOfAccessesUnsuccessfulFour);
        System.out.println("Key value five: " + searchResultUnSuccessfulFive);
        System.out.println("Number of access for searching value one:" + numberOfAccessesUnsuccessfulFive);
        System.out.println("Time to search five values: " + (endTime - startTime));
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
}
