package com.secutity.service.impl;

import com.secutity.dao.CompanyDao;
import com.secutity.dao.StockHolderDao;
import com.secutity.dao.StockSumDao;
import com.secutity.dao.TradeDao;
import com.secutity.entity.Company;
import com.secutity.entity.StockSum;
import com.secutity.entity.Trade;
import com.secutity.service.CompanyService;
import com.secutity.service.stockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("stockService")


public class stockServiceImpl implements stockService {
    @Autowired
    private TradeDao tradeDao;
    @Autowired
    private StockHolderDao stockHolderDao;
    @Autowired
    private StockSumDao stockSumDao;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public int buystock(Trade trade) {
        //插入股票交易记录
        int a = tradeDao.addTrade(trade);

        //查询股民拥有资金
        double asset = stockHolderDao.queryasset(trade.getTradeStockholderId());
        //计算股民现有资金
        double newasset = asset - trade.getSumMoney();
        //查询公司资金
        Company company = stockHolderDao.queryCompanyAsset(trade.getTradeCompanyId());
        //计算公司新资金

        double newcompanyasset = company.getCompanyAsset() + trade.getSumMoney();

        company.setCompanyAsset(newcompanyasset);
        System.out.println(asset);
        //修改股民账户的钱
        stockHolderDao.updateStock(newasset, trade.getTradeStockholderId());
        //修改公司的资金

        stockHolderDao.updateCompanyasset(company);
        //查询总记录数
        int total=stockSumDao.getCount();
        System.out.println(total);
        //跟新股民股票拥有表(如果之前无记录，新插入一条，否则更新原先数据)
        StockSum stockSum=null;
        stockSum=stockSumDao.querytrade(trade.getTradeStockholderId(),trade.getTradeCompanyId());

        if(stockSum==null||stockSum.getCompanyId()!=trade.getTradeCompanyId())
        {

            stockSumDao.doinsert(trade.getTradeStockholderId(),trade.getTradeCompanyId(),trade.getStockNum());
        }
        else{
            //计算之后股票总数
            int num=stockSum.getStockSum()+trade.getStockNum();
            stockSum.setStockSum(num);
            stockSum.setStockId(trade.getTradeStockholderId());
            stockSum.setCompanyId(trade.getTradeCompanyId());
            stockSumDao.doupdate(stockSum);
        }
        return a;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public int saleStock(Trade trade) {
        //新增一条交易数据
        int a=tradeDao.addTrade(trade);

        //查询股民拥有资金
        double asset = stockHolderDao.queryasset(trade.getTradeStockholderId());
        //计算股票卖的钱数
        double stockmoney=trade.getSumMoney()+asset;
        //将股票卖的钱更新到股民账户
        stockHolderDao.updateStock(stockmoney,trade.getTradeStockholderId());
        //将股票卖的钱减少了公司资产
        //查询公司资金
        Company company = stockHolderDao.queryCompanyAsset(trade.getTradeCompanyId());




        double newcompanyasset = company.getCompanyAsset() - trade.getSumMoney();
        company.setCompanyAsset(newcompanyasset);
        stockHolderDao.updateCompanyasset(company);
        //更新股民股票拥有表
        StockSum stockSum=null;
        stockSum=stockSumDao.querytrade(trade.getTradeStockholderId(),trade.getTradeCompanyId());
        int num=stockSum.getStockSum()-trade.getStockNum();
        stockSum.setStockSum(num);
        stockSum.setStockId(trade.getTradeStockholderId());
        stockSum.setCompanyId(trade.getTradeCompanyId());
        stockSumDao.doupdate(stockSum);
        //更新股票单价
        //计算股票单价
        double price=newcompanyasset/(stockSum.getStockSum()+company.getCompanyStockNum());
        company.setCompanyStockPerprice(price);
        stockHolderDao.updateprice(company);
    return a;
    }
}
