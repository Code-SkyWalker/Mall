package com.skywalker.oms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.skywalker.oms.dao.OmsRefundInfoMapper;
import com.skywalker.oms.pojo.OmsRefundInfo;
import com.skywalker.oms.service.OmsRefundInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname OmsRefundInfoServiceImpl
 * @Description TODO
 */
@Service
public class OmsRefundInfoServiceImpl implements OmsRefundInfoService {

    @Autowired
    private OmsRefundInfoMapper omsRefundInfoMapper;


    /**
     * OmsRefundInfo条件+分页查询
     * @param omsRefundInfo 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<OmsRefundInfo> findPage(OmsRefundInfo omsRefundInfo, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(omsRefundInfo);
        //执行搜索
        return new PageInfo<OmsRefundInfo>(omsRefundInfoMapper.selectByExample(example));
    }

    /**
     * OmsRefundInfo分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<OmsRefundInfo> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<OmsRefundInfo>(omsRefundInfoMapper.selectAll());
    }

    /**
     * OmsRefundInfo条件查询
     * @param omsRefundInfo
     * @return
     */
    @Override
    public List<OmsRefundInfo> findList(OmsRefundInfo omsRefundInfo){
        //构建查询条件
        Example example = createExample(omsRefundInfo);
        //根据构建的条件查询数据
        return omsRefundInfoMapper.selectByExample(example);
    }


    /**
     * OmsRefundInfo构建查询对象
     * @param omsRefundInfo
     * @return
     */
    public Example createExample(OmsRefundInfo omsRefundInfo){
        Example example=new Example(OmsRefundInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if(omsRefundInfo!=null){
            // id
            if(!StringUtils.isEmpty(omsRefundInfo.getId())){
                    criteria.andEqualTo("id",omsRefundInfo.getId());
            }
            // 退款的订单
            if(!StringUtils.isEmpty(omsRefundInfo.getOrderReturnId())){
                    criteria.andEqualTo("orderReturnId",omsRefundInfo.getOrderReturnId());
            }
            // 退款金额
            if(!StringUtils.isEmpty(omsRefundInfo.getRefund())){
                    criteria.andEqualTo("refund",omsRefundInfo.getRefund());
            }
            // 退款交易流水号
            if(!StringUtils.isEmpty(omsRefundInfo.getRefundSn())){
                    criteria.andEqualTo("refundSn",omsRefundInfo.getRefundSn());
            }
            // 退款状态
            if(!StringUtils.isEmpty(omsRefundInfo.getRefundStatus())){
                    criteria.andEqualTo("refundStatus",omsRefundInfo.getRefundStatus());
            }
            // 退款渠道[1-支付宝，2-微信，3-银联，4-汇款]
            if(!StringUtils.isEmpty(omsRefundInfo.getRefundChannel())){
                    criteria.andEqualTo("refundChannel",omsRefundInfo.getRefundChannel());
            }
            // 
            if(!StringUtils.isEmpty(omsRefundInfo.getRefundContent())){
                    criteria.andEqualTo("refundContent",omsRefundInfo.getRefundContent());
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
        omsRefundInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改OmsRefundInfo
     * @param omsRefundInfo
     */
    @Override
    public void update(OmsRefundInfo omsRefundInfo){
        omsRefundInfoMapper.updateByPrimaryKey(omsRefundInfo);
    }

    /**
     * 增加OmsRefundInfo
     * @param omsRefundInfo
     */
    @Override
    public void add(OmsRefundInfo omsRefundInfo){
        omsRefundInfoMapper.insert(omsRefundInfo);
    }

    /**
     * 根据ID查询OmsRefundInfo
     * @param id
     * @return
     */
    @Override
    public OmsRefundInfo findById(Long id){
        return  omsRefundInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询OmsRefundInfo全部数据
     * @return
     */
    @Override
    public List<OmsRefundInfo> findAll() {
        return omsRefundInfoMapper.selectAll();
    }
}
