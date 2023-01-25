package Lambda.Worker;

public class Main {
    static OnTaskDoneListener listener = System.out::println;
    static OnTaskErrorListener errorListener = System.out::println;

    public static void main(String[] args) {
        Worker worker = new Worker(listener, errorListener);
        worker.setFailedTask(33);
        worker.start();
    }

    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }

    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String result);
    }
}
