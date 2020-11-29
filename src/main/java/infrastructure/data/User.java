package infrastructure.data;

public class User {
   public String id;
   public String userName;
   public String eMail;
   public String userPassword;

    public User(String id, String userName, String eMail, String password) {
        this.id = id;
        this.userName = userName;
        this.eMail = eMail;
        this.userPassword = password;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEMail() {
        return eMail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "eMail='" + eMail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
