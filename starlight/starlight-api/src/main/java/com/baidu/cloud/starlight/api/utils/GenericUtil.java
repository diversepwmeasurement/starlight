/*
 * Copyright (c) 2019 Baidu, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 
package com.baidu.cloud.starlight.api.utils;

import com.baidu.cloud.starlight.api.common.Constants;
import com.baidu.cloud.starlight.api.model.MsgBase;
import com.baidu.cloud.starlight.api.model.Request;
import java.util.HashMap;

/**
 * Created by liuruisen on 2020/4/8.
 */
public class GenericUtil {

    public static boolean isGenericCall(Request request) {
        if (request.getMethodName() != null && request.getMethodName().contains(Constants.GENERIC_METHOD_NAME_PREFIX)) {
            return true;
        }
        return false;
    }

    public static void markGeneric(MsgBase msgBase) {
        if (msgBase.getAttachmentKv() == null) {
            msgBase.setAttachmentKv(new HashMap<>());
        }
        msgBase.getAttachmentKv().put(Constants.IS_GENERIC_KEY, Boolean.TRUE);
    }

    public static boolean isGenericMsg(MsgBase msgBase) {
        if (msgBase.getAttachmentKv() != null && msgBase.getAttachmentKv().get(Constants.IS_GENERIC_KEY) != null
            && (Boolean) msgBase.getAttachmentKv().get(Constants.IS_GENERIC_KEY)) {
            return true;
        }

        return false;
    }
}
