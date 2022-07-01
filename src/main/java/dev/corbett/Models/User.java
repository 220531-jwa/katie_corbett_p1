package dev.corbett.Models;

public class User {
    private int user_id;
    private String username;
    private String pword;
    private int usertype;

    public User(){

    }

    public User(int user_id, String username, String pword, int usertype){
        this.user_id = user_id;
        this.username = username;
        this.pword = pword;
        this.usertype = usertype;
    }

    public void setUser_id(int user_id){
        this.user_id = user_id;
    }
    public int getUser_id(){
        return this.user_id;
    }

//    public void setUsername(String username){
//        this.username = username;
//    }
    public String getUsername(){
        return this.username;
    }

//    public void setPword(String pword){
//        this.pword = pword;
//    }
    public String getPword(){
        return this.pword;
    }

    public int getUsertype(){
        return this.usertype;
    }
}
