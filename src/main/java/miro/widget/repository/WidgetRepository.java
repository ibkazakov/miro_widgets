package miro.widget.repository;

import miro.widget.repository.entity.Widget;

import java.util.Optional;


public interface WidgetRepository {
    //create
    Widget create(Widget widget);

    //read
    Optional<Widget> findById(Long id);

    Iterable<Widget> findAll();

    boolean existsById(Long id);

    boolean isEmpty();

    //update
    Widget update(Widget widget);

    //delete
    void deleteById(Long id);

}
