package vn.app.project.dao;

import java.util.List;


public abstract class AbstractDAO<T> {
    public abstract Boolean add(T item);
    public abstract Boolean update(T item);
    public abstract void delete(int id);
    public abstract List<T> getAll() throws Exception;
}
