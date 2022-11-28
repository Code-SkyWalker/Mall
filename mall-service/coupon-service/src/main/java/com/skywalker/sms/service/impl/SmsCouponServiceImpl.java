package com.skywalker.sms.service.impl;
import com.skywalker.sms.dao.SmsCouponMapper;
import com.skywalker.sms.pojo.SmsCoupon;
import com.skywalker.sms.service.SmsCouponService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname SmsCouponServiceImpl
 * @Description TODO
 */
@Service
public class SmsCouponServiceImpl implements SmsCouponService {

    @Autowired
    private SmsCouponMapper smsCouponMapper;


    /**
     * SmsCoupon条件+分页查询
     * @param smsCoupon 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SmsCoupon> findPage(SmsCoupon smsCoupon, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(smsCoupon);
        //执行搜索
        return new PageInfo<SmsCoupon>(smsCouponMapper.selectByExample(example));
    }

    /**
     * SmsCoupon分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SmsCoupon> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SmsCoupon>(smsCouponMapper.selectAll());
    }

    /**
     * SmsCoupon条件查询
     * @param smsCoupon
     * @return
     */
    @Override
    public List<SmsCoupon> findList(SmsCoupon smsCoupon){
        //构建查询条件
        Example example = createExample(smsCoupon);
        //根据构建的条件查询数据
        return smsCouponMapper.selectByExample(example);
    }


    /**
     * SmsCoupon构建查询对象
     * @param smsCoupon
     * @return
     */
    public Example createExample(SmsCoupon smsCoupon){
        Example example=new Example(SmsCoupon.class);
        Example.Criteria criteria = example.createCriteria();
        if(smsCoupon!=null){
            // id
            if(!StringUtils.isEmpty(smsCoupon.getId())){
                    criteria.andEqualTo("id",smsCoupon.getId());
            }
            // 优惠卷类型[0->全场赠券；1->会员赠券；2->购物赠券；3->注册赠券]
            if(!StringUtils.isEmpty(smsCoupon.getCouponType())){
                    criteria.andEqualTo("couponType",smsCoupon.getCouponType());
            }
            // 优惠券图片
            if(!StringUtils.isEmpty(smsCoupon.getCouponImg())){
                    criteria.andEqualTo("couponImg",smsCoupon.getCouponImg());
            }
            // 优惠卷名字
            if(!StringUtils.isEmpty(smsCoupon.getCouponName())){
                    criteria.andEqualTo("couponName",smsCoupon.getCouponName());
            }
            // 数量
            if(!StringUtils.isEmpty(smsCoupon.getNum())){
                    criteria.andEqualTo("num",smsCoupon.getNum());
            }
            // 金额
            if(!StringUtils.isEmpty(smsCoupon.getAmount())){
                    criteria.andEqualTo("amount",smsCoupon.getAmount());
            }
            // 每人限领张数
            if(!StringUtils.isEmpty(smsCoupon.getPerLimit())){
                    criteria.andEqualTo("perLimit",smsCoupon.getPerLimit());
            }
            // 使用门槛
            if(!StringUtils.isEmpty(smsCoupon.getMinPoint())){
                    criteria.andEqualTo("minPoint",smsCoupon.getMinPoint());
            }
            // 开始时间
            if(!StringUtils.isEmpty(smsCoupon.getStartTime())){
                    criteria.andEqualTo("startTime",smsCoupon.getStartTime());
            }
            // 结束时间
            if(!StringUtils.isEmpty(smsCoupon.getEndTime())){
                    criteria.andEqualTo("endTime",smsCoupon.getEndTime());
            }
            // 使用类型[0->全场通用；1->指定分类；2->指定商品]
            if(!StringUtils.isEmpty(smsCoupon.getUseType())){
                    criteria.andEqualTo("useType",smsCoupon.getUseType());
            }
            // 备注
            if(!StringUtils.isEmpty(smsCoupon.getNote())){
                    criteria.andEqualTo("note",smsCoupon.getNote());
            }
            // 发行数量
            if(!StringUtils.isEmpty(smsCoupon.getPublishCount())){
                    criteria.andEqualTo("publishCount",smsCoupon.getPublishCount());
            }
            // 已使用数量
            if(!StringUtils.isEmpty(smsCoupon.getUseCount())){
                    criteria.andEqualTo("useCount",smsCoupon.getUseCount());
            }
            // 领取数量
            if(!StringUtils.isEmpty(smsCoupon.getReceiveCount())){
                    criteria.andEqualTo("receiveCount",smsCoupon.getReceiveCount());
            }
            // 可以领取的开始日期
            if(!StringUtils.isEmpty(smsCoupon.getEnableStartTime())){
                    criteria.andEqualTo("enableStartTime",smsCoupon.getEnableStartTime());
            }
            // 可以领取的结束日期
            if(!StringUtils.isEmpty(smsCoupon.getEnableEndTime())){
                    criteria.andEqualTo("enableEndTime",smsCoupon.getEnableEndTime());
            }
            // 优惠码
            if(!StringUtils.isEmpty(smsCoupon.getCode())){
                    criteria.andEqualTo("code",smsCoupon.getCode());
            }
            // 可以领取的会员等级[0->不限等级，其他-对应等级]
            if(!StringUtils.isEmpty(smsCoupon.getMemberLevel())){
                    criteria.andEqualTo("memberLevel",smsCoupon.getMemberLevel());
            }
            // 发布状态[0-未发布，1-已发布]
            if(!StringUtils.isEmpty(smsCoupon.getPublish())){
                    criteria.andEqualTo("publish",smsCoupon.getPublish());
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
        smsCouponMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SmsCoupon
     * @param smsCoupon
     */
    @Override
    public void update(SmsCoupon smsCoupon){
        smsCouponMapper.updateByPrimaryKey(smsCoupon);
    }

    /**
     * 增加SmsCoupon
     * @param smsCoupon
     */
    @Override
    public void add(SmsCoupon smsCoupon){
        smsCouponMapper.insert(smsCoupon);
    }

    /**
     * 根据ID查询SmsCoupon
     * @param id
     * @return
     */
    @Override
    public SmsCoupon findById(Long id){
        return  smsCouponMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SmsCoupon全部数据
     * @return
     */
    @Override
    public List<SmsCoupon> findAll() {
        return smsCouponMapper.selectAll();
    }
}
