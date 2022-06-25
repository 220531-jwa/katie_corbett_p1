package Controllers;

import Models.User;
import Services.UserService;
import io.javalin.http.Context;

public class UserController {
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
