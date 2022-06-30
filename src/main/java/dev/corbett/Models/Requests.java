package dev.corbett.Models;

public class Requests {
    private int request_id;
    private int user_id;
    private String employee_first_name;
    private String employee_last_name;
    private String request_date;
    private String request_time;
    private int trainingType;
    private String description;
    private float request_cost;
    private String request_justification;
    private int gradeType;
    private int status;
    private String proof;

    public Requests(){

    }

    public Requests(int request_id, int user_id, String employee_first_name,
                    String employee_last_name, String request_date, String request_time, int trainingType,
                    String description, float request_cost, String request_justification,
                    int gradeType, int status, String proof){
        this.request_id = request_id;
        this.user_id = user_id;
        this.employee_first_name = employee_first_name;
        this.employee_last_name = employee_last_name;
        this.request_date = request_date;
        this.request_time = request_time;
        this.trainingType = trainingType;
        this.description = description;
        this.request_cost = request_cost;
        this.request_justification = request_justification;
        this.gradeType = gradeType;
        this.status = status;
        this.proof = proof;
    }

//    public void setUser_id(int user_id){
//        this.user_id = user_id;
//    }
    public int getUser_id(){
        return this.user_id;
    }

//    public void setRequest_id(int request_id){
//        this.request_id = request_id;
//    }
//    public int getRequest_id(){
//        return this.request_id;
//    }

//    public void setEmployee_first_name(String employee_first_name){
//        this.employee_first_name = employee_first_name;
//    }
    public String getEmployee_first_name(){
        return this.employee_first_name;
    }

//    public void setEmployee_last_name(String employee_last_name){
//        this.employee_last_name = employee_last_name;
//    }
    public String getEmployee_last_name(){
        return this.employee_last_name;
    }

//    public void setRequest_date(String request_date){
//        this.request_date = request_date;
//    }
    public String getRequest_date(){
        return this.request_date;
    }

//    public void setRequest_time(String request_time){
//        this.request_time = request_time;
//    }
    public String getRequest_time(){
        return this.request_time;
    }

//    public void setTrainingType(int trainingType){
//        this.trainingType = trainingType;
//    }
    public int getTrainingType(){
        return this.trainingType;
    }

//    public void setDescription(String description){
//        this.description = description;
//    }
    public String getDescription(){
        return this.description;
    }

//    public void setRequest_cost(float request_cost){
//        this.request_cost = request_cost;
//    }
    public float getRequest_cost(){
        return this.request_cost;
    }

//    public void setRequest_justification(String request_justification){
//        this.request_justification = request_justification;
//    }
    public String getRequest_justification(){
        return this.request_justification;
    }

//    public void setGradeType(int gradeType){
//        this.gradeType = gradeType;
//    }
    public int getGradeType(){
        return this.gradeType;
    }

//    public void setStatus(int status){
//        this.status = status;
//    }
    public int getStatus(){
        return this.status;
    }

//    public void setProof(String proof){
//        this.proof = proof;
//    }
    public String getProof(){
        return this.proof;
    }
}
