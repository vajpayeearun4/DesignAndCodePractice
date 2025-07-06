package design.patterns;

public class TestBridge {

    public static void main(String[] args) {
        Provider aws = new AWS();
    Resource resource = new VMResource(aws);
    resource.provision();
    }
}

interface Provider{
    void createResource(String name);
    void deleteResource(String name);
}

class AWS implements Provider{

    @Override
    public void createResource(String name) {
        System.out.println("Creating Resource in AWS" + name);
    }

    @Override
    public void deleteResource(String name) {
        System.out.println("Deleting Resource from AWS: " + name);
    }
}

class Azure implements Provider{

    @Override
    public void createResource(String name) {
        System.out.println("Creating Resource in Azure" + name);
    }

    @Override
    public void deleteResource(String name) {
        System.out.println("Deleting Resource from Azure: " + name);
    }
}

abstract class Resource{
    Provider provider;

    public Resource(Provider provider) {
        this.provider = provider;
    }

    abstract void provision();
    abstract void deprovision();
}

class VMResource extends Resource{

    public VMResource(Provider provider) {
        super(provider);
    }

    @Override
    void provision() {
        System.out.println("Provisioning VM.. ");
        provider.createResource("VM->"+1);
    }

    @Override
    void deprovision() {
        System.out.println("Deprovisioning VM.. ");
        provider.deleteResource("VM->"+1);
    }
}
