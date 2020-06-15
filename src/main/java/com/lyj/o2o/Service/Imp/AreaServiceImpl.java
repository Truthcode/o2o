package com.lyj.o2o.Service.Imp;

import com.lyj.o2o.Dao.AreaDao;
import com.lyj.o2o.Pojo.Area;
import com.lyj.o2o.Service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Description: 区域业务接口实现
 * @Description: 区域业务接口
 * @date 2020年6月15日
 */
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

}
