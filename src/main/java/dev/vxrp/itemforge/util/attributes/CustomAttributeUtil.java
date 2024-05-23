package dev.vxrp.itemforge.util.attributes;

import java.util.List;

public class CustomAttributeUtil {
    List<String> attributes;

    public CustomAttributeUtil() {
    }
    //
    //Armor
    //
    //Positive
    public CustomAttributeUtil agility() {
        this.attributes.add("attribute.agility");
        return this;
    }
    public CustomAttributeUtil pride() {
        this.attributes.add("attribute.pride");
        return this;
    }
    public CustomAttributeUtil hardShell() {
        this.attributes.add("attribute.hardShell");
        return this;
    }
    public CustomAttributeUtil hotMetal() {
        this.attributes.add("attribute.hotMetal");
        return this;
    }
    public CustomAttributeUtil gliding() {
        this.attributes.add("attribute.gliding");
        return this;
    }

    //Negative
    public CustomAttributeUtil flamable() {
        this.attributes.add("attribute.flamable");
        return this;
    }
    public CustomAttributeUtil slowing() {
        this.attributes.add("attribute.slowing");
        return this;
    }
    public CustomAttributeUtil soft() {
        this.attributes.add("attribute.soft");
        return this;
    }
    public CustomAttributeUtil aHoleInTheWall() {
        this.attributes.add("attribute.aHoleInTheWall");
        return this;
    }

    public List<String> build() {
        return attributes;
    }
}
