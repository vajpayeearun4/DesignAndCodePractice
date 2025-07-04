package design.patterns;

public class TestTemplate {
    public static void main(String[] args) {
        ReportGenerator desktopPoolReport= new DesktopPoolReportGenerator();
        desktopPoolReport.generateReport();
    }
}

class DesktopPoolReportGenerator extends ReportGenerator{

    @Override
    void fetchData() {
        System.out.println("Fetching Desktop Pool data");
    }

    @Override
    void formatData() {
        System.out.println("Formatting to CSV");
    }

    @Override
    void uploadAndNotify() {
        System.out.println("Uploading to S3 and notifying via email");
    }
}

abstract class ReportGenerator {

    final void generateReport() {
        connectToDS();
        fetchData();
        formatData();
        uploadAndNotify();
    }

    void connectToDS() {
        System.out.println("Connecting to DS");
    }

    abstract void fetchData();

    abstract void formatData();

    abstract void uploadAndNotify();
}
