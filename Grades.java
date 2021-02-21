package sk.kosickaakademia.stanovska.school;

public class Grades {
    private int math;
    private int eng;
    private int pro;
    private int bio;

    public Grades(int math, int eng, int pro, int bio) {
        this.math = math;
        this.eng = eng;
        //to do add bio
        this.pro = pro;
        this.pro=bio;
    }

    public int getMath() {
        return math;
    }

    public int getEng() {
        return eng;
    }

    public int getPro() {
        return pro;
    }
    
    // override
    @Override
    public String toString(){
        return "Grades: MATH: "+math+" ENG: "+eng+" PRO: "+pro;
}

    public double average(){
        return (double) (math+eng+pro)/3;
    }
    
    public int getValue(){
        retuirn 5;
    }
    //koniec

}
