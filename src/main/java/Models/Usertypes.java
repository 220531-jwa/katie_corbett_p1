package Models;

public class Usertypes {
    private int user_id;
    private int type;

    //Will not need constructor/setters - will be set in DB. Will not be responsible for getting user_id.

    public int getType(){
        return this.type;
    }
}
