public class PrefixTree {
	public PrefixTree[] words;
    private boolean isWord;
    
    public PrefixTree() {
            this.isWord = false;
            this.words = new PrefixTree[26];
    }
    
    public void addWord(String word) {
            char[] c = word.toCharArray();
            PrefixTree current = this;
            for (int i=0; i<c.length; i++) {
                    if (current.getLetter(c[i]) == null) {
                            current.addLetter(c[i]);
                    }
                    current = current.getLetter(c[i]);
            }
            current.isWord = true;
    }
    
    public boolean isWord() {
            return this.isWord;
    }
    
    public void addLetter(char c) {
            this.words[c - 'A'] = new PrefixTree();
    }
    
    public PrefixTree getLetter(char c) {
            return this.words[c - 'A'];
    }
}

