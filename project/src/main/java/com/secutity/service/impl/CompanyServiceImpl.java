package com.secutity.service.impl;

import com.secutity.dao.CompanyDao;
import com.secutity.entity.Company;
import com.secutity.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService {
   @Autowired
   private CompanyDao companyDao;

    @Override
    public int addCompany(Company company) {
        int rows=companyDao.insertCompany(company);
        return rows;
    }

    @Override
    public boolean deleteCompany(int Companyid) {

        boolean flag=companyDao.deleteCompany(Companyid);
        return flag;
    }

    @Override
    public List<Company> queryCompanysByArray(int currPage, int pageSize) {
        List<Company> companies = companyDao.queryCompanysByArray();
//        从第几条数据开始
        int firstIndex = (currPage - 1) * pageSize;
//        到第几条数据结束
        int lastIndex = currPage * pageSize;
        return companies.subList(firstIndex, lastIndex);

    }

    @Override
    public void updateCompany(int id,double amount) {

       Company company=new Company();
       company.setCompanyId(id);
       company.setCompanyAsset(amount);
       companyDao.updateCompany(company);

    }
//
//    @Override
//    public void queryasset(int id) {
//        Company company=companyDao.queryasset(id);
//    }
}
