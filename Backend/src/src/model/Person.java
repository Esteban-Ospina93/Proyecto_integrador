package model;

public abstract class Person {
    private Integer Id;
    private String name;
    private Integer age;
    private String telephone;
    private String CC;
    private String email;

    //Constructor
    public Person(){}

    public Person(Integer id, String name, Integer age, String telephone, String CC, String email) {
        this.Id = id;
        this.name = name;
        this.age = age;
        this.telephone = telephone;
        this.CC = CC;
        this.email = email;
    }

    //Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getCC() {
        return CC;
    }

    public void setCC(String CC) {
        this.CC = CC;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
