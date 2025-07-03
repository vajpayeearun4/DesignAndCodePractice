package design.patterns;

public class TestFactory {

    public static void main(String[] args) {
        PaymentGateway gateway = PaymentFactory.getGateway("Paytm");
        gateway.processPayment(100);
    }
}

class PaymentFactory{
    static PaymentGateway getGateway(String gateway){
        switch (gateway){
            case "RazorPay":
                return new RazorPay();
            case "Paytm":
                return new Paytm();
            default:
                throw new IllegalArgumentException("Invalid gateway");
        }
    }
}

interface PaymentGateway {
    void processPayment(double amount);
}

class RazorPay implements PaymentGateway {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing using Razorpay: " + amount);
    }
}

class Paytm implements PaymentGateway {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing using Paytm: " + amount);
    }
}
