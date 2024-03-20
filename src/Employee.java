import java.time.LocalDate;

public class Employee {
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
