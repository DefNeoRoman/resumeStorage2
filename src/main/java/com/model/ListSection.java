package com.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ListSection extends Section {

    private static final long serialVersionUID = 8794929072305001926L;
    private final List<String> items = new ArrayList<>();
    public static final ListSection EMPTY = new ListSection("");
    public ListSection() {

    }

    public ListSection(String...items) {
       this(Arrays.asList(items));
    }

    public ListSection(List<String> items) {
        Objects.requireNonNull(items,"items must be not null");
        this.items.addAll(items);
    }
    public List<String> getItems() {
        return items;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListSection that = (ListSection) o;

        return items.equals(that.items);

    }

    @Override
    public int hashCode() {
        return items.hashCode();
    }

    @Override
    public String toString() {
        return items.toString();
    }


}
