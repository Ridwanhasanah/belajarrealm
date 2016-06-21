package com.kalviansofian.belajarrealm.Model;

/**
 * Created by root on 18/06/16.
 */
public class ArticelModel {

    //manampung object sementarara besifat array list ketika operasi CRUD

    private int id;
    private String title;
    private String description;

    public ArticelModel(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
