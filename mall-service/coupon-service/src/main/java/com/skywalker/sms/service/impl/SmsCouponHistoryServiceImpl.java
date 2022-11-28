package com.skywalker.sms.service.impl;
import com.skywalker.sms.dao.SmsCouponHistoryMapper;
import com.skywalker.sms.pojo.SmsCouponHistory;
import com.skywalker.sms.service.SmsCouponHistoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname SmsCouponHistoryServiceImpl
 * @Description TODO
 */
@Service
public class SmsCouponHistoryServiceImpl implements SmsCouponHistoryService {

    @Autowired
    private SmsCouponHistoryMapper smsCouponHistoryMapper;


    /**
     * SmsCouponHistory条件+分页查询
     * @param smsCouponHistory 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SmsCouponHistory> findPage(SmsCouponHistory smsCouponHistory, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(smsCouponHistory);
        //执行搜索
        return new PageInfo<SmsCouponHistory>(smsCouponHistoryMapper.selectByExample(example));
    }

    /**
     * SmsCouponHistory分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SmsCouponHistory> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SmsCouponHistory>(smsCouponHistoryMapper.selectAll());
    }

    /**
     * SmsCouponHistory条件查询
     * @param smsCouponHistory
     * @return
     */
    @Override
    public List<SmsCouponHistory> findList(SmsCouponHistory smsCouponHistory){
        //构建查询条件
        Example example = createExample(smsCouponHistory);
        //根据构建的条件查询数据
        return smsCouponHistoryMapper.selectByExample(example);
    }


    /**
     * SmsCouponHistory构建查询对象
     * @param smsCouponHistory
     * @return
     */
    public Example createExample(SmsCouponHistory smsCouponHistory){
        Example example=new Example(SmsCouponHistory.class);
        Example.Criteria criteria = example.createCriteria();
        if(smsCouponHistory!=null){
            // id
            if(!StringUtils.isEmpty(smsCouponHistory.getId())){
                    criteria.andEqualTo("id",smsCouponHistory.getId());
            }
            // 优惠券id
            if(!StringUtils.isEmpty(smsCouponHistory.getCouponId())){
                    criteria.andEqualTo("couponId",smsCouponHistory.getCouponId());
            }
            // 会员id
            if(!StringUtils.isEmpty(smsCouponHistory.getMemberId())){
                    criteria.andEqualTo("memberId",smsCouponHistory.getMemberId());
            }
            // 会员名字
            if(!StringUtils.isEmpty(smsCouponHistory.getMemberNickName())){
                    criteria.andEqualTo("memberNickName",smsCouponHistory.getMemberNickName());
            }
            // 获取方式[0->后台赠送；1->主动领取]
            if(!StringUtils.isEmpty(smsCouponHistory.getGetType())){
                    criteria.andEqualTo("getType",smsCouponHistory.getGetType());
            }
            // 创建时间
            if(!StringUtils.isEmpty(smsCouponHistory.getCreateTime())){
                    criteria.andEqualTo("createTime",smsCouponHistory.getCreateTime());
            }
            // 使用状态[0->未使用；1->已使用；2->已过期]
            if(!StringUtils.isEmpty(smsCouponHistory.getUseType())){
                    criteria.andEqualTo("useType",smsCouponHistory.getUseType());
            }
            // 使用时间
            if(!StringUtils.isEmpty(smsCouponHistory.getUseTime())){
                    criteria.andEqualTo("useTime",smsCouponHistory.getUseTime());
            }
            // 订单id
            if(!StringUtils.isEmpty(smsCouponHistory.getOrderId())){
                    criteria.andEqualTo("orderId",smsCouponHistory.getOrderId());
            }
            // 订单号
            if(!StringUtils.isEmpty(smsCouponHistory.getOrderSn())){
                    criteria.andEqualTo("orderSn",smsCouponHistory.getOrderSn());
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
        smsCouponHistoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SmsCouponHistory
     * @param smsCouponHistory
     */
    @Override
    public void update(SmsCouponHistory smsCouponHistory){
        smsCouponHistoryMapper.updateByPrimaryKey(smsCouponHistory);
    }

    /**
     * 增加SmsCouponHistory
     * @param smsCouponHistory
     */
    @Override
    public void add(SmsCouponHistory smsCouponHistory){
        smsCouponHistoryMapper.insert(smsCouponHistory);
    }

    /**
     * 根据ID查询SmsCouponHistory
     * @param id
     * @return
     */
    @Override
    public SmsCouponHistory findById(Long id){
        return  smsCouponHistoryMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SmsCouponHistory全部数据
     * @return
     */
    @Override
    public List<SmsCouponHistory> findAll() {
        return smsCouponHistoryMapper.selectAll();
    }
}
