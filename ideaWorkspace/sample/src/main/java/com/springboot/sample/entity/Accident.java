package com.springboot.sample.entity;

import java.io.Serializable;

public class Accident implements Serializable {
    private String accidentId;
    private String accidentTitle;

    public String getAccidentId() {
        return accidentId;
    }

    public void setAccidentId(String accidentId) {
        this.accidentId = accidentId;
    }

    public String getAccidentTitle() {
        return accidentTitle;
    }

    public void setAccidentTitle(String accidentTitle) {
        this.accidentTitle = accidentTitle;
    }

    @Override
    public String toString() {
        return "Accident{" +
                "accidentId='" + accidentId + '\'' +
                ", accidentTitle='" + accidentTitle + '\'' +
                '}';
    }
}
