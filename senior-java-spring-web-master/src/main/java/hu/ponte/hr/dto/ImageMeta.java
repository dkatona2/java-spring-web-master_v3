package hu.ponte.hr.dto;

import hu.ponte.hr.domain.Image;
import lombok.Builder;


/**
 * @author zoltan
 */

@Builder
public class ImageMeta {
    private String id;
    private String name;
    private String mimeType;
    private Long size;
    private String digitalSign;


    public ImageMeta() {
    }

    public ImageMeta(String id, String name, String mimeType, Long size, String digitalSign) {
        this.id = id;
        this.name = name;
        this.mimeType = mimeType;
        this.size = size;
        this.digitalSign = digitalSign;
    }

    public ImageMeta(Image image) {
        this.id = image.getId().toString();
        this.name = image.getName();
        this.mimeType = image.getMimeType();
        this.size = image.getSize();
        this.digitalSign = image.getDigitalSign();

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDigitalSign() {
        return digitalSign;
    }

    public void setDigitalSign(String digitalSign) {
        this.digitalSign = digitalSign;
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
}
