package de.bcxp.challenge.weather;

public class Weather{
    private int day, mxt, mnt, hrp, tpcpn, pdir, dir, mxs, mxr, mnr;
    private double avt, avdp, avsp, avslp, skyc;

    public Weather(int day, int mxt, int mnt, double avt, double avdp, int tpcpn, int pdir, double avsp, int dir, int mxs, double skyc, int mxr, int mnr, double avslp){
        this.day = day;
        this.mxt = mxt;
        this.mnt = mnt;
        this.avt = avt;
        this.avdp = avdp;
        this.tpcpn = tpcpn;
        this.pdir = pdir;
        this.avsp = avsp;
        this.dir = dir;
        this.mxs = mxs;
        this.skyc = skyc;
        this.mxr = mxr;
        this.mnr = mnr;
        this.avslp = avslp;
    }

    public int getDay() {
        return day;
    }

    public int getMxt() {
        return mxt;
    }

    public int getMnt() {
        return mnt;
    }

    public int getHrp() {
        return hrp;
    }

    public int getTpcpn() {
        return tpcpn;
    }

    public int getPdir() {
        return pdir;
    }

    public int getDir() {
        return dir;
    }

    public int getMxs() {
        return mxs;
    }

    public int getMxr() {
        return mxr;
    }

    public int getMnr() {
        return mnr;
    }

    public double getAvt() {
        return avt;
    }

    public double getAvdp() {
        return avdp;
    }

    public double getAvsp() {
        return avsp;
    }

    public double getAvslp() {
        return avslp;
    }

    public double getSkyc() {
        return skyc;
    }

}
