
import java.util.Scanner;


/*
 *  A solution to the XV Computer Science Olimpics task called "Posters"
 *  
 *  The description of the task can be found in here: 
 *  https://szkopul.edu.pl/problemset/problem/au-E9FH96-3U9rCKhcNsD5n9/site/?key=statement
 * 
 *  Written by
 *      Maksymilian Spisjak
 */

public class Main {
    public static void main(String[] args){
        System.out.println(linearSolution(getDataFromStandardInput()));
    }

    static int linearSolution(int[] heights){           //a linear solution
        int[] tempArr=new int[heights.length];          //an array storing the "stack" of buildings
        int tempPointer=0,posters=0;
        tempArr[0]=heights[0];                          //loading the first building's height onto the stack

        for(int i=1;i<heights.length;i++){
            while(heights[i]<tempArr[tempPointer]){     
                                                        //while the next building in the nested loop is bigger than the previous,
                posters++;                              //then we look for the building to "paint"
                tempPointer--;                          //every painted building comes off the stack

                if(tempPointer==-1)                     //if the stack is empty, we reset it
                    tempArr[++tempPointer]=heights[i];  
            }

            if(heights[i]>tempArr[tempPointer])
                tempArr[++tempPointer]=heights[i];

        }
        posters+=tempPointer+1;                         //painting the last buildings left on the stack
        return posters;
    }

    static int[] getDataFromStandardInput(){    //a simple function asking the user where to import the source file from
        Scanner in=new Scanner(System.in);      //and filtering the needed information.
        int numberOfBuildings=in.nextInt();
        int[] heights = new int[numberOfBuildings];

        for(int i=0;i<numberOfBuildings;i++){
            in.next();                      //skipping the buildings' height, as they are not needed
            heights[i]=in.nextInt();
        }
        return heights;
    }
}
