package miro.widget.web.mapper;

import miro.widget.repository.entity.Widget;
import miro.widget.web.area.WidgetRectangleArea;
import miro.widget.web.mapper.dto.RectangleAreaDTO;
import miro.widget.web.mapper.dto.WidgetDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class RectangleAreaMapper {
    @Autowired
    private ModelMapper mapper;

    public WidgetRectangleArea toEntity(RectangleAreaDTO dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, WidgetRectangleArea.class);
    }

    public RectangleAreaDTO toDto(WidgetRectangleArea entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, RectangleAreaDTO.class);
    }
}