package miro.widget.service.impl;

import miro.widget.repository.entity.Widget;
import miro.widget.service.WidgetSelectService;
import miro.widget.service.WidgetService;
import miro.widget.web.area.WidgetArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WidgetSelectServiceImpl implements WidgetSelectService {

    @Autowired
    private WidgetService widgetService;

    private static final int MAX_PAGE_SIZE = 500;

    public List<Widget> getWidgetPage(int pageSize, int pageNum) {
        List<Widget> allWidgets = widgetService.getAllWidgets();
        int size = allWidgets.size();

        if (size == 0) {
            return new ArrayList<>();
        }

        if (!checkPage(pageSize, pageNum)){
            return null;
        }

        PagedListHolder<Widget> pageHolder = new PagedListHolder<Widget>(allWidgets);
        pageHolder.setPageSize(pageSize);
        pageHolder.setPage(pageNum - 1);

        return pageHolder.getPageList();
    }

    public List<Widget> getWidgetsInArea(WidgetArea area) {
        List<Widget> allWidgets = widgetService.getAllWidgets();
        List<Widget> selectedWidgets = new ArrayList<>();
        for(Widget widget : allWidgets) {
            if (area.contains(widget)) {
                selectedWidgets.add(widget);
            }
        }
        return selectedWidgets;
    }

    private boolean checkPage(int pageSize, int pageNum) {
        return (pageSize > 0) && (pageSize < MAX_PAGE_SIZE) && (pageNum > 0);
    }


}
