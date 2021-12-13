package com.xlz.demo01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Demo02 {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入生产日期 (yyyy-MM-dd HH:mm:ss)：");
        String prodeuctionDate = scanner.nextLine();
        System.out.println("请输入保质期：");
        int canUseDate = scanner.nextInt();
        Product product = new Product(prodeuctionDate, canUseDate);
        System.out.println("促销日期为：" + product.saleDate);
    }
}

class Product {
    String productionDate;  // 生产日期
    int canUseDate;  // 保质期
    String saleDate;    // 促销日期

    public Product() {
    }

    public Product(String productionDate, int canUseDate) throws ParseException {
        this.productionDate = productionDate;
        this.canUseDate = canUseDate;
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date prodate = sd.parse(productionDate);
        Instant instant = prodate.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        LocalDateTime canusedate = localDateTime.plusDays(canUseDate);
        LocalDateTime saledata = canusedate.minusWeeks(3);
        String tmp = sd.format(Date.from(saledata.atZone(zoneId).toInstant()));
        this.saleDate = tmp;
    }
}