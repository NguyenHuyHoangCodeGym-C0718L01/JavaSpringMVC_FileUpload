package controllers;

import org.springframework.web.multipart.MultipartFile;

public class FileBucket {
    private MultipartFile file;

    public FileBucket(MultipartFile file) {
        this.file = file;
    }

    public FileBucket(){}

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
