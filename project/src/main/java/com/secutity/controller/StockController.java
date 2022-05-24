package com.secutity.controller;


import com.secutity.entity.Company;
import com.secutity.entity.Result;
import com.secutity.entity.Trade;
import com.secutity.service.stockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StockController {

    @Autowired
    private stockService  stockService;

    @RequestMapping(value = "/Stock/buyStock",method = RequestMethod.POST)
    @ResponseBody
    public Result addTrade(@RequestBody Trade trade){
        try {
            stockService.buystock(trade);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(500, "添加失败", null);
        }
        return new Result(200, "添加成功", null);
    }

    @RequestMapping(value = "/Stock/saleStock",method = RequestMethod.POST)
    @ResponseBody
    public Result saleTrade(@RequestBody Trade trade){
        try {
            stockService.saleStock(trade);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(500, "添加失败", null);
        }
        return new Result(200, "添加成功", null);
    }
}
