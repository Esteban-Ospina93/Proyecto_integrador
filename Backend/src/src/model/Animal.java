package model;

public class Animal {
    private Integer animalId;
    private String name;
    private Integer age;
    private String animalType;

    //Constructor
    public Animal(){}

    public Animal(Integer animalId, String name, Integer age, String animalType) {
        this.animalId = animalId;
        this.name = name;
        this.age = age;
        this.animalType = animalType;
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

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public Integer getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Integer animalId) {
        this.animalId = animalId;
    }

    @Override
    public String toString() {
        return "model.Animal:" + animalType + ", with Id: " + animalId + ", Name: "+ name + ", Age: "+ age;
    }
}
