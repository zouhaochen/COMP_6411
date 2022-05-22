package assignment2;

import filemanager.OutputWriter;
import filemanager.Reader;

import java.util.Random;

public class BinarySearch {

    public static void main(String[] args) {
        String path;
        Reader reader = new Reader();
        int[] list;

        if (args.length <= 0) {
            System.out.println("Reading data from the default file rand.txt...");
            list = reader.readDefaultFile();
        } else {
            path = args[0];
            System.out.println("Reading data from " + path + "...");
            list = reader.read(path);
        }

        System.out.println("The random number file is read.\n");
        System.out.println("Start to perform 5 successful searches and 5 unsuccessful searches using Binary Search Tree...");

        BinarySearchTreePerformanceLog performanceLog = new BinarySearchTreePerformanceLog();
        performanceLog.logPreMemory();

        BinarySearchTree binarySearchTree = new BinarySearchTree();

        performanceLog.startTimer();
        performanceLog.logPreMemory();

        // constructs BST using the input file
        for (int j : list) {
            binarySearchTree.insert(j);
        }

        performanceLog.stopTimer();
        performanceLog.logUsedMemory();
        performanceLog.logElapsedTimeForConstruction();

        // randomize 5 numbers for successful searches
        Random random = new Random();
        for (int i = 0; i < 5; i++){
            performanceLog.addSuccessfulSearchKey(list[random.nextInt(list.length)]);
        }

        // perform successful searches
        performanceLog.startTimer();

        for (int target : performanceLog.getSuccessfulSearches()) {
            binarySearchTree.setNumberOfAccesses(0);
            performanceLog.addResultForSuccessfulSearches(binarySearchTree.search(target));
            performanceLog.addAccessNumberForSuccessfulSearches(binarySearchTree.getNumberOfAccesses());
        }

        performanceLog.stopTimer();
        performanceLog.logElapsedTimeForSuccessfulSearches();


        // perform unsuccessful searches
        int[] missTargets = new int[] {0, 100000000, 300000000, 600000000, 1000000000};
        for (int target : missTargets) {
            performanceLog.addUnsuccessfulSearchKey(target);
        }
        performanceLog.startTimer();

        for (int target : performanceLog.getUnsuccessfulSearches()) {
            binarySearchTree.setNumberOfAccesses(0);
            performanceLog.addResultForUnsuccessfulSearches(binarySearchTree.search(target));
            performanceLog.addAccessNumberForUnsuccessfulSearches(binarySearchTree.getNumberOfAccesses());
        }

        performanceLog.stopTimer();
        performanceLog.logElapsedTimeForUnsuccessfulSearches();

        System.out.println("Searches are completed.");
        System.out.println();
        performanceLog.printToConsole();

        String outputPath;
        outputPath = args.length > 1 ? args[1] : "output.txt";
        OutputWriter outputWriter = new OutputWriter(outputPath);
        outputWriter.writeResult(performanceLog);
        System.out.println("\nThe result output file is created.");
    }
}
