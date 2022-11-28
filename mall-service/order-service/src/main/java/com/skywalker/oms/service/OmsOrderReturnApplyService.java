package com.skywalker.oms.service;

import com.github.pagehelper.PageInfo;
import com.skywalker.oms.pojo.OmsOrderReturnApply;

import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname OmsOrderReturnApplyService
 * @Description TODO
 */
public interface OmsOrderReturnApplyService {

    /***
     * OmsOrderReturnApply多条件分页查询
     * @param omsOrderReturnApply
     * @param page
     * @param size
     * @return
     */
    PageInfo<OmsOrderReturnApply> findPage(OmsOrderReturnApply omsOrderReturnApply, int page, int size);

    /***
     * OmsOrderReturnApply分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<OmsOrderReturnApply> findPage(int page, int size);

    /***
     * OmsOrderReturnApply多条件搜索方法
     * @param omsOrderReturnApply
     * @return
     */
    List<OmsOrderReturnApply> findList(OmsOrderReturnApply omsOrderReturnApply);

    /***
     * 删除OmsOrderReturnApply
     * @param id
     */
    void delete(Long id);

    /***
     * 修改OmsOrderReturnApply数据
     * @param omsOrderReturnApply
     */
    void update(OmsOrderReturnApply omsOrderReturnApply);

    /***
     * 新增OmsOrderReturnApply
     * @param omsOrderReturnApply
     */
    void add(OmsOrderReturnApply omsOrderReturnApply);

    /**
     * 根据ID查询OmsOrderReturnApply
     * @param id
     * @return
     */
     OmsOrderReturnApply findById(Long id);

    /***
     * 查询所有OmsOrderReturnApply
     * @return
     */
    List<OmsOrderReturnApply> findAll();
}
