package design.patterns;

import java.util.Stack;

public class TestMomento {
    public static void main(String[] args) {
        DDesktopPool desktopPool = new DDesktopPool("desktopId", 4, 100, "snap1");
        CareTaker careTaker = new CareTaker();
        careTaker.saveState(desktopPool);
    }
}

class DDesktopPool {
    String id;
    int cores;
    int memoryInGb;
    String snapshot;

    public DDesktopPool(String id, int cores, int memoryInGb, String snapshot) {
        this.id = id;
        this.cores = cores;
        this.memoryInGb = memoryInGb;
        this.snapshot = snapshot;
    }

    Momento saveState() {
        return new Momento(this.id, this.cores, this.memoryInGb, this.snapshot);
    }

    void restoreState(Momento momento) {
        this.id = momento.id;
        this.memoryInGb = momento.memoryInGb;
        this.snapshot = momento.snapshot;
        this.cores = momento.cores;
    }

    static class Momento {
        final String id;
        final int cores;
        final int memoryInGb;
        final String snapshot;

        public Momento(String id, int cores, int memoryInGb, String snapshot) {
            this.id = id;
            this.cores = cores;
            this.memoryInGb = memoryInGb;
            this.snapshot = snapshot;
        }
    }
}

class CareTaker {
    Stack<DDesktopPool.Momento> stack = new Stack<>();

    void saveState(DDesktopPool desktopPool) {
        stack.push(desktopPool.saveState());
    }

    void undo(DDesktopPool desktopPool) {
        if (!stack.isEmpty()) {
            desktopPool.restoreState(stack.pop());
        }
    }
}
