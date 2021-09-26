package com.mrxiaozhu.springbootmybatis01.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class ExcelUploadController {


    @PostMapping("/eleCoupon/pre")
    public String uploadPre(@RequestParam("filedata") MultipartFile filedata) {
        String fileName = filedata.getOriginalFilename();
        String prefix = fileName.substring(fileName.lastIndexOf("."));
        if (!prefix.toLowerCase().contains("xls") && !prefix.toLowerCase().contains("xlsx")) {
            return "文件格式异常,请上传Excel文件格式";
        }
        try (InputStream inputStream = filedata.getInputStream()) {
            List<Map<String, String>> listMap = EasyExcel.read(inputStream).headRowNumber(0).sheet().doReadSync();
            log.info("取到内容如下：{}", JSONObject.toJSONString(listMap));
            return "success";
        } catch (Exception e) {
            return e.toString();
        }
    }
}
