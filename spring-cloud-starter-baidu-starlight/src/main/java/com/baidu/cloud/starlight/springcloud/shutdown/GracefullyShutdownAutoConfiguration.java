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
 
package com.baidu.cloud.starlight.springcloud.shutdown;

import com.baidu.cloud.starlight.api.rpc.StarlightServer;
import com.baidu.cloud.starlight.springcloud.server.StarlightServerAutoConfiguration;
import com.baidu.cloud.starlight.springcloud.server.register.StarlightRegisterAutoConfiguration;
import com.baidu.cloud.starlight.springcloud.server.register.StarlightRegisterListener;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liuruisen on 2020/12/3.
 */
@Configuration
@AutoConfigureAfter(value = {StarlightServerAutoConfiguration.class, StarlightRegisterAutoConfiguration.class})
@ConditionalOnBean(value = {StarlightServer.class, StarlightRegisterListener.class})
public class GracefullyShutdownAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public StarlightGracefullyShutdownLifecycle starlightGracefullyShutdownLifecycle(StarlightServer starlightServer,
        StarlightRegisterListener starlightRegisterListener) {
        return new StarlightGracefullyShutdownLifecycle(starlightServer, starlightRegisterListener);
    }
}
