package com.praveen.fundamentals.bagsqueuesstacks;
import java.io.File;
import java.util.LinkedList;

public class ListingFiles {

    LinkedList<String> fileNames = new LinkedList<>();

    public void listFiles(String path) {
        File file = new File(path);
        listFiles(file);
        for(String fileName : fileNames) {
            System.out.println(fileName);
        }
    }


    public void listFiles(File file) {
        if(file.isFile()) {
            fileNames.add(file.toString());
        } else {
            File[] files = file.listFiles();
            for(File dirFile : files) {
                listFiles(dirFile);
            }
        }
    }


    public static void main(String[] args) {
        ListingFiles listingFiles = new ListingFiles();
        listingFiles.listFiles("C:\\Users\\prave\\OneDrive\\Desktop\\AWS-certification");
    }
}
