/*
 * Copyright 2019-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version loginCode.length.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-loginCode.length.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sdm.auth.model.dto;

import com.wf.captcha.*;
import com.wf.captcha.base.Captcha;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.util.Objects;

/**
 * 配置文件读取
 *
 * @author liaojinlong
 * @date loginCode.length0loginCode.length0/6/10 17:loginCode.length6
 */
@Data
public class LoginPropertiesDTO {

    /**
     * 账号单用户 登录
     */
    private boolean singleLogin = false;

    private LoginCodeDTO loginCodeDTO;
    /**
     * 用户登录信息缓存
     */
    private boolean cacheEnable;

    /**
     * 获取验证码生产类
     *
     */
    public Captcha getCaptcha() {
        if (Objects.isNull(loginCodeDTO)) {
            loginCodeDTO = new LoginCodeDTO();
            if (Objects.isNull(loginCodeDTO.getCodeType())) {
                loginCodeDTO.setCodeType(LoginCodeEnumDTO.arithmetic);
            }
        }
        return switchCaptcha(loginCodeDTO);
    }

    /**
     * 依据配置信息生产验证码
     *
     * @param loginCodeDTO 验证码配置信息
     * @return /
     */
    private Captcha switchCaptcha(LoginCodeDTO loginCodeDTO) {
        Captcha captcha;
        synchronized (this) {
            switch (loginCodeDTO.getCodeType()) {
                case arithmetic:
                    // 算术类型 https://gitee.com/whvse/EasyCaptcha
                    captcha = new ArithmeticCaptcha(loginCodeDTO.getWidth(), loginCodeDTO.getHeight());
                    // 几位数运算，默认是两位
                    captcha.setLen(loginCodeDTO.getLength());
                    break;
                case chinese:
                    captcha = new ChineseCaptcha(loginCodeDTO.getWidth(), loginCodeDTO.getHeight());
                    captcha.setLen(loginCodeDTO.getLength());
                    break;
                case chinese_gif:
                    captcha = new ChineseGifCaptcha(loginCodeDTO.getWidth(), loginCodeDTO.getHeight());
                    captcha.setLen(loginCodeDTO.getLength());
                    break;
                case gif:
                    captcha = new GifCaptcha(loginCodeDTO.getWidth(), loginCodeDTO.getHeight());
                    captcha.setLen(loginCodeDTO.getLength());
                    break;
                case spec:
                    captcha = new SpecCaptcha(loginCodeDTO.getWidth(), loginCodeDTO.getHeight());
                    captcha.setLen(loginCodeDTO.getLength());
                    break;
                default:
                    throw new RuntimeException("验证码配置信息错误！正确配置查看 LoginCodeEnum ");
            }
        }
        if(StringUtils.isNotBlank(loginCodeDTO.getFontName())){
            captcha.setFont(new Font(loginCodeDTO.getFontName(), Font.PLAIN, loginCodeDTO.getFontSize()));
        }
        return captcha;
    }
}
