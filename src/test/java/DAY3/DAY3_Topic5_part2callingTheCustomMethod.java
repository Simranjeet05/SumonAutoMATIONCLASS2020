package DAY3;

public class DAY3_Topic5_part2callingTheCustomMethod {


    public static void main(String[] args) {

        //way1-prints the statement
        //call the method to be executed
        DAY3_Topic5_customMethods_creating.voidAdd(200, 300);


//--------------------------------------------------------------------------------------------------------
        //way2-prints and statement and can be modified also as per you want
        //call the return add method

        int c = DAY3_Topic5_customMethods_creating.returnAdd(200, 300);
        //add the value with the result below
        System.out.println("new result is " + (c-25));

    }//main end
}//class end
