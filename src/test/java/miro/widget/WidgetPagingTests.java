package miro.widget;

import miro.widget.web.controller.WidgetController;
import miro.widget.web.controller.WidgetPartialController;
import miro.widget.web.mapper.dto.PointDTO;
import miro.widget.web.mapper.dto.WidgetDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class WidgetPagingTests {

    @Autowired
    private WidgetController widgetController;

    @Autowired
    private WidgetPartialController widgetPartialController;

    @Test
    public void test1() {
        for(int i = 0; i < 50; i++) {
            WidgetDTO widgetDTO = new WidgetDTO(new PointDTO(0, 0), null,
                    10 * (i + 1), 10 * (i + 1));
            widgetController.createWidget(widgetDTO);
        }

        List<WidgetDTO> widgetDTOList = widgetPartialController.getWidgetPage(5, 1);
        System.out.println(widgetDTOList);
    }

}
