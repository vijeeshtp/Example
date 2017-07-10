package com.expertzlab;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 */
public class Main {

    static final String SOURCE_FILE= "students.txt";
    static final String DESTINATION_FILE= "ranklist.txt";

    public static void main(String[] args) throws Exception {
        List <String> lines = readFromFileIO(SOURCE_FILE);
        List<Student> students = createStudentList(lines);
        Collections.sort(students,new MarkComparator());
        System.out.println(students);
        writeToFileIO(DESTINATION_FILE,students);
    }



    public static List<String> readFromFile(String filename) throws IOException{
        Path path = Paths.get(filename);
        List<String> lines = Files.readAllLines(path);
        return lines;
    }

    public static List<String> readFromFileIO(String filename) throws IOException{
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }


    public static void writeToFile(String filename, List<Student> students) throws IOException{
        Path path = Paths.get(filename);
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedWriter writer = Files.newBufferedWriter(path, charset)) {
            for (Student student :students)    {
                writer.write(student.toString(), 0, student.toString().length());
                writer.write("\n");
            }
        } catch (IOException x) {
            System.err.format("IOException:", x);
        }
    }

    public static void writeToFileIO(String filename, List<Student> students) throws IOException{
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Student student :students)    {
                writer.write(student.toString(), 0, student.toString().length());
                writer.write("\n");
            }
        } catch (IOException x) {
            System.err.format("IOException:", x);
        }
    }



    static List<Student>  createStudentList (List<String> lines){
        List <Student> students= new ArrayList<>();
        for ( String str :lines){
            String [] tokens= str.split(" ");
            students.add(new Student(tokens[0],tokens[1],Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4])));
        }
        return students;
    }

}

 class Student {
     String id;
     String name;
     int mark1;
     int mark2;
     int mark3;
     int total;
     public Student(String id, String name, int mark1, int mark2, int mark3) {
         this.id = id;
         this.name = name;
         this.mark1 = mark1;
         this.mark2 = mark2;
         this.mark3 = mark3;
         this.total= mark1+ mark2+ mark3;
     }

     @Override
     public String toString() {
         return "Student{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", total=" + total +
               '}';
     }
 }


class MarkComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return o2.total-o1.total;
    }
}

class NameComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }
}
