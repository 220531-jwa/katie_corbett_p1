import dev.corbett.Controllers.RequestsController;
import dev.corbett.Controllers.UserController;
import dev.corbett.Repos.RequestsDAO;
import dev.corbett.Repos.UserDAO;
import dev.corbett.Services.RequestsService;
import dev.corbett.Services.UserService;
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
