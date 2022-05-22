package assignment2;

import performance.Log;
import performance.PerformanceLog;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreePerformanceLog extends PerformanceLog implements Log {

    private final List<Integer> successfulSearches;
    private final List<Integer> unsuccessfulSearches;

    private final List<Integer> numberOfAccessesForSuccessfulSearches;
    private final List<Integer> numberOfAccessesForUnsuccessfulSearches;

    private final List<Boolean> resultsOfSuccessfulSearches;
    private final List<Boolean> resultsOfUnsuccessfulSearches;

    private long timeForConstruction;
    private long timeForSuccessfulSearches;
    private long timeForUnsuccessfulSearches;

    public BinarySearchTreePerformanceLog() {
        successfulSearches = new ArrayList<>();
        unsuccessfulSearches = new ArrayList<>();

        numberOfAccessesForSuccessfulSearches = new ArrayList<>();
        numberOfAccessesForUnsuccessfulSearches = new ArrayList<>();

        resultsOfSuccessfulSearches = new ArrayList<>();
        resultsOfUnsuccessfulSearches = new ArrayList<>();
    }

    public List<Integer> getSuccessfulSearches() {
        return successfulSearches;
    }

    public List<Integer> getUnsuccessfulSearches() {
        return unsuccessfulSearches;
    }

    public long getTimeForConstruction() {
        return timeForConstruction;
    }

    public void logElapsedTimeForConstruction() {
        this.timeForConstruction = getElapsedTime();
    }

    public long getTimeForSuccessfulSearches() {
        return timeForSuccessfulSearches;
    }

    public void logElapsedTimeForSuccessfulSearches() {
        this.timeForSuccessfulSearches = getElapsedTime();
    }

    public long getTimeForUnsuccessfulSearches() {
        return timeForUnsuccessfulSearches;
    }

    public void logElapsedTimeForUnsuccessfulSearches() {
        this.timeForUnsuccessfulSearches = getElapsedTime();
    }

    public void addSuccessfulSearchKey(int key) {
        successfulSearches.add(key);
    }

    public void addUnsuccessfulSearchKey(int key) {
        unsuccessfulSearches.add(key);
    }

    public void addAccessNumberForSuccessfulSearches(int numberOfAccesses) {
        numberOfAccessesForSuccessfulSearches.add(numberOfAccesses);
    }

    public void addAccessNumberForUnsuccessfulSearches(int numberOfAccesses) {
        numberOfAccessesForUnsuccessfulSearches.add(numberOfAccesses);
    }

    public void addResultForSuccessfulSearches(boolean result) {
        resultsOfSuccessfulSearches.add(result);
    }

    public void addResultForUnsuccessfulSearches(boolean result) {
        resultsOfUnsuccessfulSearches.add(result);
    }

    @Override
    public String formatToOutput() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Statistics are as follows:");
        stringBuilder.append("\nTime to construct a binary search tree (in millisecond): ").append(timeForConstruction);
        stringBuilder.append("\nMemory usage to construct a binary search tree (in MB): ").append(getUsedMemory());

        stringBuilder.append("\n");
        stringBuilder.append("\nResult for successful searches:");
        for (int i = 0; i < successfulSearches.size(); i++) {
            stringBuilder.append("\nSearch target ").append(i + 1).append(": ").append(successfulSearches.get(i));
            stringBuilder.append("\nNumber of accesses: ").append(numberOfAccessesForSuccessfulSearches.get(i));
        }
        stringBuilder.append("\nTime to search five values (in millisecond): ").append(getTimeForSuccessfulSearches());

        stringBuilder.append("\n");
        stringBuilder.append("\nResult for unsuccessful searches:");
        for (int i = 0; i < unsuccessfulSearches.size(); i++) {
            stringBuilder.append("\nSearch target ").append(i + 1).append(": ").append(unsuccessfulSearches.get(i));
            stringBuilder.append("\nNumber of accesses: ").append(numberOfAccessesForUnsuccessfulSearches.get(i));
        }
        stringBuilder.append("\nTime to search five values (in millisecond): ").append(getTimeForUnsuccessfulSearches());

        return stringBuilder.toString();
    }

    @Override
    public void printToConsole() {
        System.out.println(formatToOutput());
    }

}
