package multithreading.practice;

public class Counter {
    private int counter;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int increment() {
        return counter++;
    }
}
