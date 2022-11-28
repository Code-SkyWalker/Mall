package com.skywalker.oms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.skywalker.oms.dao.OmsOrderReturnApplyMapper;
import com.skywalker.oms.pojo.OmsOrderReturnApply;
import com.skywalker.oms.service.OmsOrderReturnApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname OmsOrderReturnApplyServiceImpl
 * @Description TODO
 */
@Service
public class OmsOrderReturnApplyServiceImpl implements OmsOrderReturnApplyService {

    @Autowired
    private OmsOrderReturnApplyMapper omsOrderReturnApplyMapper;


    /**
     * OmsOrderReturnApply条件+分页查询
     * @param omsOrderReturnApply 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<OmsOrderReturnApply> findPage(OmsOrderReturnApply omsOrderReturnApply, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(omsOrderReturnApply);
        //执行搜索
        return new PageInfo<OmsOrderReturnApply>(omsOrderReturnApplyMapper.selectByExample(example));
    }

    /**
     * OmsOrderReturnApply分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<OmsOrderReturnApply> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<OmsOrderReturnApply>(omsOrderReturnApplyMapper.selectAll());
    }

    /**
     * OmsOrderReturnApply条件查询
     * @param omsOrderReturnApply
     * @return
     */
    @Override
    public List<OmsOrderReturnApply> findList(OmsOrderReturnApply omsOrderReturnApply){
        //构建查询条件
        Example example = createExample(omsOrderReturnApply);
        //根据构建的条件查询数据
        return omsOrderReturnApplyMapper.selectByExample(example);
    }


