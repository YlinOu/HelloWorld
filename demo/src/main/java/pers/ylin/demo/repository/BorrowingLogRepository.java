package pers.ylin.demo.repository;

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
public interface BorrowingLogRepository extends JpaRepository<BorrowingLog, String> {

    
    /**    
     * @Description 自定义简单查询 根据方法名来自动生成SQL  
     * @Author Ylin  
     * @Date 2018/9/4 17:42  
     * @param   
     * @return java.util.List<pers.ylin.demo.entity.BorrowingLog>  
     */  
    List<BorrowingLog> findAllByCaseNumberOrderById(String caseNumber);

    /**    
     * @Description 自定义HQL查询  用实体名不用数据库表字段
     * @Author Ylin  
     * @Date 2018/9/4 17:42  
     * @param iousNumber  
     * @return java.util.List<pers.ylin.demo.entity.BorrowingLog>  
     */  
    @Query(value = "select bl from BorrowingLog bl where iousNumber = :iousNumber")
    List<BorrowingLog> selectAllByIousNumber(@Param("iousNumber") String iousNumber);


    /**
     * @Description 自定义SQL查询
     * @Author Ylin
     * @Date 2018/9/4 17:42
     * @param iousNumber
     * @return java.util.List<pers.ylin.demo.entity.BorrowingLog>
     */
    @Query(value = "SELECT * FROM borrowing_log WHERE id IN ?1", nativeQuery = true)
    List<BorrowingLog> selectAllByIds(List<String> ids);


    /**    
     * @Description 根据ID修改payStatus
     * @Author Ylin  
     * @Date 2018/9/5 10:18  
     * @param ids
 * @param payStatus  
     * @return java.lang.Long  
     */  
    @Query(value = "update borrowing_log set pay_status = :payStatus where id in :ids", nativeQuery = true)
    @Modifying
    @Transactional
    int updatePayStatusByIds(@Param("ids") List<String> ids, @Param("payStatus") String payStatus);
}
