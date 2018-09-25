package cn.itcast.ssm.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BuyerCart implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<BuyerItem> items = new ArrayList<>();

    private float order_total;

    public void addItems(BuyerItem new_item, Integer AbQuantity) {
        if (items.contains(new_item)) {
            //商品已在购物车时，追加item的数量
            for (BuyerItem buyerItem : items) {
                if (new_item.equals(buyerItem)) {
                    if (AbQuantity != null) {
                        buyerItem.setQuantity(AbQuantity);
//                        if (AbQuantity == 0) items.remove(buyerItem);
                    } else buyerItem.setQuantity(buyerItem.getQuantity() + new_item.getQuantity());
                }
            }
        }
        //否则添加新的商品对象
        else {
            items.add(new_item);
        }

    }

    public void remove_item(Integer itemId) {

        //报错java.util.ConcurrentModificationException
        /*for (BuyerItem item : items) {
            if (items.size()!=0 && (item.getItemsCustom().getId() == itemId)) {
                items.remove(item);
            }
        }*/
        Iterator<BuyerItem> iter = items.iterator();
        while (iter.hasNext()) {
            BuyerItem buyerItem = iter.next();
            Integer id = buyerItem.getItemsCustom().getId();
            if (id.equals(itemId))
//            if(id == itemId )  判断值是否相等用equals()，而不是“==”，“==”判断的是对象的地址。
            {
                iter.remove();
            }
        }
    }


    public List<BuyerItem> getItems() {
        return items;
    }

    public void setItems(List<BuyerItem> items) {
        this.items = items;
    }

    public float getOrder_total() {
        return order_total;
    }

    public void setOrder_total(float order_total) {
        this.order_total = order_total;
    }
}