    /**
     * OmsOrderReturnApply构建查询对象
     * @param omsOrderReturnApply
     * @return
     */
    public Example createExample(OmsOrderReturnApply omsOrderReturnApply){
        Example example=new Example(OmsOrderReturnApply.class);
        Example.Criteria criteria = example.createCriteria();
        if(omsOrderReturnApply!=null){
            // id
            if(!StringUtils.isEmpty(omsOrderReturnApply.getId())){
                    criteria.andEqualTo("id",omsOrderReturnApply.getId());
            }
            // order_id
            if(!StringUtils.isEmpty(omsOrderReturnApply.getOrderId())){
                    criteria.andEqualTo("orderId",omsOrderReturnApply.getOrderId());
            }
            // 退货商品id
            if(!StringUtils.isEmpty(omsOrderReturnApply.getSkuId())){
                    criteria.andEqualTo("skuId",omsOrderReturnApply.getSkuId());
            }
            // 订单编号
            if(!StringUtils.isEmpty(omsOrderReturnApply.getOrderSn())){
                    criteria.andEqualTo("orderSn",omsOrderReturnApply.getOrderSn());
            }
            // 申请时间
            if(!StringUtils.isEmpty(omsOrderReturnApply.getCreateTime())){
                    criteria.andEqualTo("createTime",omsOrderReturnApply.getCreateTime());
            }
            // 会员用户名
            if(!StringUtils.isEmpty(omsOrderReturnApply.getMemberUsername())){
                    criteria.andLike("memberUsername","%"+omsOrderReturnApply.getMemberUsername()+"%");
            }
            // 退款金额
            if(!StringUtils.isEmpty(omsOrderReturnApply.getReturnAmount())){
                    criteria.andEqualTo("returnAmount",omsOrderReturnApply.getReturnAmount());
            }
            // 退货人姓名
            if(!StringUtils.isEmpty(omsOrderReturnApply.getReturnName())){
                    criteria.andEqualTo("returnName",omsOrderReturnApply.getReturnName());
            }
            // 退货人电话
            if(!StringUtils.isEmpty(omsOrderReturnApply.getReturnPhone())){
                    criteria.andEqualTo("returnPhone",omsOrderReturnApply.getReturnPhone());
            }
            // 申请状态[0->待处理；1->退货中；2->已完成；3->已拒绝]
            if(!StringUtils.isEmpty(omsOrderReturnApply.getStatus())){
                    criteria.andEqualTo("status",omsOrderReturnApply.getStatus());
            }
            // 处理时间
            if(!StringUtils.isEmpty(omsOrderReturnApply.getHandleTime())){
                    criteria.andEqualTo("handleTime",omsOrderReturnApply.getHandleTime());
            }
            // 商品图片
            if(!StringUtils.isEmpty(omsOrderReturnApply.getSkuImg())){
                    criteria.andEqualTo("skuImg",omsOrderReturnApply.getSkuImg());
            }
            // 商品名称
            if(!StringUtils.isEmpty(omsOrderReturnApply.getSkuName())){
                    criteria.andEqualTo("skuName",omsOrderReturnApply.getSkuName());
            }
            // 商品品牌
            if(!StringUtils.isEmpty(omsOrderReturnApply.getSkuBrand())){
                    criteria.andEqualTo("skuBrand",omsOrderReturnApply.getSkuBrand());
            }
            // 商品销售属性(JSON)
            if(!StringUtils.isEmpty(omsOrderReturnApply.getSkuAttrsVals())){
                    criteria.andEqualTo("skuAttrsVals",omsOrderReturnApply.getSkuAttrsVals());
            }
            // 退货数量
            if(!StringUtils.isEmpty(omsOrderReturnApply.getSkuCount())){
                    criteria.andEqualTo("skuCount",omsOrderReturnApply.getSkuCount());
            }
            // 商品单价
            if(!StringUtils.isEmpty(omsOrderReturnApply.getSkuPrice())){
                    criteria.andEqualTo("skuPrice",omsOrderReturnApply.getSkuPrice());
            }
            // 商品实际支付单价
            if(!StringUtils.isEmpty(omsOrderReturnApply.getSkuRealPrice())){
                    criteria.andEqualTo("skuRealPrice",omsOrderReturnApply.getSkuRealPrice());
            }
            // 原因
            if(!StringUtils.isEmpty(omsOrderReturnApply.getReason())){
                    criteria.andEqualTo("reason",omsOrderReturnApply.getReason());
            }
            // 描述
            if(!StringUtils.isEmpty(omsOrderReturnApply.getDescription述())){
                    criteria.andEqualTo("description述",omsOrderReturnApply.getDescription述());
            }
            // 凭证图片，以逗号隔开
            if(!StringUtils.isEmpty(omsOrderReturnApply.getDescPics())){
                    criteria.andEqualTo("descPics",omsOrderReturnApply.getDescPics());
            }
            // 处理备注
            if(!StringUtils.isEmpty(omsOrderReturnApply.getHandleNote())){
                    criteria.andEqualTo("handleNote",omsOrderReturnApply.getHandleNote());
            }
            // 处理人员
            if(!StringUtils.isEmpty(omsOrderReturnApply.getHandleMan())){
                    criteria.andEqualTo("handleMan",omsOrderReturnApply.getHandleMan());
            }
            // 收货人
            if(!StringUtils.isEmpty(omsOrderReturnApply.getReceiveMan())){
                    criteria.andEqualTo("receiveMan",omsOrderReturnApply.getReceiveMan());
            }
            // 收货时间
            if(!StringUtils.isEmpty(omsOrderReturnApply.getReceiveTime())){
                    criteria.andEqualTo("receiveTime",omsOrderReturnApply.getReceiveTime());
            }
            // 收货备注
            if(!StringUtils.isEmpty(omsOrderReturnApply.getReceiveNote())){
                    criteria.andEqualTo("receiveNote",omsOrderReturnApply.getReceiveNote());
            }
            // 收货电话
            if(!StringUtils.isEmpty(omsOrderReturnApply.getReceivePhone())){
                    criteria.andEqualTo("receivePhone",omsOrderReturnApply.getReceivePhone());
            }
            // 公司收货地址
            if(!StringUtils.isEmpty(omsOrderReturnApply.getCompanyAddress())){
                    criteria.andEqualTo("companyAddress",omsOrderReturnApply.getCompanyAddress());
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
        omsOrderReturnApplyMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改OmsOrderReturnApply
     * @param omsOrderReturnApply
     */
    @Override
    public void update(OmsOrderReturnApply omsOrderReturnApply){
        omsOrderReturnApplyMapper.updateByPrimaryKey(omsOrderReturnApply);
    }

    /**
     * 增加OmsOrderReturnApply
     * @param omsOrderReturnApply
     */
    @Override
    public void add(OmsOrderReturnApply omsOrderReturnApply){
        omsOrderReturnApplyMapper.insert(omsOrderReturnApply);
    }

    /**
     * 根据ID查询OmsOrderReturnApply
     * @param id
     * @return
     */
    @Override
    public OmsOrderReturnApply findById(Long id){
        return  omsOrderReturnApplyMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询OmsOrderReturnApply全部数据
     * @return
     */
    @Override
    public List<OmsOrderReturnApply> findAll() {
        return omsOrderReturnApplyMapper.selectAll();
    }
}
