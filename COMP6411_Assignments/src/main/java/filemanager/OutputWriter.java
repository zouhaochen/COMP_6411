package filemanager;

import performance.PerformanceLog;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutputWriter {

    private String outputPath;
    private int[] list;
    private int iterations;
    private PerformanceLog performanceLog;

    public OutputWriter(String outputPath, int[] list, int iterations, PerformanceLog performanceLog) {
        this.outputPath = outputPath;
        this.list = list;
        this.iterations = iterations;
        this.performanceLog = performanceLog;
    }

    public void writeResult() {
        File file = new File(outputPath);
        if (checkIfNewDirectoryRequired()) {
            file.getParentFile().mkdir();
        }

        try (FileWriter fileWriter = new FileWriter(file)) {
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // write sorted numbers
            bufferedWriter.write("Sorted Numbers: ");
            bufferedWriter.newLine();
            bufferedWriter.flush();

            for (int j : list) {
                bufferedWriter.write(String.valueOf(j));
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }

            //write statistics record
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.write("Statistics record:");
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.write("Number of random number in the list: " + list.length);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.write("Quick sort time in milliseconds: " + performanceLog.getElapsedTime());
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.write("Memory usage in MB: " + performanceLog.getUsedMemory() / (1024L * 1024L));
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.write("Number of iterations: " + iterations);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Failed to create the output file.");
            System.exit(0);
        }
    }

    private boolean checkIfNewDirectoryRequired() {
        return outputPath.contains("/");
    }

}
