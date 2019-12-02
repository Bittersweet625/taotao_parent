package com.xidian.search.service;

import com.xidian.common.pojo.TaotaoResult;

public interface SearchItemService {
    //导入商品到索引库
    TaotaoResult importItemsToIndex();
}
