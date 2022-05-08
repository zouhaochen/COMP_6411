package performance;

public class PerformanceLog {
    Runtime runtime;

    private long startTime;
    private long elapsedTime;

    private long preMemory;
    private long usedMemory;

    public PerformanceLog() {
        runtime = Runtime.getRuntime();
        runtime.gc();
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public long getUsedMemory() {
        usedMemory = runtime.totalMemory() - runtime.freeMemory();

        return usedMemory;
    }

    public void startTimer() {
        startTime = System.currentTimeMillis();
        elapsedTime = 0;
    }

    public void stopTimer() {
        elapsedTime = System.currentTimeMillis() - startTime;
    }

    public void logPreMemory() {
        preMemory = runtime.totalMemory() - runtime.freeMemory();
    }

    public void logUsedMemory() {
        usedMemory = runtime.totalMemory() - runtime.freeMemory() - preMemory;
    }

}
