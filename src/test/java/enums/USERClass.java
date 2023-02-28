package enums;

public class USERClass {


    private boolean isTest;
    private int userId;
    private String token,firstName, middleName,lastName,password,email,postalCode;

    public USERClass(boolean isTest, int userId, String email, String password, String firstName, String middleName, String lastName, String postalCode, String token) {
        this.isTest = isTest;
        this.userId = userId;
        this.token = token;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.postalCode = postalCode;
    }

    public boolean isTest() {
        return isTest;
    }

    public int getUserId() {
        return userId;
    }

    public String getToken() {
        return token;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
