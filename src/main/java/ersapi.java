import Controllers.RequestsController;
import Controllers.UserController;
import Repos.RequestsDAO;
import Repos.UserDAO;
import Services.RequestsService;
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
        RequestsController rc = new RequestsController(new RequestsService(new RequestsDAO()));

        Javalin app = Javalin.create();
        app.start();

        app.routes(() -> {
           path("/login", () -> {
              get(UserController::loginUser);
           });
           path("/employee", () -> {
               path("/submit", () -> {
                   post(RequestsController::createRequest);
               });
               path("/requests/{user_id}", () -> {
                   get(RequestsController::getRequestsByUserId);
               });
           });
           path("/financemgr/requests", () -> {
               get(RequestsController::getAllRequests);
               path("/{user_id}", () -> {
                   get(RequestsController::getRequestsByUserId);
               });
           });
        });
    }


}
