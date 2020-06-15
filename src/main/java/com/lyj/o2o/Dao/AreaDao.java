package com.lyj.o2o.Dao;


import com.lyj.o2o.Pojo.Area;

import java.util.List;

/**
 * @author lyj
 * @Description: 区域数据接口
 * @date 2020年6月15日
 */
public interface AreaDao {

    /**
     * 查询区域信息
     *
     * @return
     */
    List<Area> queryArea();

}
