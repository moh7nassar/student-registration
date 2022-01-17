
package OOP20192;

import java.util.Scanner;

public class CourseDriver {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        System.out.println("Welcome...");
        System.out.println("Please enter the course Number and its Title : ");
        Course c=new Course(in.next(),in.next());
        System.out.println("How many students do you want to add to the course? (20 MAX)");
        int studentsNo=in.nextInt();
        // declaring variables to take their values from keyboard inside the loop below.
        String ID,FirstName,LastName,streetHome,cityHome,streetCollege,cityCollege,collegeName;
        int buildingHome,buildingCollege,method;
        
        for(int i=0;i<studentsNo;) // the value of 'i' will be updated inside the loop if the entered student doesn't 
            //already exist in the course, so we don't lose a count when the student already exists.
        {
            System.out.println("Please enter the student's ID : ");
            ID=in.next();
            System.out.println("Please enter the student's first name : ");
            FirstName=in.next();
            System.out.println("Please enter the student's last name : ");
            LastName=in.next();
            System.out.println("Please enter the student's home address (city, street, building) : ");
            cityHome=in.next();
            streetHome=in.next();
            buildingHome=in.nextInt();
            System.out.println("Please enter the student's college address (city, street, building, collegeName) : ");
            cityCollege=in.next();
            streetCollege=in.next();
            buildingCollege=in.nextInt();
            collegeName=in.next();
            method=c.addStudent(new Student(ID,FirstName,LastName,new Address(cityHome,streetHome,buildingHome),new CollegeAddress(cityCollege,streetCollege,buildingCollege,collegeName)));
            if(method==1){
                // if the user entered a new student, the method will return (1) and prompts the user to enter the marks.
                System.out.println("Please enter the student's first exam score : ");
                c.addExamScore(ID, 1, in.nextInt());
                System.out.println("Please enter the student's second exam score : ");
                c.addExamScore(ID, 2, in.nextInt());
                System.out.println("Please enter the student's final exam score : ");
                c.addExamScore(ID, 3, in.nextInt());
                i++;
            }
            else if(method==-1)
                break; // if the course is full then return value will be -1.
            
            // if the method returned 0, the value of 'i' won't be updated because the user entered a student who's already in the course.
        }
        System.out.println("\n");
        c.showStudents();
        System.out.println("The students' Average score equals to : "+c.getAverage());
}
}
