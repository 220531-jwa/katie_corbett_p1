package Services;

import Models.Requests;
import Repos.RequestsDAO;

import java.util.List;

public class RequestsService {
    private static RequestsDAO rd;
    public RequestsService(RequestsDAO rd){
        this.rd = rd;
    }

    public Requests createRequest(int user_id, String employee_first_name,
                                  String employee_last_name, String request_date, String request_time, int trainingType,
                                  String description, float request_cost, String request_justification,
                                  int gradeType){
        return rd.createRequest(user_id, employee_first_name,
                employee_last_name, request_date, request_time, trainingType,
                description, request_cost, request_justification, gradeType);
    }

    public List<Requests> getAllRequests(){
        return rd.getAllRequests();
    }

    public List<Requests> getRequestsByUserId(int user_id){
        return rd.getRequestsByUserId(user_id);
    }

    public Requests getRequestById(int request_id, int user_id){
        return rd.getRequestById(request_id, user_id);
    }

    public Requests updateRequestGrade(int request_id, int user_id, String proof){
        return rd.updateRequestGrade(request_id, user_id, proof);
    }

    public Requests updateRequestStatus(int user_id, int request_id, int status){
        return rd.updateRequestStatus(user_id, request_id, status);
    }
}
