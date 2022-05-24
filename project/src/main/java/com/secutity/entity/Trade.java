package com.secutity.entity;

public class Trade {

    private int tradeId;

    private int tradeStockholderId;



    private int tradeCompanyId;

    private int stockNum;

    private double sumMoney;

    private  double currentPerprice;

    private  int Type;

    public Trade() {
    }

    public Trade(int tradeId, int tradeStockholderId, int tradeCompanyId, int stockNum, double sumMoney, double currentPerprice, int Type) {
        this.tradeId = tradeId;
        this.tradeStockholderId = tradeStockholderId;
        this.tradeCompanyId = tradeCompanyId;
        this.stockNum = stockNum;
        this.sumMoney = sumMoney;
        this.currentPerprice = currentPerprice;
        this.Type = Type;
    }

    public int getTradeId() {
        return tradeId;
    }

    public void setTradeId(int tradeId) {
        this.tradeId = tradeId;
    }

    public int getTradeStockholderId() {
        return tradeStockholderId;
    }

    public void setTradeStockholderId(int tradeStockholderId) {
        this.tradeStockholderId = tradeStockholderId;
    }

    public int getTradeCompanyId() {
        return tradeCompanyId;
    }

    public void setTradeCompanyId(int tradeCompanyId) {
        this.tradeCompanyId = tradeCompanyId;
    }

    public int getStockNum() {
        return stockNum;
    }

    public void setStockNum(int stockNum) {
        this.stockNum = stockNum;
    }

    public double getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(double sumMoney) {
        this.sumMoney = sumMoney;
    }

    public double getCurrentPerprice() {
        return currentPerprice;
    }

    public void setCurrentPerprice(double currentPerprice) {
        this.currentPerprice = currentPerprice;
    }


    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "tradeId=" + tradeId +
                ", tradeStockholderId=" + tradeStockholderId +
                ", tradeCompanyId=" + tradeCompanyId +
                ", stockNum=" + stockNum +
                ", sumMoney=" + sumMoney +
                ", currentPerprice=" + currentPerprice +
                ", Type=" + Type +
                '}';
    }
}
