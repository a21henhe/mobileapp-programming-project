package com.example.project;

public class Tree {

    private int id;
    private String name;
    private int size;
    private String auxdata;

    public Tree(int id, String name, int height, String auxdata) {
        this.id = id;
        this.name = name;
        this.size = height;
        this.auxdata = auxdata;
    }

    public String getAuxdata() {
        return auxdata;
    }

    public void setAuxdata(String auxdata) {
        this.auxdata = auxdata;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


}
