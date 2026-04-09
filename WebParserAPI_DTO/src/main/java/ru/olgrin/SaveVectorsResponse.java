package ru.olgrin.DTO;

public class SaveVectorsResponse {
    private int saved;
    private int failed;

    public SaveVectorsResponse(int saved, int failed) {
        this.saved = saved;
        this.failed = failed;
    }

    public int getSavedCount() {
        return saved;
    }

    public void setSavedCount(int saved) {
        this.saved = saved;
    }

    public int getFailedCount() {
        return failed;
    }

    public void setFailedCount(int failed) {
        this.failed = failed;
    }
}
