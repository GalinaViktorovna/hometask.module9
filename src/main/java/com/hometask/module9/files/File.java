package com.hometask.module9.files;

public class File {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "File{" +
                "name='" + name + '\'' +
                '}';
    }
}
