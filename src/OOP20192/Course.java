
package OOP20192;

import java.util.Scanner;

public class Course {
    static Scanner in = new Scanner(System.in);
    private String courseNumber,courseTitle;
    private int position;
    private Student[] students;
    public Course(String courseNumber, String courseTitle)
    {
        this.courseNumber=courseNumber;
        this.courseTitle=courseTitle;
        students=new Student[20];
        position=0;
    }
    public int addStudent(Student s)
    {
        if(position==20)
        {
            System.out.println("\n---------full course---------");
            return -1;
        }
        for(int i=0;i<position;i++)
        {
           if(students[i].getFullName().equalsIgnoreCase(s.getFullName()) 
                  && students[i].getStudentId().equalsIgnoreCase(s.getStudentId()))
           {
                System.out.println("---------student already in the course---------");
                return 0;
           }
        }
        students[position]=s;
        position++;
        return 1;
    }
    public void deleteStudent(String studentId)
    {
        boolean exists=false;
        for(int i=0;i<position;i++)
        {
            if(students[i].getStudentId().equalsIgnoreCase(studentId))
            {
                students[i]=students[position-1];
                students[position-1]=null; 
                position--;
                exists=true;
            }
        }
        if(!exists)
            System.out.println("--------No such student--------");
    }
    public void addExamScore(String studentId, int reference, int Score)
    {
        boolean exists=false; // I added this boolean variable for the Optional part of the projct.
        for(int i=0;i<position;i++)
        {
            if(students[i].getStudentId().equalsIgnoreCase(studentId))
            {
               students[i].setExamScore(reference, Score);
               exists=true;
            }
        }
        if(!exists)
            System.out.println("--------No such student--------");
    }
    public void resetCourse()
    {
        for(int i=0;i<position;i++)
        {
            students[i]=null;
        }
        position=0;
    }
    public void showStudents()
    {
        if(position!=0)
        {
            for(int i=0;i<position;i++)
                System.out.println(students[i]);
        }
        else 
            System.out.println("--------Empty course--------");
    }
    public double getAverage()
    {
        int sum=0;
        for(int i=0;i<position;i++)
            sum+=students[i].getTotalExamScore();
        return sum/(double)position;
    }
    
    //----------------------------------------------------------------------------------------------------------------
    
    // OPTIONAL METHOD : 
    
    // a getter for the course number : 
    public String getCourseNum()
    {return courseNumber;}
    
    
}
