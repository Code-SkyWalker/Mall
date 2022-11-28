package com.skywalker.sms.service.impl;
import com.skywalker.sms.dao.SmsHomeAdvMapper;
import com.skywalker.sms.pojo.SmsHomeAdv;
import com.skywalker.sms.service.SmsHomeAdvService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname SmsHomeAdvServiceImpl
 * @Description TODO
 */
@Service
public class SmsHomeAdvServiceImpl implements SmsHomeAdvService {

    @Autowired
    private SmsHomeAdvMapper smsHomeAdvMapper;


    /**
     * SmsHomeAdv条件+分页查询
     * @param smsHomeAdv 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SmsHomeAdv> findPage(SmsHomeAdv smsHomeAdv, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(smsHomeAdv);
        //执行搜索
        return new PageInfo<SmsHomeAdv>(smsHomeAdvMapper.selectByExample(example));
    }

    /**
     * SmsHomeAdv分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SmsHomeAdv> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SmsHomeAdv>(smsHomeAdvMapper.selectAll());
    }

    /**
     * SmsHomeAdv条件查询
     * @param smsHomeAdv
     * @return
     */
    @Override
    public List<SmsHomeAdv> findList(SmsHomeAdv smsHomeAdv){
        //构建查询条件
        Example example = createExample(smsHomeAdv);
        //根据构建的条件查询数据
        return smsHomeAdvMapper.selectByExample(example);
    }


    /**
     * SmsHomeAdv构建查询对象
     * @param smsHomeAdv
     * @return
     */
    public Example createExample(SmsHomeAdv smsHomeAdv){
        Example example=new Example(SmsHomeAdv.class);
        Example.Criteria criteria = example.createCriteria();
        if(smsHomeAdv!=null){
            // id
            if(!StringUtils.isEmpty(smsHomeAdv.getId())){
                    criteria.andEqualTo("id",smsHomeAdv.getId());
            }
            // 名字
            if(!StringUtils.isEmpty(smsHomeAdv.getName())){
                    criteria.andLike("name","%"+smsHomeAdv.getName()+"%");
            }
            // 图片地址
            if(!StringUtils.isEmpty(smsHomeAdv.getPic())){
                    criteria.andEqualTo("pic",smsHomeAdv.getPic());
            }
            // 开始时间
            if(!StringUtils.isEmpty(smsHomeAdv.getStartTime())){
                    criteria.andEqualTo("startTime",smsHomeAdv.getStartTime());
            }
            // 结束时间
            if(!StringUtils.isEmpty(smsHomeAdv.getEndTime())){
                    criteria.andEqualTo("endTime",smsHomeAdv.getEndTime());
            }
            // 状态
            if(!StringUtils.isEmpty(smsHomeAdv.getStatus())){
                    criteria.andEqualTo("status",smsHomeAdv.getStatus());
            }
            // 点击数
            if(!StringUtils.isEmpty(smsHomeAdv.getClickCount())){
                    criteria.andEqualTo("clickCount",smsHomeAdv.getClickCount());
            }
            // 广告详情连接地址
            if(!StringUtils.isEmpty(smsHomeAdv.getUrl())){
                    criteria.andEqualTo("url",smsHomeAdv.getUrl());
            }
            // 备注
            if(!StringUtils.isEmpty(smsHomeAdv.getNote())){
                    criteria.andEqualTo("note",smsHomeAdv.getNote());
            }
            // 排序
            if(!StringUtils.isEmpty(smsHomeAdv.getSort())){
                    criteria.andEqualTo("sort",smsHomeAdv.getSort());
            }
            // 发布者
            if(!StringUtils.isEmpty(smsHomeAdv.getPublisherId())){
                    criteria.andEqualTo("publisherId",smsHomeAdv.getPublisherId());
            }
            // 审核者
            if(!StringUtils.isEmpty(smsHomeAdv.getAuthId())){
                    criteria.andEqualTo("authId",smsHomeAdv.getAuthId());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Long id){
        smsHomeAdvMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SmsHomeAdv
     * @param smsHomeAdv
     */
    @Override
    public void update(SmsHomeAdv smsHomeAdv){
        smsHomeAdvMapper.updateByPrimaryKey(smsHomeAdv);
    }

    /**
     * 增加SmsHomeAdv
     * @param smsHomeAdv
     */
    @Override
    public void add(SmsHomeAdv smsHomeAdv){
        smsHomeAdvMapper.insert(smsHomeAdv);
    }

    /**
     * 根据ID查询SmsHomeAdv
     * @param id
     * @return
     */
    @Override
    public SmsHomeAdv findById(Long id){
        return  smsHomeAdvMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SmsHomeAdv全部数据
     * @return
     */
    @Override
    public List<SmsHomeAdv> findAll() {
        return smsHomeAdvMapper.selectAll();
    }
}
