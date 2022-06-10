package hu.ponte.hr.controller.upload;

import hu.ponte.hr.services.ImageStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
@RequestMapping("api/file")
public class UploadController {
    @Autowired
    private ImageStore service;

    @RequestMapping(value = "post", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Void> handleFormUpload(@RequestParam("file") MultipartFile file) throws IOException {
        service.saveImage(file);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
