package com.skywalker.constant;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author Code SkyWalker
 * @Date 9:48 2023/1/3
 * @Classname WareConstant
 * @Description TODO
 */
public class WareConstant {
    
    public enum PurchaseStatusEnum {
        NEW(0, "新建"),            // 新建
        DISPATCHED(1, "已分配"),     // 已分配
        RECEIVED(2, "已领取"),       // 已领取
        ACCOMPLISHED(3, "已完成"),   // 已完成
        EXCEPTION(4, "有异常");      // 有异常
        
        private int code;
        private String msg;

        PurchaseStatusEnum(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

    public enum PurchaseDetailStatusEnum {
        CREATED(0, "新建"),            // 新建
        DISPATCHED(1, "已分配"),       // 已分配
        RECEIVED(2, "正在采购"),         // 正在采购
        ACCOMPLISHED(3, "已完成"),     // 已完成
        EXCEPTION(4, "采购失败");        // 采购失败

        private int code;
        private String msg;

        PurchaseDetailStatusEnum(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
