package by.bsuir.dc.lab5.services.interfaces;

import by.bsuir.dc.lab5.entities.News;

import java.util.List;

public interface NewsService {
    News add(News editor);

    void delete(long id);

    News update(News editor);

    News getById(long id);

    List<News> getAll();

    News getByTitle(String title);
}
