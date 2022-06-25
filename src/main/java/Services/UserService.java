package Services;

import Models.User;
import Repos.UserDAO;

public class UserService {
    private static UserDAO ud;
    public UserService(UserDAO ud){
        this.ud = ud;
    }

    public User getUserById(int user_id){
        return ud.getUserById(user_id);
    }

    public User getUserByUsername(String username){
        return ud.getUserByUsername(username);
    }

    public User loginUser(String username, String pword){
        User u = ud.getUserByUsername(username);
        if(u.getUsername().equals(username)){
            if(u.getPword().equals(pword)){
                return u;
            } else {
                System.out.println("Invalid password");
                return null;
            }
        } else {
            System.out.println("Username not found");
            return null;
        }
    }
}