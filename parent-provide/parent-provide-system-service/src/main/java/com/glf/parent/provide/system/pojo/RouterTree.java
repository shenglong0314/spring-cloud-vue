package com.glf.parent.provide.system.pojo;

import com.glf.parent.provide.system.entity.Button;
import com.glf.parent.provide.system.entity.Meta;
import com.glf.parent.provide.system.entity.Router;

import java.util.List;


public class RouterTree extends Router {
  private Meta meta ;
  private List<Button> button;
    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<Button> getButton() {
        return button;
    }

    public void setButton(List<Button> button) {
        this.button = button;
    }
}
