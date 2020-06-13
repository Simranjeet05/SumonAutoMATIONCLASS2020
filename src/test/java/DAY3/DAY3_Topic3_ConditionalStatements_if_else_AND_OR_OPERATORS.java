package DAY3;

public class DAY3_Topic3_ConditionalStatements_if_else_AND_OR_OPERATORS {
    public static void main(String[] args) {

        //scenario is if student grade is 90-100 then its A
        //if student grade is 80 to below 90 then its B
        //if student grade is 70 and below 80 then its C
        //if any thing below c is failure [F]


        //defining variable
        int grade=60; //change the int value to see the results

        if (grade>=90 && grade<=100) {
            System.out.println("Student grade is A");
        }
        else if (grade>=80 && grade<90) {
             System.out.println("Student garde is B");
        }
        else if(grade>=70 && grade<80) {
            System.out.println("Student grade is C");
        }
        else{
            System.out.print("Student Failed with [F] grade");
        }








    }//main class end
}//public class end

