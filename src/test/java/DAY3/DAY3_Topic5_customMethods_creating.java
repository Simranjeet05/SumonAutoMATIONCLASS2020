package DAY3;

public class DAY3_Topic5_customMethods_creating {

    //purpose of these user defined custom methods so that i can reuse it again conti..
    //and call it on my main method when i need to use them

    //user defined customer methods will be created here

    //lets create one for void first
    //Way1-used to just print the result
    public static void voidAdd(int a,int b) {
        int result =a+b;
        System.out.println("My addition result is " +result);
    }//end of void method
//-------------------------------------------------------------------------------------------

    //lets create same method as return method
    //Way 2 to return the result in the modified way
    public static int returnAdd(int a,int b) {
        int c =a+b;
        System.out.println("My addition result is " +c);
        return c; //will return the resultc
    }//end of void method
}
