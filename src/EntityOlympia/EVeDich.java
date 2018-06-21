package EntityOlympia;

public class EVeDich {

    private int stt;
    private int sttQues;
    private String question;
    private String ansA;
    private String ansB;
    private String ansC;
    private String ansD;
    private String answer;
    private int point;

    public EVeDich() { }
    public EVeDich(int sTT, int STTQues, String ques, String a, String b, String c, String d, String ans, int diem)
    {
        this.stt = sTT;
        this.sttQues = STTQues;
        this.question = ques;
        this.ansA = a;
        this.ansB = b;
        this.ansC = c;
        this.ansD = d;
        this.answer = ans;
        this.point = diem;
    }

    //region Get and Set
    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public int getSttQues() {
        return sttQues;
    }

    public void setSttQues(int sttQues) {
        this.sttQues = sttQues;
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

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    //endregion

    public Boolean IsCorrect(int STT, int STTQues, String ans)
    {
        if (this.stt == STT && this.sttQues == STTQues && this.answer.equalsIgnoreCase(ans))
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
