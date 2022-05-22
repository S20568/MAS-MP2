package Asocjacja_z_atrybutem;

public abstract class Employee extends Person{
    String address;
    int employeeId;

    protected Employee(String name, String surname, String address, int employeeId) {
        super(name, surname);
        this.address = address;
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Adres='" + address + '\'' +
                ", Numer pracownika=" + employeeId +
                '}';
    }
}
