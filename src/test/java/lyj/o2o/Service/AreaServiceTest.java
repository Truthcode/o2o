package lyj.o2o.Service;

import com.lyj.o2o.Pojo.Area;
import com.lyj.o2o.Service.AreaService;
import lyj.o2o.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author lyj
 * @Description: 区域业务测试
 * @date 2020年6月15日
 */
public class AreaServiceTest extends BaseTest {

    @Autowired
    private AreaService areaService;

    @Test
    public void testQueryArea() {
        List<Area> areaList = areaService.getAreaList();
        System.out.println("service测试：" + areaList.toString());
    }

}
