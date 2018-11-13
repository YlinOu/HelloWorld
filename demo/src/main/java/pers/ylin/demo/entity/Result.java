package pers.ylin.demo.entity;

import lombok.Data;

/**
 * Created by Ylin on 2018/9/5
 */
@Data
public class Result {

    private String resultCode;//结果编码

    private String resultMsg;//结果信息

    public enum ResultCode {
        //**********  异常  ************
        CODE_800000("800000", "系统异常！"),
        CODE_800002("800002", "参数处理异常！"),
        CODE_800003("800003", "业务系统调用异常！"),

        //**********  失败  ************
        CODE_800001("800010", "参数校验失败！"),
        CODE_800010("800011", "业务系统调用失败！"),

        //**********  成功  ************
        CODE_9999("9999", "业务系统调用成功！"),
        CODE_999999("999999", "交易成功！"),
        ;

        private String resultCode;//结果编码
        private String resultMsg;//结果信息

        ResultCode(String code, String msg) {
            this.resultCode = code;
            this.resultMsg = msg;
        }

        public String getResultCode() {
            return resultCode;
        }

        public String getResultMsg() {
            return resultMsg;
        }
    }
}
