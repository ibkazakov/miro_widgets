package miro.widget.web.area;

import miro.widget.repository.entity.Point;
import miro.widget.repository.entity.Widget;

public class WidgetRectangleArea implements WidgetArea {

    private Point leftTop;

    private Point rightBottom;


    public Point getLeftTop() {
        return leftTop;
    }

    public void setLeftTop(Point leftTop) {
        this.leftTop = leftTop;
    }

    public Point getRightBottom() {
        return rightBottom;
    }

    public void setRightBottom(Point rightBottom) {
        this.rightBottom = rightBottom;
    }

    @Override
    public boolean contains(Widget widget) {
        int x = widget.getLocation().getX();
        int y = widget.getLocation().getY();

        int width = widget.getWidth();
        int height = widget.getHeight();

        int leftBound = leftTop.getX();
        int rightBound = rightBottom.getX();
        int topBound = leftTop.getY();
        int bottomBound = rightBottom.getY();

        boolean left =   (2 * leftBound <= 2 * x - width);
        boolean right =  (2 * x + width <= 2 * rightBound);
        boolean top =    (2 * topBound <= 2 * y - height);
        boolean bottom = (2 * y + height <= 2 * bottomBound);

        return (left && right && bottom && top);
    }
}
