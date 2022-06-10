package hu.ponte.hr.domain;

import hu.ponte.hr.dto.ImageMeta;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity

@NoArgsConstructor
@Table(name="image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name ="image")
    private String image;

    @Column(name = "name")
    private String name;

    @Column(name = "mimeType")
    private String mimeType;

    @Column(name = "size")
    private Long size;



    @Column(name ="digitalSign")
    private String digitalSign;

    public Image(MultipartFile file) {
        this.name = file.getOriginalFilename();
        this.mimeType = file.getContentType();
        this.size = file.getSize();
        this.image = "";
        this.digitalSign = "";
    }

    public String getDigitalSign() {
        return digitalSign;
    }

    public void setDigitalSign(String digitalSign) {
        this.digitalSign = digitalSign;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", mimeType='" + mimeType + '\'' +
                ", size=" + size +
                '}';
    }
}
