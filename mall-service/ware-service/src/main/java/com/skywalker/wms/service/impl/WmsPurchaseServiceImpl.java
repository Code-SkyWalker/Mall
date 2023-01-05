package com.skywalker.wms.service.impl;

import com.skywalker.constant.WareConstant;
import com.skywalker.wms.dao.WmsPurchaseMapper;
import com.skywalker.wms.pojo.WmsPurchase;
import com.skywalker.wms.pojo.WmsPurchaseDetail;
import com.skywalker.wms.service.WmsPurchaseDetailService;
import com.skywalker.wms.service.WmsPurchaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.skywalker.wms.service.WmsWareSkuService;
import com.skywalker.wms.vo.PurchaseDetail;
import com.skywalker.wms.vo.WarePurchaseDoneVo;
import com.skywalker.wms.vo.WarePurchaseMergeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author Code SkyWalker
 * @Classname WmsPurchaseServiceImpl
 * @Description TODO
 */
@Service
public class WmsPurchaseServiceImpl implements WmsPurchaseService {

    @Resource
    private WmsPurchaseMapper wmsPurchaseMapper;

    @Autowired
    private WmsPurchaseDetailService wmsPurchaseDetailService;

    @Autowired
    private WmsWareSkuService wmsWareSkuService;


    /**
     * WmsPurchase条件+分页查询
     *
     * @param wmsPurchase 查询条件
     * @param page        页码
     * @param size        页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<WmsPurchase> findPage(WmsPurchase wmsPurchase, int page, int size) {
        //分页
        PageHelper.startPage(page, size);
        //搜索条件构建
        Example example = createExample(wmsPurchase);
        //执行搜索
        return new PageInfo<>(wmsPurchaseMapper.selectByExample(example));
    }

    /**
     * WmsPurchase分页查询
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<WmsPurchase> findPage(int page, int size) {
        //静态分页
        PageHelper.startPage(page, size);
        //分页查询
        return new PageInfo<WmsPurchase>(wmsPurchaseMapper.selectAll());
    }

    /**
     * WmsPurchase条件查询
     *
     * @param wmsPurchase
     * @return
     */
    @Override
    public List<WmsPurchase> findList(WmsPurchase wmsPurchase) {
        //构建查询条件
        Example example = createExample(wmsPurchase);
        //根据构建的条件查询数据
        return wmsPurchaseMapper.selectByExample(example);
    }


