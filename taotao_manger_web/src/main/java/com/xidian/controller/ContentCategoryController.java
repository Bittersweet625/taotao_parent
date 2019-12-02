package com.xidian.controller;

import com.xidian.common.pojo.EasyUITreeNode;
import com.xidian.common.pojo.TaotaoResult;
import com.xidian.content.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ContentCategoryController {

    @Autowired
    private ContentCategoryService contentCategoryService;
    @RequestMapping("/content/category/list")
    @ResponseBody
    public List<EasyUITreeNode> getContentCategoryList(@RequestParam(value = "id",defaultValue = "0") Long parentId){
        List<EasyUITreeNode> list=contentCategoryService.getContentCategoryList(parentId);
        return list;
    }
    @RequestMapping("/content/category/create")
    @ResponseBody
    public TaotaoResult addContentCategory(Long parentId,String name){
        TaotaoResult result=contentCategoryService.addContentCategory(parentId,name);
        return result;
    }

    @RequestMapping("/content/category/update")
    public void updateContentCategory(Long id,String name){
        contentCategoryService.updateContentCategory(id,name);
    }
}
