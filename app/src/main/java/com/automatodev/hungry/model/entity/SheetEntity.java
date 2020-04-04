package com.automatodev.hungry.model.entity;

public class SheetEntity {
    private String sheetName;
    private int recomendation;
    private String typeSheet;
    private boolean fav;
    private boolean status;
    private String hour;
    private int sheetImg;

    public SheetEntity(String sheetName,
                       int sheetImg,
                       int recomendation,
                       String typeSheet,
                       boolean fav,
                       boolean status,
                       String hour) {

        this.sheetName = sheetName;
        this.recomendation = recomendation;
        this.typeSheet = typeSheet;
        this.fav = fav;
        this.status = status;
        this.hour = hour;
        this.sheetImg = sheetImg;
    }

    public int getSheetImg() {
        return sheetImg;
    }

    public String getSheetName() {
        return sheetName;
    }

    public int getRecomendation() {
        return recomendation;
    }

    public String getTypeSheet() {
        return typeSheet;
    }

    public boolean isFav() {
        return fav;
    }

    public boolean isStatus() {
        return status;
    }

    public String getHour() {
        return hour;
    }
}
