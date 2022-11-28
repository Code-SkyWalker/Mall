package com.skywalker.oms.service;

import com.github.pagehelper.PageInfo;
import com.skywalker.oms.pojo.OmsOrderSetting;

import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname OmsOrderSettingService
 * @Description TODO
 */
public interface OmsOrderSettingService {

    /***
     * OmsOrderSetting多条件分页查询
     * @param omsOrderSetting
     * @param page
     * @param size
     * @return
     */
    PageInfo<OmsOrderSetting> findPage(OmsOrderSetting omsOrderSetting, int page, int size);

    /***
     * OmsOrderSetting分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<OmsOrderSetting> findPage(int page, int size);

    /***
     * OmsOrderSetting多条件搜索方法
     * @param omsOrderSetting
     * @return
     */
    List<OmsOrderSetting> findList(OmsOrderSetting omsOrderSetting);

    /***
     * 删除OmsOrderSetting
     * @param id
     */
    void delete(Long id);

    /***
     * 修改OmsOrderSetting数据
     * @param omsOrderSetting
     */
    void update(OmsOrderSetting omsOrderSetting);

    /***
     * 新增OmsOrderSetting
     * @param omsOrderSetting
     */
    void add(OmsOrderSetting omsOrderSetting);

    /**
     * 根据ID查询OmsOrderSetting
     * @param id
     * @return
     */
     OmsOrderSetting findById(Long id);

    /***
     * 查询所有OmsOrderSetting
     * @return
     */
    List<OmsOrderSetting> findAll();
}
