package miro.widget.web.mapper;

import miro.widget.repository.entity.Widget;
import miro.widget.web.mapper.dto.WidgetDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class WidgetMapper {
    @Autowired
    private ModelMapper mapper;


    public Widget toEntity(WidgetDTO dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Widget.class);
    }

    public WidgetDTO toDto(Widget entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, WidgetDTO.class);
    }
}
