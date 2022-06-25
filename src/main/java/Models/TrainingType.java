package Models;

public class TrainingType {
    private int type_number;
    private String training_type;
    private int reimburse_percent;

    //Will not need setters/constructors - will be set in DB.
    public int getType_number(){
        return this.type_number;
    }
    public String getTraining_type(){
        return this.training_type;
    }
    public int getReimburse_percent(){
        return this.reimburse_percent;
    }
}
