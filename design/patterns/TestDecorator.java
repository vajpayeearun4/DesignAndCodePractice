package design.patterns;

public class TestDecorator {
    public static void main(String[] args) {
    LoggingProcessor logger= new MaskingSensitiveDataDecorator(new RawLogProcessor());
    logger.process("Hey I am Arun");
    }
}

interface LoggingProcessor{
    void process(String log);
}

class RawLogProcessor implements LoggingProcessor{

    @Override
    public void process(String log) {
        System.out.println("Raw log processing: " + log);
    }
}

class LogDecorator implements LoggingProcessor{
    LoggingProcessor loggingProcessor;

    public LogDecorator(LoggingProcessor loggingProcessor) {
        this.loggingProcessor = loggingProcessor;
    }

    @Override
    public void process(String log) {
        loggingProcessor.process(log);
    }
}

class MaskingSensitiveDataDecorator extends LogDecorator{

    public MaskingSensitiveDataDecorator(LoggingProcessor loggingProcessor) {
        super(loggingProcessor);
    }

    @Override
    public void process(String log) {
        System.out.println("Masking sensitive data ");
        loggingProcessor.process(log);
    }
}
