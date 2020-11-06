class Solution {
  public int findMaximumXOR(int[] nums) {
    Trie t = new Trie();
    int best = 0;
​
    for (int num : nums) {
      t.insert(num);
      best = Math.max(best, t.maxXOR(num));
    }
​
    return best;
  }
}
​
class Trie {
  class TrieNode {
    TrieNode next[];
    boolean end;
    
    public TrieNode() {
      next = new TrieNode[2];
      end = false;
    }
  }
​
  private TrieNode root;
​
  public Trie() {
    root = new TrieNode();
  }
​
  public void insert(int v) {
    String binary = toBinary(v);
​
    TrieNode trav = root;
    for (int i = 0; i < binary.length(); i++) {
      int idx = binary.charAt(i) - '0';
​
      if (trav.next[idx] == null) {
        trav.next[idx] = new TrieNode();
      }
​
      trav = trav.next[idx];
    }
    trav.end = true;
  }
​
  // Given an integer v, return the maximum XOR of v and some other value in the Trie.
  int maxXOR(int v) {
    String binary = toBinary(v);
​
    TrieNode trav = root;
    int value = 0;
    for (int i = 0; i < binary.length(); i++) {
      // To maximize the XOR, we want to take the complement of binary[i].
      int want = (binary.charAt(i) - '0') ^ 1;
​
      if (trav.next[want] != null) {
        value += (1 << (31 - i));
        trav = trav.next[want];
      } else {
        // The complement doesn't exist, so we need to take the same character.
        trav = trav.next[want ^ 1];
      }
    }
​
    return value;
  }
​
  private String toBinary(int v) {
    StringBuilder binaryRep = new StringBuilder("");
​
    for (int i = 0; i < 32; i++) {
      if ((v & (1 << i)) != 0) {
        binaryRep.append("1");
      } else {
        binaryRep.append("0");
      }
    }
​
    return binaryRep.reverse().toString();
  }
}
