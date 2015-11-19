import java.io.File;
import java.io.FileNotFoundException;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Dictionary {
	//public PrefixTree words;
	NavigableSet<String> words;
	
	//public Dictionary(NavigableSet<String> words){
		//this.words = words;
	//}
	public Dictionary(NavigableSet<String> words ){
		buildDictionary();
		this.words = words;
	}
	
    public void buildDictionary(){
    	words = new TreeSet<String>();
        try{
            Scanner scan = new Scanner(new File("dict.txt"));
            while (scan.hasNext()){
                String entry = scan.nextLine();
                
                //Skipping any words of length 2 because we only want the words that are length 3 and >
                if (entry.length() > 2){
                	words.add(entry);
                }
            }
        }
        catch (FileNotFoundException e){
        	System.err.println("Cannot find dict.txt");
            System.exit(0);
        }
    }
    
    public boolean containsWord(final String possibleWord) {
        return words.contains(possibleWord.toUpperCase());
    }
     
    /**
     * Find all of the words in the Dictionary which start with a given sequence of letters.
     *
     * @param prefix
     * @return A Dictionary which contains only those known words which start with the supplied prefix.
     */
    public Dictionary getChildWords(String prefix) {
        prefix = prefix.toUpperCase();
        return new Dictionary(words.subSet(prefix, false, prefix, true));
    }

}