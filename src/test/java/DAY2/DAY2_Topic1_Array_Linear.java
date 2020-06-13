package DAY2;

public class DAY2_Topic1_Array_Linear {
    public static void main(String[] args) {

        String[] locations, countries, places;//declare the empty string variables1
        int[] number, houseAddress; // declare the empty int array variable

        //defining the string array variables
        locations=new String[]{"Sixflag","Disney","Beach"};
        countries=new String[]{"Bangladesh", "India","USA"};
        places= new String[]{"Colony","Road", "Street"};

        //defining the int array variables
        number=new int[]{1,2,3,4};
        houseAddress= new int[]{222,333,444,555};

        //print the last value from location variable
        System.out.println("Location found at: " + locations[2]);//array follows -1, if want 3rd place var enter the numbr 2
        System.out.println("Country: " + countries[1]);

        System.out.println(number[0]+ ") Current Location is "+ locations[2] +" in "+ countries[1]+" at " +houseAddress[2]+" " + places[2]);

        } //end of main method
    } //end of java class

