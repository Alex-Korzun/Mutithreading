package multithreading.practice;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        ThreadExample thread = new ThreadExample(counter);
        thread.start();

        RunnableExample runnable = new RunnableExample(counter);
        new Thread(runnable).start();
    }
}