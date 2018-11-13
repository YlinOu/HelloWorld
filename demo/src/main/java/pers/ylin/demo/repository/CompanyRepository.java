package pers.ylin.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pers.ylin.demo.entity.Company;

/**
 * Created by Ylin on 2018/9/26
 */
public interface CompanyRepository extends MongoRepository<Company, String> {

}
