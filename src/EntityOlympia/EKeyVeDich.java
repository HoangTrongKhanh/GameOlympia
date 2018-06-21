package EntityOlympia;

public class EKeyVeDich {

    private int stt;
    private String name;

    public EKeyVeDich() { }
    public EKeyVeDich(int STT, String strName)
    {
        this.stt = STT;
        this.name = strName;
    }

    //region Get and Set
    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //endregion
}
