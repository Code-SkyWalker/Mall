package com.skywalker.pms.service.impl;
import com.skywalker.pms.dao.PmsSkuImagesMapper;
import com.skywalker.pms.pojo.PmsSkuImages;
import com.skywalker.pms.service.PmsSkuImagesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname PmsSkuImagesServiceImpl
 * @Description TODO
 */
@Service
public class PmsSkuImagesServiceImpl implements PmsSkuImagesService {

    @Autowired
    private PmsSkuImagesMapper pmsSkuImagesMapper;


    /**
     * PmsSkuImages条件+分页查询
     * @param pmsSkuImages 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<PmsSkuImages> findPage(PmsSkuImages pmsSkuImages, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(pmsSkuImages);
        //执行搜索
        return new PageInfo<PmsSkuImages>(pmsSkuImagesMapper.selectByExample(example));
    }

    /**
     * PmsSkuImages分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<PmsSkuImages> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<PmsSkuImages>(pmsSkuImagesMapper.selectAll());
    }

    /**
     * PmsSkuImages条件查询
     * @param pmsSkuImages
     * @return
     */
    @Override
    public List<PmsSkuImages> findList(PmsSkuImages pmsSkuImages){
        //构建查询条件
        Example example = createExample(pmsSkuImages);
        //根据构建的条件查询数据
        return pmsSkuImagesMapper.selectByExample(example);
    }


    /**
     * PmsSkuImages构建查询对象
     * @param pmsSkuImages
     * @return
     */
    public Example createExample(PmsSkuImages pmsSkuImages){
        Example example=new Example(PmsSkuImages.class);
        Example.Criteria criteria = example.createCriteria();
        if(pmsSkuImages!=null){
            // id
            if(!StringUtils.isEmpty(pmsSkuImages.getId())){
                    criteria.andEqualTo("id",pmsSkuImages.getId());
            }
            // sku_id
            if(!StringUtils.isEmpty(pmsSkuImages.getSkuId())){
                    criteria.andEqualTo("skuId",pmsSkuImages.getSkuId());
            }
            // 图片地址
            if(!StringUtils.isEmpty(pmsSkuImages.getImgUrl())){
                    criteria.andEqualTo("imgUrl",pmsSkuImages.getImgUrl());
            }
            // 排序
            if(!StringUtils.isEmpty(pmsSkuImages.getImgSort())){
                    criteria.andEqualTo("imgSort",pmsSkuImages.getImgSort());
            }
            // 默认图[0 - 不是默认图，1 - 是默认图]
            if(!StringUtils.isEmpty(pmsSkuImages.getDefaultImg())){
                    criteria.andEqualTo("defaultImg",pmsSkuImages.getDefaultImg());
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
        pmsSkuImagesMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改PmsSkuImages
     * @param pmsSkuImages
     */
    @Override
    public void update(PmsSkuImages pmsSkuImages){
        pmsSkuImagesMapper.updateByPrimaryKey(pmsSkuImages);
    }

    /**
     * 增加PmsSkuImages
     * @param pmsSkuImages
     */
    @Override
    public void add(PmsSkuImages pmsSkuImages){
        pmsSkuImagesMapper.insert(pmsSkuImages);
    }

    /**
     * 根据ID查询PmsSkuImages
     * @param id
     * @return
     */
    @Override
    public PmsSkuImages findById(Long id){
        return  pmsSkuImagesMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询PmsSkuImages全部数据
     * @return
     */
    @Override
    public List<PmsSkuImages> findAll() {
        return pmsSkuImagesMapper.selectAll();
    }
}
