package com.skywalker.oms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.skywalker.oms.dao.OmsOrderMapper;
import com.skywalker.oms.pojo.OmsOrder;
import com.skywalker.oms.service.OmsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname OmsOrderServiceImpl
 * @Description TODO
 */
@Service
public class OmsOrderServiceImpl implements OmsOrderService {

    @Autowired
    private OmsOrderMapper omsOrderMapper;


    /**
     * OmsOrder条件+分页查询
     * @param omsOrder 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<OmsOrder> findPage(OmsOrder omsOrder, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(omsOrder);
        //执行搜索
        return new PageInfo<OmsOrder>(omsOrderMapper.selectByExample(example));
    }

    /**
     * OmsOrder分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<OmsOrder> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<OmsOrder>(omsOrderMapper.selectAll());
    }

    /**
     * OmsOrder条件查询
     * @param omsOrder
     * @return
     */
    @Override
    public List<OmsOrder> findList(OmsOrder omsOrder){
        //构建查询条件
        Example example = createExample(omsOrder);
        //根据构建的条件查询数据
        return omsOrderMapper.selectByExample(example);
    }


    /**
     * OmsOrder构建查询对象
     * @param omsOrder
     * @return
     */
    public Example createExample(OmsOrder omsOrder){
        Example example=new Example(OmsOrder.class);
        Example.Criteria criteria = example.createCriteria();
        if(omsOrder!=null){
            // id
            if(!StringUtils.isEmpty(omsOrder.getId())){
                    criteria.andEqualTo("id",omsOrder.getId());
            }
            // member_id
            if(!StringUtils.isEmpty(omsOrder.getMemberId())){
                    criteria.andEqualTo("memberId",omsOrder.getMemberId());
            }
            // 订单号
            if(!StringUtils.isEmpty(omsOrder.getOrderSn())){
                    criteria.andEqualTo("orderSn",omsOrder.getOrderSn());
            }
            // 使用的优惠券
            if(!StringUtils.isEmpty(omsOrder.getCouponId())){
                    criteria.andEqualTo("couponId",omsOrder.getCouponId());
            }
            // create_time
            if(!StringUtils.isEmpty(omsOrder.getCreateTime())){
                    criteria.andEqualTo("createTime",omsOrder.getCreateTime());
            }
            // 用户名
            if(!StringUtils.isEmpty(omsOrder.getMemberUsername())){
                    criteria.andLike("memberUsername","%"+omsOrder.getMemberUsername()+"%");
            }
            // 订单总额
            if(!StringUtils.isEmpty(omsOrder.getTotalAmount())){
                    criteria.andEqualTo("totalAmount",omsOrder.getTotalAmount());
            }
            // 应付总额
            if(!StringUtils.isEmpty(omsOrder.getPayAmount())){
                    criteria.andEqualTo("payAmount",omsOrder.getPayAmount());
            }
            // 运费金额
            if(!StringUtils.isEmpty(omsOrder.getFreightAmount())){
                    criteria.andEqualTo("freightAmount",omsOrder.getFreightAmount());
            }
            // 促销优化金额（促销价、满减、阶梯价）
            if(!StringUtils.isEmpty(omsOrder.getPromotionAmount())){
                    criteria.andEqualTo("promotionAmount",omsOrder.getPromotionAmount());
            }
            // 积分抵扣金额
            if(!StringUtils.isEmpty(omsOrder.getIntegrationAmount())){
                    criteria.andEqualTo("integrationAmount",omsOrder.getIntegrationAmount());
            }
            // 优惠券抵扣金额
            if(!StringUtils.isEmpty(omsOrder.getCouponAmount())){
                    criteria.andEqualTo("couponAmount",omsOrder.getCouponAmount());
            }
            // 后台调整订单使用的折扣金额
            if(!StringUtils.isEmpty(omsOrder.getDiscountAmount())){
                    criteria.andEqualTo("discountAmount",omsOrder.getDiscountAmount());
            }
            // 支付方式【1->支付宝；2->微信；3->银联； 4->货到付款；】
            if(!StringUtils.isEmpty(omsOrder.getPayType())){
                    criteria.andEqualTo("payType",omsOrder.getPayType());
            }
            // 订单来源[0->PC订单；1->app订单]
            if(!StringUtils.isEmpty(omsOrder.getSourceType())){
                    criteria.andEqualTo("sourceType",omsOrder.getSourceType());
            }
            // 订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】
            if(!StringUtils.isEmpty(omsOrder.getStatus())){
                    criteria.andEqualTo("status",omsOrder.getStatus());
            }
            // 物流公司(配送方式)
            if(!StringUtils.isEmpty(omsOrder.getDeliveryCompany())){
                    criteria.andEqualTo("deliveryCompany",omsOrder.getDeliveryCompany());
            }
            // 物流单号
            if(!StringUtils.isEmpty(omsOrder.getDeliverySn())){
                    criteria.andEqualTo("deliverySn",omsOrder.getDeliverySn());
            }
            // 自动确认时间（天）
            if(!StringUtils.isEmpty(omsOrder.getAutoConfirmDay())){
                    criteria.andEqualTo("autoConfirmDay",omsOrder.getAutoConfirmDay());
            }
            // 可以获得的积分
            if(!StringUtils.isEmpty(omsOrder.getIntegration())){
                    criteria.andEqualTo("integration",omsOrder.getIntegration());
            }
            // 可以获得的成长值
            if(!StringUtils.isEmpty(omsOrder.getGrowth())){
                    criteria.andEqualTo("growth",omsOrder.getGrowth());
            }
            // 发票类型[0->不开发票；1->电子发票；2->纸质发票]
            if(!StringUtils.isEmpty(omsOrder.getBillType())){
                    criteria.andEqualTo("billType",omsOrder.getBillType());
            }
            // 发票抬头
            if(!StringUtils.isEmpty(omsOrder.getBillHeader())){
                    criteria.andEqualTo("billHeader",omsOrder.getBillHeader());
            }
            // 发票内容
            if(!StringUtils.isEmpty(omsOrder.getBillContent())){
                    criteria.andEqualTo("billContent",omsOrder.getBillContent());
            }
            // 收票人电话
            if(!StringUtils.isEmpty(omsOrder.getBillReceiverPhone())){
                    criteria.andEqualTo("billReceiverPhone",omsOrder.getBillReceiverPhone());
            }
            // 收票人邮箱
            if(!StringUtils.isEmpty(omsOrder.getBillReceiverEmail())){
                    criteria.andEqualTo("billReceiverEmail",omsOrder.getBillReceiverEmail());
            }
            // 收货人姓名
            if(!StringUtils.isEmpty(omsOrder.getReceiverName())){
                    criteria.andEqualTo("receiverName",omsOrder.getReceiverName());
            }
            // 收货人电话
            if(!StringUtils.isEmpty(omsOrder.getReceiverPhone())){
                    criteria.andEqualTo("receiverPhone",omsOrder.getReceiverPhone());
            }
            // 收货人邮编
            if(!StringUtils.isEmpty(omsOrder.getReceiverPostCode())){
                    criteria.andEqualTo("receiverPostCode",omsOrder.getReceiverPostCode());
            }
            // 省份/直辖市
            if(!StringUtils.isEmpty(omsOrder.getReceiverProvince())){
                    criteria.andEqualTo("receiverProvince",omsOrder.getReceiverProvince());
            }
            // 城市
            if(!StringUtils.isEmpty(omsOrder.getReceiverCity())){
                    criteria.andEqualTo("receiverCity",omsOrder.getReceiverCity());
            }
            // 区
            if(!StringUtils.isEmpty(omsOrder.getReceiverRegion())){
                    criteria.andEqualTo("receiverRegion",omsOrder.getReceiverRegion());
            }
            // 详细地址
            if(!StringUtils.isEmpty(omsOrder.getReceiverDetailAddress())){
                    criteria.andEqualTo("receiverDetailAddress",omsOrder.getReceiverDetailAddress());
            }
            // 订单备注
            if(!StringUtils.isEmpty(omsOrder.getNote())){
                    criteria.andEqualTo("note",omsOrder.getNote());
            }
            // 确认收货状态[0->未确认；1->已确认]
            if(!StringUtils.isEmpty(omsOrder.getConfirmStatus())){
                    criteria.andEqualTo("confirmStatus",omsOrder.getConfirmStatus());
            }
            // 删除状态【0->未删除；1->已删除】
            if(!StringUtils.isEmpty(omsOrder.getDeleteStatus())){
                    criteria.andEqualTo("deleteStatus",omsOrder.getDeleteStatus());
            }
            // 下单时使用的积分
            if(!StringUtils.isEmpty(omsOrder.getUseIntegration())){
                    criteria.andEqualTo("useIntegration",omsOrder.getUseIntegration());
            }
            // 支付时间
            if(!StringUtils.isEmpty(omsOrder.getPaymentTime())){
                    criteria.andEqualTo("paymentTime",omsOrder.getPaymentTime());
            }
            // 发货时间
            if(!StringUtils.isEmpty(omsOrder.getDeliveryTime())){
                    criteria.andEqualTo("deliveryTime",omsOrder.getDeliveryTime());
            }
            // 确认收货时间
            if(!StringUtils.isEmpty(omsOrder.getReceiveTime())){
                    criteria.andEqualTo("receiveTime",omsOrder.getReceiveTime());
            }
            // 评价时间
            if(!StringUtils.isEmpty(omsOrder.getCommentTime())){
                    criteria.andEqualTo("commentTime",omsOrder.getCommentTime());
            }
            // 修改时间
            if(!StringUtils.isEmpty(omsOrder.getModifyTime())){
                    criteria.andEqualTo("modifyTime",omsOrder.getModifyTime());
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
        omsOrderMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改OmsOrder
     * @param omsOrder
     */
    @Override
    public void update(OmsOrder omsOrder){
        omsOrderMapper.updateByPrimaryKey(omsOrder);
    }

    /**
     * 增加OmsOrder
     * @param omsOrder
     */
    @Override
    public void add(OmsOrder omsOrder){
        omsOrderMapper.insert(omsOrder);
    }

    /**
     * 根据ID查询OmsOrder
     * @param id
     * @return
     */
    @Override
    public OmsOrder findById(Long id){
        return  omsOrderMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询OmsOrder全部数据
     * @return
     */
    @Override
    public List<OmsOrder> findAll() {
        return omsOrderMapper.selectAll();
    }
}
