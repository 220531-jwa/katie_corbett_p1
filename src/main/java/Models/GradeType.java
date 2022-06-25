package Models;

public class GradeType {
    private int type_number;
    private String grade_type;

    //will not need constructors or setters - will be set by DB. Will not be responsible for getting type_number.
    public int getType_number(){
        return this.type_number;
    }
    public String getGrade_type(){
        return this.grade_type;
    }
}
