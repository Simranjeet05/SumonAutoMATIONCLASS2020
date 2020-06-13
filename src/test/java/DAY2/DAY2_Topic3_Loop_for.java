package DAY2;

public class DAY2_Topic3_Loop_for {
    public static void main(String[] args) {

        String[] states= new String[4];
        states[0]="New York";
        states[1]="California";
        states[2]="Texas";
        states[3]="Florida";

        System.out.println("Order Way");

        //defining the loop
        for(int i=0; i<=3; i++) {    //i=0 starting/initial point of index, instead of i u can use anything eg. a or x or abc
                                    // i<=3as we have 4 in string starting with 0 that means its a condition
                                    //i++ increment till the limit

            System.out.println("My State order is: "+states[i]);
        }//end of  loop

        System.out.println();//just to give space
        System.out.println("Reverse order with different start point");

        for(int x=2; x>=0; x--) {    //x=2 starting/initial point of index, instead of i u can use anything eg. a or x or abc
            // x>=0 as we have 4 in string starting point we set is 2 that means its a condition
            //x-- decrement till the limit


            System.out.println("My States is: "+states[x]);
        }//end of  loop



        System.out.println();//just to give space
        System.out.println("Dymanic way: for second step- instaed of i<=2 we use i<states.length ");



        //in dynamic way
        for(int y=2; y<states.length; y++) {    //y=0 starting/initial point of index, instead of i u can use anything eg. a or x or abc
                                                //y++ increment till the limit
            System.out.println("In dynamic way My State is: "+states[y]);
        }//end of  loop


        System.out.println();//just to give space
        System.out.println("Reverse order with dynamic way");

        for(int z=3; z>states.length; z--) { //does not work
            System.out.println("In dynamic way My States reverse order is:"+states[z]);
        }//end of  loop

       System.out.println(" X X X does not work X X X ");
    }//end of main
}//end of class
