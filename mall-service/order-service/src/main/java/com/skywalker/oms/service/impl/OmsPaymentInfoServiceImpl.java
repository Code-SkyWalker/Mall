package com.skywalker.oms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.skywalker.oms.dao.OmsPaymentInfoMapper;
import com.skywalker.oms.pojo.OmsPaymentInfo;
import com.skywalker.oms.service.OmsPaymentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname OmsPaymentInfoServiceImpl
 * @Description TODO
 */
@Service
public class OmsPaymentInfoServiceImpl implements OmsPaymentInfoService {

    @Autowired
    private OmsPaymentInfoMapper omsPaymentInfoMapper;


    /**
     * OmsPaymentInfo条件+分页查询
     * @param omsPaymentInfo 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<OmsPaymentInfo> findPage(OmsPaymentInfo omsPaymentInfo, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(omsPaymentInfo);
        //执行搜索
        return new PageInfo<OmsPaymentInfo>(omsPaymentInfoMapper.selectByExample(example));
    }

    /**
     * OmsPaymentInfo分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<OmsPaymentInfo> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<OmsPaymentInfo>(omsPaymentInfoMapper.selectAll());
    }

    /**
     * OmsPaymentInfo条件查询
     * @param omsPaymentInfo
     * @return
     */
    @Override
    public List<OmsPaymentInfo> findList(OmsPaymentInfo omsPaymentInfo){
        //构建查询条件
        Example example = createExample(omsPaymentInfo);
        //根据构建的条件查询数据
        return omsPaymentInfoMapper.selectByExample(example);
    }


    /**
     * OmsPaymentInfo构建查询对象
     * @param omsPaymentInfo
     * @return
     */
    public Example createExample(OmsPaymentInfo omsPaymentInfo){
        Example example=new Example(OmsPaymentInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if(omsPaymentInfo!=null){
            // id
            if(!StringUtils.isEmpty(omsPaymentInfo.getId())){
                    criteria.andEqualTo("id",omsPaymentInfo.getId());
            }
            // 订单号（对外业务号）
            if(!StringUtils.isEmpty(omsPaymentInfo.getOrderSn())){
                    criteria.andEqualTo("orderSn",omsPaymentInfo.getOrderSn());
            }
            // 订单id
            if(!StringUtils.isEmpty(omsPaymentInfo.getOrderId())){
                    criteria.andEqualTo("orderId",omsPaymentInfo.getOrderId());
            }
            // 支付宝交易流水号
            if(!StringUtils.isEmpty(omsPaymentInfo.getAlipayTradeNo())){
                    criteria.andEqualTo("alipayTradeNo",omsPaymentInfo.getAlipayTradeNo());
            }
            // 支付总金额
            if(!StringUtils.isEmpty(omsPaymentInfo.getTotalAmount())){
                    criteria.andEqualTo("totalAmount",omsPaymentInfo.getTotalAmount());
            }
            // 交易内容
            if(!StringUtils.isEmpty(omsPaymentInfo.getSubject())){
                    criteria.andEqualTo("subject",omsPaymentInfo.getSubject());
            }
            // 支付状态
            if(!StringUtils.isEmpty(omsPaymentInfo.getPaymentStatus())){
                    criteria.andEqualTo("paymentStatus",omsPaymentInfo.getPaymentStatus());
            }
            // 创建时间
            if(!StringUtils.isEmpty(omsPaymentInfo.getCreateTime())){
                    criteria.andEqualTo("createTime",omsPaymentInfo.getCreateTime());
            }
            // 确认时间
            if(!StringUtils.isEmpty(omsPaymentInfo.getConfirmTime())){
                    criteria.andEqualTo("confirmTime",omsPaymentInfo.getConfirmTime());
            }
            // 回调内容
            if(!StringUtils.isEmpty(omsPaymentInfo.getCallbackContent())){
                    criteria.andEqualTo("callbackContent",omsPaymentInfo.getCallbackContent());
            }
            // 回调时间
            if(!StringUtils.isEmpty(omsPaymentInfo.getCallbackTime())){
                    criteria.andEqualTo("callbackTime",omsPaymentInfo.getCallbackTime());
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
        omsPaymentInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改OmsPaymentInfo
     * @param omsPaymentInfo
     */
    @Override
    public void update(OmsPaymentInfo omsPaymentInfo){
        omsPaymentInfoMapper.updateByPrimaryKey(omsPaymentInfo);
    }

    /**
     * 增加OmsPaymentInfo
     * @param omsPaymentInfo
     */
    @Override
    public void add(OmsPaymentInfo omsPaymentInfo){
        omsPaymentInfoMapper.insert(omsPaymentInfo);
    }

    /**
     * 根据ID查询OmsPaymentInfo
     * @param id
     * @return
     */
    @Override
    public OmsPaymentInfo findById(Long id){
        return  omsPaymentInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询OmsPaymentInfo全部数据
     * @return
     */
    @Override
    public List<OmsPaymentInfo> findAll() {
        return omsPaymentInfoMapper.selectAll();
    }
}
