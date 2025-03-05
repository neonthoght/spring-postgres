package my.spring.postgres.spring_postgres;

public class AppUser {
    //public int id; // user_id
    public String userName; // user_name
    public String userPassword;
    public int userRoleId; // role_id

    public AppUser (String userName, String userPassword, int userRoleId) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRoleId = userRoleId;
    }

    /*
    public void setId( int id) {
        this.id = id;
    } 
    public int getId() {
        return this.id;
    }
    */

    public void setUserName( String userName) {
        this.userName = userName;
    }
    public String getUserName() {
        return this.userName;
    }
    public void setUserPassword( String userPassword) {
        this.userPassword = userPassword;
    }
    public String getUserPassword() {
        return this.userPassword;
    } 
    public int getUserRoleId() {
        return this.userRoleId;
    } 
}
