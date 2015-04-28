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

import com.somnus.smart.biz.meracc.resource.MeracctResource;
import com.somnus.smart.biz.meracc.service.MeracctService;
import com.somnus.smart.message.Message;
import com.somnus.smart.message.meracct.MeraccountupdRequest;
import com.somnus.smart.message.meracct.MeracctRequest;
import com.somnus.smart.message.meracct.MerchantupdRequest;
import com.somnus.smart.message.meracct.PerAccountRequest;
import com.somnus.smart.message.meracct.PerAccountUpdRequest;
import com.somnus.smart.message.meracct.SpeAccountRequest;
import com.somnus.smart.service.common.Constants;
import com.somnus.smart.service.common.MessageUtil;
import com.somnus.smart.support.common.JsonUtils;
import com.somnus.smart.support.exceptions.BizException;
/**
 * 
 * @description: TODO 
 * @author yh.liu
 * date 2015年3月6日 下午6:08:17
 */
@Component
@Validated
@Path("/com.somnus.smart.biz.meracc.resource.MeracctResource")
public class MeracctResourceImpl implements MeracctResource {

    private transient Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private MeracctService   meracctService;

    @Path("/createMeracct")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Message createMeracct(MeracctRequest request) {
        log.info(Constants.REQUEST_MSG, JsonUtils.toString(request));
        Message message = new Message();
        try {
            meracctService.txnMerCreateAcc(request);
            //返回成功报文
            message = MessageUtil.createCommMsg();
        } catch (BizException e) {
            log.error(Constants.BUSINESS_ERROR, e);
            // 组织错误报文
            message = MessageUtil.errRetrunInAction(e);
        } catch (Exception ex) {
            log.error(Constants.EXCEPTION_ERROR, ex);
            // 组织错误报文
            message = MessageUtil.createErrorMsg();
        }
        log.info(Constants.REPONSE_MSG, JsonUtils.toString(message));
        return message;
    }
    
    @Path("/createPersonAccount")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Message createPersonAccount(PerAccountRequest request) {
        log.info(Constants.REQUEST_MSG, JsonUtils.toString(request));
        Message message = new Message();
        try {
            meracctService.txnPerCreateAcc(request);
            //返回成功报文
            message = MessageUtil.createCommMsg();
        } catch (BizException e) {
            log.error(Constants.BUSINESS_ERROR, e);
            // 组织错误报文
            message = MessageUtil.errRetrunInAction(e);
        } catch (Exception ex) {
            log.error(Constants.EXCEPTION_ERROR, ex);
            // 组织错误报文
            message = MessageUtil.createErrorMsg();
        }
        log.info(Constants.REPONSE_MSG, JsonUtils.toString(message));
        return message;
    }
    
    @Path("/updatePersonAccount")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Message updatePersonAccount(PerAccountUpdRequest request){
    	log.info(Constants.REQUEST_MSG, JsonUtils.toString(request));
        Message message = new Message();
        try {
            meracctService.updatePerAccount(request);
            //返回成功报文
            message = MessageUtil.createCommMsg();
        } catch (BizException e) {
            log.error(Constants.BUSINESS_ERROR, e);
            // 组织错误报文
            message = MessageUtil.errRetrunInAction(e);
        } catch (Exception ex) {
            log.error(Constants.EXCEPTION_ERROR, ex);
            // 组织错误报文
            message = MessageUtil.createErrorMsg();
        }
        log.info(Constants.REPONSE_MSG, JsonUtils.toString(message));
        return message;
    }

    @Path("/updateMermerchant")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Message updateMermerchant(MerchantupdRequest request) {
        log.info(Constants.REQUEST_MSG, JsonUtils.toString(request));
        Message message = new Message();
        try {
            meracctService.updateMermerchant(request);
            //返回成功报文
            message = MessageUtil.createCommMsg();
        } catch (BizException e) {
            log.error(Constants.BUSINESS_ERROR, e);
            // 组织错误报文
            message = MessageUtil.errRetrunInAction(e);
        } catch (Exception ex) {
            log.error(Constants.EXCEPTION_ERROR, ex);
            // 组织错误报文
            message = MessageUtil.createErrorMsg();
        }
        log.info(Constants.REPONSE_MSG, JsonUtils.toString(message));
        return message;
    }

    @Path("/updateMeraccount")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Message updateMeraccount(MeraccountupdRequest request) {
        log.info(Constants.REQUEST_MSG, JsonUtils.toString(request));
        Message message = new Message();
        try {
            meracctService.updateMeraccount(request);
            //返回成功报文
            message = MessageUtil.createCommMsg();
        } catch (BizException e) {
            log.error(Constants.BUSINESS_ERROR, e);
            // 组织错误报文
            message = MessageUtil.errRetrunInAction(e);
        } catch (Exception ex) {
            log.error(Constants.EXCEPTION_ERROR, ex);
            // 组织错误报文
            message = MessageUtil.createErrorMsg();
        }
        log.info(Constants.REPONSE_MSG, JsonUtils.toString(message));
        return message;
    }

    /**
     * 开通特定账户
     */
    @Path("/createSpeAccount")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
	@Override
	public Message createSpeAccount(SpeAccountRequest request) {
		log.info(Constants.REQUEST_MSG, JsonUtils.toString(request));
		Message message = new Message();
		try {
			meracctService.insertSpeAccount(request);
			message = MessageUtil.createCommMsg();
		}  catch (BizException e) {
            log.error(Constants.BUSINESS_ERROR, e);
            // 组织错误报文
            message = MessageUtil.errRetrunInAction(e);
        } catch (Exception e) {
			log.error(Constants.EXCEPTION_ERROR, e);
            // 组织错误报文
            message = MessageUtil.createErrorMsg();
		}
		log.info(Constants.REPONSE_MSG, JsonUtils.toString(message));
		return message;
	}

}
