package com.food.controller;

import com.food.entity.Img;
import com.food.service.ImgService;
import com.food.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/img")

public class ImgController {

    @Value("${img.root.directory}")
    String rootDic;
@Autowired
    ImgService service;

    @PostMapping("/add")
    public ResponseEntity<Img> uploadImg(@RequestParam(value="img",required=true) MultipartFile file) throws IOException {
        //todo upload file
        String originalFilename = file.getOriginalFilename();
        int dot = originalFilename.lastIndexOf('.');
        String suffix ;
        if(dot==-1){
            suffix = "";
        }else{
            suffix = originalFilename.substring(dot);
        }

        String folder = FileUtils.generateFileDirectory();
        File dic = FileUtils.createFolder(rootDic+folder);
        String fileName = UUID.randomUUID().toString().replace("-", "") + suffix;
        file.transferTo(new File(dic,fileName));
        Img img = new Img();
        img.setFileName(fileName);
        img.setUrl(folder+"/"+fileName);
//        img.setFullUrl(dic+"/"+fileName);
        Img addedImg = service.addImg(img);
        return ResponseEntity.ok(addedImg);
    }


}
