package top.aprilyolies.coupons.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import top.aprilyolies.coupons.pojo.Response;
import top.aprilyolies.coupons.service.IUserCouponsService;

/**
 * @Author EvaJohnson
 * @Date 2019-07-30
 * @Email g863821569@gmail.com
 */
@Slf4j
@RestController
@RequestMapping("/coupons")
public class UserCouponsController {
    private IUserCouponsService userCouponsService;

    public UserCouponsController(IUserCouponsService userCouponsService) {
        this.userCouponsService = userCouponsService;
    }

    /**
     * 用户领取优惠券
     *
     * @param userId   用户 id
     * @param couponId 优惠券 id
     * @return 领取优惠券的响应结果
     */
    @RequestMapping("/gain-coupon/{userId}/{couponId}")
    public Response gainCouponForUser(@PathVariable int userId, @PathVariable int couponId) {
        log.info("GainCouponForUser: userId {} couponId {}", userId, couponId);
        return userCouponsService.gainCouponForUser(userId, couponId);
    }

    /**
     * 根据用户 id 获取该用户领取的全部优惠券
     *
     * @param userId 用户 id
     * @return 查询的用户优惠券结果
     */
    @RequestMapping("/user-coupons/{userId}")
    public Response queryUserCoupons(@PathVariable int userId) {
        log.info("QueryUserCoupons: userId {}", userId);
        return userCouponsService.queryUserCoupons(userId);
    }

    /**
     * 根据用户 id 获取该用户已使用的优惠券
     *
     * @param userId 用户 id
     * @return 查询的用户优惠券结果
     */
    @RequestMapping("/used-coupons/{userId}")
    public Response queryUsedCoupons(@PathVariable int userId) {
        log.info("QueryUsedCoupons: userId {}", userId);
        return userCouponsService.queryUsedCoupons(userId);
    }

    /**
     * 使用用户指定的优惠券
     *
     * @param userCouponId 用户优惠券 id
     * @return 使用的结果
     */
    @RequestMapping("/use-coupons/{userCouponId}")
    public Response useCoupon(@PathVariable int userCouponId) {
        log.info("UseCoupon: userCouponId {}", userCouponId);
        return userCouponsService.useCoupon(userCouponId);
    }

    /**
     * 获取用户可领取的优惠券，不包括已领取优惠券和失效
     *
     * @param userId 用户 id
     * @return 可获取的优惠券信息
     */
    @RequestMapping("/available-coupons/{userId}")
    public Response availableCoupons(@PathVariable int userId) {
        log.info("AvailableCoupons: userId {}", userId);
        return userCouponsService.availableCoupons(userId);
    }

    /**
     * 全局异常测试
     *
     * @return 无返回
     * @throws Exception
     */
    @ResponseBody
    @GetMapping("/exception")
    Response exception() throws Exception {
        throw new Exception("全局异常处理测试异常");
    }
}
