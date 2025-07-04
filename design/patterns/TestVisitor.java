package design.patterns;

import java.util.ArrayList;
import java.util.List;

public class TestVisitor {
    public static void main(String[] args) {
        List<Visitable> visitables = new ArrayList<>();
        visitables.add(new PersistentDesktop());
        visitables.add(new NonPersistentDesktop());
        LicenseCostVisitor licenseCostVisitor = new LicenseCostVisitor();
        for (Visitable visitable : visitables) {
            visitable.accept(licenseCostVisitor);
        }
    }
}

interface Visitable {
    void accept(Visitor visitor);
}

interface Visitor {
    void visit(PersistentDesktop persistentDesktop);

    void visit(NonPersistentDesktop nonPersistentDesktop);
}

class LicenseCostVisitor implements Visitor {
    int totalCost = 0;

    @Override
    public void visit(PersistentDesktop persistentDesktop) {
        totalCost += 100;
    }

    @Override
    public void visit(NonPersistentDesktop nonPersistentDesktop) {
        totalCost += 50;
    }
}

class PersistentDesktop implements Visitable {
    String memoryInGb;
    int cpuCores;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class NonPersistentDesktop implements Visitable {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
