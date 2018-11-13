package pers.ylin.demo.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pers.ylin.demo.entity.BorrowingLog;

import java.util.List;

/**
 * Created by Ylin on 2018/9/4
 */
public interface BorrowingLogMapper {

    @Cacheable(value="user-key")
    List<BorrowingLog> getAll();

    BorrowingLog getOne(String id);

    void insert(BorrowingLog borrowingLog);

    void update(BorrowingLog borrowingLog);

    void delete(String id);
    
}
