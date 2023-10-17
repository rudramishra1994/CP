class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        int bitmap = 0;
        for (int cell : cells) {
            bitmap <<= 1;
            bitmap |= cell;
        }

        Map<Integer, Integer> seen = new HashMap<>();
        boolean cycleFound = false;
        
        while (n > 0) {
            if (!cycleFound) {
                if (seen.containsKey(bitmap)) {
                    cycleFound = true;
                    int cycleLength = seen.size() - seen.get(bitmap);
                    n %= cycleLength;
                } else {
                    seen.put(bitmap, seen.size());
                }
            }
            
            if (n > 0) {
                n--;
                bitmap = ~((bitmap >> 1) ^ (bitmap << 1)) & 0x7E;
            }
        }

        int[] ret = new int[cells.length];
        for (int i = cells.length - 1; i >= 0; i--) {
            ret[i] = bitmap & 1;
            bitmap >>= 1;
        }
        return ret;
    }
}
