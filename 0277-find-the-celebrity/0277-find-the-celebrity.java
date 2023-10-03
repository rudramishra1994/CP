/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int celebCandiate = 0;
        for(int i = 1 ; i < n ; i++){
            if(knows(celebCandiate,i))
                celebCandiate = i;
        }

        for(int i = 0 ; i < n;i++){
            if(i == celebCandiate) continue;
            if(knows(celebCandiate,i) || !knows(i,celebCandiate)) return -1;
        }
        return celebCandiate;
    }
}