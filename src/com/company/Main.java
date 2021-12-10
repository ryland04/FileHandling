package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Main {

    private static File myObj = new File("NewFilename.txt"); //Change to something sensible
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String studentName = "";
        int numOfStudents = 0;
        CreateFile();
        System.out.println("Please enter the number of students that you would like in the file: ");
        numOfStudents = scanner.nextInt();
        for (int i = 0; i < (numOfStudents+1); i++) {
            System.out.println("Please enter the name of the student that you would like to append: ");
            studentName = scanner.nextLine();
            WriteToFile(studentName);
        }


        ReadFile();
        DeleteFile();
    }


    public static void CreateFile() {
        try {
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void WriteToFile(String studentName) {
        try {
            FileWriter myWriter = new FileWriter(myObj.getName(), true); //True means append to file contents, False means overwrite
            myWriter.write(studentName+"\n"); // Appends everything in the file
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void ReadFile() {
        try {
            Scanner myReader = new Scanner(myObj);
            System.out.println("These are the students with a u or an e in the name");
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.contains("e")||data.contains("u")){
                    System.out.println(data);
                }


            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void DeleteFile() {
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
}