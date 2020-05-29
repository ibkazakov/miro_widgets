package miro.widget;

import miro.widget.web.controller.WidgetController;
import miro.widget.web.mapper.dto.PointDTO;
import miro.widget.web.mapper.dto.WidgetDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class WidgetCRUDTests {
    @Autowired
    private WidgetController widgetController;

    @Test
    public void test1() {
        for(int i = 0; i < 5; i++) {
            WidgetDTO widgetDTO = new WidgetDTO(new PointDTO(0,0), null, 10 * (i + 1), 10 * (i + 1));
            widgetController.createWidget(widgetDTO);
        }
        List<WidgetDTO> widgetDTOList = widgetController.getAllWidgets();
        System.out.println(widgetDTOList);
    }

    @Test
    public void test2() {
        for(int i = 0; i < 5; i++) {
            WidgetDTO widgetDTO = new WidgetDTO(new PointDTO(0,0), 2, 10 * (i + 1), 10 * (i + 1));
            widgetController.createWidget(widgetDTO);
        }
        widgetController.deleteWidgetById(3L);

        WidgetDTO widgetDTO = widgetController.getWidgetById(5L);
        widgetDTO.setZ(5);
        widgetDTO.setWidth(111);
        widgetDTO.setHeight(222);

        widgetController.updateWidget(widgetDTO);

        WidgetDTO widgetDTO1 = widgetController.getWidgetById(1L);
        widgetDTO1.getLocation().setX(15);
        widgetDTO1.getLocation().setY(20);

        widgetController.updateWidget(widgetDTO1);

        List<WidgetDTO> widgetDTOList = widgetController.getAllWidgets();
        System.out.println(widgetDTOList);
    }
}
