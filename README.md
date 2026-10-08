# Terminal-Based Student Management System

A simple console-based Java application for managing student records. You can add, update, delete, and list students, and mark their attendance, all from a text menu. Data is stored in memory using a `HashMap`, which makes this a good beginner project for practicing core Java and CRUD logic.

## Features

- **Create Student**: add a student with name, age, roll number, and branch. An ID is assigned automatically.
- **Update Student**: change a student's name, age, roll number, or branch by ID.
- **Delete Student**: remove a student by ID.
- **Mark Attendance**: mark a particular student as present by ID.
- **Get All Students**: print all stored students.
- **Menu-driven interface**: keeps running until you choose Exit.

## Concepts Used

- Nested static classes (`Student`, `Operations`)
- `HashMap<Integer, Student>` to store students by ID
- Static counter (`s_id`) for generating unique IDs
- `Scanner` for reading console input
- `switch` statements and loops for the menu
- Constructors and instance fields

## Project Structure

```
TerminalBasedStudentManagement/
└── TerminalbasedInterface.java
```

The file declares `package TerminalBasedStudentManagement;`, so keep it inside a folder with that name.

## Requirements

- Java Development Kit (JDK) 8 or higher

Check your version with:

```bash
java -version
```

## How to Run

From the folder that **contains** the `TerminalBasedStudentManagement` folder:

```bash
# Compile
javac TerminalBasedStudentManagement/TerminalbasedInterface.java

# Run
java TerminalBasedStudentManagement.TerminalbasedInterface
```

## Usage

When the program starts, you will see this menu:

```
Press 1 if you want to Create Student
Press 2 if you want to Update Student
Press 3 if you want to Delete Student
Press 4 if you want to Mark Attendance of a particular student
Press 5 if you want to get all students
Press 6 if you want to Exit
Select what kind of operation do you want to perform:
```

### Example: Creating a Student

```
Select what kind of operation do you want to perform: 1
Enter the name of the student: Rahul Sharma
Enter the age of the student: 21
Enter the roll number of the student: 2100123
Enter the Branch of the student: IT
Student created.....
```

### Example: Marking Attendance

```
Select what kind of operation do you want to perform: 4
Enter student ID: 1
Student marked present.....
```

## Student Fields

| Field       | Type      | Description                                   |
|-------------|-----------|-----------------------------------------------|
| ID          | `int`     | Auto-generated key, starts from 1             |
| `name`      | `String`  | Student's name                                |
| `age`       | `int`     | Student's age                                 |
| `roll`      | `String`  | Roll number                                   |
| `Branch`    | `String`  | Branch / department                           |
| `isPresent` | `boolean` | Attendance status (defaults to `false`)       |

## Known Limitations

- **No saving**: all data is lost when the program closes (no file or database storage).
- **Unreadable "Get All Students" output**: the `Student` class has no `toString()` method, so option 5 prints object references (like `...$Student@1b6d3586`) instead of student details. Adding a `toString()` fixes this.
- **Attendance can't be undone**: a student can only be marked present, never reset to absent, and the status is not shown anywhere yet.
- **No input validation**: typing letters where a number is expected (age, ID, menu choice) crashes the program with an `InputMismatchException`.
- **No handling for invalid menu choices** in the main menu (it silently shows the menu again).
- **Two `Scanner` objects** read from the same input (one in `main`, one in `Operations`). It works when typing interactively, but it is better to share a single `Scanner`.

## Future Improvements

- Add a `toString()` method to `Student` for readable output
- Validate input with `try-catch` blocks and sensible limits (e.g., age > 0)
- Show attendance status and allow marking absent
- Use a single shared `Scanner`
- Save and load students from a file (or a database using JDBC)
- Add search by name or roll number
- Add date-wise attendance records

## Author

Made by Lovey.

## License

This project is for learning purposes. Feel free to use and modify it.
