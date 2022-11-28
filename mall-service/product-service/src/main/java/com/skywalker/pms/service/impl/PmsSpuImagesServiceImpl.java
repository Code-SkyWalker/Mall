package com.skywalker.pms.service.impl;
import com.skywalker.pms.dao.PmsSpuImagesMapper;
import com.skywalker.pms.pojo.PmsSpuImages;
import com.skywalker.pms.service.PmsSpuImagesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname PmsSpuImagesServiceImpl
 * @Description TODO
 */
@Service
public class PmsSpuImagesServiceImpl implements PmsSpuImagesService {

    @Autowired
    private PmsSpuImagesMapper pmsSpuImagesMapper;


    /**
     * PmsSpuImages条件+分页查询
     * @param pmsSpuImages 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<PmsSpuImages> findPage(PmsSpuImages pmsSpuImages, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(pmsSpuImages);
        //执行搜索
        return new PageInfo<PmsSpuImages>(pmsSpuImagesMapper.selectByExample(example));
    }

    /**
     * PmsSpuImages分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<PmsSpuImages> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<PmsSpuImages>(pmsSpuImagesMapper.selectAll());
    }

    /**
     * PmsSpuImages条件查询
     * @param pmsSpuImages
     * @return
     */
    @Override
    public List<PmsSpuImages> findList(PmsSpuImages pmsSpuImages){
        //构建查询条件
        Example example = createExample(pmsSpuImages);
        //根据构建的条件查询数据
        return pmsSpuImagesMapper.selectByExample(example);
    }


    /**
     * PmsSpuImages构建查询对象
     * @param pmsSpuImages
     * @return
     */
    public Example createExample(PmsSpuImages pmsSpuImages){
        Example example=new Example(PmsSpuImages.class);
        Example.Criteria criteria = example.createCriteria();
        if(pmsSpuImages!=null){
            // id
            if(!StringUtils.isEmpty(pmsSpuImages.getId())){
                    criteria.andEqualTo("id",pmsSpuImages.getId());
            }
            // spu_id
            if(!StringUtils.isEmpty(pmsSpuImages.getSpuId())){
                    criteria.andEqualTo("spuId",pmsSpuImages.getSpuId());
            }
            // 图片名
            if(!StringUtils.isEmpty(pmsSpuImages.getImgName())){
                    criteria.andEqualTo("imgName",pmsSpuImages.getImgName());
            }
            // 图片地址
            if(!StringUtils.isEmpty(pmsSpuImages.getImgUrl())){
                    criteria.andEqualTo("imgUrl",pmsSpuImages.getImgUrl());
            }
            // 顺序
            if(!StringUtils.isEmpty(pmsSpuImages.getImgSort())){
                    criteria.andEqualTo("imgSort",pmsSpuImages.getImgSort());
            }
            // 是否默认图
            if(!StringUtils.isEmpty(pmsSpuImages.getDefaultImg())){
                    criteria.andEqualTo("defaultImg",pmsSpuImages.getDefaultImg());
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
        pmsSpuImagesMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改PmsSpuImages
     * @param pmsSpuImages
     */
    @Override
    public void update(PmsSpuImages pmsSpuImages){
        pmsSpuImagesMapper.updateByPrimaryKey(pmsSpuImages);
    }

    /**
     * 增加PmsSpuImages
     * @param pmsSpuImages
     */
    @Override
    public void add(PmsSpuImages pmsSpuImages){
        pmsSpuImagesMapper.insert(pmsSpuImages);
    }

    /**
     * 根据ID查询PmsSpuImages
     * @param id
     * @return
     */
    @Override
    public PmsSpuImages findById(Long id){
        return  pmsSpuImagesMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询PmsSpuImages全部数据
     * @return
     */
    @Override
    public List<PmsSpuImages> findAll() {
        return pmsSpuImagesMapper.selectAll();
    }
}
