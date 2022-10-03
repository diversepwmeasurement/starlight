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
 
package com.baidu.cloud.starlight.protocol.stargate;

import com.baidu.cloud.starlight.serialization.serializer.DyuProtostuffSerializer;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by liuruisen on 2020/7/27.
 */
public class StargateProtocolTest {

    private StargateProtocol stargateProtocol = new StargateProtocol();

    @Test
    public void getEncoder() {
        Assert.assertTrue(stargateProtocol.getEncoder() instanceof StargateEncoder);
    }

    @Test
    public void getDecoder() {
        Assert.assertTrue(stargateProtocol.getDecoder() instanceof StargateDecoder);
    }

    @Test
    public void getHeartbeatTrigger() {
        Assert.assertNull(stargateProtocol.getHeartbeatTrigger());
    }

    @Test
    public void getSerialize() {
        Assert.assertTrue(stargateProtocol.getSerialize() instanceof DyuProtostuffSerializer);
    }
}