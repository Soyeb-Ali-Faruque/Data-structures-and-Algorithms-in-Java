package Graph;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder_LeetCode_127 {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        WordLadder_LeetCode_127 test1 = new WordLadder_LeetCode_127();
        int result = test1.ladderLength(beginWord,endWord,wordList);
        System.out.println(result);

    }
    private static class Pair{
        private String word;
        private int transformationFrequency;
        public Pair(String word,int transformationFrequency){
            this.word = word;
            this.transformationFrequency = transformationFrequency;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public int getTransformationFrequency() {
            return transformationFrequency;
        }

        public void setTransformationFrequency(int transformationFrequency) {
            this.transformationFrequency = transformationFrequency;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!isEndWordExistInList(endWord,wordList)) return 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord,1));
        while(!queue.isEmpty()){
            Pair object = queue.poll();
            if(endWord.equals(object.getWord())) return object.getTransformationFrequency();
            for(String word : wordList){
                if(diff(word,object.getWord()) == 1) queue.add(new Pair(word, (object.getTransformationFrequency())+1));
            }
        }
        return 0;
    }
    private static int diff(String word1,String word2){
        int diff = 0;
        for(int i =0;i<word1.length();i++){
            if(word1.charAt(i) != word2.charAt(i)) diff++;
        }
        return diff;
    }
    private static boolean isEndWordExistInList(String endWord,List<String> wordList){
        boolean response = false;
        for(String word : wordList){
            if(word.equals(endWord)){
                response = true;
                break;
            }
        }
        return response;

    }
}
