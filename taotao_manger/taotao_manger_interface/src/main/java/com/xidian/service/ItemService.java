package com.xidian.service;

import com.xidian.common.pojo.EasyUIDataGridResult;
import com.xidian.common.pojo.TaotaoResult;
import com.xidian.pojo.TbItem;
import com.xidian.pojo.TbItemDesc;

public interface ItemService {
    TbItem getItemById(long itemId);
    EasyUIDataGridResult getItemList(int page, int rows);
    TaotaoResult addItem(TbItem item,String desc);
    TbItemDesc getItemDescById(long itemId);
}
