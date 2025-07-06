package design.patterns;

import java.util.HashMap;
import java.util.Map;

public class TestFlyWeight {
    public static void main(String[] args) {

    }
}

class MapRenderer {

    void renderIcon(String type, String name, int x, int y) {
        MarkerIcon markerIcon = MarkerIconManager.getConfig(type);
        markerIcon.draw(x, y);
    }
}

class MarkerIconManager {
    static Map<String, MarkerIcon> markerIconMap = new HashMap<>();

    static MarkerIcon getConfig(String key) {
        if (!markerIconMap.containsKey(key)) {
            markerIconMap.put(key, new MarkerIcon(key, "icon- " + key));
        }
        return markerIconMap.get(key);
    }
}

class MarkerIcon {
    String type;
    String image;

    public MarkerIcon(String type, String image) {
        this.type = type;
        this.image = image;
    }

    void draw(int x, int y) {
        System.out.println("Drawing type " + this.type + " at x= " + x + " y=" + y);
    }
}
