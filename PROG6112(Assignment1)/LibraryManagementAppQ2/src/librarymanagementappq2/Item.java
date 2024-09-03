/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagementappq2;

/**
 *
 * @author prosp
 */
class Item {
    private String title;
    private String author;
    private boolean isCheckedOut;

    public Item(String title, String author) {
        this.title = title;
        this.author = author;
        this.isCheckedOut = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.isCheckedOut = checkedOut;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Checked Out: " + (isCheckedOut ? "Yes" : "No");
    }
}
