package lyj.o2o.Dao;

import com.lyj.o2o.Dao.ShopDao;

import com.lyj.o2o.Enums.EnableStatusEnum;
import com.lyj.o2o.Pojo.Area;
import com.lyj.o2o.Pojo.PersonInfo;
import com.lyj.o2o.Pojo.Shop;
import com.lyj.o2o.Pojo.ShopCategory;
import lyj.o2o.BaseTest;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @author lyj
 * @Description: 测试店铺接口
 * @date 2020年6月16日
 */
public class ShopDaoTest extends BaseTest {

    @Autowired
    private ShopDao shopDao;

    @Test
    public void testQueryShopList() {
        Shop shopCondition = new Shop();
        ShopCategory childCategory = new ShopCategory();
        ShopCategory parentCategory = new ShopCategory();
        parentCategory.setShopCategoryId(4L);
        childCategory.setParent(parentCategory);
        shopCondition.setShopCategory(childCategory);
        List<Shop> shopList = shopDao.selectShopList(shopCondition, 0, 3);
        System.out.println("查询店铺列表的大小：" + shopList.size());
        int shopCount = shopDao.selectShopCount(shopCondition);
        System.out.println("店铺列表总数大小：" + shopCount);
    }

    @Test
    public void testInsertShop() {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        ShopCategory shopCategory = new ShopCategory();
        Area area = new Area();
        owner.setUserId(1L);
        area.setAreaId(1);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
        shop.setShopCategory(shopCategory);
        shop.setArea(area);
        shop.setShopAddr("test");
        shop.setShopName("test店铺");
        shop.setShopDesc("test");
        shop.setShopImg("test");
        shop.setPhone("test");
        shop.setPriority(1);
        shop.setCreateTime(new Date());
        shop.setEnableStatus(EnableStatusEnum.AVAILABLE.getState());
        shop.setAdvice("审核中");
        int effectNum = shopDao.insertShop(shop);
        System.out.println("effectNum：" + effectNum);
    }

    @Test
    @Ignore
    public void testUpdateShop() {
        Shop shop = new Shop();
        shop.setShopId(1L);
        shop.setShopAddr("test@111");
        shop.setShopName("@test@111");
        shop.setShopDesc("test111");
        shop.setShopImg("test111");
        shop.setPhone("test111");
        shop.setLastEditTime(new Date());
        int effectNum = shopDao.updateShop(shop);
        System.out.println("effectNum：" + effectNum);
    }

    @Test
    @Ignore
    public void testQueryShop() {
        Shop shop = shopDao.selectByShopId(1);
        System.out.println("areaName:" + shop.getArea().getAreaName());
        System.out.println("shopCategoryName:" + shop.getShopCategory().getShopCategoryName());
    }
}
