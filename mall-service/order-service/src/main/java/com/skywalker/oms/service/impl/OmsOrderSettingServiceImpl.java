package com.skywalker.oms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.skywalker.oms.dao.OmsOrderSettingMapper;
import com.skywalker.oms.pojo.OmsOrderSetting;
import com.skywalker.oms.service.OmsOrderSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname OmsOrderSettingServiceImpl
 * @Description TODO
 */
@Service
public class OmsOrderSettingServiceImpl implements OmsOrderSettingService {

    @Autowired
    private OmsOrderSettingMapper omsOrderSettingMapper;


    /**
     * OmsOrderSetting条件+分页查询
     * @param omsOrderSetting 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<OmsOrderSetting> findPage(OmsOrderSetting omsOrderSetting, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(omsOrderSetting);
        //执行搜索
        return new PageInfo<OmsOrderSetting>(omsOrderSettingMapper.selectByExample(example));
    }

    /**
     * OmsOrderSetting分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<OmsOrderSetting> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<OmsOrderSetting>(omsOrderSettingMapper.selectAll());
    }

    /**
     * OmsOrderSetting条件查询
     * @param omsOrderSetting
     * @return
     */
    @Override
    public List<OmsOrderSetting> findList(OmsOrderSetting omsOrderSetting){
        //构建查询条件
        Example example = createExample(omsOrderSetting);
        //根据构建的条件查询数据
        return omsOrderSettingMapper.selectByExample(example);
    }


    /**
     * OmsOrderSetting构建查询对象
     * @param omsOrderSetting
     * @return
     */
    public Example createExample(OmsOrderSetting omsOrderSetting){
        Example example=new Example(OmsOrderSetting.class);
        Example.Criteria criteria = example.createCriteria();
        if(omsOrderSetting!=null){
            // id
            if(!StringUtils.isEmpty(omsOrderSetting.getId())){
                    criteria.andEqualTo("id",omsOrderSetting.getId());
            }
            // 秒杀订单超时关闭时间(分)
            if(!StringUtils.isEmpty(omsOrderSetting.getFlashOrderOvertime())){
                    criteria.andEqualTo("flashOrderOvertime",omsOrderSetting.getFlashOrderOvertime());
            }
            // 正常订单超时时间(分)
            if(!StringUtils.isEmpty(omsOrderSetting.getNormalOrderOvertime())){
                    criteria.andEqualTo("normalOrderOvertime",omsOrderSetting.getNormalOrderOvertime());
            }
            // 发货后自动确认收货时间（天）
            if(!StringUtils.isEmpty(omsOrderSetting.getConfirmOvertime())){
                    criteria.andEqualTo("confirmOvertime",omsOrderSetting.getConfirmOvertime());
            }
            // 自动完成交易时间，不能申请退货（天）
            if(!StringUtils.isEmpty(omsOrderSetting.getFinishOvertime())){
                    criteria.andEqualTo("finishOvertime",omsOrderSetting.getFinishOvertime());
            }
            // 订单完成后自动好评时间（天）
            if(!StringUtils.isEmpty(omsOrderSetting.getCommentOvertime())){
                    criteria.andEqualTo("commentOvertime",omsOrderSetting.getCommentOvertime());
            }
            // 会员等级【0-不限会员等级，全部通用；其他-对应的其他会员等级】
            if(!StringUtils.isEmpty(omsOrderSetting.getMemberLevel())){
                    criteria.andEqualTo("memberLevel",omsOrderSetting.getMemberLevel());
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
        omsOrderSettingMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改OmsOrderSetting
     * @param omsOrderSetting
     */
    @Override
    public void update(OmsOrderSetting omsOrderSetting){
        omsOrderSettingMapper.updateByPrimaryKey(omsOrderSetting);
    }

    /**
     * 增加OmsOrderSetting
     * @param omsOrderSetting
     */
    @Override
    public void add(OmsOrderSetting omsOrderSetting){
        omsOrderSettingMapper.insert(omsOrderSetting);
    }

    /**
     * 根据ID查询OmsOrderSetting
     * @param id
     * @return
     */
    @Override
    public OmsOrderSetting findById(Long id){
        return  omsOrderSettingMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询OmsOrderSetting全部数据
     * @return
     */
    @Override
    public List<OmsOrderSetting> findAll() {
        return omsOrderSettingMapper.selectAll();
    }
}
