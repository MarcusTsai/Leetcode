public class Solution {
    // Timeout !!
    public boolean wordBreak(String s, Set<String> wordDict) {
    
    // Why does it build a new ArrayList instead of using the current one?
    List<String> lst = new ArrayList<String>(wordDict);
    
    /*  public interface Comparator<T> {  
     *      int compare(T o1, T o2);
     *  }
     *  Another comparator redefinition that is being used in class
     *  is class with Comparable implementation
     */
     Class StringComparator implements Comparator<String> {
         @Override
         public int compare (String s1, s2) {
            return s2.length() - s1.length();
         }
     }

    // sort by length, longer words appear first
    Collections.sort(lst, new StringComparator());

    return wordBreakHelper(s, lst);
}

boolean wordBreakHelper(String s, List<String> wordDict) {
    if (s == null || s.isEmpty()) {
        return true;
    }

    boolean bStart = false, bEnd = false;
    for (String w : wordDict) {
        if (!bStart && s.startsWith(w))
            bStart = true;
        
        if (!bEnd && s.endsWith(w))
            bEnd = true;
    }
    // can't find a match at all from the start/end
    if (!bStart || !bEnd) {
        return false;
    }
    
    // recursive call
    for (String w : wordDict) {
        // check the the other part matches, the first part
        if (bEnd && s.endsWith(w) && wordBreakHelper(s.substring(0, s.length() - w.length()), wordDict))
            return true;
        
        // check the the other part matches, the last part
        if (bStart && s.startsWith(w) && wordBreakHelper(s.substring(w.length()), wordDict))
            return true;
    }
    return false;
}
}