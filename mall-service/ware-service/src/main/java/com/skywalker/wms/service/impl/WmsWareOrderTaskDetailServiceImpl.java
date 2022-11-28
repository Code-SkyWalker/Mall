package com.skywalker.wms.service.impl;
import com.skywalker.wms.dao.WmsWareOrderTaskDetailMapper;
import com.skywalker.wms.pojo.WmsWareOrderTaskDetail;
import com.skywalker.wms.service.WmsWareOrderTaskDetailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname WmsWareOrderTaskDetailServiceImpl
 * @Description TODO
 */
@Service
public class WmsWareOrderTaskDetailServiceImpl implements WmsWareOrderTaskDetailService {

    @Autowired
    private WmsWareOrderTaskDetailMapper wmsWareOrderTaskDetailMapper;


    /**
     * WmsWareOrderTaskDetail条件+分页查询
     * @param wmsWareOrderTaskDetail 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<WmsWareOrderTaskDetail> findPage(WmsWareOrderTaskDetail wmsWareOrderTaskDetail, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(wmsWareOrderTaskDetail);
        //执行搜索
        return new PageInfo<WmsWareOrderTaskDetail>(wmsWareOrderTaskDetailMapper.selectByExample(example));
    }

    /**
     * WmsWareOrderTaskDetail分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<WmsWareOrderTaskDetail> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<WmsWareOrderTaskDetail>(wmsWareOrderTaskDetailMapper.selectAll());
    }

    /**
     * WmsWareOrderTaskDetail条件查询
     * @param wmsWareOrderTaskDetail
     * @return
     */
    @Override
    public List<WmsWareOrderTaskDetail> findList(WmsWareOrderTaskDetail wmsWareOrderTaskDetail){
        //构建查询条件
        Example example = createExample(wmsWareOrderTaskDetail);
        //根据构建的条件查询数据
        return wmsWareOrderTaskDetailMapper.selectByExample(example);
    }


    /**
     * WmsWareOrderTaskDetail构建查询对象
     * @param wmsWareOrderTaskDetail
     * @return
     */
    public Example createExample(WmsWareOrderTaskDetail wmsWareOrderTaskDetail){
        Example example=new Example(WmsWareOrderTaskDetail.class);
        Example.Criteria criteria = example.createCriteria();
        if(wmsWareOrderTaskDetail!=null){
            // id
            if(!StringUtils.isEmpty(wmsWareOrderTaskDetail.getId())){
                    criteria.andEqualTo("id",wmsWareOrderTaskDetail.getId());
            }
            // sku_id
            if(!StringUtils.isEmpty(wmsWareOrderTaskDetail.getSkuId())){
                    criteria.andEqualTo("skuId",wmsWareOrderTaskDetail.getSkuId());
            }
            // sku_name
            if(!StringUtils.isEmpty(wmsWareOrderTaskDetail.getSkuName())){
                    criteria.andEqualTo("skuName",wmsWareOrderTaskDetail.getSkuName());
            }
            // 购买个数
            if(!StringUtils.isEmpty(wmsWareOrderTaskDetail.getSkuNum())){
                    criteria.andEqualTo("skuNum",wmsWareOrderTaskDetail.getSkuNum());
            }
            // 工作单id
            if(!StringUtils.isEmpty(wmsWareOrderTaskDetail.getTaskId())){
                    criteria.andEqualTo("taskId",wmsWareOrderTaskDetail.getTaskId());
            }
            // 仓库id
            if(!StringUtils.isEmpty(wmsWareOrderTaskDetail.getWareId())){
                    criteria.andEqualTo("wareId",wmsWareOrderTaskDetail.getWareId());
            }
            // 1-已锁定  2-已解锁  3-扣减
            if(!StringUtils.isEmpty(wmsWareOrderTaskDetail.getLockStatus())){
                    criteria.andEqualTo("lockStatus",wmsWareOrderTaskDetail.getLockStatus());
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
        wmsWareOrderTaskDetailMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改WmsWareOrderTaskDetail
     * @param wmsWareOrderTaskDetail
     */
    @Override
    public void update(WmsWareOrderTaskDetail wmsWareOrderTaskDetail){
        wmsWareOrderTaskDetailMapper.updateByPrimaryKey(wmsWareOrderTaskDetail);
    }

    /**
     * 增加WmsWareOrderTaskDetail
     * @param wmsWareOrderTaskDetail
     */
    @Override
    public void add(WmsWareOrderTaskDetail wmsWareOrderTaskDetail){
        wmsWareOrderTaskDetailMapper.insert(wmsWareOrderTaskDetail);
    }

    /**
     * 根据ID查询WmsWareOrderTaskDetail
     * @param id
     * @return
     */
    @Override
    public WmsWareOrderTaskDetail findById(Long id){
        return  wmsWareOrderTaskDetailMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询WmsWareOrderTaskDetail全部数据
     * @return
     */
    @Override
    public List<WmsWareOrderTaskDetail> findAll() {
        return wmsWareOrderTaskDetailMapper.selectAll();
    }
}
