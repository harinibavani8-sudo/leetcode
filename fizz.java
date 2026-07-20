class FizzBuzz {
    // Maximum number to process
    private int n;
  
    // Semaphores for thread synchronization
    private Semaphore fizzSemaphore = new Semaphore(0);    // Controls fizz thread execution
    private Semaphore buzzSemaphore = new Semaphore(0);    // Controls buzz thread execution
    private Semaphore fizzbuzzSemaphore = new Semaphore(0); // Controls fizzbuzz thread execution
    private Semaphore numberSemaphore = new Semaphore(1);   // Controls number thread execution (starts with 1 permit)

    /**
     * Constructor to initialize FizzBuzz with maximum number
     * @param n the maximum number to process
     */
    public FizzBuzz(int n) {
        this.n = n;
    }

    /**
     * Prints "fizz" for numbers divisible by 3 but not by 5
     * @param printFizz runnable that outputs "fizz"
     */
    public void fizz(Runnable printFizz) throws InterruptedException {
        // Iterate through all numbers divisible by 3
        for (int i = 3; i <= n; i += 3) {
            // Only process if not divisible by 5 (not a fizzbuzz case)
            if (i % 5 != 0) {
                // Wait for permission from number thread
                fizzSemaphore.acquire();
                // Print "fizz"
                printFizz.run();
                // Signal number thread to continue
                numberSemaphore.release();
}