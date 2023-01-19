import java.util.*;
import java.io.*;

public class ShareIt {
    public static void main(String args[]) throws IOException
    {
        Scanner scan=new Scanner(new File("ShareIt.dat"));
        while(scan.hasNext())
        {
            int num=scan.nextInt();
        scan.nextLine();
        int[] weights=new int[num];
        for(int i=0; i<num; i++)
        {
            weights[i]=scan.nextInt();
        }
        int max=weights[0];
        for(int i=1; i<num; i++)
        {
            if(weights[i]>max)
                max=weights[i];
        }
        int min=weights[0];
        for(int i=1; i<num; i++)
        {
            if(weights[i]<min)
                min=weights[i];
        }
        ArrayList<Integer> group1=new ArrayList<>();
        group1.add(max);
        group1.add(min);
        for(int i=2; i<num; i++)
            group1.add(0);
        
        ArrayList<Integer> group2=new ArrayList<>();
        for(int i=0; i<num; i++)
        {
            if(weights[i]!=max&&weights[i]!=min)
                group2.add(weights[i]);
            else
                group2.add(0);
        }
        int tot1=0;
        for(int i=0; i<num; i++)
            tot1+=group1.get(i);
        
        int tot2=0;
        for(int i=0; i<num; i++)
            tot2+=group2.get(i);

        int diff=Math.abs(tot1-tot2);
        boolean notLowestDiff=true;
        ArrayList<Integer> newGroup1=new ArrayList<>();
        ArrayList<Integer> newGroup2=new ArrayList<>();
        for(int i=0; i<group1.size(); i++)
            newGroup1.add(group1.get(i));
        for(int i=0; i<group2.size(); i++)
            newGroup2.add(group2.get(i));
        while(notLowestDiff)
        {
            int min2=group2.get(0);
            for(int i=1; i<num; i++)
            {
                if(group2.get(i)<min2)
                    min2=group2.get(i);
            }
            newGroup1.add(min2);
            newGroup2.remove(min2);
            int nTot1=0;
            for(int i=0; i<newGroup1.size(); i++)
                nTot1+=newGroup1.get(i);
            
            int nTot2=0;
            for(int i=0; i<newGroup2.size(); i++)
                nTot2+=newGroup2.get(i);

            int nDiff=Math.abs(nTot1-nTot2);
            if(diff<nDiff)
                notLowestDiff=false;
            else
            {
                diff=nDiff;
                group1.clear();
                group2.clear();
                for(int i=0; i<newGroup1.size(); i++)
                    group1.add(newGroup1.get(i));
                for(int i=0; i<newGroup2.size(); i++)
                    group2.add(newGroup2.get(i));
            }
        }
        System.out.println(diff+"\n");
        }
    }
}
