package com.xidian.controller;

import com.xidian.common.pojo.EasyUIDataGridResult;
import com.xidian.common.pojo.TaotaoResult;
import com.xidian.content.service.ContentService;
import com.xidian.pojo.TbContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ContentController {
    @Autowired
    private ContentService contentService;

    @RequestMapping("/content/query/list")
    @ResponseBody
    public EasyUIDataGridResult getContentList(Integer page,Integer rows){
        EasyUIDataGridResult result=contentService.getContentList(page,rows);
        return result;
    }

    @RequestMapping("/content/save")
    @ResponseBody
    public TaotaoResult addContent(TbContent content){
        TaotaoResult taotaoResult=contentService.addContent(content);
        return taotaoResult;
    }
}
