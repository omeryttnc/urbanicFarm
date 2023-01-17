package enums;

public enum USERINFO {
    SELLER(true,"Mpho","Etam","Mbebe","VHt*zzt*wQNu6XS","seller_urban@mailsac.com","","",""),
    BUYER(true,"Cristiano","Ronaldo","Santos","VHt*zzt*wQNu6XS","buyer_urban@mailsac.com","","","")

    ;

    private boolean isTest;
    private String token, firstName, middleName, lastName, password, email, lat, lng;

    USERINFO(boolean isTest, String firstName, String middleName, String lastName, String password, String email, String lat, String lng,String token ) {
        this.isTest = isTest;
        this.token = token;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.lat = lat;
        this.lng = lng;
    }

    public boolean isTest() {
        return isTest;
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

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }
}
