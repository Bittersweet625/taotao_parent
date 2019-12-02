package com.xidian.content.service;

import com.xidian.common.pojo.EasyUIDataGridResult;
import com.xidian.common.pojo.TaotaoResult;
import com.xidian.pojo.TbContent;

import java.util.List;

public interface ContentService {
    EasyUIDataGridResult getContentList(int page, int rows);
    TaotaoResult addContent(TbContent content);
    List<TbContent> getContentByCid(long cid);
}
