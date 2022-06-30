package dev.corbett.Controllers;

import dev.corbett.Models.Requests;
import dev.corbett.Services.RequestsService;
import io.javalin.http.Context;
import java.util.List;

public class RequestsController {
    private static RequestsService rs;
    public RequestsController(RequestsService rs){
        this.rs = rs;
    }

    public static void createRequest(Context ctx){
        Requests r = ctx.bodyAsClass(Requests.class);
        int user_id = r.getUser_id();
        String employee_first_name = r.getEmployee_first_name();
        String employee_last_name = r.getEmployee_last_name();
        String request_date = r.getRequest_date();
        String request_time = r.getRequest_time();
        int trainingType = r.getTrainingType();
        String description = r.getDescription();
        float cost = r.getRequest_cost();
        String request_justification = r.getRequest_justification();
        int gradeType = r.getGradeType();
        Requests check = null;
        try{
            check = rs.createRequest(user_id, employee_first_name, employee_last_name, request_date, request_time, trainingType, description,
                    cost, request_justification, gradeType);
            if(check != null){
                ctx.status(200);
                ctx.json(check);
            } else {
                ctx.status(404);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void getAllRequests(Context ctx){
        List<Requests> r = rs.getAllRequests();
        if(r != null){
            ctx.status(200);
            ctx.json(r);
        } else {
            ctx.status(404);
        }
    }

    public static void getRequestsByUserId(Context ctx){
        int user_id = Integer.parseInt(ctx.pathParam("user_id"));
        List<Requests> r = rs.getRequestsByUserId(user_id);
        if(r != null){
            ctx.status(200);
            ctx.json(r);
        } else {
            ctx.status(404);
        }
    }

    public static void getRequestById(Context ctx){
        int user_id = Integer.parseInt(ctx.pathParam("user_id"));
        int request_id = Integer.parseInt(ctx.pathParam("request_id"));
        Requests r = rs.getRequestById(request_id, user_id);
        if(r != null){
            ctx.status(200);
            ctx.json(r);
        } else {
            ctx.status(404);
        }
    }

    public static void updateRequestGrade(Context ctx){
        int user_id = Integer.parseInt(ctx.pathParam("user_id"));
        int request_id = Integer.parseInt(ctx.pathParam("request_id"));
        Requests r = ctx.bodyAsClass(Requests.class);
        String proof = r.getProof();
        Requests updated = null;
        try{
            updated = rs.updateRequestGrade(request_id, user_id, proof);
            if(updated != null){
                ctx.status(200);
                ctx.json(updated);
            } else {
                ctx.status(404);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void updateRequestStatus(Context ctx){
        int user_id = Integer.parseInt(ctx.pathParam("user_id"));
        int request_id = Integer.parseInt(ctx.pathParam("request_id"));
        Requests r = ctx.bodyAsClass(Requests.class);
        int status = r.getStatus();
        Requests updated = rs.updateRequestStatus(user_id, request_id, status);
        if(updated != null){
            ctx.status(200);
            ctx.json(updated);
        } else {
            ctx.status(404);
        }
    }

}
