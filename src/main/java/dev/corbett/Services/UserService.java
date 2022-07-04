package dev.corbett.Services;

import dev.corbett.Controllers.RequestsController;
import dev.corbett.Models.User;
import dev.corbett.Repos.UserDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserService {
    private static Logger log = LogManager.getLogger(UserService.class);
    private static UserDAO ud;
    public UserService(UserDAO ud){
        this.ud = ud;
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
