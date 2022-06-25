package Models;

public class Status {
    private int status_type;
    private String status_descr;

    //Will not need constructor or setters - will be set in DB
    public int getStatus_type(){
        return this.status_type;
    }
    public String getStatus_descr(){
        return this.status_descr;
    }
}
