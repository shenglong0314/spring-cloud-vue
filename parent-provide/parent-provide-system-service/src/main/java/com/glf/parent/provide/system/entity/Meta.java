package com.glf.parent.provide.system.entity;

import javax.persistence.*;

@Table(name = "meta")
public class Meta {
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "add")
    private Boolean add;

    @Column(name = "delete")
    private Boolean delete;

    @Column(name = "edit")
    private Boolean edit;

    @Column(name = "select")
    private Boolean select;

    @Column(name = "title")
    private String title;

    @Column(name = "icon")
    private String icon;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return add
     */
    public Boolean getAdd() {
        return add;
    }

    /**
     * @param add
     */
    public void setAdd(Boolean add) {
        this.add = add;
    }

    /**
     * @return delete
     */
    public Boolean getDelete() {
        return delete;
    }

    /**
     * @param delete
     */
    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

    /**
     * @return edit
     */
    public Boolean getEdit() {
        return edit;
    }

    /**
     * @param edit
     */
    public void setEdit(Boolean edit) {
        this.edit = edit;
    }

    /**
     * @return select
     */
    public Boolean getSelect() {
        return select;
    }

    /**
     * @param select
     */
    public void setSelect(Boolean select) {
        this.select = select;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }
}