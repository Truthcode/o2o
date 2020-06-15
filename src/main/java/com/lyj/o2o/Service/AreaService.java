package com.lyj.o2o.Service;

import com.lyj.o2o.Pojo.Area;

import java.util.List;

/**
 * @author lyj
 * @Description: 区域业务接口
 * @date 2020年6月15日
 */
public interface AreaService {
    /**
     * 获取区域列表,将区域信息放入缓存中
     *
     * @return
     */
    List<Area> getAreaList();

}
