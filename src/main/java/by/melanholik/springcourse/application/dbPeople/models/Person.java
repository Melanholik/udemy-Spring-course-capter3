package by.melanholik.springcourse.application.dbPeople.models;

import javax.validation.constraints.*;

public class Person {
    private int id;
    @NotBlank(message = "name should not be empty")
    @Size(min = 3, max = 30, message = "name should be between 2 and 30 characters")
    private String name;
    @Min(value = 0, message = "Age should be greater or equal to 0")
    private int age;
    @NotEmpty(message = "email should not be empty")
    @Email(message = "email should be valid")
    private String email;

    @NotEmpty
    @Pattern(regexp = "[A-Z]\\w+, [A-Z]\\w+, \\d{6}")
    private String address;


    public Person() {
    }

    public Person(int id, String name, int age, String email, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
