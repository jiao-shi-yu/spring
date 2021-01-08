package com.jiaoshy.springmvc.upload;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
public class UploadController {

    @PostMapping("/upload")
    public String upload(MultipartFile file) throws Exception {


        /**
         * 原始文件名
         */
        String originalFileName = file.getOriginalFilename();
        System.out.println(originalFileName);
        /**
         * 原始拓展名
         *
         */
        int beginIndex = originalFileName.lastIndexOf(".");
        String suffix = "";
        if (beginIndex > 0) {
            suffix = originalFileName.substring(beginIndex);
        }


        String parent = "/Users/jiaoshy/develop/upload";
        String fileName = "1";

        String child = fileName + suffix;

        // 存放到目标文件
        File dest = new File(parent, child);
        file.transferTo(dest);
        return "上传成功";
    }

}
