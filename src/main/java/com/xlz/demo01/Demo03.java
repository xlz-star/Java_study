package com.xlz.demo01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class Demo03 {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入购买时间(yyyy-MM-dd HH:mm)：");
        String buyTime = scanner.nextLine();
        Product2 product2 = new Product2(buyTime);
        System.out.println("发货时间为：" + product2.getFaHuo());
    }
}

class Product2 {
    private String buyTime; // 下单时间

    public Product2() {
    }

    public Product2(String buyTime) {
        this.buyTime = buyTime;
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }

    public String getFaHuo() throws ParseException {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date buytime = sd.parse(this.buyTime);
        Instant instant = buytime.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        if (localDateTime.getMinute() < 15) {
            localDateTime = localDateTime.plusDays(1);
        } else {
            localDateTime = localDateTime.plusDays(2);
        }
        if (localDateTime.getDayOfWeek().getValue() == 7) {
            localDateTime = localDateTime.plusDays(1);
        }
        String fahua = sd.format(Date.from(localDateTime.atZone(zoneId).toInstant()));
        return fahua;
    }
}
