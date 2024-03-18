import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

enum Department {
    DEV, QA, SUPPORT
}

class EAddress{
    private String city;
    private String pincode;

    public EAddress(String city, String pincode) {
        this.city = city;
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
class Employee {
    private Integer id;
    private String name;
    private LocalDate dateOfJoining;
    private Department department;
    private EAddress eAddress;

    public Employee(Integer id, String name, LocalDate dateOfJoining, Department department, EAddress eAddress) {
        this.id = id;
        this.name = name;
        this.dateOfJoining = dateOfJoining;
        this.department = department;
        this.eAddress = eAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public EAddress geteAddress() {
        return eAddress;
    }

    public void seteAddress(EAddress eAddress) {
        this.eAddress = eAddress;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Random random = new Random();
        for(int i=0; i<1000; i++){
            LocalDate randomDate = LocalDate.of(2010 + random.nextInt(14), random.nextInt(12)+1, random.nextInt(28)+1);
            Department randomDepartment = Department.values()[random.nextInt(Department.values().length)];
            EAddress randomAddress = new EAddress(i%23==0?"Gurgaon":"City"+random.nextInt(10), String.valueOf(100000 + random.nextInt(900000)));
        }

    }
}