package com.lyj.o2o.Service;

import com.lyj.o2o.Dto.ShopExecution;
import com.lyj.o2o.Exceptions.ShopOperationException;
import com.lyj.o2o.Pojo.Shop;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author lyj
 * @Description: 店铺业务接口
 * @date 2020年6月16日
 */
public interface ShopService {

    /**
     * 根据id查询店铺详情
     *
     * @param shopId
     * @return
     */
    Shop getByShopId(long shopId);

    /**
     * 添加店铺
     *
     * @param shop
     * @param shopImg
     * @return
     */
    ShopExecution addShop(Shop shop, MultipartFile shopImg) throws ShopOperationException;

    /**
     * 修改店铺
     *
     * @param shop
     * @param shopImg
     * @return
     */
    ShopExecution modifyShop(Shop shop, MultipartFile shopImg) throws ShopOperationException;

    /**
     * 获取店铺分页列表
     *
     * @param shopCondition 店铺查询条件
     * @param pageIndex     第几页
     * @param pageSize      每页条数
     * @return
     * @throws ShopOperationException
     */
    ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize) throws ShopOperationException;
}
