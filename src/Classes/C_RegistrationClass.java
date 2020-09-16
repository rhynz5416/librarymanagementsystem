package Classes;

public class C_RegistrationClass {

    private String Name;
    private String Birthday;
    private String Gender;
    private String Address;
    private String Barcode;
    private String Type;
    private String Course;
    private String Username;
    private String Password;
    private String DateIssued;
    private String DateExpired;

    public C_RegistrationClass(String barcode, String name, String birthday, String gender, String address, String type, String course, String dateIssued, String dateExpired, String username, String password) {

        this.Barcode = barcode;
        this.Name = name;
        this.Birthday = birthday;
        this.Gender = gender;
        this.Address = address;
        this.Type = type;
        this.Course = course;
        this.DateIssued = dateIssued;
        this.DateExpired = dateExpired;
        this.Username = username;
        this.Password = password;
    }

    public String getbarcode() {
        return Barcode;

    }

    public String getname() {
        return Name;
    }

    public String getbirthday() {
        return Birthday;
    }

    public String getgender() {
        return Gender;
    }

    public String getAddress() {
        return Address;
    }

    public String gettype() {
        return Type;
    }

    public String getcourse() {
        return Course;
    }

    public String getdateIssued() {
        return DateIssued;
    }

    public String getdateExpired() {
        return DateExpired;
    }

    public String getusername() {
        return Username;
    }

    public String getpassword() {
        return Password;
    }

}
