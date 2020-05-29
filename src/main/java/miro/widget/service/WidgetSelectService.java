package miro.widget.service;

import miro.widget.repository.entity.Widget;
import miro.widget.web.area.WidgetArea;
import java.util.List;

public interface WidgetSelectService {
    public List<Widget> getWidgetPage(int pageSize, int pageNum);

    public List<Widget> getWidgetsInArea(WidgetArea area);
}
