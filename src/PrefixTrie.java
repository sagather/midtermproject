//import sun.text.normalizer.Trie;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by bcxtr on 2/17/2017.
 */
public class PrefixTrie {

    private TrieNode root = new TrieNode();

    private class TrieNode{

        private Map<Character, TrieNode> children = new TreeMap<>();
        boolean aWord = false;

    }

    public PrefixTrie(){

    }

    public void insert(TrieNode nRoot, String s){

        TrieNode cur = nRoot;

        for(char ch : s.toCharArray()){

            TrieNode next = cur.children.get(ch);
            if(next == null){
                cur.children.put(ch, next = new TrieNode());
            }
            cur = cur.children.get(ch);

        }
        cur.aWord = true;

    }

    public boolean search(TrieNode node, String s){

        TrieNode cur = node;

        if(cur.children.get(s.charAt(0)) == null){
            return false;
        }
        else if(s.length() == 1 && cur.children.get(s.charAt(0)) != null){
            return true;
        }
        else {

            cur = cur.children.get(s.charAt(0));

            return search(cur, s.substring(1));
        }

    }

    public TrieNode getRoot(){  return this.root;  }

    public Map getChildren(){  return this.root.children;  }

    public void setRoot(Object newRoot){  this.root = (TrieNode) newRoot;  }

}
