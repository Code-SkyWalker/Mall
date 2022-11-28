package com.skywalker.pms.service.impl;
import com.skywalker.pms.dao.PmsSkuInfoMapper;
import com.skywalker.pms.pojo.PmsSkuInfo;
import com.skywalker.pms.service.PmsSkuInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname PmsSkuInfoServiceImpl
 * @Description TODO
 */
@Service
public class PmsSkuInfoServiceImpl implements PmsSkuInfoService {

    @Autowired
    private PmsSkuInfoMapper pmsSkuInfoMapper;


    /**
     * PmsSkuInfo条件+分页查询
     * @param pmsSkuInfo 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<PmsSkuInfo> findPage(PmsSkuInfo pmsSkuInfo, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(pmsSkuInfo);
        //执行搜索
        return new PageInfo<PmsSkuInfo>(pmsSkuInfoMapper.selectByExample(example));
    }

    /**
     * PmsSkuInfo分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<PmsSkuInfo> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<PmsSkuInfo>(pmsSkuInfoMapper.selectAll());
    }

    /**
     * PmsSkuInfo条件查询
     * @param pmsSkuInfo
     * @return
     */
    @Override
    public List<PmsSkuInfo> findList(PmsSkuInfo pmsSkuInfo){
        //构建查询条件
        Example example = createExample(pmsSkuInfo);
        //根据构建的条件查询数据
        return pmsSkuInfoMapper.selectByExample(example);
    }


    /**
     * PmsSkuInfo构建查询对象
     * @param pmsSkuInfo
     * @return
     */
    public Example createExample(PmsSkuInfo pmsSkuInfo){
        Example example=new Example(PmsSkuInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if(pmsSkuInfo!=null){
            // skuId
            if(!StringUtils.isEmpty(pmsSkuInfo.getSkuId())){
                    criteria.andEqualTo("skuId",pmsSkuInfo.getSkuId());
            }
            // spuId
            if(!StringUtils.isEmpty(pmsSkuInfo.getSpuId())){
                    criteria.andEqualTo("spuId",pmsSkuInfo.getSpuId());
            }
            // sku名称
            if(!StringUtils.isEmpty(pmsSkuInfo.getSkuName())){
                    criteria.andEqualTo("skuName",pmsSkuInfo.getSkuName());
            }
            // sku介绍描述
            if(!StringUtils.isEmpty(pmsSkuInfo.getSkuDesc())){
                    criteria.andEqualTo("skuDesc",pmsSkuInfo.getSkuDesc());
            }
            // 所属分类id
            if(!StringUtils.isEmpty(pmsSkuInfo.getCatalogId())){
                    criteria.andEqualTo("catalogId",pmsSkuInfo.getCatalogId());
            }
            // 品牌id
            if(!StringUtils.isEmpty(pmsSkuInfo.getBrandId())){
                    criteria.andEqualTo("brandId",pmsSkuInfo.getBrandId());
            }
            // 默认图片
            if(!StringUtils.isEmpty(pmsSkuInfo.getSkuDefaultImg())){
                    criteria.andEqualTo("skuDefaultImg",pmsSkuInfo.getSkuDefaultImg());
            }
            // 标题
            if(!StringUtils.isEmpty(pmsSkuInfo.getSkuTitle())){
                    criteria.andEqualTo("skuTitle",pmsSkuInfo.getSkuTitle());
            }
            // 副标题
            if(!StringUtils.isEmpty(pmsSkuInfo.getSkuSubtitle())){
                    criteria.andLike("skuSubtitle","%"+pmsSkuInfo.getSkuSubtitle()+"%");
            }
            // 价格
            if(!StringUtils.isEmpty(pmsSkuInfo.getPrice())){
                    criteria.andEqualTo("price",pmsSkuInfo.getPrice());
            }
            // 销量
            if(!StringUtils.isEmpty(pmsSkuInfo.getSaleCount())){
                    criteria.andEqualTo("saleCount",pmsSkuInfo.getSaleCount());
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
        pmsSkuInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改PmsSkuInfo
     * @param pmsSkuInfo
     */
    @Override
    public void update(PmsSkuInfo pmsSkuInfo){
        pmsSkuInfoMapper.updateByPrimaryKey(pmsSkuInfo);
    }

    /**
     * 增加PmsSkuInfo
     * @param pmsSkuInfo
     */
    @Override
    public void add(PmsSkuInfo pmsSkuInfo){
        pmsSkuInfoMapper.insert(pmsSkuInfo);
    }

    /**
     * 根据ID查询PmsSkuInfo
     * @param id
     * @return
     */
    @Override
    public PmsSkuInfo findById(Long id){
        return  pmsSkuInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询PmsSkuInfo全部数据
     * @return
     */
    @Override
    public List<PmsSkuInfo> findAll() {
        return pmsSkuInfoMapper.selectAll();
    }
}
