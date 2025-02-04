/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.sql.Timestamp;

/**
 *
 * @author aless
 */
public class Comments {

    private int comment_id;
    private String comment_text;
    private int user_id;
    private Timestamp timestamp;
    private int poi_id;
    private String user_name;

    public Comments(int comment_id, String comment_text, int user_id, Timestamp timestamp, int poi_id, String user_name) {
        this.comment_id = comment_id;
        this.comment_text = comment_text;
        this.user_id = user_id;
        this.timestamp = timestamp;
        this.poi_id = poi_id;
        this.user_name = user_name; 
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getPoi_id() {
        return poi_id;
    }

    public void setPoi_id(int poi_id) {
        this.poi_id = poi_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

}
