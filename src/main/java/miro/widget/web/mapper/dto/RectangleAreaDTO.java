package miro.widget.web.mapper.dto;

import miro.widget.repository.entity.Point;

import javax.validation.constraints.NotNull;

public class RectangleAreaDTO {

    @NotNull(message = "Location has not set")
    private PointDTO leftTop;

    @NotNull(message = "Location has not set")
    private PointDTO rightBottom;

    public RectangleAreaDTO() {
    }

    public PointDTO getLeftTop() {
        return leftTop;
    }

    public void setLeftTop(PointDTO leftTop) {
        this.leftTop = leftTop;
    }

    public PointDTO getRightBottom() {
        return rightBottom;
    }

    public void setRightBottom(PointDTO rightBottom) {
        this.rightBottom = rightBottom;
    }

    public RectangleAreaDTO(PointDTO leftTop, PointDTO rightBottom) {
        this.leftTop = leftTop;
        this.rightBottom = rightBottom;
    }
}