    /**
     * WmsPurchase构建查询对象
     *
     * @param wmsPurchase
     * @return
     */
    public Example createExample(WmsPurchase wmsPurchase) {
        Example example = new Example(WmsPurchase.class);
        Example.Criteria criteria = example.createCriteria();
        if (wmsPurchase != null) {
            if (!StringUtils.isEmpty(wmsPurchase.getId())) {
                criteria.andEqualTo("id", wmsPurchase.getId());
            }
            if (!StringUtils.isEmpty(wmsPurchase.getAssigneeId())) {
                criteria.andEqualTo("assigneeId", wmsPurchase.getAssigneeId());
            }
            if (!StringUtils.isEmpty(wmsPurchase.getAssigneeName())) {
                criteria.andEqualTo("assigneeName", wmsPurchase.getAssigneeName());
            }
            if (!StringUtils.isEmpty(wmsPurchase.getPhone())) {
                criteria.andEqualTo("phone", wmsPurchase.getPhone());
            }
            if (!StringUtils.isEmpty(wmsPurchase.getPriority())) {
                criteria.andEqualTo("priority", wmsPurchase.getPriority());
            }
            if (!StringUtils.isEmpty(wmsPurchase.getStatus())) {
                criteria.andEqualTo("status", wmsPurchase.getStatus());
            }
            if (!StringUtils.isEmpty(wmsPurchase.getWareId())) {
                criteria.andEqualTo("wareId", wmsPurchase.getWareId());
            }
            if (!StringUtils.isEmpty(wmsPurchase.getAmount())) {
                criteria.andEqualTo("amount", wmsPurchase.getAmount());
            }
            if (!StringUtils.isEmpty(wmsPurchase.getCreateTime())) {
                criteria.andEqualTo("createTime", wmsPurchase.getCreateTime());
            }
            if (!StringUtils.isEmpty(wmsPurchase.getUpdateTime())) {
                criteria.andEqualTo("updateTime", wmsPurchase.getUpdateTime());
            }
        }
        return example;
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        wmsPurchaseMapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除
     *
     * @param ids
     */
    @Override
    public void deleteByIds(List<Long> ids) {
        Example example = new Example(WmsPurchase.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", ids);
        wmsPurchaseMapper.deleteByExample(example);
    }

    /**
     * 修改WmsPurchase
     *
     * @param wmsPurchase
     */
    @Override
    public void update(WmsPurchase wmsPurchase) {
        wmsPurchase.setUpdateTime(LocalDateTime.now());
        wmsPurchaseMapper.updateByPrimaryKeySelective(wmsPurchase);
    }

    /**
     * 增加WmsPurchase
     *
     * @param wmsPurchase
     */
    @Override
    public void add(WmsPurchase wmsPurchase) {
        wmsPurchase.setCreateTime(LocalDateTime.now());
        wmsPurchase.setUpdateTime(LocalDateTime.now());
        wmsPurchaseMapper.insert(wmsPurchase);
    }

    /**
     * 根据ID查询WmsPurchase
     *
     * @param id
     * @return
     */
    @Override
    public WmsPurchase findById(Long id) {
        return wmsPurchaseMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询WmsPurchase全部数据
     *
     * @return /
     */
    @Override
    public List<WmsPurchase> findAll() {
        return wmsPurchaseMapper.selectAll();
    }

    /**
     * 查询还未采购(新建, 已分配)状态下的 采购单
     *
     * @return /
     */
    @Override
    public List<WmsPurchase> findPerchaseUnrecevied() {
        Example example = new Example(WmsPurchase.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("status", Arrays.asList(0, 1));
        return wmsPurchaseMapper.selectByExample(example);
    }

    /**
     * 合并采购单
     *
     * @param warePurchaseMergeVo 采购单vo
     */
    @Override
    @Transactional
    public void marge(WarePurchaseMergeVo warePurchaseMergeVo) throws Exception {
        Long purchaseId = warePurchaseMergeVo.getPurchaseId();

        int NEW = WareConstant.PurchaseStatusEnum.NEW.getCode();
        int DISPATCHED = WareConstant.PurchaseStatusEnum.DISPATCHED.getCode();

        WmsPurchase purchase = null;
        /* 如果没有选中采购单, 则创建采购单 */
        if (purchaseId == null) {
            purchase = WmsPurchase.builder()
                    .status(NEW)
                    .createTime(LocalDateTime.now())
                    .updateTime(LocalDateTime.now())
                    .build();
            this.add(purchase);

            // 如果采购单ID为空, 将新添加采购单的 ID 赋值给 purchaseId
            purchaseId = purchase.getId();
        }

        /* 确认采购单状态为 0, 1 */

        // 如果 purchaseId 为空, 在上一步添加采购单; 如果不为空, 在if中 查询出 purchase;
        // 因此 判断 purchase当前状态时, purchase 永不为空;
        if (purchase == null) purchase = this.findById(purchaseId);
        if (!(purchase.getStatus() == NEW || purchase.getStatus() == DISPATCHED))
            throw new Exception("该采购单状态不能合并");

        /* (合并)修改采购需求 */

        // lambda表达式为匿名内部类, 其使用的外部变量必须是final的
        Long finalPurchaseId = purchaseId;
        List<Long> items = warePurchaseMergeVo.getItems();
        if (!items.isEmpty()) {
            items.forEach(item -> {
                WmsPurchaseDetail wmsPurchaseDetail = new WmsPurchaseDetail();
                wmsPurchaseDetail.setId(item);
                wmsPurchaseDetail.setPurchaseId(finalPurchaseId);
                wmsPurchaseDetail.setStatus(NEW);
                this.wmsPurchaseDetailService.update(wmsPurchaseDetail);
            });
        }

        // 更新采购单时间
        if (purchaseId != null) {
            WmsPurchase purchaseUpdate = WmsPurchase.builder()
                    .id(purchaseId)
                    .updateTime(LocalDateTime.now())
                    .build();
            this.update(purchaseUpdate);
        }
    }

    /**
     * 采购员领取采购单
     *
     * @param purchaseIds 采购单ID
     */
    @Override
    @Transactional
    public void receive(List<Long> purchaseIds) throws Exception {
        int NEW = WareConstant.PurchaseStatusEnum.NEW.getCode();
        int DISPATCHED = WareConstant.PurchaseStatusEnum.DISPATCHED.getCode();

        List<WmsPurchase> purchaseByIds = this.findPurchaseByIds(purchaseIds);

        // 1. 确认当前采购单是 "新建"或"已分配" 状态
        for (WmsPurchase ele : purchaseByIds) {
            if (!(ele.getStatus() == NEW || ele.getStatus() == DISPATCHED)) {
                throw new Exception("采购单必须是新建或已分配状态");
            }
        }

        // 2. 改变采购单状态
        int RECEIVED = WareConstant.PurchaseStatusEnum.RECEIVED.getCode();
        purchaseIds.forEach(ele -> {
            WmsPurchase purchase = WmsPurchase.builder().id(ele)
                    .status(RECEIVED).updateTime(LocalDateTime.now()).build();
            this.wmsPurchaseMapper.updateByPrimaryKeySelective(purchase);
        });

        // 3. 改变采购项目状态
        int detailDispatched = WareConstant.PurchaseDetailStatusEnum.RECEIVED.getCode();
        WmsPurchaseDetail wmsPurchaseDetail = WmsPurchaseDetail.builder().status(detailDispatched).build();
        this.wmsPurchaseDetailService.updateStatusByPurchaseIds(purchaseIds, wmsPurchaseDetail);
    }

    /**
     * 批量查询
     *
     * @param purchaseIds List<purchase>
     * @return /
     */
    @Override
    public List<WmsPurchase> findPurchaseByIds(List<Long> purchaseIds) {
        Example example = new Example(WmsPurchase.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", purchaseIds);
        return this.wmsPurchaseMapper.selectByExample(example);
    }

    /**
     * 采购完成
     *
     * @param warePurchaseDoneVo /
     */
    @Override
    @Transactional
    public void done(WarePurchaseDoneVo warePurchaseDoneVo) {
        // 2. 改变采购项状态
        List<PurchaseDetail> purchaseDetails = warePurchaseDoneVo.getItems();
        System.out.println("purchaseDetails = " + purchaseDetails);
        int success = WareConstant.PurchaseDetailStatusEnum.ACCOMPLISHED.getCode();
        boolean isDone = true;
        if (!purchaseDetails.isEmpty()) {
            for (PurchaseDetail ele : purchaseDetails) {
                // 只要有一个需求没有完成, isDone = false;
                if (ele.getStatus() != success) isDone = false;
                WmsPurchaseDetail wmsPurchaseDetail = WmsPurchaseDetail.builder()
                        .id(ele.getItemId())
                        .status(ele.getStatus())
                        .build();
                this.wmsPurchaseDetailService.update(wmsPurchaseDetail);

                // 3. 将成功的采购的商品进行入库(修改商品数量)
                if (ele.getStatus() == success) {
                    // 查询采购需求
                    WmsPurchaseDetail purchaseDetail = this.wmsPurchaseDetailService.findById(ele.getItemId());
                    // 更新 wareSku 中的数量
                    this.wmsWareSkuService.addStock(purchaseDetail.getWareId(), purchaseDetail.getSkuId(), purchaseDetail.getSkuNum());
                }
            }
        }

        // 1. 改变采购单状态
        Long purchaseId = warePurchaseDoneVo.getId();
        int ACCOMPLISHED = WareConstant.PurchaseStatusEnum.ACCOMPLISHED.getCode();
        int EXCEPTION = WareConstant.PurchaseStatusEnum.EXCEPTION.getCode();
        WmsPurchase wmsPurchase = WmsPurchase.builder()
                .id(purchaseId)
                .status(isDone? ACCOMPLISHED : EXCEPTION)
                .build();
        this.update(wmsPurchase);

    }
}
