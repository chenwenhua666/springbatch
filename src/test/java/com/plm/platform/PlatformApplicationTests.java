package com.plm.platform;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.plm.platform.batch.entity.*;
import com.plm.platform.batch.service.*;
import com.plm.platform.batch.service.impl.SegmentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.*;

import static com.baomidou.mybatisplus.core.toolkit.Wrappers.lambdaQuery;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class PlatformApplicationTests {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private DictService dictService;

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductDescriptService productDescriptService;

    @Autowired
    private RegionService regionService;

    @Autowired
    private StoreInfoService storeInfoService;

    @Autowired
    private SegmentService segmentService;


    @Test
    void contextLoads() {
    }

    @Test
    public void testInsertOrder() {
        for (int i = 0; i < 100; i++) {
            Order order = new Order();
            //order.setOrderId(1L);
            order.setPrice(new BigDecimal(i));
            order.setUserId(8L);
            order.setOrderStatus("finish");
            orderService.save(order);
        }
    }

    @Test
    public void queryOrder() {
        List<Long> ids = new ArrayList<>();
        ids.add(725060320611008512L);
        //ids.add(725017878729850881L);
        List<Order> orderList = orderService.listByIds(ids);
        log.info("结果={}", orderList);
    }

    @Test
    public void queryOrder2() {
        List<Long> ids = new ArrayList<>();
        ids.add(725060320611008512L);
        ids.add(725017878729850881L);
        LambdaQueryWrapper<Order> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.in(Order::getOrderId, ids);
        queryWrapper.eq(Order::getUserId, 4L);

        List<Order> orderList = orderService.list(queryWrapper);
        log.info("结果={}", orderList);
    }

    @Test
    public void testInsertUser() {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUsername("username" + i);
            user.setUserType("app");
            userService.save(user);
        }
    }

    @Test
    public void queryUser() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        List<User> userList = userService.listByIds(ids);
        log.info("结果={}", userList);
    }

    @Test
    public void queryUser2() {
        List<Map> result = userService.findUserInfoByIds("user_type", Arrays.asList(1L, 2L, 3L));
        log.info("结果={}", result);
    }

    @Test
    public void testInsertRegison() {
        for (int i = 0; i < 10; i++) {
            Region region = new Region();
            region.setId(segmentService.getId("springbatch").getId());
            region.setLevel(1);
            region.setRegionCode(UUID.randomUUID().toString().replaceAll("-", ""));
            region.setRegionName(UUID.randomUUID().toString().replaceAll("-", ""));
            region.setParentRegionCode("0");
            regionService.save(region);
        }
    }

    @Test
    public void testInsertDict() {
        Dict dict = new Dict();
        dict.setCode("user_type");
        dict.setDictKey("-1");
        dict.setDictValue("用户类型");
        dict.setSort(1);
        dictService.save(dict);
        Long parentId = dict.getId();
        Dict dict2 = new Dict();
        dict2.setParentId(parentId);
        dict2.setCode("user_type");
        dict2.setDictKey("1");
        dict2.setDictValue("app");
        dict2.setSort(1);
        dictService.save(dict2);
        Dict dict3 = new Dict();
        dict3.setParentId(parentId);
        dict3.setCode("user_type");
        dict3.setDictKey("2");
        dict3.setDictValue("web");
        dict3.setSort(2);
        dictService.save(dict3);
    }

    @Test
    public void testDeleteDict() {
        dictService.removeByIds(Arrays.asList(1L, 2L, 3L));
    }

    @Test
    public void insertProduct() {
        for (int i = 0; i < 100; i++) {
            ProductInfo productInfo = new ProductInfo();
            productInfo.setProductName("商品名" + i);
            productInfo.setStoreInfoId(1L);
            productInfo.setSpec("规格");
            productInfo.setRegionCode("110000");
            productInfo.setPrice(new BigDecimal(100L));
            productInfo.setImageUrl("www.baidu.com");
            productInfoService.save(productInfo);
            ProductDescript productDescript = new ProductDescript();
            productDescript.setDescript("商品描述信息" + i);
            productDescript.setProductInfoId(productInfo.getProductInfoId());
            productDescript.setStoreInfoId(productInfo.getStoreInfoId());
            productDescriptService.save(productDescript);
        }
    }

    @Test
    public void findProductDetail() {
        List<Map> productDetails = productInfoService.findProductDetail(1, 10);
        log.info("商品详情={}", productDetails);
    }

    @Test
    public void findProductDetailByPage() {
        IPage<Map> productDetails = productInfoService.findProductDetailByPage(2, 10);
        log.info("分页对象商品详情={},total={},size={}", productDetails.getRecords(),productDetails.getTotal(), productDetails.getSize());
    }


    @Test
    public void selectProductCount() {
        log.info("商品count={}", productInfoService.count());
    }

    @Test
    public void selectProductGroupList() {
        List<Map> result = productInfoService.findProductGroupList();
        log.info("商品count={}", result);
    }

}
