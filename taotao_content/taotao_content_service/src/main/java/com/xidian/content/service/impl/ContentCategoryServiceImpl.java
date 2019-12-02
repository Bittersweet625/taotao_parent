package com.xidian.content.service.impl;

import com.xidian.common.pojo.EasyUITreeNode;
import com.xidian.common.pojo.TaotaoResult;
import com.xidian.content.service.ContentCategoryService;
import com.xidian.mapper.TbContentCategoryMapper;
import com.xidian.pojo.TbContent;
import com.xidian.pojo.TbContentCategory;
import com.xidian.pojo.TbContentCategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
    @Autowired
    private TbContentCategoryMapper contentCategoryMapper;
    @Override
    public List<EasyUITreeNode> getContentCategoryList(long parentId) {
        TbContentCategoryExample example=new TbContentCategoryExample();
        //设置查询条件
        TbContentCategoryExample.Criteria criteria=example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //执行查询
        List<TbContentCategory> list=contentCategoryMapper.selectByExample(example);
        List<EasyUITreeNode> resuliList=new ArrayList<>();
        for(TbContentCategory tbContentCategory:list){
            EasyUITreeNode node =new EasyUITreeNode();
            node.setId(tbContentCategory.getId());
            node.setText(tbContentCategory.getName());
            node.setState(tbContentCategory.getIsParent()?"closed":"open");
            resuliList.add(node);
        }
        return resuliList;
    }

    @Override
    public TaotaoResult addContentCategory(long parentId, String name) {
        TbContentCategory tbContentCategory =new TbContentCategory();
        tbContentCategory.setParentId(parentId);
        tbContentCategory.setName(name);
        //1正常 2删除
        tbContentCategory.setStatus(1);
        //默认排序
        tbContentCategory.setSortOrder(1);
        tbContentCategory.setIsParent(false);
        tbContentCategory.setCreated(new Date());
        tbContentCategory.setUpdated(new Date());
        //插入数据
        contentCategoryMapper.insert(tbContentCategory);
        //判断父节点状态
        TbContentCategory parent=contentCategoryMapper.selectByPrimaryKey(parentId);
        if(!parent.getIsParent()){
            parent.setIsParent(true);
            //更新父节点
            contentCategoryMapper.updateByPrimaryKey(parent);
        }
        return TaotaoResult.ok(tbContentCategory);
    }

    @Override
    public int updateContentCategory(long id, String name) {
        TbContentCategory tbContentCategory=contentCategoryMapper.selectByPrimaryKey(id);
        tbContentCategory.setName(name);
        tbContentCategory.setCreated(new Date());
        tbContentCategory.setUpdated(new Date());
        int state=contentCategoryMapper.updateByPrimaryKey(tbContentCategory);
        return state;
    }
}
