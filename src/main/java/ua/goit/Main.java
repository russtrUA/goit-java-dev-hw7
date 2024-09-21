package ua.goit;

import ua.goit.service.DatabaseQueryService;

public class Main {
    public static void main(String[] args) {
        DatabaseQueryService service = new DatabaseQueryService();
        System.out.println("service.findLongestProject() = " + service.findLongestProject());
        System.out.println("service.findMaxProjectsClient() = " + service.findMaxProjectsClient());
        System.out.println("service.findMaxSalaryWorker() = " + service.findMaxSalaryWorker());
        System.out.println("service.findYoungestEldestWorkers() = " + service.findYoungestEldestWorkers());
        System.out.println("service.getProjectPrices() = " + service.getProjectPrices());
    }
}
