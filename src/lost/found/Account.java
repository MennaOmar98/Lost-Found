

import java.util.Date;

public class Account {

    private String Name;
    private String Password;
    private String Email;
    private int Age;

    Account() {

    }

    Account(String name, String password, String mail, int age) {
        Name = name;
        Password = password;
        Email = mail;
        Age = age;
    }

    Account(String mail, String password) {
        Password = password;
        Email = mail;
    }

    public String get_Name() {
        return Name;
    }

    public String get_Password() {
        return Password;
    }

    public String get_Mail() {
        return Email;
    }

    public int get_Age() {
        return Age;
    }

    public void set_Name(String name) {
        Name = name;
    }

    public void set_Password(String pass) {
        Password = pass;
    }

    public void set_Mail(String mail) {
        Email = mail;
    }

    public void set_Age(int age) {
        Age = age;
    }

    @Override
    public String toString() {
        return "Account{" + "Name=" + Name + ", Password=" + Password + ", Email=" + Email + ", Age=" + Age + '}';
    }
}
