package com.company.model;

import java.io.*;
import java.util.LinkedList;

public class User implements Serializable {
    private String firstName;
    private String lastName;
    private String patronymic;
    private int age;
    private double salary;
    private String email;
    private String company;
    private final static long serialVersionUID = -5816838616656868105L;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", email='" + email + '\'' +
                ", company='" + company + '\'' +
                '}';
    }

    public static User searchUser(String firstName, String lastName) {
        LinkedList<User> users = deSerializeObjects();
        User result = null;
        for(User user: users) {
            if(user.getFirstName().equals(firstName) && user.getLastName().equals(lastName)) {
                result = user;
            }
        }
        return result;
    }

    public static void saveUser(User user) {
        LinkedList<User> users = deSerializeObjects();
        users.add(user);
        serializeObjects(users);
    }

    private static void serializeObjects(LinkedList<User> users) {
        try (ObjectOutputStream out =
                     new ObjectOutputStream(
                             new BufferedOutputStream(
                                     new FileOutputStream("users.ser")))
        ) {
            out.writeObject(users);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static LinkedList<User> deSerializeObjects() {
        LinkedList<User> users = new LinkedList<>();
        try (ObjectInputStream in =
                     new ObjectInputStream(
                             new BufferedInputStream(
                                     new FileInputStream("users.ser")))) {
            users = (LinkedList<User>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }
}
