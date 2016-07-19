package com.hometask.module9;

import com.hometask.module9.cesarcode.EnglishCesar;
import com.hometask.module9.files.AudioFile;
import com.hometask.module9.files.ImageFile;
import com.hometask.module9.files.TextFile;


public class Runner {


    public static void main(String[] args) throws DirectoryIsEmptyException {
        AudioFile audioFile = new AudioFile("Marron 5 - Wake up call");
        TextFile textFile = new TextFile("Thinking in Java");
        ImageFile imageFile = new ImageFile("Diagram of dependency");
        Directory myDirectory = new Directory("MyDirectory");
        myDirectory.addFileToDirectory(audioFile);
        myDirectory.addFileToDirectory(textFile);
        myDirectory.addFileToDirectory(imageFile);
        myDirectory.printFilesOnDirectory(myDirectory.getFiles());
        System.out.println(myDirectory.getFiles().toString());
        EnglishCesar englishCesar = new EnglishCesar(myDirectory.getFiles().toString(), 5);
        englishCesar.toEncrypt();
        englishCesar.toDecrypt();



    }
}

