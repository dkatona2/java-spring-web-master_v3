package hu.ponte.hr.services;

import hu.ponte.hr.domain.Image;
import hu.ponte.hr.dto.ImageMeta;
import hu.ponte.hr.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ImageStore {

    private final ImageRepository imageRepository;


    public Image saveImage(MultipartFile file) throws IOException {
        Image imageToSave = new Image(file);
        imageToSave.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        return imageRepository.save(imageToSave);
    }

    public List<ImageMeta> getImageList() {
        List<Image> ImageList = imageRepository.findAll();
        return ImageList.stream()
                .map(ImageMeta::new)
                .collect(Collectors.toList());
    }


    public String getImage(String id) {
        Optional<Image> image = imageRepository.findById(Long.valueOf(id));
        String base64 = null;
        if (image != null) {
            Image currentImage = image.get();
            base64 = currentImage.getImage();
        }
        return base64;
    }
}
