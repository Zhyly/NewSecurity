package com.secutity.controller;


import com.secutity.dao.CompanyDao;
import com.secutity.entity.Company;
import com.secutity.entity.Result;
import com.secutity.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CompanyController {


 @Autowired
// @Qualifier("companyService")
 private CompanyService companyService;

    @RequestMapping(value = "/company/addCompany",method = RequestMethod.POST)
    @ResponseBody
    public Result addCompany(@RequestBody Company company){
        try {
           companyService.addCompany(company);
        } catch (Exception e) {
            return new Result(500, "添加失败", null);
        }
        return new Result(200, "添加成功", null);
    }
    @RequestMapping(value = "/company/updateCompany/{companyId}/{amount}")
    @ResponseBody
    public Result updateCompany(@PathVariable(value = "companyId")int companyId,@PathVariable(value = "amount") double amount)
    {
        try{
            companyService.updateCompany(companyId,amount);
            System.out.println(companyId);
            System.out.println(amount);

        }
        catch (Exception e) {
            return new Result(500, "更新失败", null);
        }
       return new Result(200, "更新成功", null);
    }
    @ResponseBody
    @RequestMapping("/company/array/{currPage}/{pageSize}")

    public Result getCompanyByArray(@PathVariable("currPage") int currPage, @PathVariable("pageSize") int pageSize){
        List<Company>companyList=null;

        try{
            companyList =companyService.queryCompanysByArray(currPage,pageSize);
        }
        catch (Exception e) {
            return new Result(500, "查询失败", null);
        }
        return new Result(200, "查询成功", companyList);

    }
    @ResponseBody
    @RequestMapping("/company/deleteCompany/{id}")
    public Result deleteCompany(@PathVariable("id") int id)
    {
        try{
           companyService.deleteCompany(id);
        }
        catch (Exception e) {
            return new Result(500, "删除失败", null);
        }
        return new Result(200, "删除成功", null);
    }



}
