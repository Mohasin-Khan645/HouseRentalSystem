public class House {
    private int id;
    private String name;
    private String phone;
    private String city;
    private String email;
    private String aadhaar;
    private String joiningDate;
    private String flatNumber;
    private double rent;
    private String agreement;

    public House(int id, String name, String phone, String city, String email, String aadhaar, 
                 String joiningDate, String flatNumber, double rent, String agreement) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.city = city;
        this.email = email;
        this.aadhaar = aadhaar;
        this.joiningDate = joiningDate;
        this.flatNumber = flatNumber;
        this.rent = rent;
        this.agreement = agreement;
    }
    // Add a getter for `id`
    public int getId() {
        return id;
    }
    // Other getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAadhaar() {
        return aadhaar;
    }
    public void setAadhaar(String aadhaar) {
        this.aadhaar = aadhaar;
    }
    public String getJoiningDate() {
        return joiningDate;
    }
    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }
    public String getFlatNumber() {
        return flatNumber;
    }
    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }
    public double getRent() {
        return rent;
    }
    public void setRent(double rent) {
        this.rent = rent;
    }
    public String getAgreement() {
        return agreement;
    }
    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }
    @Override
    public String toString() {
        return "ID: " + id +
               "\nName: " + name +
               "\nPhone: " + phone +
               "\nCity: " + city +
               "\nEmail: " + email +
               "\nAadhaar: " + aadhaar +
               "\nJoining Date: " + joiningDate +
               "\nFlat Number: " + flatNumber +
               "\nRent: " + rent +
               "\nAgreement: " + agreement;
    }
}
