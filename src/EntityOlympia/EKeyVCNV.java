package EntityOlympia;

public class EKeyVCNV {

    private int stt;
    private String question;
    private String path;
    private int soOHN;
    private String answer;

    public EKeyVCNV() {}
    public EKeyVCNV(int STT, String ques, String ans, int SoHN, String Path)
    {
        this.stt = STT;
        this.question = ques;
        this.answer = ans;
        this.soOHN = SoHN;
        this.path=Path;
    }

    //region Get and Set
    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getSoOHN() {
        return soOHN;
    }

    public void setSoOHN(int soOHN) {
        this.soOHN = soOHN;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    //endregion

    public Boolean IsCorrect(int STT, String ans)
    {
        if (this.stt == STT && this.answer.equalsIgnoreCase(ans))
            return true;
        return false;
    }
    public Boolean IsCorrect(String ans)
    {
        if (this.answer.equalsIgnoreCase(ans))
            return true;
        return false;
    }

}
