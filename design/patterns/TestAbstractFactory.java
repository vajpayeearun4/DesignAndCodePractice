package design.patterns;

public class TestAbstractFactory {
    public static void main(String[] args) {
        String theme = "Dark";
        UIComponentFactory factory;
        if (theme.equalsIgnoreCase("Light")) {
            factory = new LightUIFactory();
        } else if (theme.equalsIgnoreCase("Dark")) {
            factory = new DarkUIFactory();
        } else {
            throw new IllegalArgumentException("Invalid theme");
        }
        Application application = new Application(factory);
        application.renderUI();
    }
}

class Application {
    Button button;
    Checkbox checkbox;

    public Application(UIComponentFactory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    void renderUI() {
        button.render();
        checkbox.render();
    }
}

interface Button {
    void render();
}

interface Checkbox {
    void render();
}

class LightButton implements Button {

    @Override
    public void render() {
        System.out.println("Rendering Light button");
    }
}

class LightCheckbox implements Checkbox {

    @Override
    public void render() {
        System.out.println("Rendering light checkbox");
    }
}

class DarkButton implements Button {

    @Override
    public void render() {
        System.out.println("Rendering Dark button");
    }
}

class DarkCheckbox implements Checkbox {

    @Override
    public void render() {
        System.out.println("Rendering Dark Checkbox");
    }
}

interface UIComponentFactory {

    Button createButton();

    Checkbox createCheckbox();
}

class LightUIFactory implements UIComponentFactory {

    @Override
    public Button createButton() {
        return new LightButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new LightCheckbox();
    }
}

class DarkUIFactory implements UIComponentFactory {

    @Override
    public Button createButton() {
        return new DarkButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new DarkCheckbox();
    }
}