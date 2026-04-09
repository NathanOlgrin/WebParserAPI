package ru.olgrin.ports.out.model;

public class VectorSaveResult {
    private final int savedCount;
    private final int failedCount;

    public VectorSaveResult(int savedCount, int failedCount) {
        this.savedCount = savedCount;
        this.failedCount = failedCount;
    }

    public int getSavedCount() {
        return savedCount;
    }

    public int getFailedCount() {
        return failedCount;
    }
}
