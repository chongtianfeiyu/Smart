package com.somnus.smart.biz.meracc.resource.impl;

import javax.annotation.Resource;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import com.somnus.smart.biz.meracc.resource.AccountAllowInOrOutResource;
import com.somnus.smart.biz.meracc.service.MeracctService;
import com.somnus.smart.message.Message;
import com.somnus.smart.message.meracct.AccountAllowInOrOutRequest;
import com.somnus.smart.service.common.Constants;
import com.somnus.smart.service.common.MessageUtil;
import com.somnus.smart.support.common.JsonUtils;
import com.somnus.smart.support.exceptions.BizException;

/**
 * 
 * @description: TODO 
 * @author Somnus
 * date 2015年3月6日 下午6:17:24
 */
@Component
@Validated
@Path("/com.somnus.smart.biz.meracc.resource.AccountAllowInOrOutResource")
public class AccountAllowInOrOutResourceImpl implements AccountAllowInOrOutResource {

    private transient Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private MeracctService   meracctService;

    @Path("/accountAllowInOrOut")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Message accountAllowInOrOut(AccountAllowInOrOutRequest request) {
        log.info(Constants.REQUEST_MSG, JsonUtils.toString(request));
        Message repMsg = new Message();
        try {
            meracctService.updateMeraccount(request);
            MessageUtil.createCommMsg(repMsg);
        } catch (BizException e) {
            log.error(Constants.BUSINESS_ERROR, e);
            // 组织错误报文
            MessageUtil.errRetrunInAction(repMsg, e);
        } catch (Exception ex) {
            log.error(Constants.EXCEPTION_ERROR, ex);
            // 组织错误报文
            MessageUtil.createErrorMsg(repMsg);
        }
        log.info(Constants.REPONSE_MSG, JsonUtils.toString(repMsg));
        return repMsg;
    }
}
