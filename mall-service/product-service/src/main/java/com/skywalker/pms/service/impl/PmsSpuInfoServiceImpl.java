package com.skywalker.pms.service.impl;
import com.skywalker.pms.dao.PmsSpuInfoMapper;
import com.skywalker.pms.pojo.PmsSpuInfo;
import com.skywalker.pms.service.PmsSpuInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname PmsSpuInfoServiceImpl
 * @Description TODO
 */
@Service
public class PmsSpuInfoServiceImpl implements PmsSpuInfoService {

    @Autowired
    private PmsSpuInfoMapper pmsSpuInfoMapper;


    /**
     * PmsSpuInfo条件+分页查询
     * @param pmsSpuInfo 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<PmsSpuInfo> findPage(PmsSpuInfo pmsSpuInfo, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(pmsSpuInfo);
        //执行搜索
        return new PageInfo<PmsSpuInfo>(pmsSpuInfoMapper.selectByExample(example));
    }

    /**
     * PmsSpuInfo分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<PmsSpuInfo> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<PmsSpuInfo>(pmsSpuInfoMapper.selectAll());
    }

    /**
     * PmsSpuInfo条件查询
     * @param pmsSpuInfo
     * @return
     */
    @Override
    public List<PmsSpuInfo> findList(PmsSpuInfo pmsSpuInfo){
        //构建查询条件
        Example example = createExample(pmsSpuInfo);
        //根据构建的条件查询数据
        return pmsSpuInfoMapper.selectByExample(example);
    }


    /**
     * PmsSpuInfo构建查询对象
     * @param pmsSpuInfo
     * @return
     */
    public Example createExample(PmsSpuInfo pmsSpuInfo){
        Example example=new Example(PmsSpuInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if(pmsSpuInfo!=null){
            // 商品id
            if(!StringUtils.isEmpty(pmsSpuInfo.getId())){
                    criteria.andEqualTo("id",pmsSpuInfo.getId());
            }
            // 商品名称
            if(!StringUtils.isEmpty(pmsSpuInfo.getSpuName())){
                    criteria.andEqualTo("spuName",pmsSpuInfo.getSpuName());
            }
            // 商品描述
            if(!StringUtils.isEmpty(pmsSpuInfo.getSpuDescription())){
                    criteria.andEqualTo("spuDescription",pmsSpuInfo.getSpuDescription());
            }
            // 所属分类id
            if(!StringUtils.isEmpty(pmsSpuInfo.getCatalogId())){
                    criteria.andEqualTo("catalogId",pmsSpuInfo.getCatalogId());
            }
            // 品牌id
            if(!StringUtils.isEmpty(pmsSpuInfo.getBrandId())){
                    criteria.andEqualTo("brandId",pmsSpuInfo.getBrandId());
            }
            // 
            if(!StringUtils.isEmpty(pmsSpuInfo.getWeight())){
                    criteria.andEqualTo("weight",pmsSpuInfo.getWeight());
            }
            // 上架状态[0 - 下架，1 - 上架]
            if(!StringUtils.isEmpty(pmsSpuInfo.getPublishStatus())){
                    criteria.andEqualTo("publishStatus",pmsSpuInfo.getPublishStatus());
            }
            // 
            if(!StringUtils.isEmpty(pmsSpuInfo.getCreateTime())){
                    criteria.andEqualTo("createTime",pmsSpuInfo.getCreateTime());
            }
            // 
            if(!StringUtils.isEmpty(pmsSpuInfo.getUpdateTime())){
                    criteria.andEqualTo("updateTime",pmsSpuInfo.getUpdateTime());
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
        pmsSpuInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改PmsSpuInfo
     * @param pmsSpuInfo
     */
    @Override
    public void update(PmsSpuInfo pmsSpuInfo){
        pmsSpuInfoMapper.updateByPrimaryKey(pmsSpuInfo);
    }

    /**
     * 增加PmsSpuInfo
     * @param pmsSpuInfo
     */
    @Override
    public void add(PmsSpuInfo pmsSpuInfo){
        pmsSpuInfoMapper.insert(pmsSpuInfo);
    }

    /**
     * 根据ID查询PmsSpuInfo
     * @param id
     * @return
     */
    @Override
    public PmsSpuInfo findById(Long id){
        return  pmsSpuInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询PmsSpuInfo全部数据
     * @return
     */
    @Override
    public List<PmsSpuInfo> findAll() {
        return pmsSpuInfoMapper.selectAll();
    }
}
