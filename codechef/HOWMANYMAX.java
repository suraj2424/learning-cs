package codechef;

import java.util.Scanner;

/*

codechef: HOW MANY MAXIMUMS
Difficulty: 1202
Link: https://www.codechef.com/problems/HOWMANYMAX

*/


public class HOWMANYMAX {
    public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-->0) {
		    int n = sc.nextInt();
            String s = sc.next();
            char[] c = s.toCharArray();

            int count=0;

                for (int i = 0; i < n-2; i++) {
                    if(c[i]=='0'&&c[i+1]=='1'){
                        count++;
                    }
                }
                
            if(c[0]=='1')count++;
            if(c[n-2]=='0')count++;

            System.out.println(count);
		}
        sc.close();
	}
}
