package com.skywalker.oms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.skywalker.oms.dao.OmsOrderOperateHistoryMapper;
import com.skywalker.oms.pojo.OmsOrderOperateHistory;
import com.skywalker.oms.service.OmsOrderOperateHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname OmsOrderOperateHistoryServiceImpl
 * @Description TODO
 */
@Service
public class OmsOrderOperateHistoryServiceImpl implements OmsOrderOperateHistoryService {

    @Autowired
    private OmsOrderOperateHistoryMapper omsOrderOperateHistoryMapper;


    /**
     * OmsOrderOperateHistory条件+分页查询
     * @param omsOrderOperateHistory 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<OmsOrderOperateHistory> findPage(OmsOrderOperateHistory omsOrderOperateHistory, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(omsOrderOperateHistory);
        //执行搜索
        return new PageInfo<OmsOrderOperateHistory>(omsOrderOperateHistoryMapper.selectByExample(example));
    }

    /**
     * OmsOrderOperateHistory分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<OmsOrderOperateHistory> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<OmsOrderOperateHistory>(omsOrderOperateHistoryMapper.selectAll());
    }

    /**
     * OmsOrderOperateHistory条件查询
     * @param omsOrderOperateHistory
     * @return
     */
    @Override
    public List<OmsOrderOperateHistory> findList(OmsOrderOperateHistory omsOrderOperateHistory){
        //构建查询条件
        Example example = createExample(omsOrderOperateHistory);
        //根据构建的条件查询数据
        return omsOrderOperateHistoryMapper.selectByExample(example);
    }


    /**
     * OmsOrderOperateHistory构建查询对象
     * @param omsOrderOperateHistory
     * @return
     */
    public Example createExample(OmsOrderOperateHistory omsOrderOperateHistory){
        Example example=new Example(OmsOrderOperateHistory.class);
        Example.Criteria criteria = example.createCriteria();
        if(omsOrderOperateHistory!=null){
            // id
            if(!StringUtils.isEmpty(omsOrderOperateHistory.getId())){
                    criteria.andEqualTo("id",omsOrderOperateHistory.getId());
            }
            // 订单id
            if(!StringUtils.isEmpty(omsOrderOperateHistory.getOrderId())){
                    criteria.andEqualTo("orderId",omsOrderOperateHistory.getOrderId());
            }
            // 操作人[用户；系统；后台管理员]
            if(!StringUtils.isEmpty(omsOrderOperateHistory.getOperateMan())){
                    criteria.andEqualTo("operateMan",omsOrderOperateHistory.getOperateMan());
            }
            // 操作时间
            if(!StringUtils.isEmpty(omsOrderOperateHistory.getCreateTime())){
                    criteria.andEqualTo("createTime",omsOrderOperateHistory.getCreateTime());
            }
            // 订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】
            if(!StringUtils.isEmpty(omsOrderOperateHistory.getOrderStatus())){
                    criteria.andEqualTo("orderStatus",omsOrderOperateHistory.getOrderStatus());
            }
            // 备注
            if(!StringUtils.isEmpty(omsOrderOperateHistory.getNote())){
                    criteria.andEqualTo("note",omsOrderOperateHistory.getNote());
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
        omsOrderOperateHistoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改OmsOrderOperateHistory
     * @param omsOrderOperateHistory
     */
    @Override
    public void update(OmsOrderOperateHistory omsOrderOperateHistory){
        omsOrderOperateHistoryMapper.updateByPrimaryKey(omsOrderOperateHistory);
    }

    /**
     * 增加OmsOrderOperateHistory
     * @param omsOrderOperateHistory
     */
    @Override
    public void add(OmsOrderOperateHistory omsOrderOperateHistory){
        omsOrderOperateHistoryMapper.insert(omsOrderOperateHistory);
    }

    /**
     * 根据ID查询OmsOrderOperateHistory
     * @param id
     * @return
     */
    @Override
    public OmsOrderOperateHistory findById(Long id){
        return  omsOrderOperateHistoryMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询OmsOrderOperateHistory全部数据
     * @return
     */
    @Override
    public List<OmsOrderOperateHistory> findAll() {
        return omsOrderOperateHistoryMapper.selectAll();
    }
}
