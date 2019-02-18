package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {

    private static String UPLOAD_LOCATION="/home/hoangnhb/IdeaProjects/JavaSpring/spring-fileupload/src/main/resources";

    @GetMapping("/home")
    public ModelAndView getHome(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("file",new FileBucket());
        return modelAndView;
    }

    @PostMapping("/upload")
    public ModelAndView upload(@ModelAttribute("file") FileBucket fileBucket){
        ModelAndView modelAndView = new ModelAndView("success");
        System.out.println("Fetching file");
        MultipartFile multipartFile = fileBucket.getFile();

        //Now do something with file...
        try {
            FileCopyUtils.copy(fileBucket.getFile().getBytes(), new File(UPLOAD_LOCATION + fileBucket.getFile().getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String fileName = multipartFile.getOriginalFilename();
        modelAndView.addObject("file", fileName);
        modelAndView.addObject("success", "File've just uploaded!");
        return modelAndView;
    }
}
