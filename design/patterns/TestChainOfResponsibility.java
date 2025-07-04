package design.patterns;

public class TestChainOfResponsibility {

    public static void main(String[] args) {
    LoginRequest loginRequest = new LoginRequest("user1", "ALWAYS_ALLOW",true, "India");
    LoginHandler first = new GeoLocationHandler(new LicenseCheckHandler(null));
    first.handle(loginRequest);

    }
}

abstract class LoginHandler {
    LoginHandler next;

    public LoginHandler(LoginHandler handler) {
        this.next = handler;
    }

    abstract void handle(LoginRequest loginRequest);
}

class GeoLocationHandler extends LoginHandler {

    public GeoLocationHandler(LoginHandler handler) {
        super(handler);
    }

    @Override
    void handle(LoginRequest loginRequest) {
        if (!loginRequest.location.equalsIgnoreCase("India")) {
            throw new RuntimeException("Outside Indian users are not allowed");
        }
        if (next != null) {
            next.handle(loginRequest);
        }
    }
}

class LicenseCheckHandler extends LoginHandler {

    public LicenseCheckHandler(LoginHandler handler) {
        super(handler);
    }

    @Override
    void handle(LoginRequest loginRequest) {
        if (loginRequest.hasLicenseExpired) {
            throw new RuntimeException("License expired");
        }
        if (next != null) {
            next.handle(loginRequest);
        }
    }
}

class LoginRequest {
    String userId;
    String accessPolicy;
    boolean hasLicenseExpired;
    String location;

    public LoginRequest(String userId, String accessPolicy, boolean hasLicenseExpired, String location) {
        this.userId = userId;
        this.accessPolicy = accessPolicy;
        this.hasLicenseExpired = hasLicenseExpired;
        this.location = location;
    }
}
