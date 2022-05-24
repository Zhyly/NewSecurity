package com.secutity.entity;

public class StockHolder {

private  int stockholderId;
private  String stockholderAccount;
private String stockholderPassword;
private String stockholderCard;
private int stockholderTel;
private  double account_asset;

    public StockHolder() {
    }

    public StockHolder(int stockholderId, String stockholderAccount, String stockholderPassword, String stockholderCard, int stockholderTel, double account_asset) {
        this.stockholderId = stockholderId;
        this.stockholderAccount = stockholderAccount;
        this.stockholderPassword = stockholderPassword;
        this.stockholderCard = stockholderCard;
        this.stockholderTel = stockholderTel;
        this.account_asset = account_asset;
    }


    public int getStockholderId() {
        return stockholderId;
    }

    public void setStockholderId(int stockholderId) {
        this.stockholderId = stockholderId;
    }

    public String getStockholderAccount() {
        return stockholderAccount;
    }

    public void setStockholderAccount(String stockholderAccount) {
        this.stockholderAccount = stockholderAccount;
    }

    public String getStockholderPassword() {
        return stockholderPassword;
    }

    public void setStockholderPassword(String stockholderPassword) {
        this.stockholderPassword = stockholderPassword;
    }

    public String getStockholderCard() {
        return stockholderCard;
    }

    public void setStockholderCard(String stockholderCard) {
        this.stockholderCard = stockholderCard;
    }

    public int getStockholderTel() {
        return stockholderTel;
    }

    public void setStockholderTel(int stockholderTel) {
        this.stockholderTel = stockholderTel;
    }

    public double getAccount_asset() {
        return account_asset;
    }

    public void setAccount_asset(double account_asset) {
        this.account_asset = account_asset;
    }

    @Override
    public String toString() {
        return "StockHolder{" +
                "stockholderId=" + stockholderId +
                ", stockholderAccount='" + stockholderAccount + '\'' +
                ", stockholderPassword='" + stockholderPassword + '\'' +
                ", stockholderCard='" + stockholderCard + '\'' +
                ", stockholderTel=" + stockholderTel +
                ", account_asset=" + account_asset +
                '}';
    }
}
