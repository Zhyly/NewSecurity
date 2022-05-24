package com.secutity.service;

import com.secutity.entity.Company;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface CompanyService {

    int addCompany(Company company);

    boolean deleteCompany(int Companyid);

    List<Company> queryCompanysByArray(int currPage, int pageSize);

    void updateCompany(int id,double amount);
//
//    void queryasset(int id);

}
