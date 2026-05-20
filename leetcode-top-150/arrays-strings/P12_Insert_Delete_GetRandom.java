import java.util.*;

class RandomizedSet {
    List<Integer> ls;
    Map<Integer,Integer> map;
    Random rand;

    public RandomizedSet() {
        map = new HashMap<>();
        ls = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        } 
        map.put(val, ls.size());
        ls.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }

        int indexRemoved = ls.indexOf(val);
        int lastElem = ls.get(ls.size()-1);

        map.put(lastElem, indexRemoved);
        ls.set(indexRemoved, lastElem);

        ls.remove(ls.size()-1);
        map.remove(val);

        return true;
    }
    
    public int getRandom() {
        int randIndex = rand.nextInt(ls.size());
        return ls.get(randIndex);
    }
}

public class P12_Insert_Delete_GetRandom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        sc.close();
    }
}