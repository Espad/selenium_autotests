package DataTypes;


public class FillFormData {
    public String firstName;
    public String lastName;
    public String emailAddress;
    public Address address;
    public PhoneNumber phoneNumber;
    public String webSite;
    public String hasHosting;
    public String projectDescription;


    public class Address {
        public String streetAddress;
        public String city;
        public String state;
        public String postCode;
    }

    public class PhoneNumber {
        public String home;
        public String mob;
    }
}
