package com.Xml;

import java.util.Comparator;

public class Film implements Comparator<Film> {
    private String Title;
    private Double NoteMoyenne;

    public Film()
    {
    }
    public Film(Double NM, String T)
    {
        setTitle(T);
        setNoteMoyenne(NM);
    }

    public Double getNoteMoyenne()
    {
        return this.NoteMoyenne;
    }
    public void setNoteMoyenne(Double NM)
    {
        this.NoteMoyenne = NM;
    }
    public void setTitle(String T) {
        this.Title = T;
    }
    public String getTitle()
    {
        return this.Title;
    }

    @Override
    public int compare(Film o1, Film o2) {
        return o1.getNoteMoyenne().compareTo(o2.getNoteMoyenne());
    }
}
