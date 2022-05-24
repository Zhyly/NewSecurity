package com.secutity.dao;

import com.secutity.entity.Company;

import java.util.List;

public interface CompanyDao {
    //插入新公司
    int insertCompany(Company company);
    //删除公司
    boolean deleteCompany(int companyid);
    //分页操作
    List<Company> queryCompanysByArray();

    //更新操作
    int updateCompany(Company company);
    //查询企业资金
//    Company queryasset(int id);

}
