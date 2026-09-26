package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {

        Student oldest = null;
        for (Student s : students) {
            if (oldest == null) {
                oldest = s;
                continue;
            }
            if (s != null) {
                if (s.getAge() > oldest.getAge()) oldest = s;
            }

        }
        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int count = 0;

        for (Student s : students) count += (s.getAge() < 18 ? 0 : 1);
        return count;

    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        int count = 0;
        int cumulSum = 0;
        for (Student s : students)
            if (s != null) {
                count++;
                cumulSum += s.getGrade();
            }
        return cumulSum * 1.0 / count;
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        for (Student s : students)
            if (s != null) {

                if (s.getName().equals(name)) return s;

            }

        return null;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {

        Arrays.sort(students, (Student a, Student b) -> b.getGrade() - a.getGrade());

    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {

        for (Student s : students)
            if (s != null) {

                if (s.getGrade() >= 15) System.out.print(s + " ");

            }
        System.out.println();


    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {

        for (Student s : students)
            if (s != null) {
                if (s.getId() == id) {
                    s.setGrade(newGrade);
                    return true;
                }
            }
        return false;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        for (Student s : students)
            if (s != null) {

                for (Student ss : students)
                    if (ss != null) {
                        if (ss.getName().equals(s.getName())) {
                            System.out.println("Duplicates found.");
                            return true;
                        }
                    }

            }

        return false;

    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        Student[] newStudents = new Student[students.length + 1];
        System.arraycopy(students, 0, newStudents, 0, students.length);
        newStudents[students.length] = newStudent;

        return newStudents;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student[] arr = new Student[5];
        arr[0] = new Student(1, "Youssef", 21, 19);
        arr[1] = new Student(2, "Adam", 20, 15);
        arr[2] = new Student(3, "Om ar", 20, 12);
        arr[3] = new Student(4, "Oussama", 16, 16);
        arr[4] = new Student(5, "Adam", 17, 11);
        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        System.out.println("The oldest student is: " + findOldest(arr));

        // 3) Count adults
        System.out.println("The number of adult students is: " + countAdults(arr));

        // 4) Average grade
        System.out.println("The average grade of students is: " + averageGrade(arr));

        // 5) Find by name
        System.out.println("Find 'Youssef' Student: " + findStudentByName(arr, "Youssef"));

        // 6) Sort by grade desc
        sortByGradeDesc(arr);
        // sort function
        System.out.println("\n== Sorted by grade (desc) ==");

        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id

        boolean updated = updateGrade(arr, 4, 18);
        // function
        System.out.println("\nUpdated id=4? " + updated);
        System.out.println(findStudentByName(arr, "Oussama"));

        // 9) Duplicate names

        System.out.println("Found duplicates? " + hasDuplicateNames(arr));


        // 10) Append new student

        System.out.println("Append new student:");
        for (Student s : appendStudent(arr, new Student(6, "Ahmed", 20, 12))) System.out.println(s);


        //11


        Student[][] school = new Student[2][3];
        school[0][0] = arr[0];
        school[0][1] = arr[1];
        school[0][2] = arr[2];
        school[1][0] = arr[3];
        school[1][1] = arr[4];
        school[1][2] = new Student(6, "Ahmed", 20, 12);


        System.out.println("\n== 11. Challenge == ");

        for (int c = 0; c < school.length; c++) {

            System.out.print("Class " + (c+1) + ": ");
            for (int s = 0; s < school[c].length; s++) {
                System.out.print(school[c][s].getName() + " ");
            }
            System.out.println();
        }

        System.out.println("\n== Top Student in each class == ");
        for (int c = 0; c < school.length; c++) {

            System.out.print("For class " + (c+1) + ": ");
            Student top = null;
            for (Student s:school[c]) {
                if (top == null || s == null || s.getGrade()>top.getGrade()) top = s;

            }
            System.out.println(top==null ? "Null" : top.getName());

        }
    }
}

