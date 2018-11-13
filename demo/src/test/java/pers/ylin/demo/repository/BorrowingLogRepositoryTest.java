package pers.ylin.demo.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pers.ylin.demo.entity.BorrowingLog;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by Ylin on 2018/9/4
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BorrowingLogRepositoryTest {

    @Autowired
    private BorrowingLogRepository borrowingLogRepository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findAllByCaseNumberOrderById() {
        List<BorrowingLog> borrowingLogs = borrowingLogRepository.findAllByCaseNumberOrderById("772018070200084");
        borrowingLogs.forEach(System.out::println);
    }

    @Test
    public void selectAllByIousNumber() {
        List<BorrowingLog> borrowingLogs = borrowingLogRepository.selectAllByIousNumber("nmd_6385760038551798");
        borrowingLogs.forEach(System.out::println);
    }

    @Test
    public void selectAllByIds() {
        List<BorrowingLog> borrowingLogs = borrowingLogRepository.selectAllByIds(Arrays.asList("8ad1ae206591977c016592e754071a47","8ad1ae206591977c016592e7549e1a48","8ad1ae206591977c016592e755321a49"));
        borrowingLogs.forEach(System.out::println);
    }

    @Test
    public void updatePayStatusByIds() {
        List<String> ids = Arrays.asList("8ad1ae206591977c016592e7565e1a4b", "8ad1ae206591977c016592e756f61a4c");
        borrowingLogRepository.findAllById(ids).forEach(System.out::println);
        borrowingLogRepository.updatePayStatusByIds(ids,"M1");
        borrowingLogRepository.findAllById(ids).forEach(System.out::println);
    }

    /**    
     * @Description 调用jpa自带分配排序方法  
     * @Author Ylin  
     * @Date 2018/9/5 11:09  
     * @param   
     * @return void  
     */  
    @Test
    public void testPageSort() {
        Sort sort = new Sort(Sort.Direction.DESC,"caseNumber","id");
        Pageable pageable = new PageRequest(2, 3, sort);
        BorrowingLog borrowingLog = new BorrowingLog();
        borrowingLog.setPayStatus("M2");
        Page<BorrowingLog> page = borrowingLogRepository.findAll(Example.of(borrowingLog),pageable);
        page.getContent().forEach(item -> {
            System.out.println(item.getCaseNumber());
            System.out.println(item.getPayStatus());
            System.out.println(item.getLatelyDepartId());
        });

    }

    /**    
     * @Description 调用jpa自带增删改查方法
     * @Author Ylin  
     * @Date 2018/9/5 11:12
     * @param   
     * @return void  
     */  
    @Test
    public void testFindSaveUpdateDelete() {

        BorrowingLog borrowingLog = new BorrowingLog();
        borrowingLog.setPayStatus("M1");
        borrowingLog.setCaseNumber("772018042403486");
        borrowingLog.setIousNumber("nmd_6382821043863616");
        borrowingLog.setLeftOverdueAmount(BigDecimal.ONE);
        borrowingLog.setOverdueDays(3);

        // 新增
        borrowingLogRepository.save(borrowingLog);

        // Optional JDK1.8新特性
        Optional<BorrowingLog> optional = borrowingLogRepository.findById(borrowingLog.getId());
        System.out.println(optional.get());
        optional.get().setPayStatus("M3");

        // 修改
        borrowingLogRepository.save(optional.get());
        System.out.println(borrowingLogRepository.findById(optional.get().getId()).get());

        //删除
        borrowingLogRepository.delete(optional.get());
    }
}