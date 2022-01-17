
package OOP20192;

import java.util.Scanner;

public class OptionalDemo {
    
    public static int index=0;
    // this method checks whether the course that was entered by the user is in the array of courses or not
    public static int courseChecking(String ID, Course[]k)
    {
        for(int i=0;i<index;i++)
        {
            if(k[i].getCourseNum().equalsIgnoreCase(ID))
                return i; // if the course is in the array, the index value of that course will be returned to do the appropriate operation.
        }
        return -1; //if the course is not in the array, the returned value will be -1.
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the number of courses you want to add : ");
        int x=in.nextInt(),meIndex;
        Course [] co = new Course[x];
        while(true){
        System.out.println("\n1- add Course \n2- add student to a course\n3- delete student from a course\n4- remove all students from a course\n"+
                "5- display students from a course\n6- add exam score to a student in a course\n7- show total average of students in course\n8- exit");
        int input=in.nextInt(),referenceNum,scoreVal;
        boolean exit=false;
        String courseNumber,studentID;
        // Declaring variables to take student's info from keyboard (step No.2).
        String ID,FirstName,LastName,streetHome,cityHome,streetCollege,cityCollege,collegeName,courseTitle;
        int buildingHome,buildingCollege;
        switch(input)
        {
            case 1:
                if(index<x)
                {
                    System.out.println("Please enter the course Number and its Title : ");
                    courseNumber=in.next();
                    courseTitle=in.next();
                    meIndex=courseChecking(courseNumber,co); // storing data that was returned from method 'courseChecking' into 'meIndex' variable.
                    if(meIndex>=0){
                        System.out.println("---------Course already exists---------");
                    }
                    else
                    {
                        co[index]=new Course(courseNumber,courseTitle);
                        index++;
                    }
                }
                else
                    System.out.println("---------Cannot add more courses(you've reached the limit)---------");
                break;
            case 2:
                System.out.println("Please enter the course Number that you want to add a student to it : ");
                courseNumber=in.next();
                meIndex=courseChecking(courseNumber,co);
                if(meIndex>=0)
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
                       co[meIndex].addStudent(new Student(ID,FirstName,LastName,new Address(cityHome,streetHome,buildingHome),new CollegeAddress(cityCollege,streetCollege,buildingCollege,collegeName)));
                }
                else
                    System.out.println("--------Course not found--------");
                break;
            case 3:
                System.out.println("Please enter the course number that you want to delete a student from it : ");
                courseNumber=in.next();
                meIndex=courseChecking(courseNumber,co);
                if(meIndex>=0)
                {
                    System.out.println("Please enter the student's ID : ");
                    co[meIndex].deleteStudent(in.next());
                }
                else
                    System.out.println("---------Course not found---------");
                break;
            case 4:
                System.out.println("Please enter the course number that you want to remove all its students : ");
                courseNumber=in.next();
                meIndex=courseChecking(courseNumber,co);
                if(meIndex>=0)
                {
                    co[meIndex].resetCourse();
                }
                else
                    System.out.println("---------Course not found---------");
                break;
            case 5:
                System.out.println("Please enter the course number that you want to display all its students : ");
                courseNumber=in.next();
                meIndex=courseChecking(courseNumber,co);
                if(meIndex>=0)
                {
                    co[meIndex].showStudents();
                }
                else
                    System.out.println("---------Course not found---------");
                break;
            case 6:
                System.out.println("Please enter the course number : ");
                courseNumber=in.next();
                meIndex=courseChecking(courseNumber,co);
                if(meIndex>=0)
                {
                    System.out.println("Please enter the student's ID : ");
                    studentID=in.next();
                    System.out.println("Please enter which exam you want to fill in \n1--> first exam\n2--> second exam\n3--> final exam  ");
                    referenceNum=in.nextInt();
                    System.out.println("Please enter the score : ");
                    scoreVal=in.nextInt();
                    co[meIndex].addExamScore(studentID, referenceNum, scoreVal);
                }
                else
                    System.out.println("---------Course not found---------");
                break;
            case 7:
                System.out.println("Please enter the course number that you want to display its students average : ");
                courseNumber=in.next();
                meIndex=courseChecking(courseNumber,co);
                if(meIndex>=0)
                {
                    System.out.println("the students' average in this course is : " + co[meIndex].getAverage());
                }
                else
                    System.out.println("---------Course not found---------");
                break;
            case 8:
                exit=true;
        }
        if(exit)
        {
            System.out.println("Thanks for trusting this program (:\nGoodbye!");
            break; // break statement to get out of the loop.
        }
    }
}
}