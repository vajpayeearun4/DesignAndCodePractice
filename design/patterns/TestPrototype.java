package design.patterns;

import java.util.HashMap;
import java.util.Map;

public class TestPrototype {
    public static void main(String[] args) {
        VirtualMachine ubuntyMachine = new VirtualMachine("UBUNTU", 4, 100, "SSD", "SecureNet");
        VirtualMachine windowsMachine = new VirtualMachine("Windows", 4, 100, "SSD", "SecureNet");
        VmPrototypeRegistry.registerPrototypes("Ubuntu", ubuntyMachine);
        VmPrototypeRegistry.registerPrototypes("Windows", windowsMachine);

        // clone 10 Windows VMs
        for (int i = 0; i < 10; i++) {
            VirtualMachine ubuntuVm = VmPrototypeRegistry.getClonedVm("Ubunty");
            ubuntuVm.setAntiVirusInstalled(true);
        }
        for (int i = 0; i < 10; i++) {
            VirtualMachine windowsVM = VmPrototypeRegistry.getClonedVm("Windows");
            windowsVM.setAntiVirusInstalled(true);
        }
    }
}

class VmPrototypeRegistry {
    static Map<String, VirtualMachine> prototypeRegistry = new HashMap<>();

    static void registerPrototypes(String name, VirtualMachine virtualMachine) {
        prototypeRegistry.put(name, virtualMachine);
    }

    static VirtualMachine getClonedVm(String prototype) {
        VirtualMachine prototypeMachine = prototypeRegistry.get(prototype);
        return prototypeMachine != null ? prototypeMachine.clone() : null;
    }
}

class VirtualMachine implements Cloneable {
    private String os;
    private int cpuCores;
    private int memoryInGB;
    private String storageType;
    private String networkProfile;
    private boolean isAntiVirusInstalled;

    public VirtualMachine(String os, int cpuCores, int memoryInGB, String storageType, String networkProfile) {
        this.os = os;
        this.cpuCores = cpuCores;
        this.memoryInGB = memoryInGB;
        this.storageType = storageType;
        this.networkProfile = networkProfile;
    }

    public boolean isAntiVirusInstalled() {
        return isAntiVirusInstalled;
    }

    public void setAntiVirusInstalled(boolean antiVirusInstalled) {
        isAntiVirusInstalled = antiVirusInstalled;
    }

    @Override
    public VirtualMachine clone() {
        try {
            VirtualMachine clone = (VirtualMachine) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
