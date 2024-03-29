package com.lhf.sportMeeting.common.utils;

import java.util.Objects;
import java.util.Random;
import java.util.UUID;

public class RandomUtils {
    /**
     * 生成随机数
     * @param len   随机数长度
     * @return
     */
    public static String randomNum(int len){
        if (len<1) return "";
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        for (int i=0;i<len;i++){
            stringBuffer.append(random.nextInt(10));
        }
        return stringBuffer.toString();
    }

    /**
     * 生成订单ID随机数
     * @param len   默认13位，如果len小于等于13 默认返回当前时间戳13位，如果大于13位，则末尾补充随机数
     * @return
     */
    public static String randomOrderId(int len){
        //current len = 13
        long currentTimeMillis = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer(Objects.toString(currentTimeMillis));

        if (len>13){
            String random = randomNum(len - 13);
            stringBuffer.append(random);
        }

        return stringBuffer.toString();
    }

    /**
     * 32位不重复UUID大写
     * @return
     */
    public static String uuid(){
        return UUID.randomUUID().toString().toUpperCase();
    }
}
