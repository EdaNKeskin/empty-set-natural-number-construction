import java.util.*;
/*
von Neumann construction of natural numbers within set theory: auto converter of the numbers
*/


public class Set {
    public static final String EMPTY_SET = "∅"; //0

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String answer = "0";

        while(!answer.equals("q")) {
            System.out.print("Enter a natural number (>0) n to be written in terms of empty sets: ");
            answer = in.next(); 
            try{
                while(Integer.parseInt(answer) <= 0) {
                    System.out.print("Enter a natural number (>0) n to be written in terms of empty sets: ");
                    answer = in.next(); 
                }
                number2(Integer.parseInt(answer));
                System.out.println();
            } catch(Exception e) {} 
        }
    
        in.close();
    }

    //Previous set added to the end as a set (in {}) is how the numbers work. For reference:
   /*
      1 = {∅}
      2 = {∅, {∅}}
      3 = {∅, {∅}, {∅, {∅}}}
   */
    public static void number (int n) {
        String[] previousNum = new String[n];
        previousNum[0] = EMPTY_SET;

        for( int i = 1; i < n; i++ ) {
            previousNum[i] = Arrays.toString(Arrays.copyOfRange(previousNum, 0, i));
        }

        String settedNumFinal = Arrays.deepToString(previousNum);
        settedNumFinal = settedNumFinal.replace("[", "{").replace("]","}");

        //print resulting set translated from number  (and the number of empty sets- just for fun)
        System.out.println("n (number elements) = " + n + " = " + settedNumFinal);
        System.out.println("Number of empty sets total: " + (int)Math.pow(2, (n-1)));
    }

    //Previous set added to the end as a set (in {}) is how the numbers work. For reference:
   /*
      1 = {∅}
      2 = {∅, {∅}}
      3 = {∅, {∅}, {∅, {∅}}}

      Written using a string and recursion this time. 
   */
    public static void number2 (int n) {
        System.out.print(number2(n-1, "∅"));
    }

    private static String number2(int n, String s) {
        if(n == 0) {
            return "{∅}";
        } else {
            return "{" + s + "," + (number2(n-1, s)) + "}";
        }
    }

}