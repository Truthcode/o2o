package lyj.o2o.Dao;

import com.lyj.o2o.Dao.AreaDao;

import com.lyj.o2o.Pojo.Area;
import lyj.o2o.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author lyj
 * @Description: 区域接口测试
 * @date 2020年6月15日
 */

public class AreaDaoTest extends BaseTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    public void testQueryArea() {
        List<Area> areaList = areaDao.queryArea();
        System.out.println("dao测试：" + areaList.toString());
    }

}
