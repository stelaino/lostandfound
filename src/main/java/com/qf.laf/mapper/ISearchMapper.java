package com.qf.laf.mapper;

import com.qf.laf.entity.Lost;
import com.qf.laf.entity.Pickup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ISearchMapper {
    //通过内容（关键字）获取全国失物信息
    List<Lost> getLostListByContext(@Param("offset") Integer offset, @Param("num") Integer num, @Param("context") String context);
    //通过内容（关键字）获取全国失物信息总条数
    Integer getLostCountByContext(@Param("context") String context);
    //通过内容（关键字）获取全国招领信息
    List<Pickup> getPickupListByContext(@Param("offset") Integer offset, @Param("num") Integer num, @Param("context") String context);
    //通过内容（关键字）获取全国寻物信息总条数
    Integer getPickupCountByContext(@Param("context") String context);

    //通过省份和关键字查询失物信息总条数
    Integer getLostCountByContextAndProvince(@Param("province") String province, @Param("context") String context);
    //通过省份和关键字查询失物信息
    List<Lost> getLostListByContextAndProvince(@Param("province") String province, @Param("context") String context, @Param("offset") Integer offset, @Param("num") Integer num);
    //通过省份和关键字查询招领信息总条数
    Integer getPickupCountByContextAndProvince(@Param("province") String province, @Param("context") String context);
    //通过省份和关键字查询招领信息
    List<Pickup> getPickupListByContextAndProvince(@Param("province") String province, @Param("context") String context, @Param("offset") Integer offset, @Param("num") Integer num);


    /*
        寻物页和招领页通过省份和类型进行筛选
    */
    //通过类型获取全国失物信息
    List<Lost> getLostListByType(@Param("offset") Integer offset, @Param("num") Integer num, @Param("type") String type);
    //通过类型获取全国失物信息总条数
    Integer getLostCountByType(@Param("type") String type);
    //通过类型获取全国招领信息
    List<Pickup> getPickupListByType(@Param("offset") Integer offset, @Param("num") Integer num, @Param("type") String type);
    //通过类型获取全国寻物信息总条数
    Integer getPickupCountByType(@Param("type") String type);

    //通过省份和类型查询失物信息总条数
    Integer getLostCountByTypeAndProvince(@Param("province") String province, @Param("type") String type);
    //通过省份和类型查询失物信息
    List<Lost> getLostListByTypeAndProvince(@Param("province") String province, @Param("type") String type, @Param("offset") Integer offset, @Param("num") Integer num);
    //通过省份和类型查询招领信息总条数
    Integer getPickupCountByTypeAndProvince(@Param("province") String province, @Param("type") String type);
    //通过省份和类型查询招领信息
    List<Pickup> getPickupListByTypeAndProvince(@Param("province") String province, @Param("type") String type, @Param("offset") Integer offset, @Param("num") Integer num);


    /*
    寻物页和招领页通过市和类型进行筛选
    */
    //通过省份和类型查询失物信息总条数
    Integer getLostCountByTypeAndCity(@Param("city") String city, @Param("type") String type);
    //通过省份和类型查询失物信息
    List<Lost> getLostListByTypeAndCity(@Param("city") String city, @Param("type") String type, @Param("offset") Integer offset, @Param("num") Integer num);
    //通过省份和类型查询招领信息总条数
    Integer getPickupCountByTypeAndCity(@Param("city") String city, @Param("type") String type);
    //通过省份和类型查询招领信息
    List<Pickup> getPickupListByTypeAndCity(@Param("city") String city, @Param("type") String type, @Param("offset") Integer offset, @Param("num") Integer num);


    /*
    *
    *   寻物页和招领页通过省份，类型，关键字进行搜索
    * */
    //通过类型和关键字查询全国失物信息
    List<Lost> getLostListByTypeAndContext(@Param("offset") Integer offset, @Param("num") Integer num, @Param("type") String type, @Param("context") String context);
    //通过类型和关键字获取全国失物信息总条数
    Integer getLostCountByTypeAndContext(@Param("type") String type, @Param("context") String context);
    //通过类型和关键字查询全国招领信息
    List<Pickup> getPickupListByTypeAndContext(@Param("offset") Integer offset, @Param("num") Integer num, @Param("type") String type, @Param("context") String context);
    //通过类型和关键字获取全招领信息总条数
    Integer getPickupCountByTypeAndContext(@Param("type") String type, @Param("context") String context);

    //通过省份和类型和关键字查询失物信息总条数
    Integer getLostCountByTypeAndProvinceAndContext(@Param("province") String province, @Param("type") String type, @Param("context") String context);
    //通过省份和类型和关键字查询失物信息
    List<Lost> getLostListByTypeAndProvinceAndContext(@Param("province") String province, @Param("type") String type, @Param("context") String context, @Param("offset") Integer offset, @Param("num") Integer num);
    //通过省份和类型和关键字查询招领信息总条数
    Integer getPickupCountByTypeAndProvinceAndContext(@Param("province") String province, @Param("type") String type, @Param("context") String context);
    //通过省份和类型和关键字查询招领信息
    List<Pickup> getPickupListByTypeAndProvinceAndContext(@Param("province") String province, @Param("type") String type, @Param("offset") Integer offset, @Param("num") Integer num, @Param("context") String context);


    /*
     *   失物和招领页面快速筛选框进行关键字搜索（选择了市没有选择类型（传递市，关键字和当前页））
     * */
    //通过市和关键字查询失物信息总条数
    Integer getLostCountByContextAndCity(@Param("city") String city, @Param("context") String context);
    //通过市和关键字查询失物信息
    List<Lost> getLostListByContextAndCity(@Param("city") String city, @Param("context") String context, @Param("offset") Integer offset, @Param("num") Integer num);
    //通过市和关键字查询招领信息总条数
    Integer getPickupCountByContextAndCity(@Param("city") String city, @Param("context") String context);
    //通过市和关键字查询招领信息
    List<Pickup> getPickupListByContextAndCity(@Param("city") String city, @Param("context") String context, @Param("offset") Integer offset, @Param("num") Integer num);


    /*
        寻物页和招领页通过市，类型，关键字进行搜索
    */
    //通过市和类型和关键字查询失物信息总条数
    Integer getLostCountByTypeAndCityAndContext(@Param("city") String city, @Param("type") String type, @Param("context") String context);
    //通过市和类型和关键字查询失物信息
    List<Lost> getLostListByTypeAndCityAndContext(@Param("city") String city, @Param("type") String type, @Param("context") String context, @Param("offset") Integer offset, @Param("num") Integer num);
    //通过市和类型和关键字查询招领信息总条数
    Integer getPickupCountByTypeAndCityAndContext(@Param("city") String city, @Param("type") String type, @Param("context") String context);
    //通过市和类型和关键字查询招领信息
    List<Pickup> getPickupListByTypeAndCityAndContext(@Param("city") String city, @Param("type") String type, @Param("offset") Integer offset, @Param("num") Integer num, @Param("context") String context);
}
