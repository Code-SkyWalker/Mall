package com.skywalker.ums.service.impl;
import com.skywalker.ums.dao.UmsMemberStatisticsInfoMapper;
import com.skywalker.ums.pojo.UmsMemberStatisticsInfo;
import com.skywalker.ums.service.UmsMemberStatisticsInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname UmsMemberStatisticsInfoServiceImpl
 * @Description TODO
 */
@Service
public class UmsMemberStatisticsInfoServiceImpl implements UmsMemberStatisticsInfoService {

    @Autowired
    private UmsMemberStatisticsInfoMapper umsMemberStatisticsInfoMapper;


    /**
     * UmsMemberStatisticsInfo条件+分页查询
     * @param umsMemberStatisticsInfo 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<UmsMemberStatisticsInfo> findPage(UmsMemberStatisticsInfo umsMemberStatisticsInfo, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(umsMemberStatisticsInfo);
        //执行搜索
        return new PageInfo<UmsMemberStatisticsInfo>(umsMemberStatisticsInfoMapper.selectByExample(example));
    }

    /**
     * UmsMemberStatisticsInfo分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<UmsMemberStatisticsInfo> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<UmsMemberStatisticsInfo>(umsMemberStatisticsInfoMapper.selectAll());
    }

    /**
     * UmsMemberStatisticsInfo条件查询
     * @param umsMemberStatisticsInfo
     * @return
     */
    @Override
    public List<UmsMemberStatisticsInfo> findList(UmsMemberStatisticsInfo umsMemberStatisticsInfo){
        //构建查询条件
        Example example = createExample(umsMemberStatisticsInfo);
        //根据构建的条件查询数据
        return umsMemberStatisticsInfoMapper.selectByExample(example);
    }


    /**
     * UmsMemberStatisticsInfo构建查询对象
     * @param umsMemberStatisticsInfo
     * @return
     */
    public Example createExample(UmsMemberStatisticsInfo umsMemberStatisticsInfo){
        Example example=new Example(UmsMemberStatisticsInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if(umsMemberStatisticsInfo!=null){
            // id
            if(!StringUtils.isEmpty(umsMemberStatisticsInfo.getId())){
                    criteria.andEqualTo("id",umsMemberStatisticsInfo.getId());
            }
            // 会员id
            if(!StringUtils.isEmpty(umsMemberStatisticsInfo.getMemberId())){
                    criteria.andEqualTo("memberId",umsMemberStatisticsInfo.getMemberId());
            }
            // 累计消费金额
            if(!StringUtils.isEmpty(umsMemberStatisticsInfo.getConsumeAmount())){
                    criteria.andEqualTo("consumeAmount",umsMemberStatisticsInfo.getConsumeAmount());
            }
            // 累计优惠金额
            if(!StringUtils.isEmpty(umsMemberStatisticsInfo.getCouponAmount())){
                    criteria.andEqualTo("couponAmount",umsMemberStatisticsInfo.getCouponAmount());
            }
            // 订单数量
            if(!StringUtils.isEmpty(umsMemberStatisticsInfo.getOrderCount())){
                    criteria.andEqualTo("orderCount",umsMemberStatisticsInfo.getOrderCount());
            }
            // 优惠券数量
            if(!StringUtils.isEmpty(umsMemberStatisticsInfo.getCouponCount())){
                    criteria.andEqualTo("couponCount",umsMemberStatisticsInfo.getCouponCount());
            }
            // 评价数
            if(!StringUtils.isEmpty(umsMemberStatisticsInfo.getCommentCount())){
                    criteria.andEqualTo("commentCount",umsMemberStatisticsInfo.getCommentCount());
            }
            // 退货数量
            if(!StringUtils.isEmpty(umsMemberStatisticsInfo.getReturnOrderCount())){
                    criteria.andEqualTo("returnOrderCount",umsMemberStatisticsInfo.getReturnOrderCount());
            }
            // 登录次数
            if(!StringUtils.isEmpty(umsMemberStatisticsInfo.getLoginCount())){
                    criteria.andEqualTo("loginCount",umsMemberStatisticsInfo.getLoginCount());
            }
            // 关注数量
            if(!StringUtils.isEmpty(umsMemberStatisticsInfo.getAttendCount())){
                    criteria.andEqualTo("attendCount",umsMemberStatisticsInfo.getAttendCount());
            }
            // 粉丝数量
            if(!StringUtils.isEmpty(umsMemberStatisticsInfo.getFansCount())){
                    criteria.andEqualTo("fansCount",umsMemberStatisticsInfo.getFansCount());
            }
            // 收藏的商品数量
            if(!StringUtils.isEmpty(umsMemberStatisticsInfo.getCollectProductCount())){
                    criteria.andEqualTo("collectProductCount",umsMemberStatisticsInfo.getCollectProductCount());
            }
            // 收藏的专题活动数量
            if(!StringUtils.isEmpty(umsMemberStatisticsInfo.getCollectSubjectCount())){
                    criteria.andEqualTo("collectSubjectCount",umsMemberStatisticsInfo.getCollectSubjectCount());
            }
            // 收藏的评论数量
            if(!StringUtils.isEmpty(umsMemberStatisticsInfo.getCollectCommentCount())){
                    criteria.andEqualTo("collectCommentCount",umsMemberStatisticsInfo.getCollectCommentCount());
            }
            // 邀请的朋友数量
            if(!StringUtils.isEmpty(umsMemberStatisticsInfo.getInviteFriendCount())){
                    criteria.andEqualTo("inviteFriendCount",umsMemberStatisticsInfo.getInviteFriendCount());
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
        umsMemberStatisticsInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改UmsMemberStatisticsInfo
     * @param umsMemberStatisticsInfo
     */
    @Override
    public void update(UmsMemberStatisticsInfo umsMemberStatisticsInfo){
        umsMemberStatisticsInfoMapper.updateByPrimaryKey(umsMemberStatisticsInfo);
    }

    /**
     * 增加UmsMemberStatisticsInfo
     * @param umsMemberStatisticsInfo
     */
    @Override
    public void add(UmsMemberStatisticsInfo umsMemberStatisticsInfo){
        umsMemberStatisticsInfoMapper.insert(umsMemberStatisticsInfo);
    }

    /**
     * 根据ID查询UmsMemberStatisticsInfo
     * @param id
     * @return
     */
    @Override
    public UmsMemberStatisticsInfo findById(Long id){
        return  umsMemberStatisticsInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询UmsMemberStatisticsInfo全部数据
     * @return
     */
    @Override
    public List<UmsMemberStatisticsInfo> findAll() {
        return umsMemberStatisticsInfoMapper.selectAll();
    }
}
