package com.skywalker.wms.service.impl;

import com.skywalker.wms.dao.WmsWareInfoMapper;
import com.skywalker.wms.pojo.WmsWareInfo;
import com.skywalker.wms.service.WmsWareInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.jsonwebtoken.lang.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname WmsWareInfoServiceImpl
 * @Description TODO
 */
@Service
public class WmsWareInfoServiceImpl implements WmsWareInfoService {

    @Resource
    private WmsWareInfoMapper wmsWareInfoMapper;


    /**
     * WmsWareInfo条件+分页查询
     *
     * @param wmsWareInfo 查询条件
     * @param page        页码
     * @param size        页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<WmsWareInfo> findPage(WmsWareInfo wmsWareInfo, int page, int size) {
        //分页
        PageHelper.startPage(page, size);
        //搜索条件构建
        Example example = createExample(wmsWareInfo);
        //执行搜索
        return new PageInfo<>(wmsWareInfoMapper.selectByExample(example));
    }

    /**
     * WmsWareInfo分页查询
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<WmsWareInfo> findPage(int page, int size) {
        //静态分页
        PageHelper.startPage(page, size);
        //分页查询
        return new PageInfo<WmsWareInfo>(wmsWareInfoMapper.selectAll());
    }

    /**
     * WmsWareInfo条件查询
     *
     * @param wmsWareInfo
     * @return
     */
    @Override
    public List<WmsWareInfo> findList(WmsWareInfo wmsWareInfo) {
        //构建查询条件
        Example example = createExample(wmsWareInfo);
        //根据构建的条件查询数据
        return wmsWareInfoMapper.selectByExample(example);
    }


    /**
     * WmsWareInfo构建查询对象
     *
     * @param wmsWareInfo
     * @return
     */
    public Example createExample(WmsWareInfo wmsWareInfo) {
        Example example = new Example(WmsWareInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if (wmsWareInfo != null) {
            // id
            if (!StringUtils.isEmpty(wmsWareInfo.getId())) {
                criteria.andEqualTo("id", wmsWareInfo.getId());
            }
            // 仓库名
            if (!StringUtils.isEmpty(wmsWareInfo.getName())) {
                criteria.andLike("name", "%" + wmsWareInfo.getName() + "%");
            }
            // 仓库地址
            if (!StringUtils.isEmpty(wmsWareInfo.getAddress())) {
                criteria.andEqualTo("address", wmsWareInfo.getAddress());
            }
            // 区域编码
            if (!StringUtils.isEmpty(wmsWareInfo.getAreaCode())) {
                criteria.andEqualTo("areaCode", wmsWareInfo.getAreaCode());
            }
        }
        return example;
    }

    /**
     * 删除
     *
     * @param ids
     */
    @Override
    public void delete(List<Long> ids) {
        Example example = new Example(WmsWareInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if (!Collections.isEmpty(ids)) {
            criteria.andIn("id", ids);
        }
        wmsWareInfoMapper.deleteByExample(example);
    }

    /**
     * 修改WmsWareInfo
     *
     * @param wmsWareInfo
     */
    @Override
    public void update(WmsWareInfo wmsWareInfo) {
        wmsWareInfoMapper.updateByPrimaryKey(wmsWareInfo);
    }

    /**
     * 增加WmsWareInfo
     *
     * @param wmsWareInfo
     */
    @Override
    public void add(WmsWareInfo wmsWareInfo) {
        wmsWareInfoMapper.insert(wmsWareInfo);
    }

    /**
     * 根据ID查询WmsWareInfo
     *
     * @param id
     * @return
     */
    @Override
    public WmsWareInfo findById(Long id) {
        return wmsWareInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询WmsWareInfo全部数据
     *
     * @return
     */
    @Override
    public List<WmsWareInfo> findAll() {
        return wmsWareInfoMapper.selectAll();
    }
}
