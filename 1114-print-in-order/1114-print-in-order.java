class Foo {
    private Semaphore lock2;
    private Semaphore lock3;
    public Foo() {
        lock2 = new Semaphore(0);
        lock3 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        lock2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock2.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        lock3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock3.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}