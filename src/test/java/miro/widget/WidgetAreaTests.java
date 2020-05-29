package miro.widget;

import miro.widget.web.controller.WidgetController;
import miro.widget.web.controller.WidgetPartialController;
import miro.widget.web.mapper.dto.PointDTO;
import miro.widget.web.mapper.dto.RectangleAreaDTO;
import miro.widget.web.mapper.dto.WidgetDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class WidgetAreaTests {
    @Autowired
    private WidgetController widgetController;

    @Autowired
    private WidgetPartialController widgetPartialController;

    @Test
    public void test1() {


        RectangleAreaDTO rectangle = new RectangleAreaDTO(new PointDTO(0, 0),
                new PointDTO(100, 150));


        WidgetDTO widget1 = new WidgetDTO(new PointDTO(50, 50), 1, 100, 100);
        WidgetDTO widget2 = new WidgetDTO(new PointDTO(50, 100), 2, 100, 100);
        WidgetDTO widget3 = new WidgetDTO(new PointDTO(100, 100), 3, 100, 100);

        widgetController.createWidget(widget1);
        widgetController.createWidget(widget2);
        widgetController.createWidget(widget3);

        List<WidgetDTO> widgetDTOList = widgetPartialController.getWidgetsInRectangle(rectangle);

        System.out.println(widgetDTOList);
    }
}
