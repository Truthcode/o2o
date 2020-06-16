package lyj.o2o.Service;

import com.lyj.o2o.Dto.ShopExecution;
import com.lyj.o2o.Enums.ShopStateEnum;
import com.lyj.o2o.Pojo.Area;
import com.lyj.o2o.Pojo.PersonInfo;
import com.lyj.o2o.Pojo.Shop;
import com.lyj.o2o.Pojo.ShopCategory;
import com.lyj.o2o.Service.ShopService;

import lyj.o2o.BaseTest;
import org.apache.commons.io.IOUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * @author lyj
 * @Description: 店铺业务测试
 * @date 2020年6月16日
 */
public class ShopServiceTest extends BaseTest {

    @Autowired
    private ShopService shopService;

    @Test
    @Ignore
    public void testGetShopList() {

        Shop shopCondition = new Shop();
        PersonInfo personInfo = new PersonInfo();
        personInfo.setUserId(1L);

        shopCondition.setOwner(personInfo);
        shopCondition.setShopName("咖啡奶茶");

        ShopExecution se = shopService.getShopList(shopCondition, 1, 2);
        System.out.println("查询得到店铺数：" + se.getShopList().size());
        System.out.println("店铺总数：" + se.getCount());
        se = shopService.getShopList(shopCondition, 2, 2);
        System.out.println("查询得到店铺数：" + se.getShopList().size());
        System.out.println("店铺总数：" + se.getCount());
    }

    @Test
    public void testModifyShop() throws IOException {
        Shop shop = new Shop();
        shop.setShopId(2L);
        shop.setShopName("修改店铺测试");
        String filePath = "F:\\PKX\\picture\\need.png";
        shopService.modifyShop(shop, path2MultipartFile(filePath));
        System.out.println("修改后图片：" + shop.getShopImg());
    }

    @Test
    public void testAddShop() throws IOException {
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
        shop.setShopAddr("testService");
        shop.setShopName("test店铺Service");
        shop.setShopDesc("testService");
        shop.setShopImg("testService");
        shop.setPhone("testService");
        shop.setPriority(1);
        shop.setCreateTime(new Date());
        shop.setAdvice("审核中");
        String filePath = "F:\\PKX\\picture\\need.png";
        ShopExecution se = shopService.addShop(shop, path2MultipartFile(filePath));

        assertEquals(ShopStateEnum.CHECK.getState(),se.getState());
        System.out.println("ShopExecution.state" + se.getState());
        System.out.println("ShopExecution.stateInfo" + se.getStateInfo());

    }

    /**
     * filePath to MultipartFile
     *
     * @param filePath
     * @throws IOException
     */
    private MultipartFile path2MultipartFile(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream input = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile("file", file.getName(), "text/plain",
                IOUtils.toByteArray(input));
        return multipartFile;
    }

}
