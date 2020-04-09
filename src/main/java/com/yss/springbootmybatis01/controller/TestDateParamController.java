package com.yss.springbootmybatis01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateParamController {
  @RequestMapping("/testDateParam")
  public String testDateParam(@RequestParam(value = "stratTime") Date startTime,
                              @RequestParam(value = "endTime") Date endTime) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    Timestamp startTimeStr = Timestamp.valueOf(sdf.format(startTime));
    String start = "开始时间：" + startTime + "\n开始时间类型：" + startTime.getClass();
    String end = "结束时间：" + endTime + "\n结束时间类型：" + startTime.getClass();
    return start + "\n" + end +"\n" + startTimeStr;
  }

  @RequestMapping("/testTimestampParam")
  public String testTimestampParam(@RequestParam(value = "stratTime") Date stratTime,
                                 @RequestParam(value = "endTime") Date endTime) {
    String start = "开始时间：" + stratTime + "\n开始时间类型：" + stratTime.getClass();
    String end = "结束时间：" + endTime + "\n结束时间类型：" + stratTime.getClass();
    return start + "\n" + end;
  }
}

