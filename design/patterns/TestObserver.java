package design.patterns;

import java.util.ArrayList;
import java.util.List;

public class TestObserver {
    public static void main(String[] args) {
        PoolStatusManager poolStatusManager = new PoolStatusManager();
        poolStatusManager.addObserver(new EmailAlertService());
        poolStatusManager.addObserver(new SlackAlertService());
        poolStatusManager.changeStatus("Pool1", "Completed");
    }
}

class PoolStatusManager {
    List<PoolObserver> poolObserverList = new ArrayList<>();

    void addObserver(PoolObserver poolObserver) {
        poolObserverList.add(poolObserver);
    }

    void removeObserver(PoolObserver poolObserver) {
        poolObserverList.remove(poolObserver);
    }

    void changeStatus(String poolId, String newStatus) {
        for (PoolObserver poolObserver : poolObserverList) {
            poolObserver.update(poolId, newStatus);
        }
    }
}

interface PoolObserver {
    void update(String poolId, String newStatus);
}

class EmailAlertService implements PoolObserver {

    @Override
    public void update(String poolId, String newStatus) {
        System.out.println("Notifying via email: pool= " + poolId + " status= " + newStatus);
    }
}

class SlackAlertService implements PoolObserver {

    @Override
    public void update(String poolId, String newStatus) {
        System.out.println("Notifying via slack: pool= " + poolId + " status= " + newStatus);
    }
}
