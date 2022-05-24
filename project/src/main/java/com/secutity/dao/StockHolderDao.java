package com.secutity.dao;

import com.secutity.entity.Company;
import com.secutity.entity.StockHolder;
import org.apache.ibatis.annotations.Param;

public interface StockHolderDao {

    //更新资产
    int updateStock(@Param("accountAsset") double account_asset, @Param("stockholderId") int stockholderId);

    //查询资产
    double queryasset(int stocckid);

    Company queryCompanyAsset(int id);

    int updateCompanyasset(Company company);

    //更新股票单价
    int updateprice(Company company);


}
