package miro.widget.repository.impl;

import miro.widget.repository.WidgetRepository;
import miro.widget.repository.entity.Widget;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class WidgetRepositoryImpl implements WidgetRepository {
    private Map<Long, Widget> widjets = new ConcurrentHashMap<>();

    private AtomicLong nextId = new AtomicLong(0L);

    @Override
    public Widget create(Widget widget){
        widget.setId(nextId.incrementAndGet());
        widjets.put(nextId.get(), widget);
        return widget;
    }

    @Override
    public Optional<Widget> findById(Long id) {
        return Optional.ofNullable(widjets.get(id));
    }

    @Override
    public Iterable<Widget> findAll() {
       return widjets.values();
    }

    @Override
    public boolean existsById(Long id) {
        return widjets.containsKey(id);
    }

    @Override
    public boolean isEmpty() {
        return widjets.isEmpty();
    }

    @Override
    public Widget update(Widget widget) {
         widjets.put(widget.getId(), widget);
         return widget;
    }

    @Override
    public void deleteById(Long id) {
        widjets.remove(id);
    }

}
