import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.logging.Logger;

public class Main {
    public static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Random random = new Random();
        for(int i=0; i<1000; i++){
            LocalDate randomDate = LocalDate.of(2010 + random.nextInt(14), random.nextInt(12)+1, random.nextInt(28)+1);
            Department randomDepartment = Department.values()[random.nextInt(Department.values().length)];
            EAddress randomAddress = new EAddress(i%23==0?"Gurgaon":"City"+random.nextInt(10), String.valueOf(100000 + random.nextInt(900000)));

            employees.add(new Employee(i, "Employee" + i, randomDate, randomDepartment, randomAddress));
        }

        List<Employee> employeesJoinedBeforeJan2022 = employees.stream()
                .filter(employee -> employee.getDateOfJoining().isBefore(LocalDate.of(2022, 1, 1)))
                .toList();

        StringBuilder joinedBeforeJan2022Builder = new StringBuilder("Employees who joined before January 2022: ");
        for (Employee employee : employeesJoinedBeforeJan2022) {
            joinedBeforeJan2022Builder.append(employee.getName()).append(", ");
        }
        logger.info(joinedBeforeJan2022Builder.toString());

        List<Employee> employeesInGurgaonAndDev = employees.stream()
                .filter(employee -> employee.geteAddress().getCity().equalsIgnoreCase("Gurgaon") && employee.getDepartment() == Department.DEV)
                .toList();

        StringBuilder inGurgaonAndDevBuilder = new StringBuilder("Employees residing in Gurgaon and in the DEV department: ");
        for (Employee employee : employeesInGurgaonAndDev) {
            inGurgaonAndDevBuilder.append(employee.getName()).append(", ");
        }
        logger.info(inGurgaonAndDevBuilder.toString());

        logger.info("Iterating employees using a consumer:");
        Consumer<Employee> employeeConsumer = employee -> logger.info(employee.getName());
        employees.forEach(employeeConsumer);

        employees.addAll(employees.subList(0, 100));

        ConcurrentMap<Integer, Employee> employeeMap = employees.stream()
                .collect(Collectors.toConcurrentMap(Employee::getId, emp -> emp, (existing, replacement) -> existing));

        logger.info("Iterating the employee map after adding duplicates");
        employeeMap.forEach((key, value) -> logger.info("ID: " + key + ", Employee: " + value.getName()));

        Map<Department, Long> departmentEmployeeCount = employees.parallelStream()
                .collect(Collectors.groupingByConcurrent(Employee::getDepartment, Collectors.counting()));

        logger.info("Printing the number of employees in each department:");
        departmentEmployeeCount.forEach((department, count) -> logger.info(department + ": " + count));
    }
}