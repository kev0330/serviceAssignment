package cput.ac.za.domain.people;


import java.util.Objects;

public class Employee {

    private String employeeId ,firstName, lastName;
    private int age;

    private Employee(){

    }

    private Employee(Builder builder){
        this.employeeId = builder.employeeId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public int getAge(){
        return age;
    }

    public static class Builder{

        private String firstName, lastName, employeeId;
        private int age;

        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder employeeId(String employeeId){
            this.employeeId = employeeId;
            return this;
        }

        public Builder empAge(int age){
            this.age = age;
            return this;
        }

        public Builder copy(Employee employee) {
            this.employeeId = employee.employeeId;
            this.firstName = employee.firstName;
            this.lastName = employee.lastName;
            this.age = employee.age;
            return this;
      }

        public Employee build(){
            return new Employee(this);
        }
    }


    public String toString(){
        return "Employee ID : " + employeeId + "\nName : " + firstName + "\nSurname : " + lastName +"\nAge : " + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId.equals(employee.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }

}
