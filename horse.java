import java.util.*;
import java.io.*;

public class horse {
    public static void main(String args[]) throws IOException
    {
        Scanner scan=new Scanner(new File("horse.dat"));
        int numOfBreeds=scan.nextInt();
        scan.nextLine();
        ArrayList<String> breeds=new ArrayList<>();
        int[] numPerBreed=new int[numOfBreeds];
        while(scan.hasNext())
        {
            String horse=scan.nextLine();
            if(!breeds.contains(horse))
            {
                breeds.add(horse);
                int ind=breeds.indexOf(horse);
                numPerBreed[ind]=1;
            }
            else
            {
                int ind=breeds.indexOf(horse);
                numPerBreed[ind]++;
            }
        }
        System.out.println("Barn:");
        for(int i=0; i<numOfBreeds; i++)
        {
            System.out.println(breeds.get(i)+" ------- "+numPerBreed[i]);
        }
    }
}
