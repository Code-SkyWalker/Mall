package com.skywalker.ums.service.impl;
import com.skywalker.ums.dao.UmsMemberReceiveAddressMapper;
import com.skywalker.ums.pojo.UmsMemberReceiveAddress;
import com.skywalker.ums.service.UmsMemberReceiveAddressService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname UmsMemberReceiveAddressServiceImpl
 * @Description TODO
 */
@Service
public class UmsMemberReceiveAddressServiceImpl implements UmsMemberReceiveAddressService {

    @Autowired
    private UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;


    /**
     * UmsMemberReceiveAddress条件+分页查询
     * @param umsMemberReceiveAddress 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<UmsMemberReceiveAddress> findPage(UmsMemberReceiveAddress umsMemberReceiveAddress, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(umsMemberReceiveAddress);
        //执行搜索
        return new PageInfo<UmsMemberReceiveAddress>(umsMemberReceiveAddressMapper.selectByExample(example));
    }

    /**
     * UmsMemberReceiveAddress分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<UmsMemberReceiveAddress> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<UmsMemberReceiveAddress>(umsMemberReceiveAddressMapper.selectAll());
    }

    /**
     * UmsMemberReceiveAddress条件查询
     * @param umsMemberReceiveAddress
     * @return
     */
    @Override
    public List<UmsMemberReceiveAddress> findList(UmsMemberReceiveAddress umsMemberReceiveAddress){
        //构建查询条件
        Example example = createExample(umsMemberReceiveAddress);
        //根据构建的条件查询数据
        return umsMemberReceiveAddressMapper.selectByExample(example);
    }


    /**
     * UmsMemberReceiveAddress构建查询对象
     * @param umsMemberReceiveAddress
     * @return
     */
    public Example createExample(UmsMemberReceiveAddress umsMemberReceiveAddress){
        Example example=new Example(UmsMemberReceiveAddress.class);
        Example.Criteria criteria = example.createCriteria();
        if(umsMemberReceiveAddress!=null){
            // id
            if(!StringUtils.isEmpty(umsMemberReceiveAddress.getId())){
                    criteria.andEqualTo("id",umsMemberReceiveAddress.getId());
            }
            // member_id
            if(!StringUtils.isEmpty(umsMemberReceiveAddress.getMemberId())){
                    criteria.andEqualTo("memberId",umsMemberReceiveAddress.getMemberId());
            }
            // 收货人姓名
            if(!StringUtils.isEmpty(umsMemberReceiveAddress.getName())){
                    criteria.andLike("name","%"+umsMemberReceiveAddress.getName()+"%");
            }
            // 电话
            if(!StringUtils.isEmpty(umsMemberReceiveAddress.getPhone())){
                    criteria.andEqualTo("phone",umsMemberReceiveAddress.getPhone());
            }
            // 邮政编码
            if(!StringUtils.isEmpty(umsMemberReceiveAddress.getPostCode())){
                    criteria.andEqualTo("postCode",umsMemberReceiveAddress.getPostCode());
            }
            // 省份/直辖市
            if(!StringUtils.isEmpty(umsMemberReceiveAddress.getProvince())){
                    criteria.andEqualTo("province",umsMemberReceiveAddress.getProvince());
            }
            // 城市
            if(!StringUtils.isEmpty(umsMemberReceiveAddress.getCity())){
                    criteria.andEqualTo("city",umsMemberReceiveAddress.getCity());
            }
            // 区
            if(!StringUtils.isEmpty(umsMemberReceiveAddress.getRegion())){
                    criteria.andEqualTo("region",umsMemberReceiveAddress.getRegion());
            }
            // 详细地址(街道)
            if(!StringUtils.isEmpty(umsMemberReceiveAddress.getDetailAddress())){
                    criteria.andEqualTo("detailAddress",umsMemberReceiveAddress.getDetailAddress());
            }
            // 省市区代码
            if(!StringUtils.isEmpty(umsMemberReceiveAddress.getAreacode())){
                    criteria.andEqualTo("areacode",umsMemberReceiveAddress.getAreacode());
            }
            // 是否默认
            if(!StringUtils.isEmpty(umsMemberReceiveAddress.getDefaultStatus())){
                    criteria.andEqualTo("defaultStatus",umsMemberReceiveAddress.getDefaultStatus());
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
        umsMemberReceiveAddressMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改UmsMemberReceiveAddress
     * @param umsMemberReceiveAddress
     */
    @Override
    public void update(UmsMemberReceiveAddress umsMemberReceiveAddress){
        umsMemberReceiveAddressMapper.updateByPrimaryKey(umsMemberReceiveAddress);
    }

    /**
     * 增加UmsMemberReceiveAddress
     * @param umsMemberReceiveAddress
     */
    @Override
    public void add(UmsMemberReceiveAddress umsMemberReceiveAddress){
        umsMemberReceiveAddressMapper.insert(umsMemberReceiveAddress);
    }

    /**
     * 根据ID查询UmsMemberReceiveAddress
     * @param id
     * @return
     */
    @Override
    public UmsMemberReceiveAddress findById(Long id){
        return  umsMemberReceiveAddressMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询UmsMemberReceiveAddress全部数据
     * @return
     */
    @Override
    public List<UmsMemberReceiveAddress> findAll() {
        return umsMemberReceiveAddressMapper.selectAll();
    }
}
