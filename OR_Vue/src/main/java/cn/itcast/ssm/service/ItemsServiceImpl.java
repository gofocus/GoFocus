package cn.itcast.ssm.service;

import cn.itcast.ssm.mapper.ItemsMapper;
import cn.itcast.ssm.mapper.ItemsMapperCustom;
import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsMapperCustom itemsMapperCustom;

    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public List<ItemsCustom> findItemsByParam(ItemsQueryVo itemsQueryVo) {
        return itemsMapperCustom.findItemsByParam(itemsQueryVo);
    }

    @Override
    public List<ItemsCustom> findItemsByParamResultMap(ItemsQueryVo itemsQueryVo) {
        return itemsMapperCustom.findItemsByParamResultMap(itemsQueryVo);
    }

    @Override
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
        return itemsMapperCustom.findItemsList(itemsQueryVo);
    }


    @Override
    public ItemsCustom findItemsById(Integer id) {

        Items items = itemsMapper.selectByPrimaryKey(id);

        ItemsCustom itemsCustom = new ItemsCustom();

        BeanUtils.copyProperties(items, itemsCustom);

        return itemsCustom;
    }

    @Override
    public void updateItems(Integer id, ItemsCustom itemsCustom) {

        itemsCustom.setId(id);
        itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
    }

    @Override
    public void updateItemSelective(Integer id, ItemsCustom itemsCustom) {
        itemsCustom.setId(id);
        itemsMapper.updateByPrimaryKeySelective(itemsCustom);
    }

    @Override
    public void deleteItems(Integer[] a) {
        for (Integer id : a) {
            itemsMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void addItems(ItemsCustom itemsCustom) {
        itemsMapper.insert(itemsCustom);

    }

    @Override
    public void addItemsAndId(ItemsCustom itemsCustom) {
        itemsMapperCustom.insert(itemsCustom);
    }
}





