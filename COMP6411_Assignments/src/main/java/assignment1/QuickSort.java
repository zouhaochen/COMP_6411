package assignment1;

import filemanager.OutputWriter;
import filemanager.Reader;
import performance.PerformanceLog;

public class QuickSort {

    public static void main(String[] args) {
        String path;
        String outputPath;
        Reader reader = new Reader();
        int[] numbers;

        if (args.length <= 0) {
            System.out.println("Reading data from the default file rand.txt...");
            numbers = reader.readDefaultFile();
        } else {
            path = args[0];
            System.out.println("Reading data from " + path + "...");
            numbers = reader.read(path);
        }
        outputPath = args.length > 1 ? args[1] : "output.txt";

        PerformanceLog performanceLog = new PerformanceLog();

        System.out.println("Sorting has start...");
        performanceLog.logPreMemory();
        performanceLog.startTimer();
        QuickSortAlgo quickSortAlgo = new QuickSortAlgo();
        quickSortAlgo.QuickSort(numbers, 0, numbers.length-1);
        performanceLog.stopTimer();
        performanceLog.logUsedMemory();
        System.out.println("Sorting is completed.");

        OutputWriter outputWriter = new OutputWriter(outputPath, numbers, quickSortAlgo.getIterations(), performanceLog);
        outputWriter.writeResult();

        System.out.println("The result output file is created.");
    }
}
