package pers.ylin.demo.mapper;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkItemGetRequest;
import com.taobao.api.response.TbkItemGetResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pers.ylin.demo.entity.BorrowingLog;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Ylin on 2018/9/5
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BorrowingLogMapperTest {

    @Autowired
    private BorrowingLogMapper borrowingLogMapper;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getAll() {
        List<BorrowingLog> borrowingLogList = borrowingLogMapper.getAll();
        borrowingLogList.forEach(System.out::println);
    }

    @Test
    public void getOne() {
        BorrowingLog borrowingLog = borrowingLogMapper.getOne("8ad1ae206591977c016592e7565e1a4b");
        System.out.println(borrowingLog);
    }

    @Test
    public void insert() {
        BorrowingLog borrowingLog = new BorrowingLog();
        borrowingLog.setPayStatus("M1");
        borrowingLog.setCaseNumber("772018042403486");
        borrowingLog.setIousNumber("nmd_6382821043863616");
        borrowingLog.setLeftOverdueAmount(BigDecimal.ONE);
        borrowingLog.setOverdueDays(3);
        borrowingLogMapper.insert(borrowingLog);
        System.out.println(borrowingLog);
    }

    @Test
    public void update() {
        BorrowingLog borrowingLog = new BorrowingLog();
        borrowingLog.setPayStatus("M2");
        borrowingLog.setId("42f77dc7-b0dd-11e8-9d24-00163e0e43fb");
        borrowingLogMapper.update(borrowingLog);
        System.out.println(borrowingLogMapper.getOne("42f77dc7-b0dd-11e8-9d24-00163e0e43fb"));
    }

    @Test
    public void delete() {
        borrowingLogMapper.delete("42f77dc7-b0dd-11e8-9d24-00163e0e43fb");
        System.out.println(borrowingLogMapper.getOne("42f77dc7-b0dd-11e8-9d24-00163e0e43fb"));
    }

}