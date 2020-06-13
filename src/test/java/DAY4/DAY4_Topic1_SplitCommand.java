package DAY4;

public class DAY4_Topic1_SplitCommand {
    public static void main(String[] args) {

        //create a string message first and store it as a single string variable
        String message = "Welcome to_Selenium Automation Class";

        //i want to print the kewyord 'Selenium' only from the message variable
        //we need to define String array variable in order to split the message
        String[] arrayResult=message.split(" ");

        //print the result
        System.out.println("My final message is "+arrayResult[2]);

//.................................
        String[] array2= arrayResult[1].split("_");//_is there in string message
        System.out.println("My message is "+array2[1]);
//....................................
        //you want to print out to & class
        System.out.println("My to keyword is " +array2[0]+" my class Keyword is "+arrayResult[3]);
    }
}
