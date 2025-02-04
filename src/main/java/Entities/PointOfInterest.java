/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aless
 */
public class PointOfInterest {

    private int poi_id;
    private String poi_name;
    private String poi_location;
    private String poi_type;
    private int poi_likes;
    private List<Comments> comments;

    public PointOfInterest(int poi_id, String poi_name, String poi_location, String poi_type, int aInt1) {
        this.poi_id = poi_id;
        this.poi_name = poi_name;
        this.poi_location = poi_location;
        this.poi_type = poi_type;
        this.poi_likes = poi_likes; // Correctly assign the parameter
        this.comments = new ArrayList<>();
    }

    public int getPoi_id() {
        return poi_id;
    }

    public void setPoi_id(int poi_id) {
        this.poi_id = poi_id;
    }

    public String getPoi_name() {
        return poi_name;
    }

    public void setPoi_name(String poi_name) {
        this.poi_name = poi_name;
    }

    public String getPoi_location() {
        return poi_location;
    }

    public void setPoi_location(String poi_location) {
        this.poi_location = poi_location;
    }

    public String getPoi_type() {
        return poi_type;
    }

    public void setPoi_type(String poi_type) {
        this.poi_type = poi_type;
    }

    public int getPoi_likes() {
        return poi_likes;
    }

    public void setPoi_likes(int poi_likes) {
        this.poi_likes = poi_likes;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

}
