package EntityOlympia;

public class EPoint {

    private int stt;
    private String name;
    private int diem;

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

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public Boolean ExistName(String strName)
    {
        if (this.name.equalsIgnoreCase(strName))
            return true;
        return false;
    }

}
