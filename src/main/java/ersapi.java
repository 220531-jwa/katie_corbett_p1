import Controllers.RequestsController;
import Controllers.UserController;
import Repos.RequestsDAO;
import Repos.UserDAO;
import Services.RequestsService;
import Services.UserService;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;


import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.get;

import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;

public class ersapi {
    public static void main(String[] args) {
        UserController uc = new UserController(new UserService(new UserDAO()));
        RequestsController rc = new RequestsController(new RequestsService(new RequestsDAO()));

        Javalin app = Javalin.create(config -> {
            config.enableCorsForAllOrigins();
            config.addStaticFiles("/public", Location.CLASSPATH);
        });
        app.start();
        app.routes(() -> {
                path("/login", () -> {
                    post(UserController::loginUser);
                });
                path("/employee", () -> {
                    path("/submit", () -> {
                        post(RequestsController::createRequest);
                    });
                    path("/requests", () -> {
                        path("/{user_id}", () -> {
                            get(RequestsController::getRequestsByUserId);
                            path("/{request_id}", () -> {
                                get(RequestsController::getRequestById);
                                put(RequestsController::updateRequestGrade);
                            });
                        });
                    });
                });
                path("/financemgr", () -> {
                    path("/fmrequests", () -> {
                        get(RequestsController::getAllRequests);
                        path("/{user_id}", () -> {
                            get(RequestsController::getRequestsByUserId);
                            path("/{request_id}", () -> {
                                get(RequestsController::getRequestById);
                                put(RequestsController::updateRequestStatus);
                            });
                        });
                    });
                });
        });
    }
}
