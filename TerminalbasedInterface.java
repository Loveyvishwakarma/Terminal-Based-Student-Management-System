package TerminalBasedStudentManagement;

import java.util.HashMap;
import java.util.Scanner;

public class TerminalbasedInterface {
    static class Student {

        static int s_id = 0;

        String name;
        int age;
        String roll;
        boolean isPresent = false;
        String Branch;

        Student(String name, int age, String roll, String Branch) {

            s_id++;

            this.name = name;
            this.age = age;
            this.roll = roll;
            this.Branch = Branch;
        }

    }

    static class Operations{
        static HashMap<Integer, Student> map = new HashMap<>();

        static Scanner sc = new Scanner(System.in);

        // We have used our tiny brain and created students
        static void create_student() {

            System.out.print("Enter the name of the student: ");
            String name = sc.nextLine();

            System.out.print("Enter the age of the student: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter the roll number of the student: ");
            String roll = sc.nextLine();

            System.out.print("Enter the Branch of the student: ");
            String branch = sc.nextLine();

            Student student = new Student(name, age, roll, branch);

            map.put(Student.s_id, student);

            System.out.println("Student created.....");
        }

        static void update_student() {

            System.out.print("Enter student ID: ");
            int id = sc.nextInt();

            Student student = map.get(id);

            if (student == null) {
                System.out.println("Student not found");
                return;
            }

            System.out.println("1. Update name");
            System.out.println("2. Update age");
            System.out.println("3. Update roll");
            System.out.println("4. Update branch");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter new name for the student: ");
                    student.name = sc.nextLine();
                    break;

                case 2:
                    System.out.print("Enter the new age for the student: ");
                    student.age = sc.nextInt();
                    sc.nextLine();
                    break;

                case 3:
                    System.out.print("Enter the new roll number for the student: ");
                    student.roll = sc.nextLine();
                    break;

                case 4:
                    System.out.print("Enter the new Branch for the student: ");
                    student.Branch = sc.nextLine();
                    break;

                default:
                    System.out.println("Invalid choice");
            }

            System.out.println("Student updated.....");
        }

        static void delete_student() {

            System.out.print("Enter student ID to delete: ");
            int id = sc.nextInt();
            sc.nextLine();

            if (!map.containsKey(id)) {
                System.out.println("Student not found");
                return;
            }

            map.remove(id);

            System.out.println("Student deleted.....");
        }

        static void mark_student() {

            System.out.print("Enter student ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            Student student = map.get(id);

            if (student == null) {
                System.out.println("Student not found");
                return;
            }

            student.isPresent = true;

            System.out.println("Student marked present.....");
        }

        static void get_student(){
            System.out.print(map);
            System.out.println("Got all students.....");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("Press 1 if you want to Create Student");
            System.out.println("Press 2 if you want to Update Student");
            System.out.println("Press 3 if you want to Delete Student");
            System.out.println("Press 4 if you want to Mark Attendance of a particular student");
            System.out.println("Press 5 if you want to get all students");
            System.out.println("Press 6 if you want to Exit");
            System.out.print("Select what kind of operation do you want to perform: ");
            int input = sc.nextInt();

            switch (input){
                case 1: //we gonna create student wowww....
                    Operations.create_student();
                    break;

                case 2: //we gonna to update student.... :(
                    Operations.update_student();
                    break;

                case 3: //we gonna delete student..... TT
                    Operations.delete_student();
                    break;

                case 4: //Mark attendance wohooo
                    Operations.mark_student();
                    break;

                case 5: //get all students
                    Operations.get_student();
                    break;
            }

            if(input == 6){
                break;
            }
        }
    }
}
