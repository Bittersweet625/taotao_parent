package com.xidian.content.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xidian.common.pojo.EasyUIDataGridResult;
import com.xidian.common.pojo.TaotaoResult;
import com.xidian.common.utils.JsonUtils;
import com.xidian.content.service.ContentService;
import com.xidian.jedis.JedisClient;
import com.xidian.mapper.TbContentMapper;
import com.xidian.pojo.TbContent;
import com.xidian.pojo.TbContentExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private TbContentMapper tbContentMapper;
    @Autowired
    private JedisClient jedisClient;
    @Value("${INDEX_CONTENT}")
    private String INDEX_CONTENT;
    @Override
    public EasyUIDataGridResult getContentList(int page, int rows) {
        //设置分页信息
        PageHelper.startPage(page,rows);
        TbContentExample example=new TbContentExample();
        List<TbContent> list=tbContentMapper.selectByExample(example);
        //取查询结果
        PageInfo<TbContent> pageInfo=new PageInfo<>(list);
        EasyUIDataGridResult result=new EasyUIDataGridResult();
        result.setRows(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public TaotaoResult addContent(TbContent content) {
        content.setCreated(new Date());
        content.setUpdated(new Date());
        tbContentMapper.insert(content);
        //同步缓存
        jedisClient.hdel(INDEX_CONTENT,content.getCategoryId().toString());
        
        return TaotaoResult.ok();
    }

    @Override
    public List<TbContent> getContentByCid(long cid) {
        //先查询缓存
        //添加缓存不影响正常业务逻辑
        try{
            String json= jedisClient.hget(INDEX_CONTENT,cid+"");
            if(StringUtils.isNoneBlank(json)){
               List<TbContent> list= JsonUtils.jsonToList(json,TbContent.class);
               return list;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        TbContentExample example=new TbContentExample();
        TbContentExample.Criteria criteria=example.createCriteria();
        criteria.andCategoryIdEqualTo(cid);
        List<TbContent> list=tbContentMapper.selectByExample(example);
        //添加到缓存
        try {
            jedisClient.hset(INDEX_CONTENT,cid+"", JsonUtils.objectToJson((list)));
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
