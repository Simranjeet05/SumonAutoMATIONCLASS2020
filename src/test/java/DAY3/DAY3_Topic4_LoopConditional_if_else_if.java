package DAY3;

public class DAY3_Topic4_LoopConditional_if_else_if {
    public static void main(String[] args) {

        String[] city = new String[4];
        city[0] = "Brooklyn";
        city[1] = "Queens";
        city[2] = "Manhattan";
        city[3] = "Bronx";


        for (int i = 0; i < city.length; i++) {

          /*
            //XXXXXXXXX     using IF ELSE IF condition       XXXXXXXXXX

            //stirng can have equal() command or== but integer must have ==
            // equal command when expected value is matching the array value
            //equal IgnoresCase command will ignore case sensitivity as long as  the array value
            //spelling is correct
            if (city[i].equals("Brooklyn")) { //.equals() has its own pranth..
                System.out.println("My City is " + city[i]);
            } else if (city[i] == "Queens") {
                System.out.println("My City is " + city[i]);
            }
        }//end of loop

         */
            // .....................................................................
            //XXXXXXXXXXX      Using operators to do the same as above     XXXXXXXXX


            //diff operators are <,>,||,&&,<=,>=,==
            //Using or || operators to meet same condition
            if (city[i].equals("Brooklyn") || city[i] == "Queens") { //.equal only works for string, == works for string and int
                System.out.println("My city is " + city[i]);
            }//end of operator condition
        }//end of loop

    }//main class end

}//public class end
