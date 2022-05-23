package Asocjacja_kwalifikowana;

public abstract class Employee extends Person {
    private String address;
    private int employeeId;

    protected Employee(String name, String surname, String address, int employeeId) {
        super(name, surname);
        this.address = address;
        this.employeeId = employeeId;
    }

    public String getAddress() {
        return address;
    }
    public int getEmployeeId() {
        return employeeId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Adres='" + address + '\'' +
                ", Numer pracownika=" + employeeId +
                '}';
    }
}
