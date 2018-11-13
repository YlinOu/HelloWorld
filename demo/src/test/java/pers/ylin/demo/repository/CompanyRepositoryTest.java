package pers.ylin.demo.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pers.ylin.demo.entity.BorrowingLog;
import pers.ylin.demo.entity.Company;
import pers.ylin.demo.entity.Department;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by Ylin on 2018/9/4
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() {
        Company company = new Company();
        company.setCode("001");
        company.setChinaName("诺远");
        company.setEngName("nuoyuan");
        companyRepository.save(company);
        System.out.println(company);

    }

    @Test
    public void testQuery() {
        Query query = new Query();
        query.addCriteria(Criteria.where("code").is("001"));
        query.with(new Sort(Sort.Direction.DESC, "createTime"));
        List<Company> companies = mongoTemplate.find(query, Company.class);
        companies.forEach(System.out::println);

    }
}