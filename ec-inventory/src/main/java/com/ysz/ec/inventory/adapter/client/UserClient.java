package com.ysz.ec.inventory.adapter.client;

import com.ysz.ec.usr.api.UserApi;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <B>描述：</B><br/> <B>作者：</B> carl.yu <br/> <B>时间：</B> 2017/11/28 <br/> <B>版本：</B><br/>
 */
@FeignClient(value = "EC-USER")
public interface UserClient extends UserApi {
}
