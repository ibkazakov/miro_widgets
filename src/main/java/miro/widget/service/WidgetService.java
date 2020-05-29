package miro.widget.service;

import miro.widget.repository.entity.Widget;

import java.util.*;

public interface WidgetService {

    Widget getWidgetById(Long id);

    List<Widget> getAllWidgets();

    Widget createWidget(Widget widget);

    Widget updateWidget(Widget widget);

    void deleteWidgetById(Long id);
}
