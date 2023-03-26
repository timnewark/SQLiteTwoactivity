package com.example.sqlitetwoactivity;



public class CustomerModel{
    // THIS IS CREATING A CLASS WITH 4 ATTRIBITEs
    private int id;
    private String name;
    private int age;
    private boolean isActive;



    //THIS IS CREATING THE CONSTRUCTOR FOR THE CLASS CUSTOMERMODEL
    public CustomerModel(int id, String name, int age, boolean isActive) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.isActive = isActive;

    }
    //NON PARAMETERISED CONSTRUCTOR, NOT USING
    public CustomerModel(int id) {

    }

    // toString is necessary for printing the contents of a class object. its a very common method.
    @Override
    public String toString() {
        return "CustomerModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isActive=" + isActive +
                '}';
    }



    //GETTERS AND SETTERS BELOW - four of each
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
