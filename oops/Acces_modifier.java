package oops;

public class Acces_modifier {

    public static void main(String args[]) {
        BankAccount b1 = new BankAccount();
        b1.userName = "Gaurav Sharma";
        // we cannot use below to set password because it is private access modifier 
        // b1.password="Gaurav@123";
        b1.setPassword("Gaurav@123");
        System.out.println(b1.userName);
        // System.out.println(b1.password);
        // we can't print the password here because it is private we need getter for it
    }
}

class BankAccount {

    public String userName;
    private String password;

    // here set password is a setter
    // we can also use constructor this property but then we can only able to set once not change by b1.setPassword anytime
    public void setPassword(String pwd) {
        // we can also write this.password=pwd
        password = pwd;
        // System.out.println("also get printed");
    }
}
