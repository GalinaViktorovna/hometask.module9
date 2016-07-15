package com.hometask.module9;

import com.hometask.module9.files.File;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    private String name;
    private List<File> files = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public List<File> getFiles() {
        return files;
    }

    @Override
    public String toString() {
        return "Directory{" +
                "name='" + name + '\'' +
                '}';
    }

    public List<File> addFileToDirectory(File file) {
        files.add(file);
        System.out.println(file + " was added to " + name);
        return files;
    }

    public void printFilesOnDirectory(List<File> directoryForPrint) throws DirectoryIsEmptyException {
        if (directoryForPrint.size() == 0) {
            throw new DirectoryIsEmptyException("Directory is empty!!! Add file please");
        } else {
            directoryForPrint.stream().forEach(file -> System.out.println(file));
        }
    }


}

