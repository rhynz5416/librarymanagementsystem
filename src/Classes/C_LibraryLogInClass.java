package Classes;

public class C_LibraryLogInClass {

    private String Username;
    private String Password;

    public C_LibraryLogInClass(String username, String password) {
        this.Username = username;
        this.Password = password;
    }

    public String getusername() {
        return Username;
    }

    public String getpassword() {
        return Password;
    }
}
