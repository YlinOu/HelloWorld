package pers.ylin.demo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Ylin on 2018/9/4
 */
@Entity
@Table(name = "borrowing_log")
@Data
public class BorrowingLog implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "case_number")
    @ApiModelProperty(value="案件编号")
    private String caseNumber;

    @ApiModelProperty(value="借据编号")
    @Column(name = "ious_number")
    private String iousNumber;

    @ApiModelProperty(value="逾期金额")
    @Column(name = "left_overdue_amount")
    private BigDecimal leftOverdueAmount;

    @ApiModelProperty(value="逾期阶段")
    @Column(name = "pay_status")
    private String payStatus;

    @ApiModelProperty(value="逾期天数")
    @Column(name = "overdue_days")
    private Integer overdueDays;

    @Column(name = "lately_collector")
    private String latelyCollector;
    @Column(name = "current_collector")
    private String currentCollector;
    @Column(name = "operator")
    private String operator;
    @Column(name = "operator_time")
    private Date operatorTime;
    @Column(name = "current_depart_id")
    private String currentDepartId;

    @ManyToOne
    @JoinColumn(name = "lately_depart_id")
    private Department latelyDepartId;

}
