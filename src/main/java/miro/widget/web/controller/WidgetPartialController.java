package miro.widget.web.controller;

import miro.widget.service.WidgetSelectService;
import miro.widget.web.mapper.RectangleAreaMapper;
import miro.widget.web.mapper.WidgetMapper;
import miro.widget.web.mapper.dto.RectangleAreaDTO;
import miro.widget.web.mapper.dto.WidgetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("widgets/partial")
public class WidgetPartialController {

    @Autowired
    private WidgetMapper mapper;

    @Autowired
    private RectangleAreaMapper rectangleMapper;

    @Autowired
    private WidgetSelectService widgetSelectService;


    @GetMapping("/page/{pageNum}")
    public List<WidgetDTO> getWidgetPage(@RequestParam(name = "size", defaultValue = "10", required = false)
                                                 Integer pageSize, @PathVariable Integer pageNum) {

        return widgetSelectService.getWidgetPage(pageSize, pageNum).stream()
                .map(widget -> mapper.toDto(widget)).collect(Collectors.toList());

    }

    @GetMapping("/rectangle")
    public List<WidgetDTO> getWidgetsInRectangle(@Validated @RequestBody RectangleAreaDTO rectangle) {
        return widgetSelectService
                .getWidgetsInArea(rectangleMapper.toEntity(rectangle)).stream()
                .map(widget -> mapper.toDto(widget)).collect(Collectors.toList());
    }
}
