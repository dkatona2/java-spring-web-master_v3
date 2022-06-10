package hu.ponte.hr.controller;


import hu.ponte.hr.dto.ImageMeta;
import hu.ponte.hr.services.ImageStore;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController()
@RequestMapping("api/images")
public class ImagesController {

    @Autowired
    private ImageStore imageStore;

    @GetMapping("meta")
    public ResponseEntity<List<ImageMeta>> getImageList() {
        List<ImageMeta> images = imageStore.getImageList();
        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @GetMapping("preview/{id}")
    public ResponseEntity<?> getImage(@PathVariable("id") String id, HttpServletResponse response) {
        String image = imageStore.getImage(id);
        byte[] base64ToByte = Base64.decodeBase64(image);
        return new ResponseEntity<>(base64ToByte, HttpStatus.OK);
    }


}
