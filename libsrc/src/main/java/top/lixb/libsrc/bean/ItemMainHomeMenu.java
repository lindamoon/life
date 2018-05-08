package top.lixb.libsrc.bean;

import top.lixb.libcommon.base.IBindingItem;

public class ItemMainHomeMenu implements IBindingItem {
    public String title;

    public ItemMainHomeMenu(String title, int iconId) {
        this.title = title;
        this.iconId = iconId;
    }

    public ItemMainHomeMenu() {

    }

    public int iconId;

    @Override
    public int getItemType() {
        return 0;
    }
}
