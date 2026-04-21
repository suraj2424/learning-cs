class EasyPronounciation {
    boolean isVowel(Character c) {
        String s = "aeiou";
        return s.indexOf(Character.toLowerCase(c)) == -1 ? false : true;
    }

    void checkVowel(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                System.out.println(s.charAt(i) + " is a VOWEL");
            }
        }
    }

    boolean hardToPronounce(String s) {
        int count = 0;
        char[] c = s.toCharArray();
        for (char ch : c) {
            if (isVowel(ch)) {
                count = 0;
                continue;
            } else {
                count++;
                if (count > 4)
                    return true;
            }
        }
        return false;
    }
}

class ATM_Machine {
    // print '1' if amount can be withdrawn else '0'
    void canWithdraw(int[] arr, int K) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= K) {
                System.out.print('1' + "");
                K -= arr[i];
            } else {
                System.out.print('0' + "");
            }
        }
    }
}

class TCS_Examination {
    void exam(int[] dr, int[] sl) {
        int drTotal = dr[0] + dr[1] + dr[2];
        int slTotal = sl[0] + sl[1] + sl[2];
        if (drTotal > slTotal) {
            System.out.println("Dragon");
        } else if (drTotal < slTotal) {
            System.out.println("Sloth");
        } else {
            if (dr[0] > sl[0]) {
                System.out.println("Dragon");
            } else if (dr[0] < sl[0]) {
                System.out.println("Sloth");
            }
            if (dr[1] > sl[1]) {
                System.out.println("Dragon");
            } else if (dr[1] < sl[1]) {
                System.out.println("Sloth");
            } else {
                System.out.println("Tie");
            }
        }
    }
}

class AdjacentSumParity{
    void isPossible(int[] B) {
        int sum = 0;
        for(int num : B) {
            sum += num;
        }
        if(sum % 2 == 0) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}

public class CodeChef {
    public static void main(String[] args) {
        /* Easy Pronounciation */
        // EasyPronounciation ep = new EasyPronounciation();
        // String s = "AREA";
        // ep.checkVowel(s);

        /* ATM Machine */
        // ATM_Machine atm = new ATM_Machine();
        // int[] arr = {3,5,3,2,1};
        // int K = 10;
        // atm.canWithdraw(arr, K);

        /* TCS Examination */
        // TCS_Examination tcs = new TCS_Examination();
        // int[] dr = { 10, 20, 30 };
        // int[] sl = { 30, 20, 10 };
        // tcs.exam(dr, sl);


        /* Adjacent Sum Parity */
        // AdjacentSumParity asp = new AdjacentSumParity();
        // int[] B = {1,0,1,0};
        // asp.isPossible(B);

        

        
    }
}
