package org.o2f.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class BookModel {
    String id;
    String title;
    String isbn;
}
