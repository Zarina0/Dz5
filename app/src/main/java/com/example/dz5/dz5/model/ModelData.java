package com.example.dz5.dz5.model;

import java.io.Serializable;

public class ModelData implements Serializable {
    private  String title;

    public ModelData(String title) {
        this.title = title;
    }

    public String getData() {
        return title;
    }

    public void setData(String data) {
        this.title = data;
    }
}
