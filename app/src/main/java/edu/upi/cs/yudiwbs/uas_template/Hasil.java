package edu.upi.cs.yudiwbs.uas_template;

//untuk di recylerview
public class Hasil {
    private String hasil;
    private String hasilStatus;
    private String hasilAdvice;

    public String getHasil() {
        return hasil;
    }
    public String getHasilStatus() {
        return hasilStatus;
    }
    public String getHasilAdvice() {
        return hasilAdvice;
    }

    public void setHasil(String hasil) {
        this.hasil = hasil;
    }
    public void setHasilStatus(String hasilStatus) {
        this.hasilStatus = hasilStatus;
    }
    public void setHasilAdvice(String hasilAdvice) {
        this.hasilStatus = hasilAdvice;
    }

    public Hasil(String hasil, String hasilStatus, String hasilAdvice) {
        this.hasil = hasil;
        this.hasilStatus = hasilStatus;
        this.hasilAdvice = hasilAdvice;
    }
}
