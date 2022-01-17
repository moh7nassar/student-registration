
package OOP20192;

public class Student {
    private String studentID;
    private String firstName;
    private String lastName;
    private Address homeAddress;
    private CollegeAddress schoolAddress;
    private int firstExamScore;
    private int secondExamScore;
    private int finalExamScore;
    public Student(String studentID, String firstName, String lastName, Address homeAddress, CollegeAddress schoolAddress)
    {
        this.studentID=studentID;
        this.firstName=firstName;
        this.lastName=lastName;
        this.homeAddress=homeAddress;
        this.schoolAddress=schoolAddress;
        firstExamScore=0;
        secondExamScore=0;
        finalExamScore=0;
    }
    public String getFullName()
    {return firstName+" "+lastName;}
    public String getStudentId()
    {return studentID;}
    public void setExamScore(int reference,int examScore)
    {
        switch(reference)
        {
            case 1:
                firstExamScore=examScore;
                break;
            case 2:
                secondExamScore=examScore;
                break;
            case 3:
                finalExamScore=examScore;
                break;
        }
    }
    public int getExamScore(int reference)
    {
        switch(reference)
        {
            case 1:
                return firstExamScore;
            case 2:
                return secondExamScore;
            case 3:
                return finalExamScore;
            default:
                return -1;
        }
    }
    public int getTotalExamScore()
    {
        return firstExamScore+secondExamScore+finalExamScore;
    }
    public String toString()
    {
        return "Student's Name : "+getFullName()+"\n"+
                "Student's ID : "+studentID+"\n"+
                "Student's home address : \n"+homeAddress+"\n"+
                "Student's college address : \n"+schoolAddress+"\n"+
                "Student's total score : "+getTotalExamScore()+"\n";       
    }
}
