package DAY2;

public class DAY2_Topic2_Array_Dynamic {
    public static void main(String[] args) {

        String[] location,country,place; //declare dynamic string variables
        int[] expense,serial; //declare dynamic int array variables

        //define dynamic array with the length (size) of that variable
        country=new String[5];
        country[0]="India";
        country[1]="USA";
        country[2]="Germany";
        country[3]="Bangladesh";
        country[4]="United Kingdom";

        serial=new int[4];//allocating
        serial[0]=1;
        serial[1]=2;
        serial[2]=3;
        serial[3]=4;

        expense= new int[2];//allocating
        expense[0]=1500;
        expense[1]=2000;

        System.out.println("My Country for next vacation is: " +country[4]);
        System.out.println(serial[0]+") Total cost i plan to spend on my trip is: $"+expense[1]);

    }//end of main
}//end of class
