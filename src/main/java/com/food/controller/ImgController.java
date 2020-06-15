package com.food.controller;

import com.food.model.vo.ImgVO;
import com.food.service.IImgService;
import com.food.utils.FileUtils;
import com.food.utils.ImgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/api/img")

public class ImgController {

    @Value("${img.root.directory}")
    String rootDic;

    @Value("${img.root.url}")
    String rootUrl;

    @Value("${img.root.thumbnail.w}")
    int thumbnailW;
    @Value("${img.root.thumbnail.h}")
    int thumbnailH;

    @Autowired
    IImgService service;

    @PreAuthorize("hasAnyRole('MERCHANT','ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<ImgVO> uploadImg(@RequestParam(value="img") MultipartFile file) throws IOException {
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
        File targetDest = new File(dic, fileName);
        file.transferTo(targetDest);
        ImgVO img = new ImgVO();
        img.setFile_name(fileName);
        img.setUrl(rootUrl+File.separator+folder+File.separator+fileName);
        String thumbnailFileName = ImgUtil.createThumbnail(targetDest, thumbnailW, thumbnailH, false);
        img.setThumbnail_url(rootUrl+File.separator+folder+File.separator+thumbnailFileName);

        ImgVO addedImg = service.addImg(img);

        return ResponseEntity.ok(addedImg);
    }



}
