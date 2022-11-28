package com.skywalker.sms.service.impl;
import com.skywalker.sms.dao.SmsSeckillSkuNoticeMapper;
import com.skywalker.sms.pojo.SmsSeckillSkuNotice;
import com.skywalker.sms.service.SmsSeckillSkuNoticeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/**
 * @Author Code SkyWalker
 * @Classname SmsSeckillSkuNoticeServiceImpl
 * @Description TODO
 */
@Service
public class SmsSeckillSkuNoticeServiceImpl implements SmsSeckillSkuNoticeService {

    @Autowired
    private SmsSeckillSkuNoticeMapper smsSeckillSkuNoticeMapper;


    /**
     * SmsSeckillSkuNotice条件+分页查询
     * @param smsSeckillSkuNotice 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SmsSeckillSkuNotice> findPage(SmsSeckillSkuNotice smsSeckillSkuNotice, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(smsSeckillSkuNotice);
        //执行搜索
        return new PageInfo<SmsSeckillSkuNotice>(smsSeckillSkuNoticeMapper.selectByExample(example));
    }

    /**
     * SmsSeckillSkuNotice分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SmsSeckillSkuNotice> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SmsSeckillSkuNotice>(smsSeckillSkuNoticeMapper.selectAll());
    }

    /**
     * SmsSeckillSkuNotice条件查询
     * @param smsSeckillSkuNotice
     * @return
     */
    @Override
    public List<SmsSeckillSkuNotice> findList(SmsSeckillSkuNotice smsSeckillSkuNotice){
        //构建查询条件
        Example example = createExample(smsSeckillSkuNotice);
        //根据构建的条件查询数据
        return smsSeckillSkuNoticeMapper.selectByExample(example);
    }


    /**
     * SmsSeckillSkuNotice构建查询对象
     * @param smsSeckillSkuNotice
     * @return
     */
    public Example createExample(SmsSeckillSkuNotice smsSeckillSkuNotice){
        Example example=new Example(SmsSeckillSkuNotice.class);
        Example.Criteria criteria = example.createCriteria();
        if(smsSeckillSkuNotice!=null){
            // id
            if(!StringUtils.isEmpty(smsSeckillSkuNotice.getId())){
                    criteria.andEqualTo("id",smsSeckillSkuNotice.getId());
            }
            // member_id
            if(!StringUtils.isEmpty(smsSeckillSkuNotice.getMemberId())){
                    criteria.andEqualTo("memberId",smsSeckillSkuNotice.getMemberId());
            }
            // sku_id
            if(!StringUtils.isEmpty(smsSeckillSkuNotice.getSkuId())){
                    criteria.andEqualTo("skuId",smsSeckillSkuNotice.getSkuId());
            }
            // 活动场次id
            if(!StringUtils.isEmpty(smsSeckillSkuNotice.getSessionId())){
                    criteria.andEqualTo("sessionId",smsSeckillSkuNotice.getSessionId());
            }
            // 订阅时间
            if(!StringUtils.isEmpty(smsSeckillSkuNotice.getSubcribeTime())){
                    criteria.andEqualTo("subcribeTime",smsSeckillSkuNotice.getSubcribeTime());
            }
            // 发送时间
            if(!StringUtils.isEmpty(smsSeckillSkuNotice.getSendTime())){
                    criteria.andEqualTo("sendTime",smsSeckillSkuNotice.getSendTime());
            }
            // 通知方式[0-短信，1-邮件]
            if(!StringUtils.isEmpty(smsSeckillSkuNotice.getNoticeType())){
                    criteria.andEqualTo("noticeType",smsSeckillSkuNotice.getNoticeType());
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
        smsSeckillSkuNoticeMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SmsSeckillSkuNotice
     * @param smsSeckillSkuNotice
     */
    @Override
    public void update(SmsSeckillSkuNotice smsSeckillSkuNotice){
        smsSeckillSkuNoticeMapper.updateByPrimaryKey(smsSeckillSkuNotice);
    }

    /**
     * 增加SmsSeckillSkuNotice
     * @param smsSeckillSkuNotice
     */
    @Override
    public void add(SmsSeckillSkuNotice smsSeckillSkuNotice){
        smsSeckillSkuNoticeMapper.insert(smsSeckillSkuNotice);
    }

    /**
     * 根据ID查询SmsSeckillSkuNotice
     * @param id
     * @return
     */
    @Override
    public SmsSeckillSkuNotice findById(Long id){
        return  smsSeckillSkuNoticeMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SmsSeckillSkuNotice全部数据
     * @return
     */
    @Override
    public List<SmsSeckillSkuNotice> findAll() {
        return smsSeckillSkuNoticeMapper.selectAll();
    }
}
