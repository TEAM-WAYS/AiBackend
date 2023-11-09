package com.example.backendai.dto;

public class ItemDTO {
    private String INGNAME;
    private String INGAMOUNT;
    private String INGMEASUREMENT;

    public String getINGNAME() {
        return INGNAME;
    }

    public void setINGNAME(String INGNAME) {
        this.INGNAME = INGNAME;
    }

    public String getINGAMOUNT() {
        return INGAMOUNT;
    }

    public void setINGAMOUNT(String INGAMOUNT) {
        this.INGAMOUNT = INGAMOUNT;
    }

    public String getINGMEASUREMENT() {
        return INGMEASUREMENT;
    }

    public void setINGMEASUREMENT(String INGMEASUREMENT) {
        this.INGMEASUREMENT = INGMEASUREMENT;
    }
}
