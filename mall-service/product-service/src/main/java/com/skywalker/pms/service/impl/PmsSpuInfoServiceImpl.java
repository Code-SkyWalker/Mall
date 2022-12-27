package com.skywalker.pms.service.impl;
import com.skywalker.pms.dao.PmsSpuInfoMapper;
import com.skywalker.pms.pojo.*;
import com.skywalker.pms.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.skywalker.pms.vo.*;
import com.skywalker.sms.feign.SmsSkuFullReductionFeign;
import com.skywalker.sms.feign.SmsSpuBoundsFeign;
import com.skywalker.sms.pojo.SmsSpuBounds;
import com.skywalker.to.SkuCouponTo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname PmsSpuInfoServiceImpl
 * @Description TODO
 */
@Service
public class PmsSpuInfoServiceImpl implements PmsSpuInfoService {

    @Resource
    private PmsSpuInfoMapper pmsSpuInfoMapper;

    @Resource
    private PmsSpuInfoDescService pmsSpuInfoDescService;

    @Resource
    private PmsSpuImagesService pmsSpuImagesService;

    @Resource
    private PmsAttrService pmsAttrService;

    @Resource
    private PmsProductAttrValueService pmsProductAttrValueService;

    @Resource
    private PmsSkuImagesService pmsSkuImagesService;

    @Resource
    private PmsSkuInfoService pmsSkuInfoService;

    @Resource
    private PmsSkuSaleAttrValueService pmsSkuSaleAttrValueService;

    @Autowired
    private SmsSpuBoundsFeign smsSpuBoundsFeign;

    @Autowired
    private SmsSkuFullReductionFeign smsSkuFullReductionFeign;

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
        return new PageInfo<>(pmsSpuInfoMapper.selectByExample(example));
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

    /**
     * 保存商品信息
     *
     * @param vo 商品vo类
     */
    @Override
    @Transactional
    public void saveSpuInfo(SpuSaveVo vo) {
        // 1. 保存spu基本信息: pms_spu_info
        PmsSpuInfo pmsSpuInfo = new PmsSpuInfo();
        BeanUtils.copyProperties(vo, pmsSpuInfo);
        this.add(pmsSpuInfo);

        // 2. 保存Spu的描述图片: pms_spu_info_desc
        List<String> decript = vo.getDecript();
        PmsSpuInfoDesc pmsSpuInfoDesc = new PmsSpuInfoDesc();
        pmsSpuInfoDesc.setSpuId(pmsSpuInfo.getId());
        pmsSpuInfoDesc.setDecript(String.join(",", decript));
        this.pmsSpuInfoDescService.add(pmsSpuInfoDesc);

        // 3. 保存spu的图片集: pms_spu_images
        List<String> images = vo.getImages();
        images.forEach(img -> {
            PmsSpuImages pmsSpuImages = new PmsSpuImages();
            pmsSpuImages.setSpuId(pmsSpuInfo.getId());
            pmsSpuImages.setImgUrl(img);

            this.pmsSpuImagesService.add(pmsSpuImages);
        });

        // 4. 保存spu的规格参数: pms_product_attr_value
        List<BaseAttrsVo> baseAttrs = vo.getBaseAttrs();
        baseAttrs.forEach(attr -> {
            PmsProductAttrValue pmsProductAttrValue = new PmsProductAttrValue();
            pmsProductAttrValue.setSpuId(pmsSpuInfo.getId());
            pmsProductAttrValue.setAttrId(attr.getAttrId());
            pmsProductAttrValue.setAttrName(this.pmsAttrService.findById(attr.getAttrId()).getAttrName());
            pmsProductAttrValue.setAttrValue(attr.getAttrValues());
            pmsProductAttrValue.setQuickShow(attr.getShowDesc());

            this.pmsProductAttrValueService.add(pmsProductAttrValue);
        });


        // 5. 保存spu的积分信息: sms_spu_bounds
        SmsSpuBounds smsSpuBounds = new SmsSpuBounds();
        BeanUtils.copyProperties(vo.getBounds(), smsSpuBounds);
        smsSpuBounds.setSpuId(pmsSpuInfo.getId());
        this.smsSpuBoundsFeign.add(smsSpuBounds);

        // 6. 保存当前 spu 对应的所有 sku 信息
        List<Skus> skus = vo.getSkus();
        skus.forEach(sku -> {
            PmsSkuInfo pmsSkuInfo = new PmsSkuInfo();

            // 寻找默认的代表图片
            String defaultImage = null;
            for (ImagesVo image : sku.getImages()) {
                if (image.getDefaultImg() == 1) {
                    defaultImage = image.getImgUrl();
                    break;
                }
            }

            // 6.1 sku的基本信息: pms_sku_info
            BeanUtils.copyProperties(sku, pmsSkuInfo);
            pmsSkuInfo.setSpuId(pmsSpuInfo.getId());
            pmsSkuInfo.setPrice(sku.getPrice());
            pmsSkuInfo.setBrandId(vo.getBrandId());
            pmsSkuInfo.setCatalogId(vo.getCatalogId());
            pmsSkuInfo.setSkuDefaultImg(defaultImage);
            pmsSkuInfo.setSaleCount(0L);
            this.pmsSkuInfoService.add(pmsSkuInfo);

            // 6.2 sku的图片信息: pms_sku_images
            sku.getImages().forEach(img -> {
                PmsSkuImages pmsSkuImages = new PmsSkuImages();
                pmsSkuImages.setSkuId(pmsSkuInfo.getSkuId());
                pmsSkuImages.setImgUrl(img.getImgUrl());
                pmsSkuImages.setDefaultImg(img.getDefaultImg());

                pmsSkuImagesService.add(pmsSkuImages);
            });

            // 6.3 sku的销售属性信息: pms_sku_sale_attr_value
            List<AttrVo> attrs = sku.getAttr();
            attrs.forEach(attrVo -> {
                PmsSkuSaleAttrValue pmsSkuSaleAttrValue = new PmsSkuSaleAttrValue();
                pmsSkuSaleAttrValue.setSkuId(pmsSkuInfo.getSkuId());
                pmsSkuSaleAttrValue.setAttrName(attrVo.getAttrName());
                pmsSkuSaleAttrValue.setAttrValue(attrVo.getAttrValue());
                pmsSkuSaleAttrValue.setAttrId(attrVo.getAttrId());

                pmsSkuSaleAttrValueService.add(pmsSkuSaleAttrValue);
            });

            // 6.4 sku的优惠满减等信息 sms_sku_ladder / sms_sku_full_reduction / sms_member_price
            SkuCouponTo skuCouponTo = new SkuCouponTo();
            BeanUtils.copyProperties(sku, skuCouponTo); // 构建skuCoupon传输对象
            skuCouponTo.setSkuId(pmsSkuInfo.getSkuId());

            this.smsSkuFullReductionFeign.addSkuCouponInfo(skuCouponTo);
        });

    }
}
