package com.skywalker.wms.service.impl;
import com.skywalker.wms.dao.WmsPurchaseDetailMapper;
import com.skywalker.wms.pojo.WmsPurchaseDetail;
import com.skywalker.wms.service.WmsPurchaseDetailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname WmsPurchaseDetailServiceImpl
 * @Description TODO
 */
@Service
public class WmsPurchaseDetailServiceImpl implements WmsPurchaseDetailService {

    @Autowired
    private WmsPurchaseDetailMapper wmsPurchaseDetailMapper;


    /**
     * WmsPurchaseDetail条件+分页查询
     * @param wmsPurchaseDetail 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<WmsPurchaseDetail> findPage(WmsPurchaseDetail wmsPurchaseDetail, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(wmsPurchaseDetail);
        //执行搜索
        return new PageInfo<WmsPurchaseDetail>(wmsPurchaseDetailMapper.selectByExample(example));
    }

    /**
     * WmsPurchaseDetail分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<WmsPurchaseDetail> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<WmsPurchaseDetail>(wmsPurchaseDetailMapper.selectAll());
    }

    /**
     * WmsPurchaseDetail条件查询
     * @param wmsPurchaseDetail
     * @return
     */
    @Override
    public List<WmsPurchaseDetail> findList(WmsPurchaseDetail wmsPurchaseDetail){
        //构建查询条件
        Example example = createExample(wmsPurchaseDetail);
        //根据构建的条件查询数据
        return wmsPurchaseDetailMapper.selectByExample(example);
    }


    /**
     * WmsPurchaseDetail构建查询对象
     * @param wmsPurchaseDetail
     * @return
     */
    public Example createExample(WmsPurchaseDetail wmsPurchaseDetail){
        Example example=new Example(WmsPurchaseDetail.class);
        Example.Criteria criteria = example.createCriteria();
        if(wmsPurchaseDetail!=null){
            // 
            if(!StringUtils.isEmpty(wmsPurchaseDetail.getId())){
                    criteria.andEqualTo("id",wmsPurchaseDetail.getId());
            }
            // 采购单id
            if(!StringUtils.isEmpty(wmsPurchaseDetail.getPurchaseId())){
                    criteria.andEqualTo("purchaseId",wmsPurchaseDetail.getPurchaseId());
            }
            // 采购商品id
            if(!StringUtils.isEmpty(wmsPurchaseDetail.getSkuId())){
                    criteria.andEqualTo("skuId",wmsPurchaseDetail.getSkuId());
            }
            // 采购数量
            if(!StringUtils.isEmpty(wmsPurchaseDetail.getSkuNum())){
                    criteria.andEqualTo("skuNum",wmsPurchaseDetail.getSkuNum());
            }
            // 采购金额
            if(!StringUtils.isEmpty(wmsPurchaseDetail.getSkuPrice())){
                    criteria.andEqualTo("skuPrice",wmsPurchaseDetail.getSkuPrice());
            }
            // 仓库id
            if(!StringUtils.isEmpty(wmsPurchaseDetail.getWareId())){
                    criteria.andEqualTo("wareId",wmsPurchaseDetail.getWareId());
            }
            // 状态[0新建，1已分配，2正在采购，3已完成，4采购失败]
            if(!StringUtils.isEmpty(wmsPurchaseDetail.getStatus())){
                    criteria.andEqualTo("status",wmsPurchaseDetail.getStatus());
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
        wmsPurchaseDetailMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改WmsPurchaseDetail
     * @param wmsPurchaseDetail
     */
    @Override
    public void update(WmsPurchaseDetail wmsPurchaseDetail){
        wmsPurchaseDetailMapper.updateByPrimaryKey(wmsPurchaseDetail);
    }

    /**
     * 增加WmsPurchaseDetail
     * @param wmsPurchaseDetail
     */
    @Override
    public void add(WmsPurchaseDetail wmsPurchaseDetail){
        wmsPurchaseDetailMapper.insert(wmsPurchaseDetail);
    }

    /**
     * 根据ID查询WmsPurchaseDetail
     * @param id
     * @return
     */
    @Override
    public WmsPurchaseDetail findById(Long id){
        return  wmsPurchaseDetailMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询WmsPurchaseDetail全部数据
     * @return
     */
    @Override
    public List<WmsPurchaseDetail> findAll() {
        return wmsPurchaseDetailMapper.selectAll();
    }
}
