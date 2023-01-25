package Lambda.Worker;

public class Worker {
    private Main.OnTaskDoneListener callback;
    private Main.OnTaskErrorListener errorCallback;
    private int failedTask;

    public Worker(Main.OnTaskDoneListener callback, Main.OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;

    }


    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i == failedTask) {
                errorCallback.onError("Task " + i + " not completed:Error");
            } else {
                callback.onDone("Task " + i + " is done");
            }
        }
    }


    public void setFailedTask(int taskNumber) {
        this.failedTask = taskNumber;
    }

}
