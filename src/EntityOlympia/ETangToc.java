package EntityOlympia;

public class ETangToc {

    private int stt;
    private String question;
    private String ansA;
    private String ansB;
    private String ansC;
    private String ansD;
    private String answer;

    public ETangToc() { }
    public ETangToc(int STT, String ques, String a, String b, String c, String d, String ans)
    {
        this.stt = STT;
        this.question = ques;
        this.ansA = a;
        this.ansB = b;
        this.ansC = c;
        this.ansD = d;
        this.answer = ans;
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

    public String getAnsA() {
        return ansA;
    }

    public void setAnsA(String ansA) {
        this.ansA = ansA;
    }

    public String getAnsB() {
        return ansB;
    }

    public void setAnsB(String ansB) {
        this.ansB = ansB;
    }

    public String getAnsC() {
        return ansC;
    }

    public void setAnsC(String ansC) {
        this.ansC = ansC;
    }

    public String getAnsD() {
        return ansD;
    }

    public void setAnsD(String ansD) {
        this.ansD = ansD;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    //endregion

    public Boolean IsCorrect(String ans)
    {
        if (this.answer.equalsIgnoreCase(ans))
            return true;
        return false;
    }
    public Boolean IsCorrect(int STT,String ans)
    {
        if (this.answer.equalsIgnoreCase(ans) && this.stt == STT)
            return true;
        return false;
    }

}
