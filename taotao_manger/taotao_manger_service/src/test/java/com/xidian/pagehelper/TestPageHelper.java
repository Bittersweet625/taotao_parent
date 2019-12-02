package com.xidian.pagehelper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xidian.mapper.TbItemMapper;
import com.xidian.pojo.TbItem;
import com.xidian.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestPageHelper {
    @Test
    public void testPageHelper()throws  Exception{
        //配置分页插件
        //执行之前配置分页条件
        PageHelper.startPage(1,10);
        //执行查询
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
        TbItemMapper itemMapper=applicationContext.getBean(TbItemMapper.class);
        TbItemExample example=new TbItemExample();
//        TbItemExample.Criteria criteria= example.createCriteria();


        List<TbItem> list=itemMapper.selectByExample(example);
        //取分页信息
        PageInfo<TbItem> pageInfo=new PageInfo<>(list);
        System.out.println(pageInfo.getTotal());
        System.out.println(pageInfo.getPages());
        System.out.println(pageInfo.getList().size());

    }
}
