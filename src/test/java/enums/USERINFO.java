package enums;

public enum USERINFO {
    SELLER(true,"Mpho","Etam","Mbebe","VHt*zzt*wQNu6XS","seller_urban@mailsac.com","","",""),
    BUYER(true,"Cristiano","Ronaldo","Santos","VHt*zzt*wQNu6XS","buyer_urban@mailsac.com","","","eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpYXQiOjE2NzY3MjQzMjYsImV4cCI6MTcwNzgyODMyNiwicm9sZXMiOlsiUk9MRV9VU0VSIiwiUk9MRV9TRUxMRVIiXSwiZW1haWwiOiJidXllcl91cmJhbkBtYWlsc2FjLmNvbSIsImlkIjoxNDg1LCJmaXJzdE5hbWUiOiJDcmlzdGlhbiIsInBpY3R1cmUiOiIvdXBsb2Fkcy91c2VyLzE0ODUvNjNlNWMwNjQ4YjViMy5wbmciLCJnb29nbGVJZCI6bnVsbCwiZmFjZWJvb2tJZCI6bnVsbCwibGlua2VkaW5JZCI6bnVsbCwiZ2l0aHViSWQiOm51bGwsImFwcGxlSWQiOm51bGwsImlzVmVyaWZpZWQiOmZhbHNlLCJwaG9uZSI6IisxICg1NzUpIDAzOC01MDcwIiwiZGV2aWNlVG9rZW4iOiIwIiwiY3JlYXRlZCI6eyJkYXRlIjoiMjAyMy0wMS0xNyAxNDoyMzo1MS4wMDAwMDAiLCJ0aW1lem9uZV90eXBlIjozLCJ0aW1lem9uZSI6IlVUQyJ9LCJwYXlwYWxBY2NvdW50SWQiOm51bGwsImxhdCI6NTQuOTc0NDE4NSwibG5nIjotMS42NTgzNDk4LCJicm93c2VyTm90aWZpY2F0aW9ucyI6ZmFsc2UsImFsbG93QW5vbnltb3VzQ2hhdCI6dHJ1ZSwiemlwQ29kZSI6bnVsbCwiZGVsaXZlcnlUeXBlIjpbIkJVWUVSX1BJQ0tVUF9GUk9NX0JSQU5DSCIsIlNFTExFUl9GTEVYSUJMRSJdLCJtYXhEZWxpdmVyeVJhbmdlIjowLCJmcmVlRGVsaXZlcnlSYW5nZSI6NywibWluRnJlZURlbGl2ZXJ5T3JkZXIiOjIzMCwicGVyTWlsZUNvc3QiOjIsImF2YWlsYWJpbGl0eSI6IiIsImVzdGltYXRlZERlbGl2ZXJ5VGltZSI6WyI2MF8yIl0sImF2YWlsYWJpbGl0eUJyYW5jaCI6IjA4OjAwLTE3OjAwIiwibWlkZGxlTmFtZSI6IlJvbmFsZG8iLCJsYXN0TmFtZSI6IlNhbnRvcyIsImZsZXhpYmxlRGVsaXZlcnlPcHRpb25zIjpbeyJpZCI6MTE0OCwiZGVsaXZlcnlCeSI6MTY4NCwib3JkZXJCZWdpbiI6MTY4Mywib3JkZXJFbmQiOjE2ODR9XX0.BKjEWUUZU5b6p5elkMarWR9V742LzD93mrAoaXcln84Z2Zn_O762_93QKkf3FzPbmQLK8_dz34f7GkqzxlnAtaWCw92mzmqi_ktmvid0489NH1-5FqD54WQYBjJ1sY1S0AslKB9XQnHdb1ta69dPsDbnDUfYCspVAOXSwwlFAi-lfIY8YXAlPbja5EYdXDV2D7xTBiYWzPGt76YVTRzhVta1c07vbvot-ZfcBMqFwfgXRhIBZ6Q2Vk5mChd_zAThXnRRI-c9Q5Oi9EmHxGrlNDlq56LESiOGxGJ8rh-jXUENZ95A2b6ZT3-7n2L2HJ_8IY5jOZ8VNyr7iKOKfmzIQQ")

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
