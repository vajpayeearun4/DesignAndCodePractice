package design.patterns;


public class TestBuilder {
    public static void main(String[] args) {
        DesktopPool desktopPool = new DesktopPool.Builder("12", "dedicatePool", "dedicate").build();
    }
}

class DesktopPool {
    private String id;
    private String name;
    private String poolType;
    private String protocol;
    private int maxDesktops;
    private int minDesktops;

    public DesktopPool(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.poolType = builder.poolType;
        this.protocol = builder.protocol;
        this.maxDesktops = builder.maxDesktops;
        this.minDesktops = builder.minDesktops;
    }

    public static class Builder {
        private String id;
        private String name;
        private String poolType;
        private String protocol;
        private int maxDesktops;
        private int minDesktops;

        public Builder(String id, String name, String poolType) {
            this.id = id;
            this.name = name;
            this.poolType = poolType;
        }

        Builder setProtocol(String protocol) {
            this.protocol = protocol;
            return this;
        }

        Builder setMaxDesktop(int maxDesktops) {
            this.maxDesktops = maxDesktops;
            return this;
        }

        Builder setMinDesktops(int minDesktops) {
            this.minDesktops = minDesktops;
            return this;
        }

        DesktopPool build() {
            return new DesktopPool(this);
        }
    }
}
