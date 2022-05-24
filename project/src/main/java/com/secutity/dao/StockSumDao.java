package com.secutity.dao;

import com.secutity.entity.StockSum;
import org.apache.ibatis.annotations.Param;

public interface StockSumDao {

    //查询是否有该记录
    StockSum querytrade(@Param("id") int id,@Param("cid") int cid);
    //插入操作
    int doinsert( @Param("stockId") int stockId, @Param("companyId")int companyId,@Param("stockSum") int stockSum);
    //更新操作
    int doupdate(StockSum stockSum);
    //查询目前记录数
    int getCount();

}
