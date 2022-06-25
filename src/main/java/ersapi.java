import Controllers.UserController;
import Repos.UserDAO;
import Services.UserService;
import io.javalin.Javalin;

import java.awt.image.PackedColorModel;
import static io.javalin.apibuilder.ApiBuilder.*;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.delete;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.patch;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;

public class ersapi {
    public static void main(String[] args) {
        UserController uc = new UserController(new UserService(new UserDAO()));

        Javalin app = Javalin.create();
        app.start();

        app.routes(() -> {
           path("/login", () -> {
              get(UserController::loginUser);
           });
        });
    }


}
