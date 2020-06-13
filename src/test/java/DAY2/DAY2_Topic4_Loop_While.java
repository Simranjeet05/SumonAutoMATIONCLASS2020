package DAY2;

public class DAY2_Topic4_Loop_While {
    public static void main(String[] args) {

        String[] states= new String[4];
        states[0]="New York";
        states[1]="California";
        states[2]="Texas";
        states[3]="Florida";

        //while loop is more of broken down into statements
        //if the argumentsis true/false then perform some action
        int i=0;
        while(i<states.length){
                //print all the vale for states
            System.out.println("My state is " + states[i]);

            i=i+1; //incrementation and you put at the end of the statements otherwise it runs in infinite loop
        }//end of the loop


    }//end of main
}//end of class
