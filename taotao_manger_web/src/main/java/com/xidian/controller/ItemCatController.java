package com.xidian.controller;

import com.xidian.common.pojo.EasyUITreeNode;
import com.xidian.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;
    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<EasyUITreeNode> getItemList(@RequestParam(name = "id",defaultValue = "0") Long parentId){//第一次请求不展开节点，所以给默认值
        List<EasyUITreeNode> list=itemCatService.getItemCatList(parentId);
        return list;
    }
}
