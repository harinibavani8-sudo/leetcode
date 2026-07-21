import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {

    private final ReentrantLock[] forks;

    public DiningPhilosophers() {
        forks = new ReentrantLock[5];
        for (int i = 0; i < 5; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    public void wantsToEat(
            int philosopher,
            Runnable pickLeftFork,
            Runnable pickRightFork,
            Runnable eat,
            Runnable putLeftFork,
            Runnable putRightFork) throws InterruptedException {

        int left = philosopher;
        int right = (philosopher + 1) % 5;

        // Always lock the smaller-numbered fork first
        int first = Math.min(left, right);
        int second = Math.max(left, right);

        forks[first].lock();
        forks[second].lock();

        try {
            if (left < right) {
                pickLeftFork.run();
                pickRightFork.run();
            } else {
                pickRightFork.run();
                pickLeftFork.run();
            }

            eat.run();

            if (left < right) {
                putRightFork.run();
                putLeftFork.run();
            } else {
                putLeftFork.run();
                putRightFork.run();
            }

        } finally {
            forks[second].unlock();
            forks[first].unlock();
        }
    }
}
