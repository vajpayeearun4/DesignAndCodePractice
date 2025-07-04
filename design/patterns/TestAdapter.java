package design.patterns;

import java.util.HashMap;
import java.util.Map;

public class TestAdapter {

    public static void main(String[] args) {
        ExternalMetricCollector externalMetricCollector = new NewRelicMetricCollector();
        HorizonMetricCollectorAdapter adapter = new HorizonMetricCollectorAdapter(externalMetricCollector);
        HorizonDesktop horizonDesktop = new HorizonDesktop("desktop1", 55, 99.1);
        adapter.pushMetrics(horizonDesktop);
    }
}

class HorizonDesktop {
    String id;
    double cpuUsage;
    double memoryUsage;

    public HorizonDesktop(String id, double cpuUsage, double memoryUsage) {
        this.id = id;
        this.cpuUsage = cpuUsage;
        this.memoryUsage = memoryUsage;
    }
}

class HorizonMetricCollectorAdapter {
    ExternalMetricCollector externalMetricCollector;

    public HorizonMetricCollectorAdapter(ExternalMetricCollector externalMetricCollector) {
        this.externalMetricCollector = externalMetricCollector;
    }

    void pushMetrics(HorizonDesktop horizonDesktop) {
        Map<String, Double> metricsMap = new HashMap<>();
        metricsMap.put("cpuUsage", horizonDesktop.cpuUsage);
        metricsMap.put("memoryUsage", horizonDesktop.memoryUsage);
        externalMetricCollector.pushMetric(horizonDesktop.id, metricsMap);
    }
}

interface ExternalMetricCollector {
    void pushMetric(String externalId, Map<String, Double> metricsMap);
}

class NewRelicMetricCollector implements ExternalMetricCollector{

    @Override
    public void pushMetric(String externalId, Map<String, Double> metricsMap) {
        System.out.println("NewRelic processing metric");
    }
}
