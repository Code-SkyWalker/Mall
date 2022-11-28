package com.skywalker.wms.service.impl;
import com.skywalker.wms.dao.WmsWareSkuMapper;
import com.skywalker.wms.pojo.WmsWareSku;
import com.skywalker.wms.service.WmsWareSkuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname WmsWareSkuServiceImpl
 * @Description TODO
 */
@Service
public class WmsWareSkuServiceImpl implements WmsWareSkuService {

    @Autowired
    private WmsWareSkuMapper wmsWareSkuMapper;


    /**
     * WmsWareSku条件+分页查询
     * @param wmsWareSku 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<WmsWareSku> findPage(WmsWareSku wmsWareSku, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(wmsWareSku);
        //执行搜索
        return new PageInfo<WmsWareSku>(wmsWareSkuMapper.selectByExample(example));
    }

    /**
     * WmsWareSku分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<WmsWareSku> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<WmsWareSku>(wmsWareSkuMapper.selectAll());
    }

    /**
     * WmsWareSku条件查询
     * @param wmsWareSku
     * @return
     */
    @Override
    public List<WmsWareSku> findList(WmsWareSku wmsWareSku){
        //构建查询条件
        Example example = createExample(wmsWareSku);
        //根据构建的条件查询数据
        return wmsWareSkuMapper.selectByExample(example);
    }


    /**
     * WmsWareSku构建查询对象
     * @param wmsWareSku
     * @return
     */
    public Example createExample(WmsWareSku wmsWareSku){
        Example example=new Example(WmsWareSku.class);
        Example.Criteria criteria = example.createCriteria();
        if(wmsWareSku!=null){
            // id
            if(!StringUtils.isEmpty(wmsWareSku.getId())){
                    criteria.andEqualTo("id",wmsWareSku.getId());
            }
            // sku_id
            if(!StringUtils.isEmpty(wmsWareSku.getSkuId())){
                    criteria.andEqualTo("skuId",wmsWareSku.getSkuId());
            }
            // 仓库id
            if(!StringUtils.isEmpty(wmsWareSku.getWareId())){
                    criteria.andEqualTo("wareId",wmsWareSku.getWareId());
            }
            // 库存数
            if(!StringUtils.isEmpty(wmsWareSku.getStock())){
                    criteria.andEqualTo("stock",wmsWareSku.getStock());
            }
            // sku_name
            if(!StringUtils.isEmpty(wmsWareSku.getSkuName())){
                    criteria.andEqualTo("skuName",wmsWareSku.getSkuName());
            }
            // 锁定库存
            if(!StringUtils.isEmpty(wmsWareSku.getStockLocked())){
                    criteria.andEqualTo("stockLocked",wmsWareSku.getStockLocked());
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
        wmsWareSkuMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改WmsWareSku
     * @param wmsWareSku
     */
    @Override
    public void update(WmsWareSku wmsWareSku){
        wmsWareSkuMapper.updateByPrimaryKey(wmsWareSku);
    }

    /**
     * 增加WmsWareSku
     * @param wmsWareSku
     */
    @Override
    public void add(WmsWareSku wmsWareSku){
        wmsWareSkuMapper.insert(wmsWareSku);
    }

    /**
     * 根据ID查询WmsWareSku
     * @param id
     * @return
     */
    @Override
    public WmsWareSku findById(Long id){
        return  wmsWareSkuMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询WmsWareSku全部数据
     * @return
     */
    @Override
    public List<WmsWareSku> findAll() {
        return wmsWareSkuMapper.selectAll();
    }
}
