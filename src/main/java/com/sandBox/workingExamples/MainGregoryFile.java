package com.sandBox.workingExamples;

import java.io.File;
import java.io.IOException;

public class MainGregoryFile {
    public static void main(String[] args) throws IOException {
        File dir = new File(".\\src");
        printDirectoryDeeply(dir," ");
    }
    public static void printDirectoryDeeply(File dir, String offset){
        File[]files = dir.listFiles();
        if(files != null){
            for(File file:files){
                if(file.isFile()){
                    System.out.println(offset + "File:  " + file.getName());
                }else if(file.isDirectory()){
                    System.out.println(offset + "Directory  " + file.getName());
                    printDirectoryDeeply(file, offset + " ");
                }
            }
        }
    }
}
