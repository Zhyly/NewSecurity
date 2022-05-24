package com.secutity.service;

import com.secutity.entity.Trade;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface stockService {

 //购买股票
 int buystock(Trade trade);
//出售股票
 int saleStock(Trade trade);


//    double queryasset(int id);
// int saleStock(Trade trade  )


}
