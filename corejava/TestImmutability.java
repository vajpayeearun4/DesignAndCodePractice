package corejava;

import java.util.Stack;

public class TestImmutability {

    public static void main(String[] args) {
        CareTakerCo careTakerCo = new CareTakerCo();
        Coordinate coordinate = new Coordinate(0, 0);
        careTakerCo.save(coordinate);
        coordinate.show();
        coordinate.next(1, 2);
        careTakerCo.save(coordinate);
        coordinate.show();
        coordinate.next(5, 5);
        careTakerCo.save(coordinate);
        coordinate.show();
        coordinate.next(7,5);
        coordinate.show();
        careTakerCo.restore(coordinate);
        coordinate.show();
        careTakerCo.restore(coordinate);
        coordinate.show();
        careTakerCo.restore(coordinate);
        coordinate.show();
        careTakerCo.restore(coordinate);
        coordinate.show();
    }
}

class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void show() {
        System.out.println(this.x + " " + this.y);
    }

    void next(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class CoordinateSnapshot {
    final int x;
    final int y;

    public CoordinateSnapshot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class CareTakerCo {
    Stack<CoordinateSnapshot> stack = new Stack<>();

    void save(Coordinate coordinate) {
        stack.push(new CoordinateSnapshot(coordinate.x, coordinate.y));
    }

    void restore(Coordinate coordinate) {
        if (!stack.isEmpty()) {
            CoordinateSnapshot prevSnap = stack.pop();
            coordinate.x = prevSnap.x;
            coordinate.y = prevSnap.y;
            return;
        }
        throw new RuntimeException("Stack is empty");

    }
}
