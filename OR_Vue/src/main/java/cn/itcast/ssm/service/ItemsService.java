package cn.itcast.ssm.service;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;

import java.util.List;

/**
 * 2016-11-10 15:00
 */

public interface ItemsService {

     List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;

     List<ItemsCustom> findItemsByParam(ItemsQueryVo itemsQueryVo);

     List<ItemsCustom> findItemsByParamResultMap(ItemsQueryVo itemsQueryVo);

     ItemsCustom findItemsById(Integer id);

     void updateItems(Integer id, ItemsCustom itemsCustom);

     void updateItemSelective(Integer id, ItemsCustom itemsCustom);

     void deleteItems(Integer[] a);

     void addItems(ItemsCustom itemsCustom);

     void addItemsAndId(ItemsCustom itemsCustom);

//     void updateItemsList(ItemsQueryVo itemsQueryVo);
}
