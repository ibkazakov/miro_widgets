package miro.widget.web.mapper.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

public class WidgetDTO {
    private long id;

    @NotNull(message = "Location has not set")
    private PointDTO location;

    private Integer z = null;

    @Positive(message = "Dimensions should be positive")
    private int width;

    @Positive(message = "Dimensions should be positive")
    private int height;

    private Date lastModification;

    public WidgetDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getZ() {
        return z;
    }

    public void setZ(Integer z) {
        this.z = z;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Date getLastModification() {
        return lastModification;
    }

    public void setLastModification(Date lastModification) {
        this.lastModification = lastModification;
    }

    public PointDTO getLocation() {
        return location;
    }

    public void setLocation(PointDTO location) {
        this.location = location;
    }

    public WidgetDTO(PointDTO location, Integer z, int width, int height) {
        this.location = location;
        this.z = z;
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "WidgetDTO{" +
                "id=" + id +
                ", location=" + location +
                ", z=" + z +
                ", width=" + width +
                ", height=" + height +
                ", lastModification=" + lastModification +
                '}';
    }
}
