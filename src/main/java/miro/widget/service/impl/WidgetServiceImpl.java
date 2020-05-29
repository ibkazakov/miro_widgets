package miro.widget.service.impl;

import miro.widget.service.WidgetService;
import miro.widget.repository.WidgetRepository;
import miro.widget.repository.entity.Widget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Consumer;

@Service
public class WidgetServiceImpl implements WidgetService {

    @Autowired
    private WidgetRepository widgetRepository;

    @Override
    public Widget getWidgetById(Long id) {
        return widgetRepository.findById(id).orElse(null);
    }

    @Override
    public List<Widget> getAllWidgets() {
        List<Widget> allWidgets = new ArrayList<>();
        widgetRepository.findAll().forEach(new Consumer<Widget>() {
            @Override
            public void accept(Widget widget) {
                allWidgets.add(widget);
            }
        });
        // sorting by z-index
        Collections.sort(allWidgets, new Comparator<Widget>() {
            @Override
            public int compare(Widget w1, Widget w2) {
                return Integer.valueOf(w1.getZ()).compareTo(w2.getZ());
            }
        });
        return allWidgets;
    }

    private int getMaxZ() {
        if (widgetRepository.isEmpty()) {
            return 0;
        }
        else {
            Integer maxZ = null;
            for(Widget widget : widgetRepository.findAll()) {
                int z = widget.getZ();
                if (maxZ == null) {
                    maxZ = z;
                }
                if (maxZ < z) {
                    maxZ = z;
                }
            }
            return maxZ;
        }
    }

    private void freeIndexZ(int z_index) {
        boolean isZpresent = false;
        Set<Widget> upCandidates= new HashSet<>();
        for (Widget widget : widgetRepository.findAll()) {
            int z = widget.getZ();
            if (z >= z_index) {
                upCandidates.add(widget);
            }
            if (z == z_index) {
                isZpresent = true;
            }
        }
        if (isZpresent) {
            for(Widget widget : upCandidates) {
                int z = widget.getZ();
                widget.setZ(z + 1);
                simpleUpdateWidget(widget);
            }
        }
    }

    // presupposing that widget with widget.id already present and widget.Z != null
    private Widget simpleUpdateWidget(Widget widget) {
        widget.setLastModification(new Date());
        return widgetRepository.update(widget);
    }

    @Override
    public Widget createWidget(Widget widget) {
        Integer z_index = widget.getZ();
        if (z_index == null) {
            widget.setZ(getMaxZ() + 1);
        } else {
            freeIndexZ(z_index);
        }
        widget.setLastModification(new Date());
        return widgetRepository.create(widget);
    }

    @Override
    public Widget updateWidget(Widget widget) {
        if (existsWidgetById(widget.getId())) {
           Long id = widget.getId();
           Widget oldWidget = getWidgetById(id);

           if (widget.getZ() == null) {
               widget.setZ(getMaxZ() + 1);
               return simpleUpdateWidget(widget);
           }

           if (widget.getZ().equals(oldWidget.getZ())) {
               return simpleUpdateWidget(widget);
           }

           deleteWidgetById(id);
           int z_index = widget.getZ();
           freeIndexZ(z_index);
           return simpleUpdateWidget(widget);

        } else
        {
            return null;
        }
    }

    private boolean existsWidgetById(Long id) {
        return widgetRepository.existsById(id);
    }

    @Override
    public void deleteWidgetById(Long id) {
        widgetRepository.deleteById(id);
    }
}
