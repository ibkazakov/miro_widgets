package miro.widget.web.controller;

import miro.widget.web.mapper.WidgetMapper;
import miro.widget.web.mapper.dto.WidgetDTO;
import miro.widget.repository.entity.Widget;
import miro.widget.service.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("widgets")
public class WidgetController {

    @Autowired
    private WidgetMapper mapper;

    @Autowired
    private WidgetService widgetService;

    //CREATE
    @PostMapping
    public WidgetDTO createWidget(@Valid @RequestBody WidgetDTO widjetDTO) {
        Widget widget =  widgetService.createWidget(mapper.toEntity(widjetDTO));
        return mapper.toDto(widget);
    }

    // READ
    @GetMapping("/{id}")
    public WidgetDTO getWidgetById(@PathVariable Long id) {
        Widget widget = widgetService.getWidgetById(id);
        return mapper.toDto(widget);
    }

    @GetMapping
    public List<WidgetDTO> getAllWidgets() {
        return widgetService.getAllWidgets().stream()
                .map(widget -> mapper.toDto(widget)).collect(Collectors.toList());
    }


    //UPDATE
    @PutMapping
    public WidgetDTO updateWidget(@Valid @RequestBody WidgetDTO widjetDTO) {
        Widget widget = widgetService.updateWidget(mapper.toEntity(widjetDTO));
        return mapper.toDto(widget);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public void deleteWidgetById(@PathVariable Long id) {
        widgetService.deleteWidgetById(id);
    }


}
