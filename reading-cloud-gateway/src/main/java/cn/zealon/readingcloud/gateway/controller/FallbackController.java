package cn.zealon.readingcloud.gateway.controller;

import cn.zealon.readingcloud.common.result.Result;
import cn.zealon.readingcloud.common.result.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 快速失败接口
 * @author: zealon
 * @since: 2020/4/11
 */
public class FallbackController {

    @GetMapping("/fallback")
    public Result fallback() {
        System.out.println("11123");
        System.out.println("66443");
        return ResultUtil.fail();

    }
}
