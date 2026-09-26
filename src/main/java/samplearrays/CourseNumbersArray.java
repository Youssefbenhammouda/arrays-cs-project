package samplearrays;

import java.util.Arrays;

public class CourseNumbersArray {
    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};


        int [] updatedCourses = Arrays.copyOf(registeredCourses, registeredCourses.length+1);
        updatedCourses[updatedCourses.length-1]  = 3010;
        System.out.println("== Content of updatedCourse == ");
        for(int x:updatedCourses)System.out.print(x + " ");
        System.out.println();

        int target = 2140;

        for(int i = 0;i<updatedCourses.length;i++)
            if(updatedCourses[i]==target) {
                System.out.println("Target " + target + " found at index " + i);

                break;
            }


    }
}
