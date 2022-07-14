package loginMenu;

public class LoginMenu {

    private String userName = "alialvi";
    private String pwd = "seg3101";
    private String email = "ali.alvi@gmail.com";

    public boolean login(String userName, String pwd){
        if(!userName.equals(this.userName) || !pwd.equals(this.pwd))
            return false;
        else
            return true;
    }

    public String changePassword(String userName, String pwd){
        if(userName.equals(this.userName)){
            if(pwd.length() <= 5){
                return "INVALID LENGTH";
            }
            else {
                this.pwd = pwd;
                return "SUCCESS";
            }
        }
        else
            return "WRONG USERNAME";
    }

    public String changeUsername(String email, String userName){
        if(email.equals(this.email)){
            if(userName.length() <= 4)
                return "INVALID LENGTH";
            else {
                this.userName = userName;
                return "SUCCESS";
            }
        }
        else
            return "WRONG EMAIL";
    }
}
