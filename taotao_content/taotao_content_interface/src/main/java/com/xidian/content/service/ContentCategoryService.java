package com.xidian.content.service;

import com.xidian.common.pojo.EasyUITreeNode;
import com.xidian.common.pojo.TaotaoResult;

import java.util.List;

public interface ContentCategoryService {
    List<EasyUITreeNode> getContentCategoryList(long parentId);
    TaotaoResult addContentCategory(long parentId,String name);
    int updateContentCategory(long id,String name);
}
