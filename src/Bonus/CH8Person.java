package Bonus;
public class CH8Person {
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private int phoneNumber;
    
    public boolean changeFirstName(String newFirstName){
        firstName = newFirstName;
        return firstName.equals(newFirstName);
    }
    public boolean changeLastName(String newLastName){
        lastName = newLastName;
        return lastName.equals(newLastName);
    }
    public boolean changeAddress(String newAddress){
        address = newAddress;
        return address.equals(newAddress);
    }
    public boolean changeEmail(String newEmail){
        email = newEmail;
        return email.equals(newEmail);
    }
    public boolean changePhoneNumber(int newPhoneNumber){
        phoneNumber = newPhoneNumber;
        return (phoneNumber == newPhoneNumber);
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getAddress(){
        return address;
    }
    public String getEmail(){
        return email;
    }
    public int getPhoneNumber(){
        return phoneNumber;
    }
    public void printInfoToConsole(){
        System.out.println("First Name: " + firstName + "\n" +
                            "Last Name: " + lastName + "\n" +
                            "Address: " + address + "\n" +
                            "Email: " + email + "\n" +
                            "Phone: " + phoneNumber);
    }
    public String getInfo(){
        return "First Name: " + firstName + "\n" +
                "Last Name: " + lastName + "\n" +
                "Address: " + address + "\n" +
                "Email: " + email + "\n" +
                "Phone: " + phoneNumber;
    }
}
