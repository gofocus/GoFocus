package cn.itcast.ssm.po;

import java.util.List;

/**
 * 2016-11-10 22:26
 */
public class ItemsQueryVo {

    private Items items;

    private ItemsCustom itemsCustom;

    private List<ItemsCustom> itemsList;

    private String sort;

    private String order;

    public Items getItems() {
        return items;
    }
    public void setItems(Items items) {
        this.items = items;
    }
    public ItemsCustom getItemsCustom() {
        return itemsCustom;
    }
    public void setItemsCustom(ItemsCustom itemsCustom) {
        this.itemsCustom = itemsCustom;
    }
    public List<ItemsCustom> getItemsList() {
        return itemsList;
    }
    public void setItemsList(List<ItemsCustom> itemsList) {
        this.itemsList = itemsList;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
