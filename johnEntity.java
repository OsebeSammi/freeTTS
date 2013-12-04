package com;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: sammi
 * Date: 11/28/13
 * Time: 8:43 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "John", schema = "", catalog = "Bible")
@Entity
public class JohnEntity {
    private int chapter;
    private String text;

    @javax.persistence.Column(name = "Chapter")
    @Id
    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    @javax.persistence.Column(name = "Text")
    @Basic
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JohnEntity that = (JohnEntity) o;

        if (chapter != that.chapter) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = chapter;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }
}
