public class Model {
    String firstWord;
    String secondWord;

    public void setFirstWord(String firstWord) {
        this.firstWord = firstWord;
    }

    public void setSecondWord(String secondWord) {
        this.secondWord = secondWord;
    }

    public String createSentences(){
        return firstWord + " " + secondWord;
    }
}
