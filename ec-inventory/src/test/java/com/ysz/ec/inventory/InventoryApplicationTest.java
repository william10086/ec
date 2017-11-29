package com.ysz.ec.inventory;

import com.ysz.ec.common.mybatis.dao.MyBatisDAO;
import com.ysz.ec.inventory.adapter.client.UserClient;
import com.ysz.ec.inventory.core.dao.CategoryDAO;
import com.ysz.ec.inventory.core.dao.InventoryDAO;
import com.ysz.ec.inventory.core.entity.Inventory;
import com.ysz.ec.usr.api.dto.TestWithParamReq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/20 <br/> <B>版本：</B><br/>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
    classes = InventoryApplication.class
)
public class InventoryApplicationTest {


  @Resource
  private MyBatisDAO myBatisDAO;

  @Resource
  private InventoryDAO inventoryDAO;

  @Resource
  private CategoryDAO categoryDAO;

  @Resource
  private UserClient userApiAdapter;

  @Test
  public void shouldDataSourceNotNull() throws Exception {
    System.err.println(userApiAdapter == null);
    userApiAdapter.testWithParam(TestWithParamReq.builder()
        .age(1)
        .name("aaaa")
        .date(new Date())
        .build());
  }


  @Test
  public void shouldInsertSuccess() throws Exception {
    Inventory inventory =
        Inventory.builder()
            .spuId(1L)
            .supplierId(1L)
            .name("商品名称")
            .description("商品描述")
            .count(1)
            .marketPrice(BigDecimal.TEN)
            .salePrice(BigDecimal.ONE)
            .onSaleTime(new Date())
            .offSaleTime(new Date())
            .pic("http://www.baidu.com/pic/")
            .status(1)
            .build();
    inventoryDAO.addInventory(inventory);
  }


}