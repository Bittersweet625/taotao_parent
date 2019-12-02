package com.xidian.controller;

import com.xidian.common.pojo.TaotaoResult;
import com.xidian.search.service.SearchItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 将所有商品导入索引库
 */
@Controller
public class IndexMangerController {

    @Autowired
    private SearchItemService searchItemService;
    @RequestMapping("/index/import")
    @ResponseBody
    public TaotaoResult importIndex(){
        TaotaoResult taotaoResult=searchItemService.importItemsToIndex();
        return taotaoResult;
    }
}
