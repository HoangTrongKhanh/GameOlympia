package EntityOlympia;

public class EVuotChuongNgaiVat {

    private int stt;
    private int sttHN;
    private String question;
    private String answer;
    private int soOHN;

    public EVuotChuongNgaiVat() { }

    public EVuotChuongNgaiVat(int STT, int STTHN, String ques, String ans, int sohn)
    {
        this.stt = STT;
        this.sttHN = STTHN;
        this.question = ques;
        this.answer = ans;
        this.soOHN = sohn;
    }

    //region Get and Set

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public int getSttHN() {
        return sttHN;
    }

    public void setSttHN(int sttHN) {
        this.sttHN = sttHN;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getSoOHN() {
        return soOHN;
    }

    public void setSoOHN(int soOHN) {
        this.soOHN = soOHN;
    }

    //endregion

    public Boolean IsCorrect(int STT, int stthn, String ans)
    {
        if (this.stt == STT && this.sttHN == stthn && this.answer.equalsIgnoreCase(ans))
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
