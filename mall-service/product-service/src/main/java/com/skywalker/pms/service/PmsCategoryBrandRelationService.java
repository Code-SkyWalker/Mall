package com.skywalker.pms.service;
import com.skywalker.pms.pojo.PmsCategoryBrandRelation;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname PmsCategoryBrandRelationService
 * @Description TODO
 */
public interface PmsCategoryBrandRelationService {

    /***
     * PmsCategoryBrandRelation多条件分页查询
     * @param pmsCategoryBrandRelation
     * @param page
     * @param size
     * @return
     */
    PageInfo<PmsCategoryBrandRelation> findPage(PmsCategoryBrandRelation pmsCategoryBrandRelation, int page, int size);

    /***
     * PmsCategoryBrandRelation分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<PmsCategoryBrandRelation> findPage(int page, int size);

    /***
     * PmsCategoryBrandRelation多条件搜索方法
     * @param pmsCategoryBrandRelation
     * @return
     */
    List<PmsCategoryBrandRelation> findList(PmsCategoryBrandRelation pmsCategoryBrandRelation);

    /***
     * 删除PmsCategoryBrandRelation
     * @param id
     */
    void delete(Long id);

    /***
     * 修改PmsCategoryBrandRelation数据
     * @param pmsCategoryBrandRelation
     */
    void update(PmsCategoryBrandRelation pmsCategoryBrandRelation);

    /***
     * 新增PmsCategoryBrandRelation
     * @param pmsCategoryBrandRelation
     */
    void add(PmsCategoryBrandRelation pmsCategoryBrandRelation);

    /**
     * 根据ID查询PmsCategoryBrandRelation
     * @param id
     * @return
     */
     PmsCategoryBrandRelation findById(Long id);

    /***
     * 查询所有PmsCategoryBrandRelation
     * @return
     */
    List<PmsCategoryBrandRelation> findAll();
}
