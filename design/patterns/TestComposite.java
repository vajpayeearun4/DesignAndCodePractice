package design.patterns;

import java.util.ArrayList;
import java.util.List;

public class TestComposite {
    public static void main(String[] args) {
        VDIComponent desktop1 = new VDIDesktop("Desktop1");
        VDIComponent desktop2 = new VDIDesktop("Desktop2");
        VDIComponent desktop3 = new VDIDesktop("Desktop3");
        VDICluster vdiCluster = new VDICluster();
        vdiCluster.addDesktop(desktop1);
        vdiCluster.addDesktop(desktop2);
        vdiCluster.addDesktop(desktop3);
        vdiCluster.showStatus();
    }
}

interface VDIComponent {
    void showStatus();
}

class VDIDesktop implements VDIComponent {
    String name;

    public VDIDesktop(String name) {
        this.name = name;
    }

    @Override
    public void showStatus() {
        System.out.println("Desktop-> Healthy");
    }

}

class VDICluster implements VDIComponent {
    List<VDIComponent> vdiComponents = new ArrayList<>();

    void addDesktop(VDIComponent vdiComponent) {
        vdiComponents.add(vdiComponent);
    }

    @Override
    public void showStatus() {
        System.out.println("Cluster-> Healthy");
        for (VDIComponent vdiComponent : vdiComponents) {
            vdiComponent.showStatus();
        }
    }
}