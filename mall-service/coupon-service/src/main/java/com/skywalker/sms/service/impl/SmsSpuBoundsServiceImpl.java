package com.skywalker.sms.service.impl;
import com.skywalker.sms.dao.SmsSpuBoundsMapper;
import com.skywalker.sms.pojo.SmsSpuBounds;
import com.skywalker.sms.service.SmsSpuBoundsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname SmsSpuBoundsServiceImpl
 * @Description TODO
 */
@Service
public class SmsSpuBoundsServiceImpl implements SmsSpuBoundsService {

    @Autowired
    private SmsSpuBoundsMapper smsSpuBoundsMapper;


    /**
     * SmsSpuBounds条件+分页查询
     * @param smsSpuBounds 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SmsSpuBounds> findPage(SmsSpuBounds smsSpuBounds, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(smsSpuBounds);
        //执行搜索
        return new PageInfo<SmsSpuBounds>(smsSpuBoundsMapper.selectByExample(example));
    }

    /**
     * SmsSpuBounds分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SmsSpuBounds> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SmsSpuBounds>(smsSpuBoundsMapper.selectAll());
    }

    /**
     * SmsSpuBounds条件查询
     * @param smsSpuBounds
     * @return
     */
    @Override
    public List<SmsSpuBounds> findList(SmsSpuBounds smsSpuBounds){
        //构建查询条件
        Example example = createExample(smsSpuBounds);
        //根据构建的条件查询数据
        return smsSpuBoundsMapper.selectByExample(example);
    }


    /**
     * SmsSpuBounds构建查询对象
     * @param smsSpuBounds
     * @return
     */
    public Example createExample(SmsSpuBounds smsSpuBounds){
        Example example=new Example(SmsSpuBounds.class);
        Example.Criteria criteria = example.createCriteria();
        if(smsSpuBounds!=null){
            // id
            if(!StringUtils.isEmpty(smsSpuBounds.getId())){
                    criteria.andEqualTo("id",smsSpuBounds.getId());
            }
            // 
            if(!StringUtils.isEmpty(smsSpuBounds.getSpuId())){
                    criteria.andEqualTo("spuId",smsSpuBounds.getSpuId());
            }
            // 成长积分
            if(!StringUtils.isEmpty(smsSpuBounds.getGrowBounds())){
                    criteria.andEqualTo("growBounds",smsSpuBounds.getGrowBounds());
            }
            // 购物积分
            if(!StringUtils.isEmpty(smsSpuBounds.getBuyBounds())){
                    criteria.andEqualTo("buyBounds",smsSpuBounds.getBuyBounds());
            }
            // 优惠生效情况[1111（四个状态位，从右到左）;0 - 无优惠，成长积分是否赠送;1 - 无优惠，购物积分是否赠送;2 - 有优惠，成长积分是否赠送;3 - 有优惠，购物积分是否赠送【状态位0：不赠送，1：赠送】]
            if(!StringUtils.isEmpty(smsSpuBounds.getWork())){
                    criteria.andEqualTo("work",smsSpuBounds.getWork());
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
        smsSpuBoundsMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SmsSpuBounds
     * @param smsSpuBounds
     */
    @Override
    public void update(SmsSpuBounds smsSpuBounds){
        smsSpuBoundsMapper.updateByPrimaryKey(smsSpuBounds);
    }

    /**
     * 增加SmsSpuBounds
     * @param smsSpuBounds
     */
    @Override
    public void add(SmsSpuBounds smsSpuBounds){
        smsSpuBoundsMapper.insert(smsSpuBounds);
    }

    /**
     * 根据ID查询SmsSpuBounds
     * @param id
     * @return
     */
    @Override
    public SmsSpuBounds findById(Long id){
        return  smsSpuBoundsMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SmsSpuBounds全部数据
     * @return
     */
    @Override
    public List<SmsSpuBounds> findAll() {
        return smsSpuBoundsMapper.selectAll();
    }
}
