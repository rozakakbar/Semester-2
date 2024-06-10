package org.example.com.main.books;

import javafx.beans.property.SimpleStringProperty;

public class HistoryBook extends Book{
    private String category = "History";
    public HistoryBook(String bookId, String title, String author, int stock){
        super(bookId,title,author,stock);
        super.setCategory(category);
    }

    @Override
    public String getCategory() {
        return category;
    }
}
