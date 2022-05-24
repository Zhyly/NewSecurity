package com.secutity.entity;

public class StockSum {

    private int id;

    private int stockId;

    private int companyId;

    private int stockSum;

    public StockSum() {
    }

    public StockSum(int id, int stockId, int companyId, int stockSum) {
        this.id = id;
        this.stockId = stockId;
        this.companyId = companyId;
        this.stockSum = stockSum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getStockSum() {
        return stockSum;
    }

    public void setStockSum(int stockSum) {
        this.stockSum = stockSum;
    }

    @Override
    public String toString() {
        return "StockSum{" +
                "id=" + id +
                ", stockId=" + stockId +
                ", companyId=" + companyId +
                ", stockSum=" + stockSum +
                '}';
    }
}
