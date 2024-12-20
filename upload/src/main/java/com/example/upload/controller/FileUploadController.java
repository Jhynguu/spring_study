package com.example.upload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {

    @RequestMapping("/form")
    public String form() {
        return "form";
    }

    @RequestMapping("/form_ok2")
    public String form_ok2(
            MultipartFile upload,
            String userid,
            String userpw,
            Model model
    ) {
        System.out.println(userid);
        System.out.println(userpw);

        String file = "";
        if (!upload.isEmpty()) {
            try {
                String fileName = upload.getOriginalFilename().substring(0, upload.getOriginalFilename().lastIndexOf("."));
                String extension = upload.getOriginalFilename().substring(upload.getOriginalFilename().lastIndexOf("."));

                file = fileName + "_" + System.nanoTime() + extension;
                upload.transferTo(new File("/Users/jhyngu/Desktop/Java/study/upload/src/main/resources/static/uploads", file));
            } catch (IOException e) {
                System.out.println("[에러] : " + e.getMessage());
            }
        } else {
            System.out.println("업로드 파일 없음");
        }

        model.addAttribute("file", file);
        return "form_ok";
    }

    @RequestMapping("/view")
    public String view(String file, Model model) {

        model.addAttribute("file", file);
        return "view";
    }
}