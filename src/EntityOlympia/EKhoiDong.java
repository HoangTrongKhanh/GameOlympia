package EntityOlympia;

public class EKhoiDong {

    private int stt;
    private String question;
    private Boolean answer;

    public EKhoiDong() { }

    public EKhoiDong(int n,String ques, Boolean ans)
    {
        this.stt = n;
        this.answer = ans;
        this.question = ques;
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

    public Boolean getAnswer() {
        return answer;
    }

    public void setAnswer(Boolean answer) {
        this.answer = answer;
    }
    //endregion

    public Boolean IsCorrect(Boolean ans)
    {
        if (this.answer == ans)
            return true;
        return false;
    }
    public Boolean IsCorrect(int STT,Boolean ans)
    {
        if (this.answer == ans && this.stt == STT)
            return true;
        return false;
    }

}
