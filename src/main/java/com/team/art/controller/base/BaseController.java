package com.team.art.controller.base;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * <p/> File Name             : BaseController
 * <p/> Author                : watson
 * <p/> Create Date           : 2015/6/7 21:42
 * <p/> Description           :
 * <p/>
 * <p/>
 * <p/>
 * <p/> Reviewed By           :
 * <p/> Reviewed On           :
 * <p/> Version History       :
 * <p/> Modified By           :
 * <p/> Modified Date         :
 * <p/> Comments              :
 * <p/> CopyRight             :
 * <p/> *******************************************************************************************
 */
public class BaseController {
    public static final String MESSAGES_KEY = "Msg";

    /**
     * 添加Flash消息
     * @param message
     */
    protected void saveMessage(HttpServletRequest request, String message) {
        List<String> messages = new ArrayList<String>();
        messages.add(message);
        request.getSession().setAttribute(MESSAGES_KEY, messages);
    }

    /* *//**
         * 添加Flash错误消息
         * @param message
         *//*
           protected void saveError(HttpServletRequest request, String message) {
            List<String> errors = new ArrayList<String>();
            errors.add(message);
            request.getSession().setAttribute(ERROR_KEY, errors);
           }
           */

    /**
     * 添加Flash消息
     * @param message
     */
    protected void saveMessage(RedirectAttributes redirectAttributes, String message) {
        List<String> messages = new ArrayList<String>();
        messages.add(message);
        redirectAttributes.addFlashAttribute(MESSAGES_KEY, messages);
    }
}
