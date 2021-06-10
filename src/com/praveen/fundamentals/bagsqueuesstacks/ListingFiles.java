package com.praveen.fundamentals.bagsqueuesstacks;
import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class ListingFiles {

    //Queue
    Queue<File> queue = new LinkedList<>();

    public void listFiles(String path) {
        File root = new File(path);
        if(!root.exists()) throw new UnsupportedOperationException("Path Does not exist");
        queue.offer(root); //Offer =~ enqueue
        while (!queue.isEmpty()) {
            File file = queue.poll(); //pool =~ dequeue
            if(!file.isDirectory()) {
                System.out.println(file.length() + ":\t" + file.getAbsolutePath());
            } else {
                File[] files = file.listFiles();
                for(File f : files) {
                    queue.offer(f);
                }
            }
        }
    }

    public static void main(String[] args) {
        ListingFiles listingFiles = new ListingFiles();
        listingFiles.listFiles("C:\\Users\\prave\\OneDrive\\Desktop\\AWS-certification");
    }
}
