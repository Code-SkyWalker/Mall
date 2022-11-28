package com.skywalker.wms.service.impl;
import com.skywalker.wms.dao.WmsWareOrderTaskMapper;
import com.skywalker.wms.pojo.WmsWareOrderTask;
import com.skywalker.wms.service.WmsWareOrderTaskService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname WmsWareOrderTaskServiceImpl
 * @Description TODO
 */
@Service
public class WmsWareOrderTaskServiceImpl implements WmsWareOrderTaskService {

    @Autowired
    private WmsWareOrderTaskMapper wmsWareOrderTaskMapper;


    /**
     * WmsWareOrderTask条件+分页查询
     * @param wmsWareOrderTask 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<WmsWareOrderTask> findPage(WmsWareOrderTask wmsWareOrderTask, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(wmsWareOrderTask);
        //执行搜索
        return new PageInfo<WmsWareOrderTask>(wmsWareOrderTaskMapper.selectByExample(example));
    }

    /**
     * WmsWareOrderTask分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<WmsWareOrderTask> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<WmsWareOrderTask>(wmsWareOrderTaskMapper.selectAll());
    }

    /**
     * WmsWareOrderTask条件查询
     * @param wmsWareOrderTask
     * @return
     */
    @Override
    public List<WmsWareOrderTask> findList(WmsWareOrderTask wmsWareOrderTask){
        //构建查询条件
        Example example = createExample(wmsWareOrderTask);
        //根据构建的条件查询数据
        return wmsWareOrderTaskMapper.selectByExample(example);
    }


    /**
     * WmsWareOrderTask构建查询对象
     * @param wmsWareOrderTask
     * @return
     */
    public Example createExample(WmsWareOrderTask wmsWareOrderTask){
        Example example=new Example(WmsWareOrderTask.class);
        Example.Criteria criteria = example.createCriteria();
        if(wmsWareOrderTask!=null){
            // id
            if(!StringUtils.isEmpty(wmsWareOrderTask.getId())){
                    criteria.andEqualTo("id",wmsWareOrderTask.getId());
            }
            // order_id
            if(!StringUtils.isEmpty(wmsWareOrderTask.getOrderId())){
                    criteria.andEqualTo("orderId",wmsWareOrderTask.getOrderId());
            }
            // order_sn
            if(!StringUtils.isEmpty(wmsWareOrderTask.getOrderSn())){
                    criteria.andEqualTo("orderSn",wmsWareOrderTask.getOrderSn());
            }
            // 收货人
            if(!StringUtils.isEmpty(wmsWareOrderTask.getConsignee())){
                    criteria.andEqualTo("consignee",wmsWareOrderTask.getConsignee());
            }
            // 收货人电话
            if(!StringUtils.isEmpty(wmsWareOrderTask.getConsigneeTel())){
                    criteria.andEqualTo("consigneeTel",wmsWareOrderTask.getConsigneeTel());
            }
            // 配送地址
            if(!StringUtils.isEmpty(wmsWareOrderTask.getDeliveryAddress())){
                    criteria.andEqualTo("deliveryAddress",wmsWareOrderTask.getDeliveryAddress());
            }
            // 订单备注
            if(!StringUtils.isEmpty(wmsWareOrderTask.getOrderComment())){
                    criteria.andEqualTo("orderComment",wmsWareOrderTask.getOrderComment());
            }
            // 付款方式【 1:在线付款 2:货到付款】
            if(!StringUtils.isEmpty(wmsWareOrderTask.getPaymentWay())){
                    criteria.andEqualTo("paymentWay",wmsWareOrderTask.getPaymentWay());
            }
            // 任务状态
            if(!StringUtils.isEmpty(wmsWareOrderTask.getTaskStatus())){
                    criteria.andEqualTo("taskStatus",wmsWareOrderTask.getTaskStatus());
            }
            // 订单描述
            if(!StringUtils.isEmpty(wmsWareOrderTask.getOrderBody())){
                    criteria.andEqualTo("orderBody",wmsWareOrderTask.getOrderBody());
            }
            // 物流单号
            if(!StringUtils.isEmpty(wmsWareOrderTask.getTrackingNo())){
                    criteria.andEqualTo("trackingNo",wmsWareOrderTask.getTrackingNo());
            }
            // create_time
            if(!StringUtils.isEmpty(wmsWareOrderTask.getCreateTime())){
                    criteria.andEqualTo("createTime",wmsWareOrderTask.getCreateTime());
            }
            // 仓库id
            if(!StringUtils.isEmpty(wmsWareOrderTask.getWareId())){
                    criteria.andEqualTo("wareId",wmsWareOrderTask.getWareId());
            }
            // 工作单备注
            if(!StringUtils.isEmpty(wmsWareOrderTask.getTaskComment())){
                    criteria.andEqualTo("taskComment",wmsWareOrderTask.getTaskComment());
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
        wmsWareOrderTaskMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改WmsWareOrderTask
     * @param wmsWareOrderTask
     */
    @Override
    public void update(WmsWareOrderTask wmsWareOrderTask){
        wmsWareOrderTaskMapper.updateByPrimaryKey(wmsWareOrderTask);
    }

    /**
     * 增加WmsWareOrderTask
     * @param wmsWareOrderTask
     */
    @Override
    public void add(WmsWareOrderTask wmsWareOrderTask){
        wmsWareOrderTaskMapper.insert(wmsWareOrderTask);
    }

    /**
     * 根据ID查询WmsWareOrderTask
     * @param id
     * @return
     */
    @Override
    public WmsWareOrderTask findById(Long id){
        return  wmsWareOrderTaskMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询WmsWareOrderTask全部数据
     * @return
     */
    @Override
    public List<WmsWareOrderTask> findAll() {
        return wmsWareOrderTaskMapper.selectAll();
    }
}
