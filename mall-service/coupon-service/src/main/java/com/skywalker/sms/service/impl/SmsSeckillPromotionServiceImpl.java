package com.skywalker.sms.service.impl;
import com.skywalker.sms.dao.SmsSeckillPromotionMapper;
import com.skywalker.sms.pojo.SmsSeckillPromotion;
import com.skywalker.sms.service.SmsSeckillPromotionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname SmsSeckillPromotionServiceImpl
 * @Description TODO
 */
@Service
public class SmsSeckillPromotionServiceImpl implements SmsSeckillPromotionService {

    @Autowired
    private SmsSeckillPromotionMapper smsSeckillPromotionMapper;


    /**
     * SmsSeckillPromotion条件+分页查询
     * @param smsSeckillPromotion 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SmsSeckillPromotion> findPage(SmsSeckillPromotion smsSeckillPromotion, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(smsSeckillPromotion);
        //执行搜索
        return new PageInfo<SmsSeckillPromotion>(smsSeckillPromotionMapper.selectByExample(example));
    }

    /**
     * SmsSeckillPromotion分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SmsSeckillPromotion> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SmsSeckillPromotion>(smsSeckillPromotionMapper.selectAll());
    }

    /**
     * SmsSeckillPromotion条件查询
     * @param smsSeckillPromotion
     * @return
     */
    @Override
    public List<SmsSeckillPromotion> findList(SmsSeckillPromotion smsSeckillPromotion){
        //构建查询条件
        Example example = createExample(smsSeckillPromotion);
        //根据构建的条件查询数据
        return smsSeckillPromotionMapper.selectByExample(example);
    }


    /**
     * SmsSeckillPromotion构建查询对象
     * @param smsSeckillPromotion
     * @return
     */
    public Example createExample(SmsSeckillPromotion smsSeckillPromotion){
        Example example=new Example(SmsSeckillPromotion.class);
        Example.Criteria criteria = example.createCriteria();
        if(smsSeckillPromotion!=null){
            // id
            if(!StringUtils.isEmpty(smsSeckillPromotion.getId())){
                    criteria.andEqualTo("id",smsSeckillPromotion.getId());
            }
            // 活动标题
            if(!StringUtils.isEmpty(smsSeckillPromotion.getTitle())){
                    criteria.andLike("title","%"+smsSeckillPromotion.getTitle()+"%");
            }
            // 开始日期
            if(!StringUtils.isEmpty(smsSeckillPromotion.getStartTime())){
                    criteria.andEqualTo("startTime",smsSeckillPromotion.getStartTime());
            }
            // 结束日期
            if(!StringUtils.isEmpty(smsSeckillPromotion.getEndTime())){
                    criteria.andEqualTo("endTime",smsSeckillPromotion.getEndTime());
            }
            // 上下线状态
            if(!StringUtils.isEmpty(smsSeckillPromotion.getStatus())){
                    criteria.andEqualTo("status",smsSeckillPromotion.getStatus());
            }
            // 创建时间
            if(!StringUtils.isEmpty(smsSeckillPromotion.getCreateTime())){
                    criteria.andEqualTo("createTime",smsSeckillPromotion.getCreateTime());
            }
            // 创建人
            if(!StringUtils.isEmpty(smsSeckillPromotion.getUserId())){
                    criteria.andEqualTo("userId",smsSeckillPromotion.getUserId());
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
        smsSeckillPromotionMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SmsSeckillPromotion
     * @param smsSeckillPromotion
     */
    @Override
    public void update(SmsSeckillPromotion smsSeckillPromotion){
        smsSeckillPromotionMapper.updateByPrimaryKey(smsSeckillPromotion);
    }

    /**
     * 增加SmsSeckillPromotion
     * @param smsSeckillPromotion
     */
    @Override
    public void add(SmsSeckillPromotion smsSeckillPromotion){
        smsSeckillPromotionMapper.insert(smsSeckillPromotion);
    }

    /**
     * 根据ID查询SmsSeckillPromotion
     * @param id
     * @return
     */
    @Override
    public SmsSeckillPromotion findById(Long id){
        return  smsSeckillPromotionMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SmsSeckillPromotion全部数据
     * @return
     */
    @Override
    public List<SmsSeckillPromotion> findAll() {
        return smsSeckillPromotionMapper.selectAll();
    }
}
