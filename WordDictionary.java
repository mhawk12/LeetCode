public class WordDictionary {

    Node root;

    public WordDictionary() {

        root = new Node();

    }

    public static void main(String args[]) {

        WordDictionary wD = new WordDictionary();
        wD.addWord("a");
        wD.addWord("a");
//        wD.addWord(".");
//        wD.addWord("add");
//        System.out.println(wD.search("."));
//        System.out.println(wD.search("a"));
//        wD.addWord("bat");
        System.out.println(wD.search("aa"));
//        System.out.println(wD.search("a"));
//        System.out.println(wD.search(".a"));
//        System.out.println(wD.search("a."));
//        System.out.println(wD.search("a.d"));
//        System.out.println(wD.search("."));

    }

    public void addWord(String word) {

        int i = 0;
        Node temp = root;

        while (i < word.length()) {

            int index = word.charAt(i) - 'a';

            if (temp.children[index] == null)
                temp.children[index] = new Node();

            temp = temp.children[index];
            i++;

        }

        temp.isWord = true;

    }

//    public boolean search(String word) {
//
//        int i = 0;
//        Node temp = root;
//
//        while(i < word.length()){
//
//            int index = word.charAt(i) - 'a';
//
//            if(temp.children[index] == null)
//                return false;
//
//            temp = temp.children[index];
//            i++;
//        }
//
//        if(temp.isWord)
//            return true;
//
//        return false;
//
//    }

    public boolean search(String word) {

        return search(word, root, 0);
    }


    private boolean search(String word, Node root, int index) {


        if (root == null)
            return false;

        if (index >= word.length())
            return false;

        int aI = word.charAt(index) - 'a';

        if (index == word.length() && root.isWord)
            return true;

        if (word.charAt(index) == '.') {

            for (int i = 0; i < 26; i++) {

                if (search(word, root.children[i], index + 1))
                    return true;
            }
        } else if (root.children[aI] != null)
            return search(word, root.children[aI], index + 1);

        return false;

    }

    public static class Node {

        boolean isWord;
        Node[] children;

        public Node() {

            this.isWord = false;
            children = new Node[26];
            for (int i = 0; i < 26; i++)
                children[i] = null;
        }
    }

}
