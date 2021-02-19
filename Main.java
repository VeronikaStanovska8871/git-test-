package sk.kosickaakademia.stanovska.school;

import sk.kosickaakademia.stanovska.school.hobby.Book;
import sk.kosickaakademia.stanovska.school.hobby.Movie;
import sk.kosickaakademia.stanovska.school.hobby.Sport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Student[] students;
        students = initStudents();
        printN1Students(students);
        printStudentsWhereAverageLE2(students);
        Book b1= new Book ("Hlava XXII", "J.Heller");
        students[0].addHobby(b1);
        Sport s1= new Sport("Hockey");
        Book b2= new Book ("Marina", "A.Sladkovic");
        students[0].addHobby(b2);
        Movie m1= new Movie("Untouchable", "2012");
        students[2].addHobby(m1);
        Movie m2= new Movie("Lion King", "1999");
        students[6].addHobby(m2);
        students[6].addHobby(b2);
        Sport s2= new Sport("Soccer");
        students[9].addHobby(s2);

    }
    private static void printStudentsWhereAverageLE2(Student[] students){
        int i;
        int len= students.length;
        System.out.println("List of students with average ro 2");
        for (i=0;i<len;i++){
            Grades temp = students[i].getGrades();
            double average= (temp.getEng()+ temp.getMath()+ temp.getEng()+ temp.getPro());
                    if (average<=2)
                        System.out.println(" "+students[i].getFirstName()+" "+students[i].getLastName()+ " "+average);
        }
        System.out.println();
    }
    private static void printN1Students(Student[] students) {
        int i;
        int len = students.length;
        System.out.println("List of students - 1N :");
        for (i = 0; i < len; i++) {
            if (students[i].getClassName() == ClassName.N1)
                System.out.println(students[i].toString());
        }
        System.out.println();
    }

    private static Student [] initStudents(){
        Student [] s= new Student[10];

        Grades z1= new Grades(3, 2, 3);
        Student s1 = new Student ("Ivana", "Hornyakova", z1, ClassName.N1, createDob("2003-11-04"));
        s[0]=s1;
        Student s2 = new Student("Peter", "Baran", new Grades(3,2,1), ClassName.N2, createDob("2010-05-30"));
        s[1]=s2;
        Student s3= new Student("Tomas", "Novak", new Grades (1,2,1), ClassName.N1, createDob("1997-06-18"));
        s[2]=s3;
        Student s4= new Student ("Marian", "Miezga", new Grades(3,2,1),ClassName.N3, createDob("1984-12-22"));
        s[3]=s4;
        Student s5= new Student("Daniela", "Pekna", new Grades(1,1,1), ClassName.N1);
        s[4]=s5;
        Student s6= new Student("David","Andrejkovic", new Grades(1,2,2),ClassName.N2);
        s[5]=s6;
        Student s7= new Student("Ema","Majlatova", new Grades(1,1,3), ClassName.N2);
        s[6]=s7;
        Student s8= new Student ("Damian", "Kollar", new Grades(2,2,2), ClassName.N3);
        s[7]=s8;
        Student s9= new Student("Leo", "Hornyak", new Grades(3,2,1), ClassName.N1);
        s[8]=s9;
        Student s10= new Student("Filip", "Balaz", new Grades(3,2,2), ClassName.N1);
        s[9]=s10;
        return s;
    }
    private static Date createDob(String dateS){
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateS);
        }catch(ParseException e){
            e.printStackTrace();
        }
        return null;
    }
    private static void printAge(Student[] students){
        Date currentDate=new Date();
        System.out.println(currentDate);
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(dateFormat.format(currentDate)); 


    }
    private static void shortByAverage (Student [] students){
        int len= students.length;
        for (int i=0; i<len; i++)
            for (int j=0; i<len; j++)
                if (students[j].getGrades().average()>students[j+1].getGrades().average()){
                    Student temp=  students [j];
                    students [j]= students [j+1];
                    students [j+1]=temp;
                }
    }
}
