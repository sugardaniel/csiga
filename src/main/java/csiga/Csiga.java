package csiga;

import java.util.Objects;

public class Csiga
{
    private int messze;
    private String szin;
    private boolean kap;
    private int sebesseg; //Erre az attribútumra szerintem nem feltétlen van szükség

    public Csiga(int messze, String szin, boolean kap, int sebesseg)
    {
        this.messze = messze;
        this.szin = szin;
        this.kap = kap;
        this.sebesseg = sebesseg;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Csiga{");
        sb.append("messze=").append(messze);
        sb.append(", szin='").append(szin).append('\'');
        sb.append(", kap=").append(kap);
        sb.append(", sebesseg=").append(sebesseg);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (object == null || getClass() != object.getClass())
        {
            return false;
        }
        Csiga csiga = (Csiga) object;
        return messze == csiga.messze && kap == csiga.kap && sebesseg == csiga.sebesseg && Objects.equals(szin,
                csiga.szin);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(messze, szin, kap, sebesseg);
    }

    public int getMessze()
    {
        return messze;
    }

    public void setMessze(int messze)
    {
        this.messze = messze;
    }

    public String getSzin()
    {
        return szin;
    }

    public void setSzin(String szin)
    {
        this.szin = szin;
    }

    public boolean isKap()
    {
        return kap;
    }

    public void setKap(boolean kap)
    {
        this.kap = kap;
    }

    public int getSebesseg()
    {
        return sebesseg;
    }

    public void setSebesseg(int sebesseg)
    {
        this.sebesseg = sebesseg;
    }
}
