package cn.itcast.ssm.po;

import java.io.Serializable;


public class BuyerItem implements Serializable{

    private static final long serialVersionUID = 1L;

    private ItemsCustom itemsCustom;
    private Integer quantity;   //商品数量
    private float subTotal;     //同种商品价格小计


    public ItemsCustom getItemsCustom() {
        return itemsCustom;
    }

    public void setItemsCustom(ItemsCustom itemsCustom) {
        this.itemsCustom = itemsCustom;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal() {
        this.subTotal = itemsCustom.getPrice() * quantity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((itemsCustom == null) ? 0 : itemsCustom.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) //比较地址
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BuyerItem other = (BuyerItem) obj;
        if (itemsCustom == null) {
            if (other.itemsCustom != null)
                return false;
        } else if (!itemsCustom.getId().equals(other.itemsCustom.getId()))
            return false;
        return true;
    }


/*
  @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((item_id == null) ? 0 : item_id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) //比较地址
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BuyerItem other = (BuyerItem) obj;
        if (item_id == null) {
            if (other.item_id != null)
                return false;
        } else if (!item_id.equals(other.item_id))
            return false;
        return true;
    }*/


}
