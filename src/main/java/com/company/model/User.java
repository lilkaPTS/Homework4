package com.company.model;

import java.io.*;
import java.util.LinkedList;
import java.util.Objects;

public class User implements Serializable {
    private String firstName;
    private String lastName;
    private String patronymic;
    private int age;
    private double salary;
    private String email;
    private String company;
    private final static long serialVersionUID = -5816838616656868105L;

    public User() {
    }

    public User(String firstName, String lastName, String patronymic, int age, double salary, String email, String company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.age = age;
        this.salary = salary;
        this.email = email;
        this.company = company;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return firstName.equals(user.firstName) && lastName.equals(user.lastName) && patronymic.equals(user.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, patronymic);
    }

    public static User searchUser(SearchUser searchUser) {
        LinkedList<User> users = deSerializeObjects();
        User result = null;
        for(User user: users) {
            if(user.getFirstName().equals(searchUser.getFirstName()) && user.getLastName().equals(searchUser.getLastName())) {
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

    public static boolean contains(User user) {
        return User.deSerializeObjects().contains(user);
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
