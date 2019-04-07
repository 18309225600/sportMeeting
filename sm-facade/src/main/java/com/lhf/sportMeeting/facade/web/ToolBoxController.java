package com.lhf.sportMeeting.facade.web;

import com.lhf.sportMeeting.common.utils.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/toolbox")
public class ToolBoxController {

    protected Logger logger = LoggerFactory.getLogger(ToolBoxController.class);

    @GetMapping
    public String toTest(){
        return "test";
    }

    @ResponseBody
    @RequestMapping("/fileupload")
    public String fileupload(@RequestParam("file")MultipartFile file) throws IOException {
        String fileTempPath = ResourceUtils.getURL("classpath:static").getPath()+"/assets/img";
        logger.info("上传文件目录 filePath = {}",fileTempPath);
        String newFileName = "";
        try{
            byte[] bytes = file.getBytes();

            String originalFilename = file.getOriginalFilename();
            int index = originalFilename.lastIndexOf(".");
            newFileName = RandomUtils.uuid()+originalFilename.substring(index);
            String realPath = fileTempPath.substring(1)+"/"+newFileName;
            Path path = Paths.get(realPath);
            Files.write(path, bytes);
        }catch (IOException e) {
            logger.error("上传文件失败,msg={}",e);
            newFileName = "";
        }
        System.out.println(newFileName);
        return  newFileName;
    }

}
