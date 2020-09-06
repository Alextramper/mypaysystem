package ru.krayPro.beans;

public class Client implements Person {

    public Client( int id, String login, String psswd, String firstname, String secondname, String surname, Account account) {
        this.id = id;
        this.login = login;
        this.psswd = psswd;
        this.firstname = firstname;
        this.secondname = secondname;
        this.surname = surname;
        this.account = account;
    }

    public Client( String login, String psswd, String firstname, String secondname, String surname) {
        this.login = login;
        this.psswd = psswd;
        this.firstname = firstname;
        this.secondname = secondname;
        this.surname = surname;
    }

    public Client( int id, String login, String psswd, String firstname, String secondname, String surname) {
        this.id = id;
        this.login = login;
        this.psswd = psswd;
        this.firstname = firstname;
        this.secondname = secondname;
        this.surname = surname;
    }

    public Client(String login, String psswd, String firstname, String secondname, String surname, Account account) {
        this.login = login;
        this.psswd = psswd;
        this.firstname = firstname;
        this.secondname = secondname;
        this.surname = surname;
        this.account = account;
    }

    public Client( int id, String firstname, String secondname, String surname, Account account) {
        this.id = id;
        this.firstname = firstname;
        this.secondname = secondname;
        this.surname = surname;
        this.account = account;
    }

    public Client() {}

    private int id;
    private String login;
    private String psswd;
    private String firstname;
    private String secondname;
    private String surname;
    private Account account;

   public int getId() {return id;}

   public void setId(int id) {this.id = id;}

   public String getLogin() {return login;}

   public void setLogin(String login) {this.login = login;}

   public String getPsswd() {return psswd;}

   public void setPsswd(String psswd) {this.psswd = psswd;}

   public String getFirstname() {return psswd;}

   public void setFirstname(String firstname) {this.firstname = firstname;}

   public String getSecondname() {return secondname;}

   public void setSecondname(String secondname) {this.secondname = secondname;}

   public String getSurname() {return surname;}

   public void setSurname(String surname) {this.surname = surname;}

   public Account getAccount() {return account;}

    public void setAccount(Account account) {this.account = account;}

   public String getFullName() {
       return String.join(" ", surname, firstname, secondname);
   }

}
