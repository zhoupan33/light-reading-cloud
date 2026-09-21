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
        System.out.println("111");
        System.out.println("985112");
        System.out.println("33333");
        System.out.println("4444");
        System.out.println("55555");
        return ResultUtil.fail();

    }
}
