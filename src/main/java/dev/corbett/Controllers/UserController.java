package dev.corbett.Controllers;

import dev.corbett.Models.User;
import dev.corbett.Services.UserService;
import io.javalin.http.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserController {
    private static Logger log = LogManager.getLogger(UserController.class);
    private static UserService us;
    public UserController(UserService us){
        this.us = us;
    }

    public static void loginUser(Context ctx){
        User u = ctx.bodyAsClass(User.class);
        String username = u.getUsername();
        String pword = u.getPword();
        User login = null;
        try{
            login = us.loginUser(username, pword);
            if(login != null){
                ctx.status(200);
                ctx.json(login);
            } else {
                ctx.status(404);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
