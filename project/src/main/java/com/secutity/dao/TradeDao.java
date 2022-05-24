package com.secutity.dao;

import com.secutity.entity.Trade;

public interface TradeDao {

    //添加一个交易记录
    int addTrade(Trade trade);

}
